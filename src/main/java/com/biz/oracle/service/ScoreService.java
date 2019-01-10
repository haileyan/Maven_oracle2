package com.biz.oracle.service;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.biz.oracle.dao.ScoreDao;
import com.biz.oracle.db.OracleSqlFactory;
import com.biz.oracle.vo.ScoreVO;

public class ScoreService {

	SqlSessionFactory sessionFactory;
	Scanner scan;

	public ScoreService() {
		scan = new Scanner(System.in);

		OracleSqlFactory sqlFactory = new OracleSqlFactory();
		this.sessionFactory = sqlFactory.getSessionFactory();
	}
	
	public List<ScoreVO> viewScore(String st_num) {
		SqlSession session = this.sessionFactory.openSession();
		ScoreDao dao = session.getMapper(ScoreDao.class);
		
		List<ScoreVO> scoreList = dao.findByStNum(st_num);
		for(ScoreVO s : scoreList) {
			System.out.println(s);
		}
		return scoreList;
	}
	
	
}
