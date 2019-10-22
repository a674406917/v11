package com.qf.spring_boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author HuangPingJian
 * @Date 2019/10/21
 */
@Component
@ConfigurationProperties(prefix = "resources")
public class Resources {
private  String imageServer;
private String emailServer;


    public String getImageServer() {
        return imageServer;
    }

    public void setImageServer(String imageServer) {
        this.imageServer = imageServer;
    }

    public String getEmailServer() {
        return emailServer;
    }

    public void setEmailServer(String emailServer) {
        this.emailServer = emailServer;
    }
}
