package com.cos.domain;

import lombok.Data;

@Data
public class LectureVO {
	private int lcNum; //PK
	private String lcTitle;
	private String lcContent;
	private String lcWriteDate;
	private int lcReadCount;
	private String userID; //FK -> user table
	private int ctNum; //FK -> category table
}
