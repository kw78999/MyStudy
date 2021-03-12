package com.bit.springBoard2.dao;

import java.util.ArrayList;

import com.bit.springBoard2.dto.BoardDto;

public interface IDao {

	public ArrayList<BoardDto> listDao();
	public BoardDto contentViewDao(int id);
	public void writeDao(String name,String title,String content);
	public void modifyDao(String name,String title,String content,int id);
	public void deleteDao(int id);
	public void upHitDao(int id);
}
