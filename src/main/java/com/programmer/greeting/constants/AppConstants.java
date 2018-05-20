package com.programmer.greeting.constants;

public class AppConstants {

	public static final String INSERT_QUERY = "insert into GreetingDetails(gId, SP_DATE, subject ,name, mailId) values (?, ? , ? , ?, ?)";
	public static final String GET_DETAILS_QUERY = "select * from GreetingDetails where GID = ?";
	public static final String GET_ALL_DETAILS_QUERY = "select * from GreetingDetails";
	public static final String DELETE_QUERY = "delete from GreetingDetails where gId = ?";
	public static final String UPDATE_QUERY = "update GreetingDetails set SP_DATE = ?, name = ?, subject=?, mailId=? where gId = ? ";

}
