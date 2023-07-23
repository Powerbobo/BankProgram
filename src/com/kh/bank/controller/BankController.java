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

}
