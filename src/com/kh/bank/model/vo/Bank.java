package com.kh.bank.model.vo;

public class Bank {
	// 멤버변수
	private String customerId;
	private String customerPw;
	private String customerName;
	private char customerGender;
	private String customerCompany;
	private String customerPosition;
	private String customerPhone;
	private String customerAddress;
	private long customerMoney;
	
	// 기본 생성자
	public Bank() {}
	
	// 매개변수 생성자
	public Bank(String customerId, String customerPw, String customerName, char customerGender, String customerCompany,
			String customerPosition, String customerPhone, String customerAddress, long customerMoney) {
		super();
		this.customerId = customerId;
		this.customerPw = customerPw;
		this.customerName = customerName;
		this.customerGender = customerGender;
		this.customerCompany = customerCompany;
		this.customerPosition = customerPosition;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.customerMoney = customerMoney;
	}
	
	// getter, setter 메소드
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPw() {
		return customerPw;
	}

	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public char getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(char customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerCompany() {
		return customerCompany;
	}

	public void setCustomerCompany(String customerCompany) {
		this.customerCompany = customerCompany;
	}

	public String getCustomerPosition() {
		return customerPosition;
	}

	public void setCustomerPosition(String customerPosition) {
		this.customerPosition = customerPosition;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public long getCustomerMoney() {
		return customerMoney;
	}

	public void setCustomerMoney(long customerMoney) {
		this.customerMoney = customerMoney;
	}

	// toString() 오버라이드 -> 정보 확인용
	@Override
	public String toString() {
		return "고객 [아이디 =" + customerId + ", 비밀번호 =" + customerPw + ", 고객명 =" + customerName
				+ ", 성별 =" + customerGender + ", 직장 =" + customerCompany + ", 직급 ="
				+ customerPosition + ", 연락처 =" + customerPhone + ", 주소 =" + customerAddress
				+ ", 예금 금액 =" + customerMoney + "]";
	}
	
}