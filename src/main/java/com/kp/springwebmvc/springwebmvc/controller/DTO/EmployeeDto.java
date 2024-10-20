package com.kp.springwebmvc.springwebmvc.controller.DTO;

import java.time.LocalDate;


import java.util.jar.Attributes.Name;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kp.springwebmvc.springwebmvc.annotations.AgeValidator;
import com.kp.springwebmvc.springwebmvc.annotations.EmployeeRoleValidation;
import com.kp.springwebmvc.springwebmvc.annotations.PrimeAgeInterface;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor

public class EmployeeDto {
	
	private Long id;
	@NotBlank(message = "name cannot be empty")
	private String name;
	@Email(message = "enter valid email")
	private String email;
	
//	@Min(value = 20)
//	@Max(value = 80)
	@PrimeAgeInterface // ---> custom validation
	private Integer age;
	@PastOrPresent(message = "enter valid date")
	private LocalDate dateOfJoining;
	@JsonProperty("isactive")
	private Boolean isActive;
	
//	@Pattern(regexp = "^(USER|ADMIN)", message="enter valid role")
	@EmployeeRoleValidation //--> custom validation
	private String role;
	
	public EmployeeDto(Long id, @NotBlank String name, @Email String email, @Min(20) @Max(80) Integer age,
			@PastOrPresent LocalDate dateOfJoining, Boolean isActive, @Pattern(regexp = "^(USER|ADMIN)") String role) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.dateOfJoining = dateOfJoining;
		this.isActive = isActive;
		this.role = role;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public EmployeeDto() {
		
	}

	
	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

//	@Override
//	public String toString() {
//		return "EmployeeDto [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", dateOfJoining="
//				+ dateOfJoining + "]";
//	}
	
	
	

}
