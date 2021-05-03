package src.main.java.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import project.model.Course;
import project.model.Courses;

/*
 * Due to small classes Course and Courses were not separated into two Test classes. Same applies for relatively few and not complex logic in functions within classes,
 * hence the decision not to make separate test functions within the test classes.
 */
 
public class courseTest {

	@Test
	public void CourseTest() {
		Course course = new Course("99", "Markedsføring");
			assertEquals("99", course.getCourseID());
			assertEquals("Markedsføring", course.getCourseName());
			// empty course name
			assertThrows(IllegalArgumentException.class, () -> {
				Course course1 = new Course("100","");
				});
			// course name null
			assertThrows(IllegalArgumentException.class, () -> {
				Course course2 = new Course("100", null);
				});
			assertThrows(IllegalArgumentException.class, () -> {
				Course course3 = new Course("", "Matte");
				});
			// courseID null
			assertThrows(IllegalArgumentException.class, () -> {
				Course course4 = new Course(null, "Matte");
				});
		}
	
	@Test
	public void CoursesTest() {
		Course c1 = new Course("1","Norsk");
		Course c2 = new Course("2","Fysikk");
		Course c3 = new Course("3","Java");
		Course c4 = new Course("4","ITGK");
		Courses cs = new Courses();
		
		cs.addCourse(c1);
		cs.addCourse(c2);
		cs.addCourse(c3);
		cs.addCourse(c4);
		
		List<Course> courses = new ArrayList<Course>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);
		
		assertEquals(c1, cs.getCourse("1"));
		assertEquals(courses, cs.getCourses());
		// course does not exists 
		assertThrows(IllegalArgumentException.class, () -> {
			cs.getCourse("99");
		});
		// course already exist
		assertThrows(IllegalArgumentException.class, () -> {
			cs.addCourse(c2);
		});

	}

}

		

		
		

	

	
	
		
		


	

		
		
