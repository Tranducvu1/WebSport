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
import com.example.SportWebFullStack.Model.DonHang;
import com.example.SportWebFullStack.Model.LoginRequest;
import com.example.SportWebFullStack.Model.Nguoidung;
import com.example.SportWebFullStack.Util.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
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
	public Nguoidung Loggin(String email,String password,String roles) throws JsonMappingException, JsonProcessingException {
		 String apiURL = Utils.BASE_URL + "auth/login";
		   System.out.println(apiURL);
		 Nguoidung log = new Nguoidung();
		 log.setEmail(email);
		 log.setPassword(password);
		 log.setRole(roles);
		 System.out.println("hi"+log);
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 HttpEntity<Nguoidung> entity = new HttpEntity<>(log,headers);
		 RestTemplate resTemplate = new RestTemplate();
		 Nguoidung response = resTemplate.postForObject(apiURL,entity,Nguoidung.class);
//		 if(response.getStatusCode().is2xxSuccessful()) {
//			 String json = response.getBody();
//			 ObjectMapper objectMapper = new ObjectMapper();
//			 JsonNode jsonnode = objectMapper.readTree(json);
//			 String accessToken = jsonnode.get("access_token").asText();
//			 String refreshToken = jsonnode.get("refresh_token").asText();
//			 Claims claims =jwtService.decodeToken(accessToken);
//			 jwkTokenStore.storeToken(accessToken, refreshToken, usernailemail);
//			 return usernailemail;
//		 } else {
//			 throw new RuntimeException( "Failed to login.Status code  "+response.getStatusCode().value());
//		 }	
		// System.out.println("reponse"+response);
		 return response;
		 
	}
	
//	public LoginRequest Loggin(String email, String password) throws JsonMappingException, JsonProcessingException {
//	    String apiURL = Utils.BASE_URL + "auth/login";
//	    LoginRequest log = new LoginRequest();
//	    log.setEmail(email);
//	    log.setPassword(password);
//	    
//	    HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_JSON);
//	    HttpEntity<LoginRequest> entity = new HttpEntity<>(log, headers);
//	    
//	    RestTemplate resTemplate = new RestTemplate();
//	    ResponseEntity<LoginRequest> response = resTemplate.postForEntity(apiURL, entity, LoginRequest.class);
//	    
//	    if(response.getStatusCode().is2xxSuccessful()) {
//	        LoginRequest loginResponse = response.getBody();
//	        
//	        // Xử lý JWT nếu cần
//	        // String accessToken = loginResponse.getAccessToken();
//	        // String refreshToken = loginResponse.getRefreshToken();
//	        // Claims claims = jwtService.decodeToken(accessToken);
//	        // String userEmail = claims.getSubject();
//	        // jwkTokenStore.storeToken(accessToken, refreshToken, userEmail);
//	        
//	        return loginResponse;
//	    } else {
//	        throw new RuntimeException("Failed to login. Status code: " + response.getStatusCode().value());
//	    }
//	}
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
	 
	 public List<Nguoidung> getDataFromAPI() throws JsonMappingException, JsonProcessingException {
    	 String apiURL = Utils.BASE_URL  + "auth/getAll";
    	RequestEntity<?> requestEntity = new RequestEntity<>(HttpMethod.GET,URI.create(apiURL));
		 ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
		    String json = response.getBody();
		    ObjectMapper objectMapper = new ObjectMapper();
		    List<Nguoidung> listEthnic = objectMapper.readValue(json, new TypeReference<List<Nguoidung>>() {});

		    return listEthnic;
	}
	 
}
