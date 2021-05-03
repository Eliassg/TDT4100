package project.model;

import java.util.ArrayList;
import java.util.List;

public class Courses {
	
	private List<Course> courses = new ArrayList<Course>();
	
	public List<Course> getCourses(){
		return new ArrayList<Course>(courses);
	}
	
	public void addCourse(Course course) {
		for (Course existingCourse : courses) {
			if (course.getCourseID().equals(existingCourse.getCourseID())) {
				throw new IllegalArgumentException("Course already exists.");
			}
		}
		courses.add(course);
	}
	
	public Course getCourse(String courseID) {
		for (Course course : courses) {
			if (courseID.equals(course.getCourseID())) {
				return course;
			}
		}
		throw new IllegalArgumentException("There is no course with the given course ID.");
	}
		
	public static void main(String[] args) {
		Course c1 = new Course("TDT4100", "OOP");
		Course c2 = new Course("TDT4140", "PU");
		Course c3 = new Course("TDT4110", "ITGK");
		Courses cs = new Courses();
		cs.addCourse(c1);
		cs.addCourse(c2);
		cs.addCourse(c3);
		for (Course course : cs.getCourses()) {
			System.out.println(course);
		}
		System.out.println(cs.getCourses());
	}

}
