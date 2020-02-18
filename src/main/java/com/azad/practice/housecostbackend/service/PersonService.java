package com.azad.practice.housecostbackend.service;

import java.util.List;

import com.azad.practice.housecostbackend.shared.dto.PersonDto;

public interface PersonService {

	PersonDto createPerson(PersonDto personDto);

	List<PersonDto> getAllPersons(int page, int limit);

	PersonDto getPersonByPersonId(String personId);

	PersonDto updatePerson(String personId, PersonDto personDto);

	void deletePerson(String personId);

}
