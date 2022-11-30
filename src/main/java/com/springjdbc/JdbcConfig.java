package com.springjdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.dao.StudentDaoImpl;
@Configuration
@ComponentScan(basePackages = {"com.springjdbc.dao"})
public class JdbcConfig {

	@Bean(name= {"ds"})
	public DataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		ds.setUrl("jdbc:sqlserver://localhost;databaseName=StudentJDBC;instanceName=SQLEXPRESS;");
		ds.setUsername("sa");
		ds.setPassword("password_123");
		return ds;
	}
	@Bean(name= {"jdbcTemplate"})
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	/////////when we do not use autowiring for this.///////////
//	@Bean(name= {"studentDao"})
//	public StudentDao getStudentDao() {
//		StudentDaoImpl studentDao=new StudentDaoImpl();
//		studentDao.setJdbcTemplate(getTemplate());
//		return studentDao;
//	}
}
