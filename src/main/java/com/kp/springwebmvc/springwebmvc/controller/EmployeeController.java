package com.kp.springwebmvc.springwebmvc.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.jsf.FacesContextUtils;

import com.kp.springwebmvc.springwebmvc.advices.ResourceNotFoundException;
import com.kp.springwebmvc.springwebmvc.controller.DTO.EmployeeDto;
import com.kp.springwebmvc.springwebmvc.entity.EmployeeEntity;
import com.kp.springwebmvc.springwebmvc.repository.EmpLoyeeRepository;
import com.kp.springwebmvc.springwebmvc.service.EmployeeService;

import jakarta.validation.Valid;

import java.io.Serial;
import java.nio.MappedByteBuffer;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.catalina.mapper.Mapper;
import org.apache.coyote.BadRequestException;
import org.apache.el.parser.AstFalse;
import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.Return;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private final  EmployeeService service;
	
	
	public EmployeeController(EmployeeService service) {
		
		this.service = service;
	}

	
//	@GetMapping(path="/secretMessage")
//	public String getSecretMessage() {
//		return new String("secret massage : c dskncds74efhgcbej");
//	}
	
//	using path variable --> mandatory data
	
	
	
	
	@GetMapping(path = "/{employeeId}")
	public ResponseEntity<EmployeeDto> getDto(@PathVariable(name = "employeeId") Long id) {
		
		if (id==null) {
//			return new BadRequestException("id cannot be null");
		}
		
		Optional<EmployeeDto> employeeDto= service.getById(id);
		
		return employeeDto
						.map(employeeDto1 -> ResponseEntity.ok(employeeDto1))
						.orElseThrow(()-> new ResourceNotFoundException("hello exception occured is getDto"));
	}
//	@ExceptionHandler(NoSuchElementException.class)
//	public ResponseEntity<String> handleException(NoSuchElementException noSuchElementException){
//		
//		return new ResponseEntity<>("element not found", HttpStatus.NOT_FOUND);
//	}
	@GetMapping()
	public ResponseEntity<List<EmployeeDto>> getAllEmployee(@RequestParam(required=false ,name="inputAge") Integer age ,@RequestParam(required = false,name = "sort") Integer sortBy) {
		return ResponseEntity.ok(service.getAllEmployee());
	}
	
	@PostMapping()
	public ResponseEntity<EmployeeDto> createEmployeeDto (@RequestBody @Valid EmployeeDto inputDto) {
		//TODO: process POST request
		EmployeeDto savedEmployeeDto = service.createEmployee(inputDto);
		return new ResponseEntity<>(savedEmployeeDto,HttpStatus.CREATED);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<EmployeeDto> updateEmployeeDto(@PathVariable(name = "employeeId") Long id, @RequestBody @Valid EmployeeDto dto) {
		//TODO: process PUT request
		
		
		
		return ResponseEntity.ok(service.updateEntity(id, dto));
	}
	
	@DeleteMapping("/{employeeid}")
	
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable(name = "employeeid") Long id) {
		//TODO: process PUT request
		
		boolean gotFound = service.deleteEntity(id);
		
		if (gotFound) {
			return ResponseEntity.ok(true);
		}
		
		
		throw new ResourceNotFoundException("resource not found in deleteEmployee");
	}
	
	@PatchMapping("/patch/{empid}")
	public ResponseEntity<EmployeeDto> partialUpdateEmployeeDto(@PathVariable(name = "empid") Long id , @RequestBody Map<String, Object> updates) {
		
		EmployeeDto employeeDto = service.partialUpdateEntity(id,updates);
		
		if (employeeDto==null) {
			throw new ResourceNotFoundException("resource not found in partialupdate");

		}
		return ResponseEntity.ok(employeeDto);
	}
	
	
	
	
	
	
	
	

}
