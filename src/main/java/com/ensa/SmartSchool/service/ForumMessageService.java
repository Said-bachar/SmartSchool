package com.ensa.SmartSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.dao.ForumMessageDao;
import com.ensa.SmartSchool.entity.ForumMessage;

@Component
public class ForumMessageService {

	@Autowired
	private ForumMessageDao forumMessageDao;
	
	public ForumMessage create(ForumMessage forumMessage) {
		
		return forumMessageDao.create(forumMessage);
	}
	
	public List<ForumMessage> getForumMessages(){
		return forumMessageDao.getForumMessages();
	}
	
	public ForumMessage getForumMessage(int id) {
		
		return forumMessageDao.getForumMessage(id);
	}
	
	public ForumMessage delete(ForumMessage forumMessage) {
		return forumMessageDao.delete(forumMessage);
	}
}
