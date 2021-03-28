package com.cos.persistence;

import com.cos.domain.ProductOptionVO;
import com.cos.domain.productTextureVO;

public interface ProductOptionDAO {

	public void optionUpload(ProductOptionVO productOption)throws Exception;
	public void textureUpload(productTextureVO productTexture) throws Exception;
}
