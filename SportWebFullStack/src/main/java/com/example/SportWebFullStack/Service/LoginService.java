package com.example.SportWebFullStack.Service;

import java.net.URI;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.SportWebFullStack.Model.DanhMuc;
import com.example.SportWebFullStack.Model.LoginRequest;
import com.example.SportWebFullStack.Model.Nguoidung;
import com.example.SportWebFullStack.Util.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;

@Service
public class LoginService {
	@Autowired
	private JwtService jwtService;
	JwkTokenStore jwkTokenStore;
	private RestTemplate restTemplate = new RestTemplate();
	private HttpHeaders headers = new HttpHeaders();
	public String Loggin(String email,String password,List<String> roles) throws JsonMappingException, JsonProcessingException {
		 String apiURL = Utils.BASE_URL + "auth/signup";
		 LoginRequest log = new LoginRequest();
		 log.setEmail(email);
		 log.setPassword(password);
		 log.setRoles(roles);
		 HttpHeaders headers = new HttpHeaders();
		 HttpEntity<LoginRequest> entity = new HttpEntity<LoginRequest>(log,headers);
		 RestTemplate resTemplate = new RestTemplate();
		 ResponseEntity<String> response = resTemplate.exchange(apiURL, HttpMethod.POST,entity,String.class);
		 if(response.getStatusCode().is2xxSuccessful()) {
			 String json = response.getBody();
			 ObjectMapper objectMapper = new ObjectMapper();
			 JsonNode jsonnode = objectMapper.readTree(json);
			 String accessToken = jsonnode.get("access_token").asText();
			 String refreshToken = jsonnode.get("refresh_token").asText();
			 
			 Claims claims =jwtService.decodeToken(accessToken);
			 String usernailemail = claims.getSubject();
			 
			 jwkTokenStore.storeToken(accessToken, refreshToken, usernailemail,roles);
			 return email;
		 } else {
			 throw new RuntimeException( "Failed to login.Status code  "+response.getStatusCodeValue());
		 }
		 
		
		
	}
	
	public Boolean Register(Nguoidung nguoidung) {
		 String apiURL = Utils.BASE_URL + "auth/register";
		headers.setContentType(MediaType.APPLICATION_JSON);
		RequestEntity<?> requestEntity = new RequestEntity<>(nguoidung , HttpMethod.POST, URI.create(apiURL));
		ResponseEntity<Boolean> response = restTemplate.exchange(requestEntity, Boolean.class);
	    Boolean rs = response.getBody();
		return rs;
	}

	
	 public boolean logout() {
		 String LOGOUT_URL = Utils.BASE_URL + "auth/logout";
	        try {
	            ResponseEntity<String> response = restTemplate.postForEntity(LOGOUT_URL, null, String.class);
	            return response.getStatusCode().is2xxSuccessful();
	        } catch (Exception e) {
	        	System.out.println(e.getMessage());
	            return false;
	        }
	    }
	 
}
