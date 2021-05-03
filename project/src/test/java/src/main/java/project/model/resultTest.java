package src.main.java.project.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import project.model.Course;
import project.model.Student;
import project.model.Result;

 public class resultTest {
	@Test
	public void ResultTest() {
		Student student = new Student("Ole", 1996, 1000);
		Course course = new Course("2", "PPL");
		Course course1 = new Course("3", "Matte");
		Course course2 = new Course("4", "Fysikk");

		Result result = new Result(student, 3, course);
		Result result1 = new Result(student, 4, course1);
		// get GPA
		assertEquals(3.5, student.getGPA());
		// add new result
		Result result2 = new Result(student, 5, course);
		// get GPA again
		assertEquals(4.5, student.getGPA());
		// new result which is lower
		assertThrows(IllegalArgumentException.class, () -> {
			Result result4 = new Result(student, 3, course1);
		});
		// new results which is not valid result value(1-5)
		assertThrows(IllegalArgumentException.class, () -> {
			Result result0 = new Result(student, 0, course1);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Result result3 = new Result(student,7,course1);
		});

		
		
		
	}

}
