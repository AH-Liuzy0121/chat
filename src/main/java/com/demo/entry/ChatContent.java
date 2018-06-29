package com.demo.entry;

/**
 * @className: ChatContent
 * @package: com.demo.entry
 * @describe: 聊天内容
 * @auther: liuzhiyong
 * @date: 2018/6/28
 * @time: 下午 2:49
 */
public class ChatContent {


    /**
     * 时间
     */
    private String date;

    /**
     * 内容
     */
    private String content;

    /**
     * 发送消息的人
     */
    private String sendUser;

    public ChatContent() {
    }

    public ChatContent(String date, String content, String sendUser) {
        this.date = date;
        this.content = content;
        this.sendUser = sendUser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser;
    }
}
