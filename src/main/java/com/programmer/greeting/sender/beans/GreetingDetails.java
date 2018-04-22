package com.programmer.greeting.sender.beans;

import org.springframework.stereotype.Component;

@Component
public class GreetingDetails {
	
	private Integer gId;
	private String name;
	private String subject;
	private String date;
	
	
	public Integer getgId() {
		return gId;
	}
	public void setgId(Integer gId) {
		this.gId = gId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "GreetingDetails [gId=" + gId + ", name=" + name + ", subject=" + subject + ", date=" + date + "]";
	}
	
	
	
	

}
