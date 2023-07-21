package com.kh.bankgiftprogram;

import java.util.Scanner;

public class MemberRun {
	public static void main(String[] args) {
		int index = 0;
		MemberFunction memFunc = new MemberFunction();
		
		finish :
		while(true) {
			int choice = memFunc.printMenu();
			
			switch(choice) {
				case 1 : 
					memFunc.inputInfo();
					break;
				case 2 : 
					memFunc.searchInfoByName();
					break;
				case 3 : 
					memFunc.printInfo();
					break;
				case 4 : 
					memFunc.modifyInfo();
					break;
				case 5 : 
					memFunc.CheckGift();
					break;
				case 6 : 
					memFunc.romoveInfo();
					break;
				case 0 : 
					memFunc.ShowEnd();
					break finish;
				default : 
					memFunc.WorngChoice();
					break;
			}
		}
	}

}
