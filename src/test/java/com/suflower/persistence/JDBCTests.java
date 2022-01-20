package com.suflower.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//JDBC 연결 테스트코드
	@Test
	public void testJDBCConnection() {
		try(Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE",
				"suflower",
				"password")){
			log.info(con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
