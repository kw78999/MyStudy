package com.bit.springNote2.dao;

import java.util.ArrayList;

import com.bit.springNote2.dto.note2dto;

public interface IDao {

	public ArrayList<note2dto> listDao();
	public void writeDao(String writer, String content);
	public void deleteDao(String id);
	


}
