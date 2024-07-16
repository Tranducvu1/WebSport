package com.example.SportWebFullStack.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JwtService {


	private String secretKey = "5r7P8vLkMnBvCxZaQwEtYuIoPlKjHgFdSa2R4f6G3h9J0m1N6b7c8D5E3F2A";
    public Claims decodeToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
