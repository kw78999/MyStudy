package com.cos.domain;

import lombok.Data;

@Data
public class ProductVO {
	private int pNum;
	private String pName;
	private String thumbnail;
	private String price;
	private String category;
	private String categorySub;
	private int stock;
	private int discount;
	
}
