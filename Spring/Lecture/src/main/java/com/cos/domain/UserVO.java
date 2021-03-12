package com.cos.domain;

import lombok.Data;

@Data
public class UserVO {
	private String userID;
	private String userPW;
	private String userName;
	private String userEmail;
	private boolean userEmailCheck;
	private String userSalt;
	
}
