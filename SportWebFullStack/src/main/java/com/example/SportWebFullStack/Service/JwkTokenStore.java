package com.example.SportWebFullStack.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class JwkTokenStore {
    private Map<String, TokenInfo> tokenStore = new ConcurrentHashMap<>();

    public void storeToken(String accessToken, String refreshToken, String username, List<String> roles) {
        TokenInfo tokenInfo = new TokenInfo(accessToken, refreshToken, username, roles);
        tokenStore.put(username, tokenInfo);
    }

    public TokenInfo getTokenInfo(String username) {
        return tokenStore.get(username);
    }

    public void removeToken(String username) {
        tokenStore.remove(username);
    }


    public static class TokenInfo {
        private String accessToken;
        private String refreshToken;
        private String username;
        private List<String> roles;

        public TokenInfo(String accessToken, String refreshToken, String username, List<String> roles) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
            this.username = username;
            this.roles = roles;
        }

       
    }
}