package com.example.SportWebFullStack.Config;

import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    private String jwtToken;
    private String refreshToken;


    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
