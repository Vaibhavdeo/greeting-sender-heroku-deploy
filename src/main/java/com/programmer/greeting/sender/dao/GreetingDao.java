package com.programmer.greeting.sender.dao;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.programmer.greeting.constants.AppConstants;
import com.programmer.greeting.exception.UserNotFoundException;
import com.programmer.greeting.mapper.GreetingDetailsMapper;
import com.programmer.greeting.sender.beans.GreetingDetails;
import com.programmer.greeting.sender.beans.ResponseMessgae;

@Component
public class GreetingDao implements IGreetingDao {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	@Autowired
	private ResponseMessgae response;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);

	}

	@Override
	public ResponseMessgae create(List<GreetingDetails> detailsList) {
		System.out.println("Inside method create of Greeting Dao" + dataSource);
		setDataSource(dataSource);
		detailsList.forEach(greetingDetails -> {
			jdbcTemplateObject.update(AppConstants.INSERT_QUERY, greetingDetails.getgId(), greetingDetails.getDate(),
					greetingDetails.getSubject(), greetingDetails.getName());
		});

		response.setMessgae("Success");
		response.setStatus(0);
		return response;
	}

	@Override
	public GreetingDetails getGreetingDetails(Integer id) {
		GreetingDetails greetingDetails = null;
		try{
		System.out.println("Inside method GETgREETINGdETAILS of Greeting Dao" + id);
		setDataSource(dataSource);
		greetingDetails = (GreetingDetails) jdbcTemplateObject.queryForObject(AppConstants.GET_DETAILS_QUERY,
				new Object[] { id }, new GreetingDetailsMapper());
		}catch(Exception e){
			throw new UserNotFoundException("id -"+id);
		}
		return greetingDetails;
	}

	@Override
	public List<GreetingDetails> listGreetingDetails() {
		setDataSource(dataSource);
		List<GreetingDetails> listGreetingDetails = jdbcTemplateObject.query(AppConstants.GET_ALL_DETAILS_QUERY,
				new GreetingDetailsMapper());
		return listGreetingDetails;
	}

	@Override
	public ResponseMessgae delete(Integer id) {
		try{
		setDataSource(dataSource);
		jdbcTemplateObject.update(AppConstants.DELETE_QUERY, id);
		}catch(Exception e){
			throw new UserNotFoundException("Id not found"+id);
		}
		response.setMessgae("Success");
		response.setStatus(0);
		return response;

	}

	@Override
	public ResponseMessgae update(List<GreetingDetails> detailsList) {
		try{
		setDataSource(dataSource);
		detailsList.forEach(greetingDetails -> {
			jdbcTemplateObject.update(AppConstants.UPDATE_QUERY, greetingDetails.getDate(), greetingDetails.getName(),
					greetingDetails.getSubject(), greetingDetails.getgId());
			System.out.println("Updated Record with ID = " + greetingDetails.getgId());
		});
		}catch(Exception e){
			throw new UserNotFoundException("Id - "+detailsList);
		}

		response.setMessgae("Success");
		response.setStatus(0);
		return response;

	}

}
