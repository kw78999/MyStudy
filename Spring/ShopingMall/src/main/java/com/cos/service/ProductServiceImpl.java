package com.cos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.domain.ProductVO;
import com.cos.persistence.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO dao;
	
	@Override
	public void productUpload(ProductVO product) throws Exception {
	dao.upload(product);
		
	}
}
