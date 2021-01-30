package com.ensa.SmartSchool.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ensa.SmartSchool.entity.ForumMessage;


@Component
public class ForumMessageDao {

	@Autowired
	private RestTemplate restTemplate;

	public ForumMessage create(ForumMessage forumMessage) {

		String ForumMessageResourceUrl = "http://localhost:8081/forumMessage/create";
		HttpEntity<ForumMessage> request = new HttpEntity<ForumMessage>(forumMessage);

		
		return restTemplate.postForObject(ForumMessageResourceUrl, request, ForumMessage.class);

	}

	public List<ForumMessage> getForumMessages() {

		String ForumMessageResourceUrl = "http://localhost:8081/forumMessage/getForumMessages";
		ResponseEntity<ForumMessage[]> response = restTemplate.getForEntity(ForumMessageResourceUrl,ForumMessage[].class);
		ForumMessage[] forumMessagesTab = response.getBody();
		List<ForumMessage> forumMessages = Arrays.asList(forumMessagesTab);
		return forumMessages;

	}

	
	public ForumMessage getForumMessage(int id) {
		String ForumMessageResourceUrl = "http://localhost:8081/forumMessage/getForumMessage/id="+id;
		HttpEntity<Integer> request = new HttpEntity<Integer>(id);

		return restTemplate.postForObject(ForumMessageResourceUrl, request, ForumMessage.class);

	}
	
	public ForumMessage updateContent(ForumMessage forumMessage, String content) {
		String NoticeResourceUrl = "http://localhost:8081/forumMessage/updateContent/content="+content;
		HttpEntity<ForumMessage> request =new HttpEntity<>(forumMessage);
		return restTemplate.postForObject(NoticeResourceUrl, request, ForumMessage.class);
	}
	
	public ForumMessage updateTopic(ForumMessage forumMessage, String topic) {
		String NoticeResourceUrl = "http://localhost:8081/forumMessage/updateTopic/topic="+topic;
		HttpEntity<ForumMessage> request =new HttpEntity<>(forumMessage);
		return restTemplate.postForObject(NoticeResourceUrl, request, ForumMessage.class);
	}
	
	public ForumMessage delete(ForumMessage forumMessage) {
		String ForumMessageResourceUrl = "http://localhost:8081/forumMessage/delete";
		HttpEntity<ForumMessage> request = new HttpEntity<ForumMessage>(forumMessage);

		return restTemplate.postForObject(ForumMessageResourceUrl, request, ForumMessage.class);
	}

}
