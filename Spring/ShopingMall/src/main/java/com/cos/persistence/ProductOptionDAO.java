package com.cos.persistence;

import com.cos.domain.ProductOptionVO;
import com.cos.domain.ProductTextureVO;

public interface ProductOptionDAO {

	public void optionUpload(ProductOptionVO productOption)throws Exception;
	public void textureUpload(ProductTextureVO productTexture) throws Exception;
}
