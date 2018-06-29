package com.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @className: WebsocketConfig
 * @package: com.demo.config
 * @describe: 配置信息
 * @auther: liuzhiyong
 * @date: 2018/6/28
 * @time: 下午 2:57
 */
@Configuration
//开启使用STOMP协议来实现代理消息
@EnableWebSocketMessageBroker
public class WebsocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    public void registerStompEndpoints(StompEndpointRegistry registry){
        //注册STOMP节点，并映射指定的URL,注册一个STOMP的endPoint，并指定使用SocketJS协议
        registry.addEndpoint("/endpoint").withSockJS();
    }
}
