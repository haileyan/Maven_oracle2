package com.biz.oracle.service;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.biz.oracle.dao.StdDao;
import com.biz.oracle.db.OracleSqlFactory;
import com.biz.oracle.vo.StdVO;

public class StdService {

	SqlSessionFactory sessionFactory;
	Scanner scan;
	
	public StdService() {
		// TODO Auto-generated constructor stub
		
		Properties props = new Properties();
		scan = new Scanner(System.in);
		
		OracleSqlFactory sqlFactory = new OracleSqlFactory();
		this.sessionFactory = sqlFactory.getSessionFactory();
		
	}

	public void stdView() {
		SqlSession session = this.sessionFactory.openSession();
		StdDao dao = session.getMapper(StdDao.class);
		
		List<StdVO> stdList = dao.SelectAll();
		for(StdVO vo : stdList) {
			System.out.println(vo);
		}
	}
	
	public void insert() {
		
		StdVO vo = this.stdInfoInput();
		if(vo==null) return;
		
		SqlSession session = this.sessionFactory.openSession();
		StdDao dao = session.getMapper(StdDao.class);

		int ret = dao.insert(vo);
		session.commit();
		session.close();
		
		if(ret > 0) {
			System.out.println("추가 성공:)");
		} else {
			System.out.println("추가 실패;)");
		}
		
	}
	
	private StdVO stdInfoInput() {
		
		StdVO vo = new StdVO();
		
		System.out.println("========================================");
		System.out.println("업데이트를 위한 정보를 입력해주세요");
		System.out.println("----------------------------------------");
		
		System.out.print("학번(0:종료)>> ");
		String strNum = scan.nextLine();
		if(strNum.equals("0")) return null;
		
		System.out.print("이름>> ");
		String strName = scan.nextLine();
		
		System.out.print("학년>> ");
		String strGrade = scan.nextLine();
		
		System.out.println("전화번호>>");
		String strTel = scan.nextLine();
		
		vo.setSt_num(strNum);
		vo.setSt_name(strName);
		vo.setSt_grade(strGrade);
		vo.setSt_tel(strTel);
		
		return vo;
	}

	public void update() {
		StdVO vo = this.stdInfoInput();
		if(vo==null) return;
	
		SqlSession session = this.sessionFactory.openSession();
		StdDao dao = session.getMapper(StdDao.class);

		int ret = dao.update(vo);
		session.commit();
		session.close();
		
		if(ret > 0) {
			System.out.println("추가 성공:)");
		} else {
			System.out.println("추가 실패;)");
		}
	}
	
}

