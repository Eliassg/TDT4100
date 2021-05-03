package project.model;

public class Result {

	private int result;
	private final Course course;
	private final Student student;

	
	public Result(Student student, int result, Course course) {
		if (invalidResult(result)) {
			throw new IllegalArgumentException("Result is not valid integer (1-5).");
		}
		this.student = student;
		this.result = result;
		this.course = course;
		this.student.addResult(this);
		this.course.addResult(this);
	}
	
	public Student getStudent() {
		return student;
	}
	
	public int getResult() {
		return result;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
	
	public Course getCourse() {
		return this.course;
	}
	
	private boolean invalidResult(int result) {
		return ((result < 1) || (result > 5)); 
	}
	@Override
	public String toString() {
		return String.valueOf(student.getStudNr()) + " - " + String.valueOf(getResult()) + " - " + 
				String.valueOf(course.getCourseID());
	}
	
	public static void main(String[] args) {
		Student s1 = new Student("eliassg", 1998, 12345);
		Course c1 = new Course("TDT4100", "OOP");
		Result r1 = new Result(s1, 5, c1);
		System.out.println(r1);
	}
}

