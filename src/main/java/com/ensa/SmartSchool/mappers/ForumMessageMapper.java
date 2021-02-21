package com.ensa.SmartSchool.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.entity.ForumMessage;



@Component
public class ForumMessageMapper implements RowMapper<ForumMessage> {

	@Override
	public ForumMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
		ForumMessage forumMessage = new ForumMessage();
		forumMessage.setId(rs.getInt("forum_message_id"));
		forumMessage.setContent(rs.getNString("content"));
		forumMessage.setMessageWriter("message_writer");
		forumMessage.setTopic(rs.getNString("topic"));
		forumMessage.setPubDate(rs.getDate("pub_date"));
		return forumMessage;
	}

}
