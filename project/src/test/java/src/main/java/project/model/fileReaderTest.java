package src.main.java.project.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import project.controller.FileSupport;
import project.controller.ObjectLoader;


public class fileReaderTest {

	@Test
	public void fileReadingTest() throws IOException { 
		FileSupport io = new FileSupport();
		ObjectLoader loader = io.load("defaultValues.txt");
		assertEquals(loader.students.getStudents().get(0).toString(),"94060 - gcdnc - 1993");
		
	}
		
	

	

}
