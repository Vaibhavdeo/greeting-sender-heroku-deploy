package com.programmer.greeting.constants;

public class AppConstants {

	public static final String INSERT_QUERY = "insert into GreetingDetails(g_Id, SP_DATE, subject ,name, mail_Id) values (?, ? , ? , ?, ?)";
	public static final String GET_DETAILS_QUERY = "select * from GreetingDetails where G_ID = ?";
	public static final String GET_ALL_DETAILS_QUERY = "select * from GreetingDetails";
	public static final String DELETE_QUERY = " IF EXISTS( SELECT * FROM GreetingDetails WHERE g_Id = ? ) UPDATE GreetingDetails SET (SP_DATE = ?, name = ?, subject = ?, mail_Id = ?) WHERE g_Id = ? ELSE INSERT INTO GreetingDetails VALUES(g_Id, SP_DATE, subject, name, mail_Id) values (?, ?, ?, ?, ?)";
}
