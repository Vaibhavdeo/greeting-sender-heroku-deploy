package com.programmer.greeting.sender.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.programmer.greeting.exception.GreetingServiceException;
import com.programmer.greeting.exception.UserNotFoundException;
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
    	GreetingDetails greetingDetails = greetingDao.getGreetingDetails(id);
    	if(greetingDetails == null){
    		throw new UserNotFoundException("Not Found "+ id);
    	}
		return greetingDetails;
    	
    }
    
    public List<GreetingDetails> getAllDetails(){
    	List<GreetingDetails> listDetails = greetingDao.listGreetingDetails();
    	if(listDetails.isEmpty()){
    		//throw new GreetingServiceException("No Details Found");
    	}
		return listDetails;
    	
    }
    
    public ResponseMessgae deleteDetails(Integer id){
		return greetingDao.delete(id);
    	
    }
    
    public ResponseMessgae updateDetails(GreetingDetails detailsList){
		return greetingDao.update(detailsList);
    	
    }
	

}
