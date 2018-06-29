package com.demo.controller;

import com.demo.entry.CacheBean;
import com.demo.entry.ChatContent;
import com.demo.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @className: WebController
 * @package: com.demo.controller
 * @describe: 控制器
 *  说明: 由于在配置中已经开启了STOMP协议来传输代理信息，
 *    支持@MessageMapping注解，相当于RequestMapping注解
 * @auther: liuzhiyong
 * @date: 2018/6/28
 * @time: 下午 3:07
 */
@Controller
public class WebController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * @methodName: talk
     * @param: content 聊天内容
     * @describe: 聊天
     * @auther: liuzhiyong
     * @date: 2018/6/28
     * @time: 下午 3:18
     */
    @MessageMapping("/talk")
    @SendTo("refreshWindow")
    public ChatContent talk(ChatContent content){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        content.setDate(format.format(new Date()));
        return content;
    }

    /**
     * @methodName: refreshList
     * @param:
     * @describe: 服务端通知客户端刷新用户列表
     * @auther: liuzhiyong
     * @date: 2018/6/28
     * @time: 下午 3:24
     */
    @MessageMapping("/refreshList")
    public void refreshList(){
        messagingTemplate.convertAndSend("/refreshList",CacheBean.clientList);
    }

    /**
     * @methodName: logout
     * @param: user 用户
     * @describe: 退出
     * @auther: liuzhiyong
     * @date: 2018/6/28
     * @time: 下午 3:27
     */
    @MessageMapping("/downLine")
    public void logout(User user){
        List<User> clientList = CacheBean.clientList;
        //将退出的用户移除用户登录列表
        clientList.remove(user);
        //通知客户端刷新用户列表
        refreshList();
    }

    /**
     * @methodName: login
     * @param: user 用户
     * @describe: 上线
     * @auther: liuzhiyong
     * @date: 2018/6/28
     * @time: 下午 3:30
     */
    @MessageMapping("/upLine")
    public void login(User user){
        List<User> clientList = CacheBean.clientList;
        //将上线用户添加到登录用户列表
        clientList.add(user);
        //服务端通知客户端刷新列表
        refreshList();
    }
}
