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

import com.azad.practice.housecostbackend.service.BillService;
import com.azad.practice.housecostbackend.shared.dto.BillDto;
import com.azad.practice.housecostbackend.ui.model.request.BillDetailsRequestModel;
import com.azad.practice.housecostbackend.ui.model.response.BillRest;
import com.azad.practice.housecostbackend.ui.model.response.OperationStatusModel;
import com.azad.practice.housecostbackend.ui.model.response.RequestOperationName;
import com.azad.practice.housecostbackend.ui.model.response.RequestOperationStatus;

@RestController
@RequestMapping("bills")
@CrossOrigin("http://127.0.0.1:4200")
public class BillController {
	
	@Autowired
	BillService billService;
	
	ModelMapper modelMapper = new ModelMapper();

	@PostMapping
	public BillRest createBill(@RequestBody BillDetailsRequestModel billDetails) {
		
		BillDto billDto = modelMapper.map(billDetails, BillDto.class);
		
		if (!billDetails.getAmount().equals("")) {
			billDto.setAmount(Double.parseDouble(billDetails.getAmount()));
		}
		
		BillDto createdBill = billService.createBill(billDto);
		
		BillRest returnValue = modelMapper.map(createdBill, BillRest.class);
		return returnValue;
	}
	
	@GetMapping
	public List<BillRest> getAllBills(
			@RequestParam(value = "page", defaultValue = "0") int page, 
			@RequestParam(value = "limit", defaultValue = "25") int limit) {
		
		List<BillDto> billDtoList = billService.getAllBills(page, limit);
    	
    	List<BillRest> returnValue = new ArrayList<BillRest>();
    	
    	for (BillDto billDto: billDtoList) {
    		BillRest billRest = modelMapper.map(billDto, BillRest.class);
			returnValue.add(billRest);
		}
    	
    	return returnValue;
	}
	
	@GetMapping(path = "/{billId}")
	public BillRest getBill(@PathVariable String billId) {
		
		BillDto fetchedBill = billService.getBillByBillId(billId);
		
		BillRest returnValue = modelMapper.map(fetchedBill, BillRest.class);
		return returnValue;
	}
	
	@PutMapping(path = "/{billId}")
	public BillRest updateBill(
			@PathVariable String billId, 
			@RequestBody BillDetailsRequestModel billDetails) {
		
		BillDto billDto = modelMapper.map(billDetails, BillDto.class);
		
		if (!billDetails.getAmount().equals("")) {
			billDto.setAmount(Double.parseDouble(billDetails.getAmount()));
		}
		
		BillDto updatedBill = billService.updateBill(billId, billDto);
		
		BillRest returnValue = modelMapper.map(updatedBill, BillRest.class);
		return returnValue;
	}
	
	@DeleteMapping(path = "/{billId}")
	public OperationStatusModel deleteBill(@PathVariable String billId) {
    	
    	OperationStatusModel returnValue = new OperationStatusModel();
    	
    	returnValue.setOperationName(RequestOperationName.DELETE.name());
    	billService.deleteBill(billId);
    	returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
    	
        return returnValue;
    }
}
