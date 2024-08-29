package com.danieh.di.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Square implements Figure {

	@Value("${square.side}")
	private double side;
	
	@Override
	public double calculateArea() {
		return side*side;
	}

}
