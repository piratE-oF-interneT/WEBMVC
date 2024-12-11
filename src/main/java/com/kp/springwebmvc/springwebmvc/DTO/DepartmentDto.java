package com.kp.springwebmvc.springwebmvc.DTO;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.kp.springwebmvc.springwebmvc.annotations.DeptTitleValidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.*;

public class DepartmentDto {
	
	
	private Long id;
	
	@NotBlank(message = "title should not be blank")
//	@Length(min = 4,max = 10,message = "title must be in range 4-20")
	@DeptTitleValidation
	private String title;
	
//	generated
	@NotNull(message = "status cannot be blank")
	private Boolean isActive;
	
	@PastOrPresent(message= "date must be of past or present")
	private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public DepartmentDto(Long id, String title, Boolean isActive, Date createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.isActive = isActive;
		this.createdAt = createdAt;
	}

	public DepartmentDto() {
		super();
	}
	
	

}
