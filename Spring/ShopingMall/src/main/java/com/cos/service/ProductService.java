package com.cos.service;

import java.util.List;

import com.cos.domain.ProductVO;

public interface ProductService {
	public void productUpload(ProductVO product) throws Exception;
	public List<ProductVO> productSelect() throws Exception;
}
