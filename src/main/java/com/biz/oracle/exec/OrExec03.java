package com.biz.oracle.exec;

import java.util.Scanner;

import com.biz.oracle.service.ScoreService;

public class OrExec03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScoreService ss = new ScoreService();
		Scanner scan = new Scanner(System.in);
	
		System.out.print("학번>> ");
		String st_num = scan.nextLine();
		ss.viewScore(st_num);
		
	}

	
}
