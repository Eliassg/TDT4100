package app_oving;

import java.io.IOException;


public interface app_loading {
	
	public void save(String filename, Turn player) throws IOException;
	
	public app_objectloader load(String filename) throws IOException;
}		
