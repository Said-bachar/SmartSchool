package com.ensa.SmartSchool.dao;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ensa.SmartSchool.entity.Notice;
import com.ensa.SmartSchool.mappers.NoticeMapper;


@Component
public class NoticeDao {

	@Autowired
	private RestTemplate restTemplate;

		
		public List<Notice> getNotices() {
			String NoticeResourceUrl = "http://localhost:8081/notice/getNotices";
			ResponseEntity<Notice[]> response = restTemplate.getForEntity(NoticeResourceUrl, Notice[].class);
			Notice[] noticesTab=response.getBody();
			List<Notice> notices=Arrays.asList(noticesTab);
			return notices;
		}
		
		public Notice getNoticeByTitle(String title) {
			String NoticeResourceUrl = "http://localhost:8081/notice/getNoticeByTitle/title=" + title;
			HttpEntity<String> request = new HttpEntity<>(title);
			 return restTemplate.postForObject(NoticeResourceUrl, request, Notice.class);
		}

		
		public Notice getNoticeByPublicationDate(String publicationDate) {
			String NoticeResourceUrl = "http://localhost:8081/notice/getNoticeByPublicationDate/date="+ publicationDate;
			HttpEntity<String> request = new HttpEntity<>(publicationDate);
			 return restTemplate.postForObject(NoticeResourceUrl, request, Notice.class);
		}
		
		public Notice create(Notice notice) {
			String NoticeResourceUrl = "http://localhost:8081/notice/create";
			HttpEntity<Notice> request=new HttpEntity<Notice>(notice);
			
			return restTemplate.postForObject(NoticeResourceUrl, request, Notice.class);
			
		}
		
		
		public Notice updateMessage(Notice notice, String message) {
			String NoticeResourceUrl = "http://localhost:8081/notice/updateMessage/message="+message;
			HttpEntity<Notice> request =new HttpEntity<>(notice);
			return restTemplate.postForObject(NoticeResourceUrl,request,Notice.class);
		}
		
		public Notice updateTitle(Notice notice, String title) {
			String NoticeResourceUrl = "http://localhost:8081/notice/updateTitle/title="+title;
			HttpEntity<Notice> request =new HttpEntity<>(notice);
			return restTemplate.postForObject(NoticeResourceUrl,request,Notice.class);
		}
		
		public Notice updatePublicationDate(Notice notice, String date) {
			String NoticeResourceUrl = "http://localhost:8081/notice/updatePublicationDate/date="+date;
			HttpEntity<Notice> request =new HttpEntity<>(notice);
			return restTemplate.postForObject(NoticeResourceUrl,request,Notice.class);
		}
		
		public Notice delete(Notice notice) {
			String NoticeResourceUrl = "http://localhost:8081/notice/delete";
			HttpEntity<Notice> request = new HttpEntity<>(notice);
			return restTemplate.postForObject(NoticeResourceUrl, request, Notice.class);
		}
		
	
}
