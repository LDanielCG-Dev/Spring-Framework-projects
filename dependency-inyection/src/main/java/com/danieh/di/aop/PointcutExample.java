package com.danieh.di.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutExample {

	//@Pointcut("execution(* com.danieh.di.aop.TargetObject.*(..))")
	//@Pointcut("within(com.danieh.di.aop.*)")
	//@Pointcut("within(com.danieh.di.aop.TargetObject)")
	//@Pointcut("within(TargetObject)")
	@Pointcut("@annotation(DaniehAnnotation)")
	public void targetObjectMethods() {}
}
