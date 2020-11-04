package app_rev2;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IOInterface {
	
	void save(Object o, String saveLocation) throws IOException;
	
	Object load(String loadLocation) throws IOException, FileNotFoundException, ClassNotFoundException;
	
}
