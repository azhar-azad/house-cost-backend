package com.azad.practice.housecostbackend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.azad.practice.housecostbackend.exception.BillServiceException;
import com.azad.practice.housecostbackend.io.entity.BillEntity;
import com.azad.practice.housecostbackend.io.repository.BillRepository;
import com.azad.practice.housecostbackend.service.BillService;
import com.azad.practice.housecostbackend.shared.dto.BillDto;
import com.azad.practice.housecostbackend.shared.utils.Utils;
import com.azad.practice.housecostbackend.ui.model.response.ErrorMessages;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private Utils utils;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public BillDto createBill(BillDto billDto) {
		
		BillEntity billEntity = modelMapper.map(billDto, BillEntity.class);
		
//		if (personDto.getName() == "") {
//			throw new PersonServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage() + ":PersonName");
//		}
//		
//		if (personDto.getEmail() == "") {
//			throw new PersonServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage() + ":PersonEmail");
//		}
//		
//		if (personDto.getContactNo() == "") {
//			throw new PersonServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage() + ":PersonContactNo");
//		}
//		
//		if (personRepository.findByEmail(personDto.getEmail()) != null)
//			throw new PersonServiceException(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessage());
		
		billEntity.setBillId(utils.generateBillId(10));
		BillEntity createdBill = billRepository.save(billEntity);
		
//		if (createdPerson == null) {
//			throw new PersonServiceException(ErrorMessages.COULD_NOT_CREATE_RECORD.getErrorMessage());
//		}
		
		BillDto returnValue = modelMapper.map(createdBill, BillDto.class);
		return returnValue;
	}

	@Override
	public List<BillDto> getAllBills(int page, int limit) {

		if (page > 0) {
			page--;
		}
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<BillEntity> billPage = billRepository.findAll(pageableRequest);
		List<BillEntity> billEntityList = billPage.getContent();
		
		List<BillDto> returnValue = new ArrayList<BillDto>();
		
		for (BillEntity billEntity : billEntityList) {
			BillDto billDto = modelMapper.map(billEntity, BillDto.class);
			returnValue.add(billDto);
		}
		
		return returnValue;
	}

	@Override
	public BillDto getBillByBillId(String billId) {
		
		BillEntity fetchedBill = billRepository.findByBillId(billId);
		
//		if (fetchedPerson == null) {
//			throw new PersonServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
//		}
		
		BillDto returnValue = modelMapper.map(fetchedBill, BillDto.class);
		return returnValue;
	}

	@Override
	public BillDto updateBill(String billId, BillDto billDto) {
		
		BillEntity billEntity = billRepository.findByBillId(billId);
		
//		if (personEntity == null) {
//			throw new PersonServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
//		}
//		
//		if (personDto.getName() == "") {
//			throw new PersonServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage() + ":PersonName");
//		}
//		
//		if (personDto.getEmail() == "") {
//			throw new PersonServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage() + ":PersonEmail");
//		}
//		
//		if (personDto.getContactNo() == "") {
//			throw new PersonServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage() + ":PersonContactNo");
//		}
		
		billEntity.setName(billDto.getName());
		billEntity.setAmount(billDto.getAmount());
		billEntity.setActive(billDto.getIsActive());
		BillEntity updatedBill = billRepository.save(billEntity);
		
		BillDto returnValue = modelMapper.map(updatedBill, BillDto.class);
		return returnValue;
	}

	@Override
	public void deleteBill(String billId) {
		BillEntity billEntity = billRepository.findByBillId(billId);

		if (billEntity == null) {
			throw new BillServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		billRepository.delete(billEntity);
	}

	@Override
	public BillEntity getBillByName(String billName) {
		BillEntity billEntity = billRepository.findByName(billName); 
		return billEntity;
	}
	
	@Override
	public List<BillEntity> getBillListByName(List<String> billNameList) {
		List<BillEntity> returnValueList = new ArrayList<BillEntity>();
		
		for (String billName : billNameList) {
			returnValueList.add(getBillByName(billName));
		}
		
		return returnValueList;
	}
}
