package project.model;

import java.util.ArrayList;
import java.util.Collection;

public class Course {
	
	private final String courseID; 
	private final String courseName;
	private float GPA;
	//private ObservableList<Result> results = FXCollections.observableArrayList();
	private Collection<Result> results = new ArrayList<Result>();
	
	public Course(String courseID, String courseName) {
		if (emptyArg(courseID) || emptyArg(courseName)) {
			throw new IllegalArgumentException("Course ID or course name cannot be empty.");
		}
		this.courseID = courseID;
		this.courseName = courseName;
	}
	
	public void addResult(Result result) {
		boolean unique = true;
		for (Result existingResult : results) {
			if (existingResult.getStudent().getStudNr() == result.getStudent().getStudNr()) {
				unique = false;
				existingResult.setResult(result.getResult());
			}
		}
		if (unique) {
			results.add(result);
		}
		updateGPA();
	}
	
	public String getCourseID() {
		return courseID;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public float getGPA() {
		updateGPA();
		return GPA;
	}
	
	public void updateGPA() {
		float avg = 0;
		for (Result result : results) {
			avg += result.getResult();
		}
		if(results.size() > 0) {
			GPA = avg / results.size();
		}
	}
	
	public Collection<Result> getResults(){
		return new ArrayList<Result>(results);
	}
	
	public boolean emptyArg(String arg) {
		return ("".equals(arg) || arg == null);
	}
	
	@Override
	public String toString() {
		return this.courseID + " - " + this.courseName;
	}
	
	public static void main(String[] args) {
		Course c = new Course(null, "OOP");
		System.out.println(c);
	}
	

}
