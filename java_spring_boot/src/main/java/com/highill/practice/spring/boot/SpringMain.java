package com.highill.practice.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class SpringMain {

	public static void main(String[] args)
	{
		ConfigurableApplicationContext configContext = SpringApplication.run(SpringMain.class, args);

		String[] beanNameArray = configContext.getBeanDefinitionNames();
		System.out.println("\n\n----- bean count: " + beanNameArray == null ? -1 : beanNameArray.length);
		System.out.println("\n\n\n");

	}
}
