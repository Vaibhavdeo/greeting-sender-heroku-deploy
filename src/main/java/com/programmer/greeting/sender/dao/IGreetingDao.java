package com.programmer.greeting.sender.dao;

import java.util.List;

import javax.sql.DataSource;

import com.programmer.greeting.sender.beans.GreetingDetails;
import com.programmer.greeting.sender.beans.ResponseMessgae;

public interface IGreetingDao {

	/**
	 * This is the method to be used to initialize database resources ie.
	 * connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create a record in the GreetingDetails
	 * table.
	 */
	public ResponseMessgae create(List<GreetingDetails> detailsList);

	/**
	 * This is the method to be used to list down a record from the Student
	 * table corresponding to a passed GreetingDetails id.
	 */
	public GreetingDetails getGreetingDetails(Integer id);

	/**
	 * This is the method to be used to list down all the records from the
	 * GreetingDetails table.
	 */
	public List<GreetingDetails> listGreetingDetails();

	/**
	 * This is the method to be used to delete a record from the Student table
	 * corresponding to a passed GreetingDetails id.
	 */
	public ResponseMessgae delete(Integer id);

	/**
	 * This is the method to be used to update a record into the GreetingDetails table.
	 */
	public ResponseMessgae update(GreetingDetails detailsList);

}
