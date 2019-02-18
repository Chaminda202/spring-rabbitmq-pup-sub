package com.spring.amq.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.amq.model.Content;
import com.spring.amq.service.ProducerService;

@RestController
@RequestMapping(value="/producer")
public class ProducerRestService {
	private ProducerService producerService;
	
	public ProducerRestService(ProducerService producerService){
		this.producerService = producerService;
	}
	
	@RequestMapping(value="/message", method=RequestMethod.POST)
	public String produceMessgage(@RequestBody Content content){
		producerService.produceMessage(content);
		return "Successfully produced the message...!!";
	}
}
