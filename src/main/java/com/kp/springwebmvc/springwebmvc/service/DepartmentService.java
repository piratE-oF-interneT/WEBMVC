package com.kp.springwebmvc.springwebmvc.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp.springwebmvc.springwebmvc.DTO.DepartmentDto;
import com.kp.springwebmvc.springwebmvc.DTO.EmployeeDto;
import com.kp.springwebmvc.springwebmvc.entity.DepartmentEntity;
import com.kp.springwebmvc.springwebmvc.exceptions.ResourceNotFoundException;
import com.kp.springwebmvc.springwebmvc.repository.DepartmentRepository;

import jakarta.validation.Valid;

@Service
public class DepartmentService {
	

	private DepartmentRepository departmentRepository;
	
	private ModelMapper modelMapper;
	
	

	public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
		super();
		this.departmentRepository = departmentRepository;
		this.modelMapper = modelMapper;
	}



	public DepartmentDto getDeptById(Long id) {
		// TODO Auto-generated method stub
		
		Optional<DepartmentEntity> entity = departmentRepository.findById(id);
		
		DepartmentEntity e = entity.orElseThrow(() -> new ResourceNotFoundException("department not present") );
		
		
		DepartmentDto dto = modelMapper.map(e, DepartmentDto.class);
		return dto;
	
	}



	public DepartmentDto createDept(@Valid DepartmentDto dto) {
		// TODO Auto-generated method stub
		
		DepartmentEntity entity = departmentRepository.save(modelMapper.map(dto, DepartmentEntity.class));
		
		
		return modelMapper.map(entity, DepartmentDto.class);
	}



	public List<DepartmentDto> getAllDept() {
		// TODO Auto-generated method stub
		
		List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
		
		if (departmentEntities==null) {
			throw new ResourceNotFoundException("there are no departments currently in database");
		}
		
		return departmentEntities
				.stream()
				.map(x -> modelMapper.map(x, DepartmentDto.class))
				.collect(Collectors.toList());
	}

	

	public DepartmentDto updateDeptInService(Long id , DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		
		
		
	

		DepartmentEntity entity = modelMapper.map(departmentDto, DepartmentEntity.class);
		
		entity.setId(id);
	    DepartmentEntity entity2 = departmentRepository.save(entity);
		
		
		
		
		
	    return modelMapper.map(entity2, DepartmentDto.class);
	}


	private Optional<DepartmentEntity> isDeptExist(Long id) {
		
		Optional<DepartmentEntity> entity = departmentRepository.findById(id);
		
		return entity;
	}
	public Boolean deleteDepartment(Long id) {
		// TODO Auto-generated method stub
		
		Optional<DepartmentEntity> entityOptional = isDeptExist(id);
		
		DepartmentEntity entity = entityOptional.orElseThrow(() -> new ResourceNotFoundException("dept not exist"));
		
		departmentRepository.delete(entity);
		
		return true;
		
		
		
	}

}
