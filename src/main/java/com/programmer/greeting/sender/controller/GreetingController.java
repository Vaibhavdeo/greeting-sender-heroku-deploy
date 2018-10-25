package com.programmer.greeting.sender.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import com.programmer.greeting.exception.UserNotFoundException;
import com.programmer.greeting.sender.beans.GreetingDetails;
import com.programmer.greeting.sender.beans.ResponseMessgae;
import com.programmer.greeting.sender.service.GreetingSenderService;

@CrossOrigin
@RestController
public class GreetingController {

	private RestTemplate restTemplate;
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
	public  ResponseMessgae updateDetails(@RequestBody GreetingDetails detailsList) {
		if (detailsList != null) {
			return greetingService.updateDetails(detailsList);
		}
		return null;
	}

	@RequestMapping(value = "/getAllEvents", method = RequestMethod.GET)
	public List<GreetingDetails>  getAllEvents()  {
		List<GreetingDetails> eventList = new ArrayList<GreetingDetails>();
		restTemplate = new RestTemplate();
		ResponseEntity<List<GreetingDetails>> responseDetails = restTemplate.exchange(
				"https://heroku-greeting-sender.herokuapp.com/getAllDetails", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<GreetingDetails>>() {
				});
		System.out.println("Local Date= " + LocalDate.now());
		List<GreetingDetails> greetingDetails = responseDetails.getBody();
		greetingDetails.forEach(list -> {
			LocalDate tempDate = LocalDate.parse(list.getDate());
			if (tempDate.getDayOfMonth() == LocalDate.now().getDayOfMonth()
					&& tempDate.getMonthValue() == LocalDate.now().getMonthValue()) {

				eventList.add(list);

			}

		});
		return eventList;

	}

}
