package com.programmer.greeting.sender.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.programmer.greeting.sender.beans.GreetingDetails;
import com.programmer.greeting.sender.beans.ResponseMessgae;
import com.programmer.greeting.sender.dao.GreetingDao;
@Component
public class GreetingSenderService {
	
	@Autowired
	private GreetingDao greetingDao;
    
    public ResponseMessgae createGreeting(List<GreetingDetails> greetingDetailsList){
    	if(!greetingDetailsList.isEmpty()){
    		return greetingDao.create(greetingDetailsList);
    	}
    	
		return null;
      }
    
    public GreetingDetails getGreetingDetails(Integer id){
		return greetingDao.getGreetingDetails(id);
    	
    }
    
    public List<GreetingDetails> getAllDetails(){
		return greetingDao.listGreetingDetails();
    	
    }
    
    public ResponseMessgae deleteDetails(Integer id){
		return greetingDao.delete(id);
    	
    }
    
    public ResponseMessgae updateDetails(List<GreetingDetails> detailsList){
		return greetingDao.update(detailsList);
    	
    }
	

}
