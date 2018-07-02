package com.programmer.greeting.sender.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GREETINGDETAILS")
public class GreetingDetails {

	@Id
	@GeneratedValue
	private Integer gId;
	private String name;
	private String subject;
	@Column(name="SP_DATE")
	private String date;
	@Column(name="MAIL_Id")
	private String mailId;


	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
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
		return "GreetingDetails [gId=" + gId + ", name=" + name + ", subject=" + subject + ", date=" + date
				+ ", mailId=" + mailId + "]";
	}






}
