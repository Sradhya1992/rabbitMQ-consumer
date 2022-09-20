package com.poc.rabbitMQData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class RequestMessage {

	@Id
	private String requestId;
	private String cfoType;
	private String cfoSubType;
	private String deliveryType;
	private String build;
	private String dpid;
	private String country;
	private String language;
	private String cceSegment;
	private String companyNumber;
	private String customerNumber;
	private String customerName;
	private String msgText;
}
