package com.kp.springwebmvc.springwebmvc.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.convert.DtoInstantiatingConverter;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.kp.springwebmvc.springwebmvc.advices.ResourceNotFoundException;
import com.kp.springwebmvc.springwebmvc.controller.DTO.EmployeeDto;
import com.kp.springwebmvc.springwebmvc.entity.EmployeeEntity;
import com.kp.springwebmvc.springwebmvc.repository.EmpLoyeeRepository;
@Service
public class EmployeeService {
	
	private final EmpLoyeeRepository empLoyeeRepository;
	private final ModelMapper mapper;
	

	
	public EmployeeService(EmpLoyeeRepository empLoyeeRepository, ModelMapper mapper) {
		
		this.empLoyeeRepository = empLoyeeRepository;
		this.mapper = mapper;
	}

	public Optional<EmployeeDto> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<EmployeeEntity> entity = empLoyeeRepository.findById(id);
		
		Optional<EmployeeDto> dto = entity.map(entity1 -> mapper.map(entity1, EmployeeDto.class));
		
		return dto;
	}

	public List<EmployeeDto> getAllEmployee() {
		// TODO Auto-generated method stub
		
		List<EmployeeEntity> entities = empLoyeeRepository.findAll();
		
		return entities
					  .stream()
					  .map(entity -> mapper.map(entity, EmployeeDto.class))
					  .collect(Collectors.toList());
		
		
	}

	public EmployeeDto createEmployee(EmployeeDto inputDto) {
		// TODO Auto-generated method stub
		EmployeeEntity entity = mapper.map(inputDto, EmployeeEntity.class);
		
		
		return mapper.map(empLoyeeRepository.save(entity), EmployeeDto.class);
	}

	public EmployeeDto updateEntity(Long id,EmployeeDto dto	) {
		// TODO Auto-generated method stub
		EmployeeEntity entity = mapper.map(dto, EmployeeEntity.class);
		entity.setId(id);
		EmployeeEntity savedEntity =    empLoyeeRepository.save(entity);
		return mapper.map(savedEntity, EmployeeDto.class);
	}

	public boolean  deleteEntity(Long id) {
		// TODO Auto-generated method stub
		
		if (empLoyeeRepository.existsById(id)==true) {
			empLoyeeRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

	public EmployeeDto partialUpdateEntity(Long id, Map<String, Object> updates) {
		// TODO Auto-generated method stub
		
		if (!empLoyeeRepository.existsById(id)) {
			throw new ResourceNotFoundException("not found at partial service layer");
		}
		
		EmployeeEntity entity = empLoyeeRepository.findById(id).orElse(null);
		
		updates.forEach((field,Value) ->{
			Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
			fieldToBeUpdated.setAccessible(true);
			ReflectionUtils.setField(fieldToBeUpdated, entity, Value);
		});
		
		
		
		return mapper.map(empLoyeeRepository.save(entity), EmployeeDto.class);
	}
	
	

}
