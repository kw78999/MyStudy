package com.cos.controller;

import java.io.File;

import javax.inject.Inject;

import org.jsoup.select.Evaluator.IsEmpty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cos.domain.ProductOptionVO;
import com.cos.domain.ProductVO;
import com.cos.domain.productTextureVO;
import com.cos.service.ProductOptionServie;
import com.cos.service.ProductService;

@Controller
public class ProductController{
	
	private static final String FILE_SERVER_PATH =
			"C:\\Spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ShopingMall\\resources\\editor\\upload";
					
	
	@Inject
	private ProductService pService;
	@Inject
	private ProductOptionServie poService;
	
	@RequestMapping(value="productDetails",method=RequestMethod.GET)
	public String productDetails() {
		return "product/productDetails";
	}
	@RequestMapping(value="productUploadPage",method=RequestMethod.GET)
	public String productUploadPage() {
		return "product/productUploadPage";
	}
	
	
	//��ǰ �Խ��ϸ鼭 ��ǥ���� ����
	@RequestMapping(value="productUpload",method=RequestMethod.POST)
	public String productUpload(@RequestParam("uploadFile") MultipartFile file,
			ProductVO product,ProductOptionVO productOption,productTextureVO productTexture,ModelAndView mv,Model model) throws Exception {
		
		if(!file.getOriginalFilename().isEmpty()) {
			file.transferTo(new File(FILE_SERVER_PATH, file.getOriginalFilename()));
			model.addAttribute("msg", "File uploaded successfully.");
		}else {
			model.addAttribute("msg", "Please select a valid mediaFile..");
		}
		pService.productUpload(product);
		
		productTexture.setPNum(product.getPNum());
		poService.textureUpload(productTexture);
		
		
		
		if(null!=productOption.getList()) {
		//옵션이 null이 아니라면 정상 insert
			for (int i = 0; i < productOption.getList().size(); i++) {
				if(productOption.getList().get(i).getOSize() != null) {
					  productOption.getList().get(i).setPNum(product.getPNum());
					  poService.optionUpload(productOption.getList().get(i));
				}
			}
		}
		
		
		
		return "index";
	}
	
}
