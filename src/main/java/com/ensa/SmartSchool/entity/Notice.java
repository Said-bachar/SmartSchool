package com.ensa.SmartSchool.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Notice {
	
	private int noticeId;
	private String title;
	private Date date;
	private String message;

}