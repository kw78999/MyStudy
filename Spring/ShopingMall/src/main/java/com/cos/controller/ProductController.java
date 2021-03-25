package com.cos.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cos.domain.ProductVO;
import com.cos.service.ProductService;

@Controller
public class ProductController {

	@Inject
	private ProductService pService;
	
	
	@RequestMapping(value="productDetails",method=RequestMethod.GET)
	public String productDetails() {
		return "product/productDetails";
	}
	@RequestMapping(value="productUploadPage",method=RequestMethod.GET)
	public String productUploadPage() {
		return "product/productUploadPage";
	}
	@RequestMapping(value="productUpload",method=RequestMethod.POST)
	public String productUpload(Model model,ProductVO product) throws Exception {
		pService.productUpload(product);
		return "index";
	}
	
}
