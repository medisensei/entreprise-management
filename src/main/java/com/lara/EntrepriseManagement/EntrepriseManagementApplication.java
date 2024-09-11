package com.lara.EntrepriseManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@SpringBootApplication
public class EntrepriseManagementApplication {

	public static void main(String[] args) {

		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("lang/messages");
		messageSource.setDefaultEncoding("UTF-8");
		System.out.println(messageSource.getMessage("hello", null, Locale.ITALIAN));

		SpringApplication.run(EntrepriseManagementApplication.class, args);
	}

}
