package com.poc.rabbitMQRepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.poc.rabbitMQData.RequestMessage;

@Repository
public interface MessageListenerRepository extends
		MongoRepository<RequestMessage, String> {
	
	@Query(value="{'companyNumber': {$eq:?0}}")
	List<RequestMessage> getAllCompanyNumbergiven(String companyNum);
	
}
