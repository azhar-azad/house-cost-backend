package com.azad.practice.housecostbackend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.azad.practice.housecostbackend.exception.PersonServiceException;
import com.azad.practice.housecostbackend.io.entity.PersonEntity;
import com.azad.practice.housecostbackend.io.repository.PersonRepository;
import com.azad.practice.housecostbackend.service.PersonService;
import com.azad.practice.housecostbackend.shared.dto.PersonDto;
import com.azad.practice.housecostbackend.shared.utils.Utils;
import com.azad.practice.housecostbackend.ui.model.response.ErrorMessages;

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

	@Override
	public List<PersonDto> getAllPersons(int page, int limit) {

		if (page > 0) {
			page--;
		}
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<PersonEntity> personsPage = personRepository.findAll(pageableRequest);
		List<PersonEntity> personEntityList = personsPage.getContent();
		
		List<PersonDto> returnValue = new ArrayList<PersonDto>();
		
		for (PersonEntity personEntity : personEntityList) {
			PersonDto personDto = modelMapper.map(personEntity, PersonDto.class);
			returnValue.add(personDto);
		}
		
		return returnValue;
	}

	@Override
	public PersonDto getPersonByPersonId(String personId) {
		
		PersonEntity fetchedPerson = personRepository.findByPersonId(personId);
		
		PersonDto returnValue = modelMapper.map(fetchedPerson, PersonDto.class);
		return returnValue;
	}

	@Override
	public PersonDto updatePerson(String personId, PersonDto personDto) {
		
		PersonEntity personEntity = personRepository.findByPersonId(personId);
		
		personEntity.setName(personDto.getName());
		personEntity.setEmail(personDto.getEmail());
		personEntity.setContactNo(personDto.getContactNo());
		personEntity.setSalary(personDto.getSalary());
		PersonEntity updatedPerson = personRepository.save(personEntity);
		
		PersonDto returnValue = modelMapper.map(updatedPerson, PersonDto.class);
		return returnValue;
	}

	@Override
	public void deletePerson(String personId) {
		PersonEntity personEntity = personRepository.findByPersonId(personId);

		if (personEntity == null) {
			throw new PersonServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		personRepository.delete(personEntity);
	}
}
