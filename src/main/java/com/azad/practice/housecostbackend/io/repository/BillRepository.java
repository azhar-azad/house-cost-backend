package com.azad.practice.housecostbackend.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.azad.practice.housecostbackend.io.entity.BillEntity;

@Repository
public interface BillRepository extends PagingAndSortingRepository<BillEntity, Long> {

	BillEntity findByBillId(String billId);

}
