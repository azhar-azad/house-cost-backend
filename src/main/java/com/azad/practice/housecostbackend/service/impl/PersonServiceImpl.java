package com.azad.practice.housecostbackend.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azad.practice.housecostbackend.io.entity.PersonEntity;
import com.azad.practice.housecostbackend.io.repository.PersonRepository;
import com.azad.practice.housecostbackend.service.PersonService;
import com.azad.practice.housecostbackend.shared.dto.PersonDto;
import com.azad.practice.housecostbackend.shared.utils.Utils;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	Utils utils;
	
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public PersonDto createPerson(PersonDto personDto) {
		
		PersonEntity personEntity = modelMapper.map(personDto, PersonEntity.class);
		
		personEntity.setPersonId(utils.generatePersonId(10));
		PersonEntity createdPerson = personRepository.save(personEntity);
		
		PersonDto returnValue = modelMapper.map(createdPerson, PersonDto.class);
		return returnValue;
	}

}
