package com.highill.practice.spring.boot.bean;

public class NameBean {

	private String firstName;

	private String lastName;

	private String fullName;

	public NameBean()
	{
		firstName = "";
		lastName = "";
		fullName = firstName + " " + lastName;
	}

	public NameBean(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = this.firstName + " " + this.lastName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

}
