package project.model;

import java.util.ArrayList;
import java.util.List;

public class Students {
	
	private List<Student> students = new ArrayList<Student>();
	
	public List<Student> getStudents(){
		return students;
	}
	
	public void addStudent(Student student) {
		for (Student existingStudent : students) {
			if ((student.getStudNr() == existingStudent.getStudNr()) || 
					(student.getUsername().equals(existingStudent.getUsername()))) {
					throw new IllegalArgumentException("Student number or username is not unique.");
			}
 		}
		students.add(student);
	}
	
	public Student getStudent(int studNr) {
		for (Student student : students) {
			if (studNr == student.getStudNr()) {
				return student;
			}
		}
		throw new IllegalArgumentException("There is no student with the given student number.");
	}
	
	public static void main(String[] args) {
		Students s = new Students();
		s.addStudent(new Student("eliassg", 1998, 12345));
		System.out.println(s.students);
		//s.addStudent(new Student("eliassg", 1998, 12355));
		//s.addStudent(new Student("elias", 1998, 12345));
	}
	
}
