package com.cos.domain;

import lombok.Data;

@Data
public class CategoryVO {
	private int ctNum;
	private int ctGubun1;
	private String ctGubun2;
	private String ctWriteDate;
	private String userID; //FK -> user table
}
