package com.poc.rabbitMQconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.poc.rabbitMQRepository.MessageListenerRepository;

@SpringBootApplication
@ComponentScan("com.poc")
@EnableMongoRepositories(basePackageClasses = MessageListenerRepository.class)
public class RabbitMqConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqConsumerApplication.class, args);
	}
}
