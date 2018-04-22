package com.programmer.greeting.sender.beans;

import org.springframework.stereotype.Component;

@Component
public class ResponseMessgae {

	private Integer status;
	private String messgae;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessgae() {
		return messgae;
	}
	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}
	@Override
	public String toString() {
		return "ResponseMessgae [status=" + status + ", messgae=" + messgae + "]";
	}
	
	

}
