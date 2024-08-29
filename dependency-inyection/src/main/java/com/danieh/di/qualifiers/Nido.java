/**
 * 
 */
package com.danieh.di.qualifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
public class Nido {
	
	@Autowired
	private Animal animal;
	
	final static Logger log = LoggerFactory.getLogger(Nido.class);
	
	public void imprimir() {
		log.info("Mi nido tiene al animal {}", animal.getNombre());
	}
}
