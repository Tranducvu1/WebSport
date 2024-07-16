package com.example.SportWebFullStack.Service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.SportWebFullStack.Model.Nguoidung;
import com.example.SportWebFullStack.Util.Utils;

@Service
public class RegisterService {
	@Autowired
	private JwtService jwtService;
	JwkTokenStore jwkTokenStore;
	private RestTemplate restTemplate = new RestTemplate();
	private HttpHeaders headers = new HttpHeaders();
	public Boolean Register(Nguoidung nguoidung) {
		 String apiURL = Utils.BASE_URL + "auth/register";
		headers.setContentType(MediaType.APPLICATION_JSON);
		RequestEntity<?> requestEntity = new RequestEntity<>(nguoidung , HttpMethod.POST, URI.create(apiURL));
		ResponseEntity<Boolean> response = restTemplate.exchange(requestEntity, Boolean.class);
	    Boolean rs = response.getBody();
		return rs;
	}

}
