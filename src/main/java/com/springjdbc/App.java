package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entites.Student;

/**
 * spring JDBC crud operation !
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "spring jdbc project started...." );

		///////////for xml configuration//////////////////
		//        ApplicationContext con = new ClassPathXmlApplicationContext("com/springjdbc/config.xml");
		
		
		///////////for xml configuration//////////////////
		ApplicationContext con = new AnnotationConfigApplicationContext(JdbcConfig.class);
		

		/////////////////normal without dao class//////////////////////
		//        JdbcTemplate template = con.getBean("jdbcTemplate",JdbcTemplate.class);
		//        
		//        //insert query
		//        String query="insert into student(id,name,city) values(?,?,?)";
		//        
		//        //execute your query
		//        int result=template.update(query,3,"Nilesh","Mumbai");
		//        System.out.println(result+" number of record inserted...");

		StudentDao studentDao = con.getBean("studentDao",StudentDao.class);

		///insert data///
		//        Student student=new Student();
		//        student.setId(4);
		//        student.setName("Rakshit");
		//        student.setCity("Bangaore");
		//        
		//        int result=studentDao.insert(student);
		//        System.out.println(result+" number of record inserted...");



		///update data///
		//        Student student=new Student();
		//      student.setId(4);
		//      student.setName("avanish");
		//      student.setCity("noida");
		//      
		//      int result=studentDao.update(student);
		//      System.out.println(result+" record updated...");



		///delete data///
		//      int result=studentDao.delete(4);
		//      System.out.println(result+" record deleted...");




		///get one student data///
		//        Student s=studentDao.getStudent(2);
		//        System.out.println(s);


		///get all record ///
		List<Student> students=studentDao.getAllStudent();
		students.forEach(s->System.out.println(s));

	}
}
