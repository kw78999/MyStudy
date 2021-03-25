package com.cos.persistence;

import com.cos.domain.ProductVO;

public interface ProductDAO {
	public void upload(ProductVO product) throws Exception;
}
