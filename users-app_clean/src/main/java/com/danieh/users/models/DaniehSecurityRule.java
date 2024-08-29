package com.danieh.users.models;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

@Retention(RUNTIME)
@Target({ METHOD, TYPE })
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") //USER and ADMIN can run this method
@PostAuthorize("hasRole('ROLE_ADMIN')") // but only ADMIN can get the response
public @interface DaniehSecurityRule {

}
