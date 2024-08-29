package com.danieh.di.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype") -- Recordemos que predestroy no se ejecuta para beans de tipo prototype
@Lazy // si el bean es Lazy no se inicializará a menos que se inyecte
public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean {
	
	private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);
	
	/*
	 * Se ejecutará durante la construcción del bean "BeanNameAware"
	 */
	@Override
	public void setBeanName(String name) {
		log.info("Bean name aware {}", name);
	}

	/**
	 * Se ejecutará despues de la inyeccion de dependencias
	 */
	@PostConstruct
	public void init() {
		log.info("Post construct");
	}
	
	/*
	 * Antes de que el bean sea destruido
	 * No se ejecutan para beans prototype
	 * Solo se ejecutan durante una terminación de la JVM de forma normal
	 */
	@PreDestroy
	public void destroyBean() {
		log.info("Pre destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("After properties set method");
	}

	@Override
	public void destroy() throws Exception {
		log.info("Destroy method");
	}
	
	
}
