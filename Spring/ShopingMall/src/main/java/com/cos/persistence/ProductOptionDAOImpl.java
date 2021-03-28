package com.cos.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cos.domain.ProductOptionVO;
import com.cos.domain.productTextureVO;

@Repository
public class ProductOptionDAOImpl implements ProductOptionDAO{

	@Inject
	private SqlSession session;
	private static final String namespace ="com.cos.domain.productOption";

	@Override
	public void optionUpload(ProductOptionVO productOption) throws Exception {
		session.insert(namespace+".optionUpload",productOption);
		
	}
	@Override
	public void textureUpload(productTextureVO productTexture) throws Exception {
	session.insert(namespace+".textureUpload",productTexture);
		
	}
}
