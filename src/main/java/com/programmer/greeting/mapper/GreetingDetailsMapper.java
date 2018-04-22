package com.programmer.greeting.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.programmer.greeting.sender.beans.GreetingDetails;

public class GreetingDetailsMapper implements RowMapper<GreetingDetails>{

	@Override
	public GreetingDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		GreetingDetails details = new GreetingDetails();
		details.setgId(rs.getInt("gId"));
		details.setDate(rs.getString("SP_DATE"));
		details.setName(rs.getString("name"));
		details.setSubject(rs.getString("subject"));
		
		return details;
	}
	
	

}
