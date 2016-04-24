package com.highill.practice.spring.boot.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.highill.practice.spring.boot.bean.NameBean;

@RestController
public class HelloWorldRest {

	@RequestMapping(value = "/helloName", method = RequestMethod.GET)
	public NameBean getHelloName(
			@RequestParam(name = "firstName", required = false, defaultValue = "") String firstName,
	        @RequestParam(name = "lastName", required = false, defaultValue = "") String lastName)
	{

		NameBean name = new NameBean();
		name.setFirstName(firstName);
		name.setLastName(lastName);

		name.setFullName(firstName + " " + lastName);

		return name;
	}

}
