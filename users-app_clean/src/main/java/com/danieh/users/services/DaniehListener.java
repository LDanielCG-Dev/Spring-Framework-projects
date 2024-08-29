package com.danieh.users.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DaniehListener {

	private static final Logger log = LoggerFactory.getLogger(DaniehListener.class);
	
	@KafkaListener(topics = "danieh-topic", groupId = "DaniehGroup")
	public void listen(String message) {
		log.info("Code to post the message in the audit api {}", message);
		try { //Simulate api delay
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
