//package com.example.postgres.Entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.Email;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Entity
//@Table(name = "employees")
//@Getter @Setter
//@NoArgsConstructor @AllArgsConstructor
//@ToString
//public class EmployeeEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer employeeId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "location", nullable = false)
//    private String location;
//    
//    @Column(name = "email_address", nullable = false)
//    @Email(message="Invalid email format:")
//    private String emailId;
//    
//    @Column(name = "age", nullable = false)
//    private int age;
//}
package com.example.postgres.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;


@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;
    
    @Column(name = "email_address", nullable = false)
    @Email(message="Invalid email format:")
    private String emailId;
    
    @Column(name = "age", nullable = false)
    private int age;
    
    public EmployeeEntity() {

    }

    public EmployeeEntity(Integer employeeId, String name, String location,
			@Email(message = "Invalid email format:") String emailId, int age) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.location = location;
		this.emailId = emailId;
		this.age = age;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", name=" + name + ", location=" + location + ", emailId="
				+ emailId + ", age=" + age + "]";
	}
}