package project.controller;

import java.io.IOException;

import project.model.Courses;
import project.model.Students;

public interface IFileReading {
	
	public void save(String filename, Courses courses, Students students) throws IOException;
	
	public ObjectLoader load(String filename) throws IOException;
	
}
