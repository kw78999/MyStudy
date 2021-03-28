package com.cos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.domain.ProductOptionVO;
import com.cos.domain.productTextureVO;
import com.cos.persistence.ProductOptionDAO;

@Service
public class ProductOptionServiceImpl implements ProductOptionServie{

		@Autowired
		private ProductOptionDAO dao;
		
		@Override
		public void optionUpload(ProductOptionVO productOption) throws Exception {
		dao.optionUpload(productOption);
		
		}
		@Override
		public void textureUpload(productTextureVO productTexture) throws Exception {
			dao.textureUpload(productTexture);
		
		}
}
