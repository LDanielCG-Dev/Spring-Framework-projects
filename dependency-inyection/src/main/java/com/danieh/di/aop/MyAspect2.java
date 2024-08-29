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
@Order(0)
public class MyAspect2 {

	private static Logger log = LoggerFactory.getLogger(MyAspect2.class);

	@Before("PointcutExample.targetObjectMethods()")
	public void before(JoinPoint joinPoint) {
		log.info("1 Method name {}", joinPoint.getSignature().getName());
		log.info("1 Object type {}", joinPoint.getSignature().getDeclaringTypeName());
		log.info("1 Is public {}", Modifier.isPublic(joinPoint.getSignature().getModifiers()));
		log.info("1 Arguments {}", joinPoint.getArgs());
		log.info("1 Before advice");
	}
}
