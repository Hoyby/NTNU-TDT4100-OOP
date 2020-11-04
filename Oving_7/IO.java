package app_rev2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IO implements IOInterface {
	

	@Override
	public void save(Object o, String saveLocation) throws IOException {
		FileOutputStream fs = new FileOutputStream(saveLocation);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		
		os.writeObject(o);
		
		os.close();
		System.out.println("File was succesfully written to file");
	}

	@Override
	public Object load(String loadLocation) throws IOException, FileNotFoundException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream(loadLocation);
		ObjectInputStream oi = new ObjectInputStream(fi);
		
		Object o = oi.readObject();

		oi.close();
		System.out.println("Object was succesfully loaded from file");
		
		return o;		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, IllegalArgumentException {
		IOInterface save = new IO();
		Player p1 = new Player("Alex");
		System.out.println(p1.getName() + " - " + p1.getScore());
		try {
			save.save(p1, "C:\\Programming\\save.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Player p2 = (Player) save.load("C:\\Programming\\save.txt");
	
		System.out.println(p2.getName() + " - " + p2.getScore());		
	}

}
