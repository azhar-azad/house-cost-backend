package com.azad.practice.housecostbackend.service;

import java.util.List;

import com.azad.practice.housecostbackend.shared.dto.BillDto;

public interface BillService {

	BillDto createBill(BillDto billDto);

	List<BillDto> getAllBills(int page, int limit);

	BillDto getBillByBillId(String billId);

	BillDto updateBill(String billId, BillDto billDto);

	void deleteBill(String billId);

}
