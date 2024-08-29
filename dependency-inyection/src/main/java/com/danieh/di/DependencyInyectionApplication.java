package com.danieh.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.danieh.di.aop.TargetObject;

@SpringBootApplication
public class DependencyInyectionApplication {
	
	private static Logger log = LoggerFactory.getLogger(DependencyInyectionApplication.class);
	
//	@Bean
//	public String getApplicationName() {
//		return "Daniehhh";
//	}
	
//	@Bean(initMethod = "init", destroyMethod = "destroy")
//	public ExplicitBean getBean() {
//		return new ExplicitBean();
//	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInyectionApplication.class, args);
		TargetObject targetObject = context.getBean(TargetObject.class);
		targetObject.hello("Hello world");
		//targetObject.foo();
	}

}
