package com.saksham.cruddemo;

import com.saksham.cruddemo.dao.StudentDAO;
import com.saksham.cruddemo.dao.StudentDAOImpl;
import com.saksham.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return (args) -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all Students.");
		Integer recordsDeleted = studentDAO.deleteAll();
		System.out.println("Total records deleted: " + recordsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student Id: " + studentId);
		studentDAO.delete(3);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on ID: primary key
		int studentId = 1;
		Student student = studentDAO.findById(1);
		System.out.println("Student old value: " + student);

		// change first name to "Scooby"
		student.setFirstName("John");

		// update the student
		studentDAO.update(student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findByLastName("Doe");
		for(Student student : studentList) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		for(Student student : studentList) {
			System.out.println(student);
		}
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating 3 student object ...");
		Student student1 = new Student("Paul", "Doe", "paul@gmail.com");
		Student student2 = new Student("Mary", "Public", "mary@gmail.com");
		Student student3 = new Student("Bonita", "Applebum", "bonita@gmail.com");

		// save student object
		System.out.println("Saving new student object ...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create student object
		System.out.println("Creating new student object ...");
		Student student = new Student("Paul", "Doe", "paul@gmail.com");

		// save student object
		System.out.println("Saving new student object ...");
		studentDAO.save(student);

		// display the Id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
	}

	private void readStudent(StudentDAO studentDAO) {

		// create student object
		System.out.println("Creating new student object ...");
		Student student = new Student("Daffy", "Duck", "daffy@gmail.com");

		// save student object
		System.out.println("Saving new student object ...");
		studentDAO.save(student);

		// display the Id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());

		// retrieve student based on id: primary Key
		System.out.println("Fetching student with id: " + student.getId());
		Student fetchedStudent = studentDAO.findById(student.getId());
		System.out.println("Fetched student: " + fetchedStudent);
	}

}
