package src.main.java.project.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import project.model.Student;
import project.model.Students;

/*
 * Due to small classes Student and Students were not separated into two Test classes. Same applies for relatively few and not complex logic in functions within classes,
 * hence the decision not to make separate test functions within the test classes.
 */

public class studentTest {
	@Test
	public void StudentTest() {
		Student student = new Student("Ola", 1996, 15);
		assertEquals("Ola", student.getUsername());
		assertEquals(1996, student.getBirthYear());
		assertEquals(15, student.getStudNr());
		// student name is null
		assertThrows(IllegalArgumentException.class, () -> {
			Student s1 = new Student(null,1996,0);
		});
		// student name is empty
		assertThrows(IllegalArgumentException.class, () -> {
			Student s1 = new Student("",1814,0);
		});
		// student name contains numeric 
		assertThrows(IllegalArgumentException.class, () -> {
			Student s1 = new Student("student1",1814,0);
		});
		// student name contains space
		assertThrows(IllegalArgumentException.class, () -> {
			Student s1 = new Student("student one",1814,0);
		});
		// illegal birthyear, too young 
		assertThrows(IllegalArgumentException.class, () -> {
			Student s1 = new Student("Per",2010,0);
		});
		// illegal birthyear, too old
		assertThrows(IllegalArgumentException.class, () -> {
			Student s1 = new Student("Per",1814,0);
		});
	}
		
		@Test
		public void StudentsTest() {
			Student s1 = new Student("Petter",1996,1);
			Student s2 = new Student("Ole",1996,2);
			Student s3 = new Student("Gro",1996,3);
			Student s4 = new Student("Lise",1996,4);
			Students s = new Students();
			
			s.addStudent(s1);
			s.addStudent(s2);
			s.addStudent(s3);
			s.addStudent(s4);
			
			List<Student> students = new ArrayList<Student>();
			students.add(s1);
			students.add(s2);
			students.add(s3);
			students.add(s4);
			
			assertEquals(s1, s.getStudent(1));
			// student does not exist
			assertThrows(IllegalArgumentException.class, () -> {
				s.getStudent(1000);
			});
			// get student returns student correctly
			assertEquals(s4, s.getStudent(4));
			
			assertEquals(students, s.getStudents());
			// student already in students
			assertThrows(IllegalArgumentException.class, () -> {
				s.addStudent(s4);
			});
	
			
		
		}
}




		
		
		
	
