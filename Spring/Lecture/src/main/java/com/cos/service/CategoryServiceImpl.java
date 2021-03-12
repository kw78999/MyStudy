package com.cos.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cos.domain.CategoryVO;
import com.cos.persistence.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Inject
	private CategoryDAO dao;
	
	@Override
	public void insert(CategoryVO category) throws Exception {
		dao.insert(category);
	}

	@Override
	public List<CategoryVO> selectGubun1(int ctGubun1) throws Exception {
		return dao.selectGubun1(ctGubun1);
	}

	@Override
	public CategoryVO select(int ctNum) throws Exception {
		
		return null;
	}

	@Override
	public void delete(int ctNum) throws Exception {
		
		
	}

	@Override
	public void update(CategoryVO category) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
