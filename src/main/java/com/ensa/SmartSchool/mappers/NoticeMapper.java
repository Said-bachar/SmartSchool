package com.ensa.SmartSchool.mappers;


import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.entity.Notice;

@Component
public class NoticeMapper implements RowMapper<Notice> {

	@Override
	public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
		   
		Notice notice = new Notice();
		notice.setNoticeId(rs.getInt("notice_id"));
		notice.setTitle(rs.getString("title"));
		notice.setPublicationDate(rs.getString("publication_date"));
		notice.setMessage(rs.getString("message"));
		return notice;
	}

}
