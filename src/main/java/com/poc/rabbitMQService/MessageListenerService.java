package com.poc.rabbitMQService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.rabbitMQData.RequestMessage;
import com.poc.rabbitMQRepository.MessageListenerRepository;

@Service
public class MessageListenerService {

	@Autowired
	MessageListenerRepository messageListenerRepository;
	
	public void storeRecievedMessage(RequestMessage requestMessage){
		messageListenerRepository.save(requestMessage);
	}
	
	public List<RequestMessage> getAllCompanyNumbergiven(String companyNum) {
		return messageListenerRepository.getAllCompanyNumbergiven(companyNum);
	}
}
