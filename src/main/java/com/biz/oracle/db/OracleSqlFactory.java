package com.biz.oracle.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.biz.oracle.dao.ScoreDao;
import com.biz.oracle.dao.StdDao;

public class OracleSqlFactory {

	SqlSessionFactory sessionFactory;
	
	public SqlSessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	
	public OracleSqlFactory() {
		// TODO Auto-generated constructor stub
		Properties props = new Properties();
		
		props.put("DRIVER", DBContract.ORACLE_PRO.Driver);
		props.put("URL", DBContract.ORACLE_PRO.url);
		props.put("USER", DBContract.ORACLE_PRO.user);
		props.put("PASSWORD", DBContract.ORACLE_PRO.password);
		
		StdDataSourceFactory dataFactory = new StdDataSourceFactory();
		dataFactory.setProperties(props);
		
		DataSource dataSource = dataFactory.getDataSource();
		
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		
		Environment env = new Environment("GradeENV", transactionFactory, dataSource);
		
		Configuration config = new Configuration(env);
		config.addMapper(StdDao.class);
		config.addMapper(ScoreDao.class);
		
		this.sessionFactory = new SqlSessionFactoryBuilder().build(config);
	
	}
}
