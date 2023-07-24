package com.kh.bank.controller;

import java.util.List;

import com.kh.bank.model.dao.BankDAO;
import com.kh.bank.model.vo.Bank;

public class BankController {
	
	private BankDAO bankDao;
	
	public BankController() {
		bankDao = new BankDAO();
	}
	
	// 고객 전체 정보 불러오기
	public List<Bank> showAllList() {
		List<Bank> bList =  bankDao.showCustomerList();
		return bList;
	}
	
	// 아이디로 데이터 조회
	public Bank findOneByCustomer(String customerId) {
		Bank bank = bankDao.selectOneById(customerId);
		return bank;
	}
	// 이름으로 데이터 조회
	public List<Bank> findAllByName(String customerName) {
		List<Bank> bList = bankDao.selectAllByNaem(customerName);
		return bList;
	}
	
	// 고객 정보 등록(INSERT)
	public int insertBank(Bank bank) {
		int result = bankDao.insertBank(bank);
		return result;
	}
	// 데이터 삭제
	public int deleteInfo(String customerId) {
		int result = bankDao.deleteInfo(customerId);
		return result;
	}

}
