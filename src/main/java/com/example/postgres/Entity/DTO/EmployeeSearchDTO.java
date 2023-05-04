package com.example.postgres.Entity.DTO;


public class EmployeeSearchDTO {

	private String name;
	private String emailId;
//	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age){
//		this.age= age;
//	}
}
