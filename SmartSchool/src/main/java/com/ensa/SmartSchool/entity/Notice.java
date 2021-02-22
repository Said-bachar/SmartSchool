package com.ensa.SmartSchool.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component

public class Notice {
	
	private int noticeId;
	private String title;
	private String publicationDate;
	private String message;
	
}