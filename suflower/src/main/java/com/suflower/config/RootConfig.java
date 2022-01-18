package com.suflower.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


//xml 파일을 대신하는 자바 설정 파일
@Configuration
@ComponentScan(basePackages= {"com.suflower.*"})
@MapperScan(basePackages= {"com.suflower.mapper"})
public class RootConfig {
	
	//HikariCP 커넥션풀 
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		//HikariCP 초기 설정
//		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		
		//SQL Log를 제대로 보기위한 log4jdbc 라이브러리 사용후 설정
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:XE");
		hikariConfig.setUsername("suflower");
		hikariConfig.setPassword("password");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		return dataSource;
	}//dataSource
	
	//myBatis 핵심 SqlSessionFactory
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return(SqlSessionFactory) sqlSessionFactory.getObject();
	}//sqlSessionFactory
		
}//RootConfig

