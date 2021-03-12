package com.cos.service;

import com.cos.domain.UserVO;

public interface UserService {
	public UserVO select(String userID) throws Exception;
	public void insert(UserVO user) throws Exception;
	public int login(UserVO user) throws Exception;
}
