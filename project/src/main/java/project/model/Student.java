package project.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class Student {
	
	private final String username;
	private final int birthYear;
	private final int studNr;
	private float GPA;
	private Collection<Result> results = new ArrayList<Result>();
	
	public Student(String username, int birthYear, int studNr) {
		if (notAlpha(username)) {
			throw new IllegalArgumentException("Username must not be empty and be all letters.");
		}
		if (illegalAge(birthYear)) {
			throw new IllegalArgumentException("Illegal birth year.");
		}
		this.username = username;
		this.birthYear = birthYear;
		this.studNr = studNr;
	}
	
	public void addResult(Result result) {
		boolean unique = true;
		for (Result existingResult : results) {
			if (existingResult.getCourse().getCourseID().equals(result.getCourse().getCourseID())) {
				if (existingResult.getResult() >= result.getResult()) {
					throw new IllegalArgumentException("New result is not better than existing result.");
				}
				unique = false;
				existingResult.setResult(result.getResult());
			}
		}
		if (unique) {
			results.add(result);
		}
		updateGPA();
	}
	
	public String getUsername() {
		return username;
	}

	public  int getBirthYear() {
		return birthYear;
	}

	public int getStudNr() {
		return studNr;
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
	
	public float getGPA() {
		updateGPA();
		return GPA;
	}
	
	public Collection<Result> getResults(){
		return new ArrayList<Result>(results);
	}

	public String toString() {
		return studNr + " - " + username + " - " + birthYear;
	}
	
	private boolean notAlpha(String name) {
		return (name == null) || !(name.chars().allMatch(Character :: isLetter) || "".equals(name)); 
	}
	private boolean illegalAge(int birthYear) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		return (year - birthYear >= 100 || year - birthYear <= 17);
	}
	
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		System.out.println(year);
		
		Course c1 = new Course("TDT4100", "OOP");
		Course c2 = new Course("TDT4110", "ITGK");
		
		Student s1 = new Student("studentone", 1998, 12345);
		System.out.println(s1);
		Student s2 = new Student("student", 2000, 12345);
		System.out.println(s2);
		new Result(s1, 4, c1);
		new Result(s1, 3, c2);
		System.out.println(s1.results);
		new Result(s1, 5, c1);
		System.out.println(s1.results);
		System.out.println(s1.getGPA());
		
	}

}
