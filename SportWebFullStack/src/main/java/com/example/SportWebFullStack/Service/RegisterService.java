package com.example.SportWebFullStack.Service;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.SportWebFullStack.Model.AuthenticationResponse;
import com.example.SportWebFullStack.Model.DonHang;
import com.example.SportWebFullStack.Model.Nguoidung;
import com.example.SportWebFullStack.Util.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class RegisterService {
    
    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers = new HttpHeaders();

    public String register(Nguoidung request) throws JsonProcessingException {
        String apiURL = Utils.BASE_URL  + "auth/register";
        System.out.println("hi"+request);
        System.out.println(apiURL);
        ResponseEntity<String> response = restTemplate.postForEntity(apiURL, request, String.class);
        System.out.println(response);
        System.out.println("Full response: " + response);
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Headers: " + response.getHeaders());
        System.out.println("Body: " + response.getBody());
        return response.getBody();
    }
    
    
    
}
	

