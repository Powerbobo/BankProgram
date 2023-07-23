package com.kh.bank.view;

import java.util.*;

import com.kh.bank.controller.BankController;
import com.kh.bank.model.vo.Bank;

public class BankView {
	
	private BankController controller;
	
	public BankView() {
		controller = new BankController();
	}

	public void startProgram() {
		
		Bank bank = null;
		List<Bank> bList = null;
		
		end :
		while(true) {
			int choice = this.printMenu();
			switch(choice) {
				case 1 : break;
				case 2 : break;
				case 3 : break;
				case 4 : break;
				case 5 : 
					// 고객 전체 리스트 조회
					bList = controller.showAllList();
					if(!bList.isEmpty()) {
						this.printAllCustomer(bList);
					} else {
						displayError("고객 정보가 조회되지 않습니다.");
					}
						
					break;
				case 6 : break;
				case 7 : break;
				case 0 : 
					// 프로그램 종료
					this.exitProgream();
					break end;
			}
		}
	}
	// 고객 전체 정보 출력
	private void printAllCustomer(List<Bank> bList) {
		System.out.println("====== 5. 고객 전체 리스트 조회 ======");
		for(Bank bank : bList) {
			System.out.printf("아이디 : %s, 이름 : %s, 성별 : %s, 직장 : %s, 직급 : %s, 연락처 : %s, 주소 : %s, 예금 금액 : %d\n"
					, bank.getCustomerId()
					, bank.getCustomerName()
					, bank.getCustomerGender()
					, bank.getCustomerCompany()
					, bank.getCustomerPosition()
					, bank.getCustomerPhone()
					, bank.getCustomerAddress()
					, bank.getCustomerMoney());
		}
	}

	// 성공 메세지
	private void displaySuccess(String messge) {
		System.out.println("[서비스 성공]" + messge);
	}
	
	// 에러 메세지
	private void displayError(String messge) {
		System.out.println("[서비스 실패]" + messge);
	}

	// 전체 메뉴
	private int printMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== KH은행 새해 선물 확인 프로그램 ======");
		System.out.println("1. 고객 정보 등록");
		System.out.println("2. 고객 선물 조회");
		System.out.println("3. 고객 리스트 조회(아이디)");
		System.out.println("4. 고객 리스트 조회(이름)");
		System.out.println("5. 고객 전체 리스트 조회");
		System.out.println("6. 고객 정보 수정");
		System.out.println("7. 고객 정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 >> ");
		int choice = sc.nextInt();
		return choice;
	}

	// 0. 프로그램 종료 메세지
	private void exitProgream() {
		System.out.println("프로그램이 종료되었습니다.");
	}
	
	

}
