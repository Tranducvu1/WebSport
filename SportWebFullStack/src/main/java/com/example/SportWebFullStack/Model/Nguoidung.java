package com.example.SportWebFullStack.Model;

import lombok.Data;


@Data

public class Nguoidung {
		private Long id;
	  private String email;
	  private String hoten;
	  private String password;
	  private String confirm_password;
	  private String so_dien_thoai;
	  private String address;
	  private String role;
	  private String dayofbirth;
}
