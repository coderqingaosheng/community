package com.firstSpringBoot.demo.bean;


public class AccessTokenBean {
    /**您从GitHub收到的GitHub App的客户端ID*/
    private String client_id;
    /**您从GitHub收到的GitHub App的客户密码*/
    private String client_secret;
    /**您收到的作为对步骤1的响应的代码。*/
    private String code;
    /**授权后将用户发送到应用程序中的URL。*/
    private String redirect_uri;
    /**您在步骤1中提供的无法猜测的随机字符串。*/
    private String state;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
