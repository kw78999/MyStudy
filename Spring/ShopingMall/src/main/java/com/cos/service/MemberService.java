package com.cos.service;

import com.cos.domain.MemberVO;

public interface MemberService {
	public void insert(MemberVO member) throws Exception;
	public int login(MemberVO member) throws Exception;
	
}
