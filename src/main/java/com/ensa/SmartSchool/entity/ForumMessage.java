package com.ensa.SmartSchool.entity;

import java.util.Date;

import lombok.Data;

@Data

public class ForumMessage {
	
	private int id;
	private String content;
	private String messageWriter;
	private String topic;
	private Date pubDate;
	
}
 
