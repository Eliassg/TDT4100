package project.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import project.model.Course;
import project.model.Courses;
import project.model.Result;
import project.model.Student;
import project.model.Students;

public class FileSupport implements IFileReading {

	@Override
	public void save(String filename, Courses courses, Students students) throws IOException {
		PrintWriter writer = new PrintWriter(filename);
		writer.println("#Courses");
		for (Course course : courses.getCourses()) {
			String filetext = String.format("%s,%s", course.getCourseID(), course.getCourseName());
			writer.println(filetext);
		}
		writer.println("#Students");
		for (Student student : students.getStudents()) {
			String filetext = String.format("%s,%d,%d", student.getUsername(), student.getBirthYear(), student.getStudNr());
			writer.println(filetext);
		}
		writer.println("#Results");
		for (Student student : students.getStudents()) {
			for (var result : student.getResults()) {
				String filetext = String.format("%d,%d,%s", result.getStudent().getStudNr(), result.getResult(), result.getCourse().getCourseID());
				writer.println(filetext);
			}
		}
		writer.close();
	}

	@Override
	public ObjectLoader load(String filename) throws IOException {
		Scanner scanner = new Scanner(new File(filename));
		ObjectLoader loader = new ObjectLoader();
		// read courses
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			if (line.startsWith("#Courses")) {
				continue;
			} if (line.startsWith("#Students") || line.startsWith("#Results")) {
				break;
			} else {
				String[] course = line.split(",");
				loader.courses.addCourse(new Course(course[0], course[1]));
			}
		}
		// read students
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			if (line.startsWith("#Results")) {
				break;
			} else {
				String[] student = line.split(",");
				loader.students.addStudent(new Student(student[0], Integer.parseInt(student[1]), Integer.parseInt(student[2])));
			}
		}
		// read results
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			String[] result = line.split(",");
			Student student = loader.students.getStudent(Integer.parseInt(result[0]));
			int res = Integer.parseInt(result[1]);
			Course course = loader.courses.getCourse(result[2]);
			new Result(student, res, course);
		}
		scanner.close();
		return loader;
	}
	
	
	public static void main(String[] args) throws IOException {
		FileSupport io = new FileSupport();
		ObjectLoader loader = io.load("Courses.txt");
		System.out.println(loader.students.getStudents());
		
		
		
		
	}

}
