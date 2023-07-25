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
		String customerId ="";
		int result = 0;
		
		end :
		while(true) {
			int choice = this.printMenu();
			switch(choice) {
				case 1 : 
					// 고객 정보 등록
					bank = this.inputCustomerInfo();
					result = controller.insertBank(bank);
					break;
				case 2 : 
					// 고객 선물 확인
					customerId = this.inputOneById("조회");
					bank = controller.findOneByCustomer(customerId);
					if(bank != null) {
						if(bank.getCustomerMoney() > 0 && bank.getCustomerMoney() <= 5000000) {
							this.present(bank, "참치 선물세트");
						} else if(bank.getCustomerMoney() > 5000000 && bank.getCustomerMoney() <= 50000000) {
							this.present(bank, "한과 선물세트");
						} else if(bank.getCustomerMoney() > 50000000 && bank.getCustomerMoney() <= 100000000) {
							this.present(bank, "홍삼 선물세트");
						} else if(bank.getCustomerMoney() > 100000000 ) {
							this.present(bank, "1++ 한우 선물세트");
						}
					} else {
						displayError("고객 정보가 조회되지 않습니다.");
					}
					break;
				case 3 : 
					// 고객 리스트 조회 (아이디)
					customerId = this.inputOneById("조회");
					bank = controller.findOneByCustomer(customerId);
					if(bank != null) {
						this.printOneCustomer(bank);
					} else {
						displayError("고객 정보가 조회되지 않습니다.");
					}
					break;
				case 4 : 
					// 고객 리스트 조회 (이름)
					String customerName = this.inputOneByName();
					bList = controller.findAllByName(customerName);
					if(!bList.isEmpty()) {
						this.printAllCustomer(bList);
					} else {
						displayError("고객 정보가 조회되지 않습니다.");
					}
					break;
				case 5 : 
					// 고객 전체 리스트 조회
					bList = controller.showAllList();
					if(!bList.isEmpty()) {
						this.printAllCustomer(bList);
					} else {
						displayError("고객 정보가 조회되지 않습니다.");
					}
					
					break;
				case 6 : 
					// 고객 정보 수정
					customerId = this.inputOneById("수정");
					bank = controller.findOneByCustomer(customerId);
					if(bank != null) {
						bank = modifyCustomerInfo(bank);
						bank.setCustomerId(customerId); // cause1
						result = controller.modifyInfo(bank);
						if(result > 0) {
							this.displaySuccess("고객 정보 수정에 성공하였습니다.");
						} else {
							this.displayError("고객 정보 수정에 실패하였습니다.");
						}
					} else {
						displayError("고객 정보가 조회되지 않습니다.");
					}
					break;
				case 7 :
					// 고객 정보 삭제
					customerId = this.inputOneById("삭제");
					result = controller.deleteInfo(customerId);
					if(result > 0) {
						this.displaySuccess("고객 정보를 삭제하였습니다.");
					} else {
						this.displayError("고객 정보를 삭제하는데 실패하였습니다.");
					}
					break;
				case 0 : 
					// 프로그램 종료
					this.exitProgream();
					break end;
			}
		}
	}
	// 전체 메뉴
	private int printMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==================================================");
		System.out.println("          KH은행 새해 선물 확인 프로그램          ");
		System.out.println("==================================================");
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
		System.out.println();
		return choice;
	}

	// 고객 전체 정보 출력
	private void printAllCustomer(List<Bank> bList) {
		System.out.println("==================================================");
		System.out.println("             5. 고객 전체 리스트 조회             ");
		System.out.println("==================================================");
		for(Bank bank : bList) {
			System.out.printf("아이디 : %s, 고객명 : %s, 성별 : %s, 직장 : %s, 직급 : %s, 연락처 : %s, 주소 : %s, 예금 금액 : %d\n"
					, bank.getCustomerId()
					, bank.getCustomerName()
					, bank.getCustomerGender()
					, bank.getCustomerCompany()
					, bank.getCustomerPosition()
					, bank.getCustomerPhone()
					, bank.getCustomerAddress()
					, bank.getCustomerMoney());
		}
		System.out.println();
	}

	// 아이디로 고객 정보 출력
	private void printOneCustomer(Bank bank) {
		System.out.println("==================================================");
		System.out.println("            3. 고객 리스트 조회(아이디)           ");
		System.out.println("==================================================");
		System.out.printf("고객명 : %s, 성별 : %s, 직장 : %s, 직급 : %s, 연락처 %s, 주소 : %s, 예금 금액 : %s"
				, bank.getCustomerName()
				, bank.getCustomerGender()
				, bank.getCustomerCompany()
				, bank.getCustomerPosition()
				, bank.getCustomerPhone()
				, bank.getCustomerAddress()
				, bank.getCustomerMoney());
		System.out.println();
	}

	// 고객 정보 등록
	private Bank inputCustomerInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==================================================");
		System.out.println("                 1. 고객 정보 등록                ");
		System.out.println("==================================================");
		System.out.print("아이디 : ");
		String customerId = sc.next();
		System.out.print("비밀번호 : ");
		String customerPw = sc.next();
		System.out.print("고객명 : ");
		String customerName = sc.next();
		System.out.print("성별 : ");
		char customerGender = sc.next().charAt(0);
		System.out.print("직장 : ");
		sc.nextLine();
		String customerCompany = sc.nextLine();
		System.out.print("직급 : ");
		String customerPosition = sc.next();
		System.out.print("연락처 : ");
		String customerPhone = sc.next();
		System.out.print("주소 : ");
		sc.nextLine();
		String customerAddress = sc.nextLine();
		System.out.print("예금 금액 : ");
		long customerMoney = sc.nextLong();
		Bank bank = new Bank(customerId, customerPw, customerName, customerGender, customerCompany, customerPosition, customerPhone, customerAddress, customerMoney);
		System.out.println();
		return bank;
	}

	// 고객 이름 검색
	private String inputOneByName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 이름 입력 : ");
		String customerName = sc.next();
		System.out.println();
		return customerName;
	}

	private String inputOneById(String category) {
		Scanner sc = new Scanner(System.in);
		System.out.print(category+"할 아이디 입력 : ");
		String customerId = sc.next();
		System.out.println();
		return customerId;
	}

	// 데이터 수정
	private Bank modifyCustomerInfo(Bank bank) {
		Scanner sc = new Scanner(System.in);
		System.out.println("==================================================");
		System.out.println("                 6. 고객 정보 수정                ");
		System.out.println("==================================================");
		System.out.print("비밀번호 : ");
		String customerPw = sc.next();
		System.out.print("고객명 : ");
		String customerName = sc.next();
		System.out.print("직장 : ");
		String customerCompany = sc.next();
		System.out.print("직급: ");
		String customerPosition = sc.next();
		System.out.print("연락처 : ");
		String customerPhone = sc.next();
		System.out.print("주소 : ");
		String customerAddress = sc.next();
		System.out.print("예금 금액 : ");
		long customerMoney = sc.nextLong();
		bank.setCustomerPw(customerPw);
		bank.setCustomerName(customerName);
		bank.setCustomerCompany(customerCompany);
		bank.setCustomerPosition(customerPosition);
		bank.setCustomerPhone(customerPhone);
		bank.setCustomerAddress(customerAddress);
		bank.setCustomerMoney(customerMoney);
		return bank;
	}

	// 금액별 선물
	private void present(Bank bank, String message) {
		System.out.println(bank.getCustomerName()+"님의 2024년 새해 선물은 "+message+" 입니다.");
		System.out.println();
	}

	// 성공 메세지
	private void displaySuccess(String messge) {
		System.out.println("[서비스 성공]" + messge);
		System.out.println();
	}
	
	// 에러 메세지
	private void displayError(String messge) {
		System.out.println("[서비스 실패]" + messge);
		System.out.println();
	}

	// 0. 프로그램 종료 메세지
	private void exitProgream() {
		System.out.println("프로그램이 종료되었습니다.");
	}
	
}
