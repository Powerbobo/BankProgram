package com.kh.bankgiftprogram;

public class Member {
	// ===========================> 멤버변수
	// 
	private String name;
	private String company;
	private String position;
	private String phone;
	private String address;
	private long money;
	
	// ===========================> 생성자
	public Member() {}
	public Member(String name, String company, String position, String phone, String address, long money) {
		this.name = name;
		this.company = company;
		this.position = position;
		this.phone = phone;
		this.address = address;
		this.money = money;
	}
	
	// ===========================> 메소드
	
	// getter 메소드
	public String getName() {
		return this.name;
	}
	
	public String getCompany() {
		return this.company;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public long getMoney() {
		return this.money;
	}
	
	// setter 메소드
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setMoney(long money) {
		this.money = money;
	}
}
