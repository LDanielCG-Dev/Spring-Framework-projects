package com.danieh.di.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Figure {
	
	@Value("${circle.radius:1}")
	private double radius;
	
	@Override
	public double calculateArea() {
		return Math.PI*Math.pow(radius, 2);
	}

}
