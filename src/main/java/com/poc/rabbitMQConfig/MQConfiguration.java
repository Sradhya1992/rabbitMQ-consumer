package com.poc.rabbitMQConfig;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfiguration {

	@Value("${spring.rabbitmq.queue}")
	private String queue;
	
	@Value("${spring.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${spring.rabbitmq.routingkey}")
	private String routing_key;
	
	@Bean
	public Queue queue(){
		System.out.println("in Queue");
		return new Queue(queue);
	}
	
	@Bean
	public TopicExchange exchange() {
		System.out.println("in exchange");
		return new TopicExchange(exchange);
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		System.out.println("in Binding");
		return BindingBuilder.bind(queue)
				.to(exchange)
				.with(routing_key);
	}
	
	@Bean
	public MessageConverter messageConverter(){
		System.out.println("in msg converter");
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate template(ConnectionFactory connectionFactory) {
		System.out.println("in template creation");
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(messageConverter());
		return template;
	}
}
