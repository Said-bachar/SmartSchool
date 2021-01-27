package com.ensa.SmartSchool.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.dao.NoticeDao;
import com.ensa.SmartSchool.entity.Notice;

@Component
public class NoticeService {
	private NoticeDao noticeDao;
	
	@Autowired
	public NoticeService(NoticeDao noticeDao) {
		super();
		this.noticeDao = noticeDao;
	}
	
	public List<Notice> getNotices() {
		return this.noticeDao.getNotices();
	}
	
	public Notice getNoticeByTitle(String title) {
		return this.noticeDao.getNoticeByTitle(title);
	}
	
	public Notice getNoticeByPublicationDate(String publicationDate) {
		return this.noticeDao.getNoticeByPublicationDate(publicationDate);
	}
	
	public Notice create(Notice notice) {
		return this.noticeDao.create(notice);
	}
	
	public Notice updateMessage(Notice notice, String message) {
		return this.noticeDao.updateMessage(notice, message);
	}
	
	public Notice updateTitle(Notice notice, String title) {
		return this.noticeDao.updateTitle(notice, title);
	}
	
	public Notice updatePublicationDate(Notice notice, String date) {
		return this.noticeDao.updatePublicationDate(notice, date);
	}
	
	public Notice delete(Notice notice) {
		return this.noticeDao.delete(notice);
	}
}
