package com.kp.springwebmvc.springwebmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kp.springwebmvc.springwebmvc.DTO.DepartmentDto;
import com.kp.springwebmvc.springwebmvc.DTO.EmployeeDto;
import com.kp.springwebmvc.springwebmvc.advices.ApiResponse;
import com.kp.springwebmvc.springwebmvc.exceptions.ResourceNotFoundException;
import com.kp.springwebmvc.springwebmvc.repository.DepartmentRepository;
import com.kp.springwebmvc.springwebmvc.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	
	private DepartmentService departmentService;
	
	@GetMapping("/get")
	
	public ResponseEntity<DepartmentDto> getById(@RequestParam(required = true , name = "id") Long id){
		
		DepartmentDto dto = departmentService.getDeptById(id);
		
		
		
		return new ResponseEntity<>(dto,HttpStatus.FOUND);
	}
	
	@PostMapping("/create")
	
	public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody DepartmentDto dto){
		
		DepartmentDto createdDept = departmentService.createDept(dto);
		
		return new ResponseEntity<>(createdDept,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	
	public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
		
		
		List<DepartmentDto> dto = departmentService.getAllDept();
		
		return new ResponseEntity<>(dto,HttpStatus.FOUND);
	}
	
	@PutMapping("/update")
	
	public ResponseEntity<DepartmentDto> updateDept(@RequestParam(name = "id" , required = true) Long id ,@Valid @RequestBody DepartmentDto departmentDto){
		
		DepartmentDto dto = departmentService.updateDeptInService(id,departmentDto);
		
		
		return new ResponseEntity<DepartmentDto>(dto,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/delete")
	
	public ResponseEntity<Boolean> deleteDept(@RequestParam(name = "id" , required = true) Long id){
		
		
		return new ResponseEntity<>(departmentService.deleteDepartment(id),HttpStatus.OK);
	}
	

}
