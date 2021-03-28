package com.cos.service;

import com.cos.domain.ProductOptionVO;
import com.cos.domain.productTextureVO;

public interface ProductOptionServie {
	public void optionUpload(ProductOptionVO productOption)throws Exception;
	public void textureUpload(productTextureVO productTexture)throws Exception;

}
