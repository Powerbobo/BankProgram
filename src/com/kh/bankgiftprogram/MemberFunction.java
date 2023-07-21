package com.kh.bankgiftprogram;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class MemberFunction {
	
	List<Member> memList;
	
	public MemberFunction() {
		memList = new ArrayList<Member>();
	}
	
	// 객체 배열 선언
//	private Member [] memArrs;
	
	// 인덱스 변수 선언
//	static int index;
	
	// 메인 메뉴
	public int printMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=====================================================================================");
		System.out.println("                        [KH은행] 새해 선물 등급 관리 프로그램                        ");
		System.out.println("=====================================================================================");
		System.out.println("1. 고객 정보 입력");
		System.out.println("2. 고객 정보 이름 조회");
		System.out.println("3. 고객 정보 출력");
		System.out.println("4. 고객 정보 수정");
		System.out.println("5. 고객 선물 조회");
		System.out.println("6.고객 정보 삭제");
		System.out.println("0. 종료");
		System.out.print("메뉴 선택 : ");
		int choice = sc.nextInt();
		System.out.println();
		return choice;
	}
	// 고객 정보 입력
	public void  inputInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=====================================================================================");
		System.out.println("                                   고객 정보 입력                                    ");
		System.out.println("=====================================================================================");
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("회사 : ");
		sc.nextLine();
		String company = sc.nextLine();
		System.out.print("직급 : ");
		String position = sc.next();
		System.out.print("연락처 : ");
		String phone = sc.next();
		System.out.print("주소 : ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.print("예금 금액 : ");
		int money = sc.nextInt();
		Member member = new Member(name, company, position, phone, address, money);
		memList.add(member);
		System.out.println();
		System.out.println("[서비스 성공] : 입력 성공!");
		System.out.println();
	}
	// 이름으로 고객 정보 조회
	public void searchInfoByName() {
		System.out.println("=====================================================================================");
		System.out.println("                                 고객 정보 이름 조회                                 ");
		System.out.println("=====================================================================================");
		Scanner sc = new Scanner(System.in);
		System.out.println("고객 정보 이름 검색");
		System.out.print("조회할 고객 : ");
		String searchName = sc.next();
		System.out.println();
		boolean flag = false;
		for(Member mem : memList) {
			if(mem.getName().equals(searchName)) {
				System.out.printf("이름 : %s\n회사 : %s\n직급 : %s\n연락처 : %s\n주소 : %s \n예금 금액 : %s\n"
						, mem.getName(), mem.getCompany(), mem.getPosition(), mem.getPhone(), mem.getAddress(), mem.getMoney());
				System.out.println();
				System.out.println("[서비스 성공] : 조회 성공!");
				flag = true;
				break;
			} 
		}
		if(!flag) {
			System.out.println("등록되지 않은 고객님입니다. 고객님의 성함을 정확히 입력해주세요.");
			System.out.println();
			System.out.println("[서비스 실패] : 조회 실패!");
		}
		System.out.println();
	}
	// 고객 전체 정보 출력
	public void printInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=====================================================================================");
		System.out.println("                                    고객 정보 출력                                   ");
		System.out.println("=====================================================================================");
		for(int i = 0; i < memList.size(); i++) {
			System.out.println();
			Member mem = memList.get(i);
			System.out.printf((i+1) + "번째 고객 \n이름 : %s\n회사 : %s\n직급 : %s\n연락처 : %s\n주소 : %s \n예금 금액 : %s\n"
					, mem.getName(), mem.getCompany(), mem.getPosition(), mem.getPhone(), mem.getAddress(), mem.getMoney());
		}
		System.out.println();
		System.out.println("[서비스 성공] : 출력 성공!");
		System.out.println();
	}
	// 고객 정보 이름으로 수정
	public void modifyInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=====================================================================================");
		System.out.println("                                    고객 정보 수정                                   ");
		System.out.println("=====================================================================================");
		System.out.println();
		System.out.print("수정할 고객 이름 입력 : ");
		String Name = sc.next();
		System.out.print("수정할 정보 입력(이름) : ");
		String modName = sc.next();
		System.out.print("수정할 정보 입력(회사) : ");
		String modCompany = sc.next();
		System.out.print("수정할 정보 입력(직급) : ");
		String modPosition = sc.next();
		System.out.print("수정할 정보 입력(연락처) : ");
		String modPhone = sc.next();
		System.out.print("수정할 정보 입력(주소) ");
		sc.nextLine();
		String modAddress = sc.nextLine();
		System.out.print("수정할 정보 입력(예금 금액) : ");
		int modMoney = sc.nextInt();
		// 수정한 정보 저장
		Member modMember = new Member(modName, modCompany, modPosition, modPhone, modAddress, modMoney);
		boolean flag = false;
		for (int i = 0; i < memList.size(); i++) {
			Member member = memList.get(i);
			if(member.getName().equals(Name)) {
				memList.set(i, modMember);
				System.out.println();
				System.out.println("[서비스 성공] : 출력 성공!");
				System.out.println();
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println();
			System.out.println("등록되지 않은 고객님입니다. 고객님의 성함을 정확히 입력해주세요.");
			System.out.println();
			System.out.println("[서비스 실패] : 조회 실패!");
		}
	}
	// 고객 선물 확인
	public void CheckGift() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=====================================================================================");
		System.out.println("                                    고객 선물 조회                                   ");
		System.out.println("=====================================================================================");
		System.out.print("조회할 고객 : ");
		String searchName = sc.next();
		System.out.println();
		boolean flag = false;
		for(Member mem : memList) {
			if(mem.getName().equals(searchName)) {
				if(mem.getMoney() <= 10000000) {
					System.out.println(searchName + "님의 2024년 새해 선물은 참치 선물세트입니다.");
				} else if(mem.getMoney() > 10000000 && mem.getMoney() <= 100000000) {
					System.out.println(searchName + "님의 2024년 새해 선물은 고급 한과 선물세트입니다.");
				} else if(mem.getMoney() > 100000000 && mem.getMoney() <= 1000000000) {
					System.out.println(searchName + "님의 2024년 새해 선물은 홍삼 선물세트입니다.");
				} else if(mem.getMoney() > 1000000000) {
					System.out.println(searchName + "님의 2024년 새해 선물은 1++ 한우 선물세트입니다.");
				}
				System.out.println();
				System.out.println("[서비스 성공] : 조회 성공!");
				System.out.println();
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("등록되지 않은 고객님입니다. 고객님의 성함을 정확히 입력해주세요.");
			System.out.println();
			System.out.println("[서비스 실패] : 조회 실패!");
		}
	}
	// 등록 된 고객정보 삭제
	public void romoveInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=====================================================================================");
		System.out.println("                                    고객 정보 삭제                                   ");
		System.out.println("=====================================================================================");
		System.out.print("삭제할 고객 : ");
		String searchName = sc.next();
		System.out.println();
		boolean flag = false;
		for(int i = 0; i < memList.size(); i++) {
			Member mem = memList.get(i);
			if(mem.getName().equals(searchName)) {
				memList.remove(i);
				System.out.println("[서비스 성공] : 삭제 성공!");
				flag = true;
				break;
			} 
		}
		if(!flag) {
			System.out.println("등록되지 않은 고객님입니다. 고객님의 성함을 정확히 입력해주세요.");
			System.out.println();
			System.out.println("[서비스 실패] : 삭제 실패!");
			System.out.println();
		}
	}
	
	public void ShowEnd() {
		System.out.println("프로그램이 종료되었습니다.");
	}
	
	public void WorngChoice() {
		System.out.println("잘못 선택하셨습니다. 메뉴를 다시 선택해주세요.");
	}	
}
