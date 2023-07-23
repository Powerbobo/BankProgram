package com.kh.bank.model.dao;

import java.sql.*;
import java.util.*;

import com.kh.bank.model.vo.Bank;

public class BankDAO {
	
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "STUDENT";
	private final String PASSWORD = "STUDENT";

	/**
	 * 고객 정보 전체 조회
	 */
	public List<Bank> showCustomerList() {
		
		List<Bank> bList = null;
		Bank bank = null;
		String query = "SELECT * FROM BANKGIFTPROGRAM_TBL";
		
		try {
			// 1. 드라이버 등록
			Class.forName(DRIVER_NAME);
			// 2. DB 연결
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 3. 쿼리문 실행 준비
			Statement stmt = conn.createStatement();
			// 4. 쿼리문 실행 및 5. 결과 받기
			ResultSet rset = stmt.executeQuery(query);
			// 후처리
			bList = new ArrayList<Bank>();
			while(rset.next()) {
				bank = rsetToBank(rset);
				bList.add(bank);
			}
			// 6. 자원 해제
			rset.close();
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
	}
	
	/**
	 * JDBC 후처리
	 * @param rset
	 * @return
	 * @throws SQLException
	 */
	private Bank rsetToBank(ResultSet rset) throws SQLException {
		Bank bank = new Bank();
		bank.setCustomerId(rset.getString("CUSTOMER_ID"));
		bank.setCustomerPw(rset.getString("CUSTOMER_PW"));
		bank.setCustomerName(rset.getString("CUSTOMER_NAME"));
		bank.setCustomerGender(rset.getString("CUSTOMER_GENDER").charAt(0));
		bank.setCustomerCompany(rset.getString("CUSTOMER_COMPANY"));
		bank.setCustomerPosition(rset.getString("CUSTOMER_POSITION"));
		bank.setCustomerPhone(rset.getString("CUSTOMER_PHONE"));
		bank.setCustomerAddress(rset.getString("CUSTOMER_ADDRESS"));
		bank.setCustomerMoney(rset.getInt("CUSTOMER_MONEY"));
		return bank;
	}
	
}
