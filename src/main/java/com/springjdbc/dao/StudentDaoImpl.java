package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entites.Student;
@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
//	private JdbcTemplate jdbcTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		 //insert query
        String query="insert into student(id,name,city) values(?,?,?)";
        int result=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return result;
	}

	public int update(Student student) {
		//update query
        String query="update student set name=? , city=? where id=?";
        int result=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return result;

	}
	
	public int delete(int studentId) {
		//delete record
        String query="delete from student where id=?";
        int result=this.jdbcTemplate.update(query,studentId);
		return result;
	}
	
	public Student getStudent(int studentId) {
		//get single record
        String query="select * from student where id=?";
        RowMapper<Student> rowMapper=new RowMapperImpl();
        Student student=this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}
	
	
	public List<Student> getAllStudent() {
		//get all record
		String query="select * from student";
		List<Student> students=this.jdbcTemplate.query(query, new RowMapperImpl());	
		return students;
	}

	

	
	
	///getter setter
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

}
