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
	// 고객 아이디로 데이터 조회
	public Bank selectOneById(String customerId) {
		String query = "SELECT * FROM BANKGIFTPROGRAM_TBL WHERE CUSTOMER_ID = ?";
		Bank bank = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, customerId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				bank = rsetToBank(rset);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bank;
	}
	// 이름으로 데이터 조회
	public List<Bank> selectAllByNaem(String customerName) {
		String query = "SELECT * FROM BANKGIFTPROGRAM_TBL WHERE CUSTOMER_NAME = ?";
		List<Bank> bList = new ArrayList<Bank>();
		Bank bank = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, customerName);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				bank = rsetToBank(rset);
				bList.add(bank);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bList;
	}
	
	// 고객 정보 등록
	public int insertBank(Bank bank) {
		String query = "INSERT INTO BANKGIFTPROGRAM_TBL VALUES(?,?,?,?,?,?,?,?,?)";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bank.getCustomerId());
			pstmt.setString(2, bank.getCustomerPw());
			pstmt.setString(3, bank.getCustomerName());
			pstmt.setString(4, bank.getCustomerGender()+"");
			pstmt.setString(5, bank.getCustomerCompany());
			pstmt.setString(6, bank.getCustomerPosition());
			pstmt.setString(7, bank.getCustomerPhone());
			pstmt.setString(8, bank.getCustomerAddress());
			pstmt.setLong(9, bank.getCustomerMoney());
			result = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	// 데이터 삭제
	public int deleteInfo(String customerId) {
		String query = "DELETE FROM BANKGIFTPROGRAM_TBL WHERE CUSTOMER_ID = ?";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, customerId);
			result = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
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
