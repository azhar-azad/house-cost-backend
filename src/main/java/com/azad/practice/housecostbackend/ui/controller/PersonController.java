package com.azad.practice.housecostbackend.ui.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azad.practice.housecostbackend.service.PersonService;
import com.azad.practice.housecostbackend.shared.dto.PersonDto;
import com.azad.practice.housecostbackend.ui.model.request.PersonDetailsRequestModel;
import com.azad.practice.housecostbackend.ui.model.response.PersonRest;

@RestController
@RequestMapping("person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	ModelMapper modelMapper = new ModelMapper();

	@PostMapping
	public PersonRest createPerson(@RequestBody PersonDetailsRequestModel personDetails) {
		
		PersonDto personDto = modelMapper.map(personDetails, PersonDto.class);
		personDto.setSalary(Double.parseDouble(personDetails.getSalary()));
		
		PersonDto createdPerson = personService.createPerson(personDto);
		
		PersonRest returnValue = modelMapper.map(createdPerson, PersonRest.class);
		return returnValue;
	}
}
