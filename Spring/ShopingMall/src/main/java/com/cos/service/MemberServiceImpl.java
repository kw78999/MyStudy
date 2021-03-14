package com.cos.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.domain.MemberVO;
import com.cos.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

		@Autowired
		private MemberDAO dao;

		@Override
		public void insert(MemberVO member) throws Exception {
			dao.insert(member);
		}
		@Override
		public int login(MemberVO member) throws Exception {
			return dao.login(member);
		}
		
}
