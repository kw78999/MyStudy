package com.cos.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cos.domain.CategoryVO;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

	@Inject
	private SqlSession session;
	private static final String namespace = "com.cos.domain.category";
	
	@Override
	public void insert(CategoryVO category) throws Exception {
		session.insert(namespace+".insert", category);		
	}

	@Override
	public List<CategoryVO> selectGubun1(int ctGubun1) throws Exception {
		return session.selectList(namespace+".selectGubun1", ctGubun1);
	}

	@Override
	public CategoryVO select(int ctNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int ctNum) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CategoryVO category) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
