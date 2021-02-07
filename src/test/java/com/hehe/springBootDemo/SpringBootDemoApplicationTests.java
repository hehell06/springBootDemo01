package com.hehe.springBootDemo;

import com.hehe.springBootDemo.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootTest
class SpringBootDemoApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	public void test02() throws SQLException {
		System.out.println(dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}

	@Autowired
	Person person;

	@Test
	void contextLoads() {
		System.out.println(person);
	}

}
