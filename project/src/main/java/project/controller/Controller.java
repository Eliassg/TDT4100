package project.controller;
import java.io.IOException;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import project.model.*;


public class Controller {

    @FXML
    private Button addStudent;

    @FXML
    private TextField usernameForm;

    @FXML
    private TextField studNrForm;

    @FXML
    private TextField birthYearForm;
    
    @FXML
    private TextField resultStudNr;

    @FXML
    private TextField resultCourseID;

    @FXML
    private TextField resultForm;
    
    @FXML
    private Button addResult;

    @FXML
    private TextField courseIdForm;

    @FXML
    private TextField courseNameForm;

    @FXML
    private Button addCourse;
    
    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, String> studentCol;
    
    @FXML
    private TableColumn<Student, String> GPACol;
    
    @FXML
    private TableView<Course> courseTable;

    @FXML
    private TableColumn<Course, String> courseCol;
    
    @FXML
    private TableColumn<Course, String> courseGPACol;
    
    @FXML
    private MenuItem closeButton;
    
    @FXML
    private MenuItem saveMenuItem;
    
    @FXML
    private MenuItem loadMenuItem;
    
    @FXML
    private MenuItem loadDefaultMenuItem;
    
    @FXML
    public void initialize() {
    	// initializes tables in application
    	studentCol.setCellValueFactory(new PropertyValueFactory<>("studNr"));
    	GPACol.setCellValueFactory(new PropertyValueFactory<>("GPA"));
    	courseCol.setCellValueFactory(new PropertyValueFactory<>("courseID"));
    	courseGPACol.setCellValueFactory(new PropertyValueFactory<>("GPA"));
    }
        
    private Courses c = new Courses();
    private Students s = new Students();
    private FileSupport io = new FileSupport();
    
    public void createStudent() {
    	// retrieve input from form 
    	int studNr = 0;
    	int birthYear = 0;
    	String username = usernameForm.getText();
    	// in case of no integer input
    	try {
    		studNr = Integer.parseInt(studNrForm.getText());
        	birthYear = Integer.parseInt(birthYearForm.getText());
    	} catch(Exception e) {
    		throw new IllegalArgumentException("Birth year and/or student number does not have an integer value.");
    	}
    	// add student in students
    	s.addStudent(new Student(username, birthYear, studNr));
    	System.out.println(s.getStudents());
    	// set students in table
    	updateTables();
    }
    
    public void createCourse() {
    	// retrieve input from form
    	String courseID = courseIdForm.getText();
    	String courseName = courseNameForm.getText();
    	// add course in courses
    	c.addCourse(new Course(courseID, courseName));
    	System.out.println(c.getCourses());
    	// set courses in table
    	updateTables();
    }
    
    public void createResult() {
    	// retrieve input from form
    	Course course = c.getCourse(resultCourseID.getText());
    	int studNr = 0;
    	int result = 0;
    	
    	try {
    		studNr = Integer.parseInt(resultStudNr.getText());
        	result = Integer.parseInt(resultForm.getText());
    	} catch(Exception e) {
    		throw new IllegalArgumentException("Student number and/or result does not have an integer value.");
    	}
    	Student student = s.getStudent(studNr);
    	new Result(student, result, course);
    	System.out.println(student.getResults());
    	System.out.println(course.getResults());
    	// updating tables with result
    	updateTables();
    }
    
    
    public void updateTables() {
    	ObservableList<Student> students = FXCollections.observableList(s.getStudents());
    	ObservableList<Course> courses = FXCollections.observableList(c.getCourses());
    	studentTable.setItems(students);
    	courseTable.setItems(courses);
    	//to refresh fields in existing rows
    	studentTable.getColumns().get(0).setVisible(false);
    	studentTable.getColumns().get(0).setVisible(true);
    	courseTable.getColumns().get(0).setVisible(false);
    	courseTable.getColumns().get(0).setVisible(true);
    }
    
    public void save() {
    	try {
    		io.save("courses.txt", c, s);
    	} catch (IOException e) {
    		System.err.print(e);
    	}
    }
    
    public void load() {
    	ObjectLoader loader = new ObjectLoader();
    	try {
        	loader = io.load("courses.txt");
    	} catch (IOException e) {
    		System.err.print(e);
    	}
    	c = loader.courses;
    	s = loader.students;
    	updateTables();
    }
    
    public void loadDefault() {
    	ObjectLoader loader = new ObjectLoader();
    	try {
        	loader = io.load("defaultValues.txt");
    	} catch (IOException e) {
    		System.err.print(e);
    	}
    	c = loader.courses;
    	s = loader.students;
    	updateTables();
    }
    
    public void close() {
    	Platform.exit();
    }   
}
