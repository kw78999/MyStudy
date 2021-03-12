package com.bit.springBoard2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BoardDto {

	private int id;
	private String name;
	private String title;
	private String content;
	private String regdate;
	private int hit;
}
