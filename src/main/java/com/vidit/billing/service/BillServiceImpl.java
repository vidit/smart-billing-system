package com.vidit.billing.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vidit.billing.dto.BillResponseDto;
import com.vidit.billing.dto.BillingRequestDto;
import com.vidit.billing.entity.Bill;
import com.vidit.billing.entity.BillCategory;
import com.vidit.billing.entity.BillStatus;
import com.vidit.billing.entity.User;
import com.vidit.billing.exception.ResourceNotFoundException;
import com.vidit.billing.mapper.BillMapper;
import com.vidit.billing.repository.BillCategoryRepository;
import com.vidit.billing.repository.BillRepository;
import com.vidit.billing.repository.BillStatusRepository;

import com.vidit.billing.repository.UserRepository;

@Service
public class BillServiceImpl implements BillService {

	private final BillRepository billRepository;
	private final UserRepository userRepository;
	private final BillCategoryRepository billCategoryRepository;
	private final BillStatusRepository billStatusRepository;
	
	
	public BillServiceImpl(BillRepository billRepository, UserRepository userRepository,
			BillCategoryRepository billCategoryRepository, BillStatusRepository billStatusRepository) {
		super();
		this.billRepository = billRepository;
		this.userRepository = userRepository;
		this.billCategoryRepository = billCategoryRepository;
		this.billStatusRepository = billStatusRepository;
	}
	
	

	@Override
	public List<BillResponseDto> getAllBills() {
		return billRepository.findAll().stream().map(BillMapper::toResponseDto).collect(Collectors.toList());
	}

	@Override
	public BillResponseDto getBillById(Long id) {
		Bill bill = billRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bill Not Found with Id " + id));
		return BillMapper.toResponseDto(bill);
	}


	@Override
	public BillResponseDto createBill(BillingRequestDto dto) {
		Bill bill = BillMapper.toEntity(dto);
		bill.setGeneratedDate(LocalDate.now());
		
		User user = userRepository.findById(dto.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found With Id " + dto.getUserId()));
		
		BillCategory billCategory = billCategoryRepository.findById(dto.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Category Not Found With Id " + dto.getCategoryId()));
		
		BillStatus billStatus = billStatusRepository.findById(dto.getStatusId())
				.orElseThrow(() -> new ResourceNotFoundException("Bill Staus Not Found With Id " + dto.getStatusId()));
		
		
		bill.setUser(user);
		bill.setCategory(billCategory);
		bill.setStatus(billStatus);
		
		Bill savedBill = billRepository.save(bill);
		
		
		return BillMapper.toResponseDto(savedBill);
	}
	

	@Override
	public List<BillResponseDto> getBillsByStatusId(Long statusId) {
		return billRepository.findByStatusStatusId(statusId)
				.stream()
				.map(BillMapper::toResponseDto)
				.collect(Collectors.toList());
	}

	

	
	@Override
	public boolean deleteBill(Long id) {

		Bill bill = billRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Bill not found with id " +id));
		billRepository.deleteById(id);
		return true;
	}

	

	@Override
	public BillResponseDto updateBill(Long id, BillingRequestDto dto) {
		Bill existingBill = billRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bill Not Found with Id " + id));
		
		
		User user = userRepository.findById(dto.getUserId())
				.orElseThrow(()-> new ResourceNotFoundException("User Not Found with Id " +dto.getUserId()));
		
		BillCategory billCategory = billCategoryRepository.findById(dto.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("BillCategory Not Found With Id " + dto.getCategoryId()));
		
		BillStatus billStatus = billStatusRepository.findById(dto.getStatusId())
				.orElseThrow(()-> new ResourceNotFoundException("BillStatus Not Found With Id " + dto.getStatusId()));
				
		BillMapper.updateEntity(existingBill, dto);
		
		existingBill.setUser(user);
		existingBill.setCategory(billCategory);
		existingBill.setStatus(billStatus);
		
		Bill updatedBill = billRepository.save(existingBill);
		return BillMapper.toResponseDto(updatedBill);
	
	
	
	}

	@Override
	public List<BillResponseDto> getBillByConsumerName(String consumerName) {

		return billRepository.findByConsumerNameContainingIgnoreCase(consumerName).stream()
				.map(BillMapper::toResponseDto).collect(Collectors.toList());
	}

	
	



}
