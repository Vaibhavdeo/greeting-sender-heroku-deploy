package com.programmer.greeting.sender.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.programmer.greeting.exception.UserNotFoundException;
import com.programmer.greeting.sender.beans.GreetingDetails;
import com.programmer.greeting.sender.beans.ResponseMessgae;
import com.programmer.greeting.sender.service.GreetingSenderService;

@CrossOrigin(origins = * )
@RestController
public class GreetingController {
	@Autowired
	private ResponseMessgae responseMessgae;
	@Autowired
	private GreetingSenderService greetingService;

	@RequestMapping(value = "/addGreetingDetails", method = RequestMethod.POST)
	public ResponseMessgae createGreetingDetails(@RequestBody List<GreetingDetails> detailsList) {
		if (!detailsList.isEmpty()) {
			return greetingService.createGreeting(detailsList);
		}
		return responseMessgae;
	}

	@RequestMapping(value = "/getGreetingDetails/{id}", method = RequestMethod.GET)
	public GreetingDetails getGreetingDetails(@PathVariable("id") Integer id) {	
		GreetingDetails greetingDetails = greetingService.getGreetingDetails(id);
		if(greetingDetails == null){
			throw new UserNotFoundException("id="+id);
		}
	return greetingDetails;
	
	}

	@RequestMapping(value = "/getAllDetails", method = RequestMethod.GET)
	public List<GreetingDetails> getAllDetails() {
		return greetingService.getAllDetails();

	}
	
	@RequestMapping(value = "/deleteDetails/{id}", method = RequestMethod.DELETE)
	public  ResponseMessgae deleteDetails(@PathVariable("id") Integer id) {
		if (id != null) {
			return greetingService.deleteDetails(id);
		}
		return null;
	}
	
	@RequestMapping(value = "/updateDetails", method = RequestMethod.PUT)
	public  ResponseMessgae updateDetails(@RequestBody List<GreetingDetails> detailsList) {
		if (!detailsList.isEmpty()) {
			return greetingService.updateDetails(detailsList);
		}
		return null;
	}
	
}
