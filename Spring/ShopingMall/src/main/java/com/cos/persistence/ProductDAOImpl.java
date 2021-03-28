package com.cos.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cos.domain.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Inject
	private SqlSession session;
	private static final String namespace ="com.cos.domain.product";

	@Override
	public void upload(ProductVO product) throws Exception {
		 session.insert(namespace+".upload",product);
	}
	@Override
	public List<ProductVO> select() throws Exception {
		return session.selectList(namespace+".select");
	}

}
