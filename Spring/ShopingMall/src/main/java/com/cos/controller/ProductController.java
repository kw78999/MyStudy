package com.cos.controller;

import java.io.File;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cos.domain.ProductVO;
import com.cos.service.ProductService;

@Controller
public class ProductController{
	
	private static final String FILE_SERVER_PATH = "C:\\Sping\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ShopingMall\\resources\\editor\\upload";

	
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
	
	
	//상품 게시하면서 대표사진 저장
	@RequestMapping(value="productUpload",method=RequestMethod.POST)
	public String productUpload(@RequestParam("uploadFile") MultipartFile file,
									ModelAndView mv,Model model,ProductVO product) throws Exception {
		
		if(!file.getOriginalFilename().isEmpty()) {
			file.transferTo(new File(FILE_SERVER_PATH, file.getOriginalFilename()));
			model.addAttribute("msg", "File uploaded successfully.");
		}else {
			model.addAttribute("msg", "Please select a valid mediaFile..");
		}
		
		pService.productUpload(product);
		
		return "index";
	}
	
}
