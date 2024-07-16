package com.example.SportWebFullStack.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Nguoidung {
	
	  private Long id;
	  private String firstname;
	  private String lastname;
	  private String email;
	  private String sdt;
	  private String address;
	  private String password;
	  private String confirmPassword;


}
