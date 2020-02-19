package com.azad.practice.housecostbackend.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azad.practice.housecostbackend.service.PersonService;
import com.azad.practice.housecostbackend.shared.dto.PersonDto;
import com.azad.practice.housecostbackend.ui.model.request.PersonDetailsRequestModel;
import com.azad.practice.housecostbackend.ui.model.response.OperationStatusModel;
import com.azad.practice.housecostbackend.ui.model.response.PersonRest;
import com.azad.practice.housecostbackend.ui.model.response.RequestOperationName;
import com.azad.practice.housecostbackend.ui.model.response.RequestOperationStatus;

@RestController
@RequestMapping("persons")
@CrossOrigin("http://127.0.0.1:4200")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	ModelMapper modelMapper = new ModelMapper();

	@PostMapping
	public PersonRest createPerson(@RequestBody PersonDetailsRequestModel personDetails) {
		
		PersonDto personDto = modelMapper.map(personDetails, PersonDto.class);
		if (!personDetails.getSalary().equals("")) {
			personDto.setSalary(Double.parseDouble(personDetails.getSalary()));
		}
		
		PersonDto createdPerson = personService.createPerson(personDto);
		
		PersonRest returnValue = modelMapper.map(createdPerson, PersonRest.class);
		return returnValue;
	}
	
	@GetMapping
	public List<PersonRest> getAllPersons(
			@RequestParam(value = "page", defaultValue = "0") int page, 
			@RequestParam(value = "limit", defaultValue = "25") int limit) {
		
		List<PersonDto> personDtoList = personService.getAllPersons(page, limit);
    	
    	List<PersonRest> returnValue = new ArrayList<PersonRest>();
    	
    	for (PersonDto personDto: personDtoList) {
    		PersonRest personRest = modelMapper.map(personDto, PersonRest.class);
			returnValue.add(personRest);
		}
    	
    	return returnValue;
	}
	
	@GetMapping(path = "/{personId}")
	public PersonRest getPerson(@PathVariable String personId) {
		
		PersonDto fetchedPerson = personService.getPersonByPersonId(personId);
		
		PersonRest returnValue = modelMapper.map(fetchedPerson, PersonRest.class);
		return returnValue;
	}
	
	@PutMapping(path = "/{personId}")
	public PersonRest updatePerson(
			@PathVariable String personId, 
			@RequestBody PersonDetailsRequestModel personDetails) {
		
		PersonDto personDto = modelMapper.map(personDetails, PersonDto.class);
		personDto.setSalary(Double.parseDouble(personDetails.getSalary()));
		
		PersonDto updatedPerson = personService.updatePerson(personId, personDto);
		
		PersonRest returnValue = modelMapper.map(updatedPerson, PersonRest.class);
		return returnValue;
	}
	
	@DeleteMapping(path = "/{personId}")
	public OperationStatusModel deletePerson(@PathVariable String personId) {
    	
    	OperationStatusModel returnValue = new OperationStatusModel();
    	
    	returnValue.setOperationName(RequestOperationName.DELETE.name());
    	personService.deletePerson(personId);
    	returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
    	
        return returnValue;
    }
}
