package com.danieh.di.aop;

import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyAspect {
	
	private static Logger log = LoggerFactory.getLogger(MyAspect.class);
	
	@Before("PointcutExample.targetObjectMethods()")
	public void before(JoinPoint joinPoint) {
		log.info("Method name {}", joinPoint.getSignature().getName());
		log.info("Object type {}", joinPoint.getSignature().getDeclaringTypeName());
		log.info("Is public {}", Modifier.isPublic(joinPoint.getSignature().getModifiers()));
		log.info("Arguments {}", joinPoint.getArgs());
		log.info("Before advice");
	}
}
