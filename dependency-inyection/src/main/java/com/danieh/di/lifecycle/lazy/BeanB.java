package com.danieh.di.lifecycle.lazy;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy//(false)
public class BeanB {
	@Autowired
	private BeanA bean;
	private static Logger log = LoggerFactory.getLogger(BeanB.class);
	
	@PostConstruct
	public void init() {
		 log.info("Init Bean b");
	}
}
