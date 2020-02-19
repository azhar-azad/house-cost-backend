package com.azad.practice.housecostbackend.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.azad.practice.housecostbackend.io.entity.PersonEntity;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<PersonEntity, Long> {

	PersonEntity findByPersonId(String personId);

	PersonEntity findByEmail(String email);

}
