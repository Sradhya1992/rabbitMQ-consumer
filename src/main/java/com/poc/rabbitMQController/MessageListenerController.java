package com.poc.rabbitMQController;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.poc.rabbitMQData.RequestMessage;
import com.poc.rabbitMQService.MessageListenerService;

@Component
@RestController
public class MessageListenerController {

	@Autowired
	MessageListenerService messageListenerService;
	
	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void listener(RequestMessage requestMessage) {
		messageListenerService.storeRecievedMessage(requestMessage);
	}
	
	@GetMapping("/getAllbycompanyNum/{companyNum}")
	public List<RequestMessage> getAllCompanyNumbergiven(@PathVariable String companyNum) {
		return messageListenerService.getAllCompanyNumbergiven(companyNum);
	}
}
