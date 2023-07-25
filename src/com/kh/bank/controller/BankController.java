package com.kh.bank.controller;

import java.util.List;

import com.kh.bank.model.dao.BankDAO;
import com.kh.bank.model.vo.Bank;

public class BankController {
	
	private BankDAO bankDao;
	
	public BankController() {
		bankDao = new BankDAO();
	}
	
	/**
	 * 고객 전체 정보 조회
	 * @return
	 */
	public List<Bank> showAllList() {
		List<Bank> bList =  bankDao.showCustomerList();
		return bList;
	}
	
	/**
	 * 아이디로 고객 정보 조회
	 * @param customerId
	 * @return
	 */
	public Bank findOneByCustomer(String customerId) {
		Bank bank = bankDao.selectOneById(customerId);
		return bank;
	}
	/**
	 * 이름으로 고객 정보 조회
	 * @param customerName
	 * @return
	 */
	public List<Bank> findAllByName(String customerName) {
		List<Bank> bList = bankDao.selectAllByNaem(customerName);
		return bList;
	}
	
	/**
	 * 고객 정보 INSERT
	 * @param bank
	 * @return
	 */
	public int insertBank(Bank bank) {
		int result = bankDao.insertBank(bank);
		return result;
	}

	/**
	 * 고객 아이디로 데이터 DELETE
	 * @param customerId
	 * @return
	 */
	public int deleteInfo(String customerId) {
		int result = bankDao.deleteInfo(customerId);
		return result;
	}
	/**
	 * 데이터 수정
	 * @param bank
	 * @return
	 */
	public int modifyInfo(Bank bank) {
		int result = bankDao.modifyInfo(bank);
		return result;
	}
}
