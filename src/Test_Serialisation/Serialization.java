package Test_Serialisation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Serializes an ApplicationHandler object with all timetable databases
 * 		in the case of the program closing
 * @author Xavier Bouchenard
 */
public class Serialization {	
	
	/**
	 * 	Represents the object which will serialize
	 */
	private ObjectOutputStream oos = null;
	
	/**
	 * 	Defines an output file in which the program will write all the info
	 */
	private FileOutputStream file = null;
	
	/**
	 * Constructor of the Serialization class
	 * @author Xavier Bouchenard
	 */
	public Serialization() {
		try {
			file = new FileOutputStream("file.txt");
			try {
				oos = new ObjectOutputStream(file);
			} catch (IOException e) {
				System.out.println("Unable to open the file");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to create the file called dataSaves.txt");
		}
	}
	
	/**
	 * Writes the data in the ApplicationHandler obj
	 * @author Xavier Bouchenard
	 * @param obj	ApplicationHandler object to serialize
	 */
	@SuppressWarnings("static-access")
	public void writeData(String phrase) {
			try {
				oos.writeObject(phrase);
				oos.flush();
			} catch (IOException e) {
				System.out.println("Unable to write the content of the ApplicationHandler object");
			} finally {
				if (oos != null) {
					try {
						oos.flush();
						oos.close();
					} catch (IOException e) {
						System.out.println("Unable to close the output stream");
					}
				}
			}	
	}
}
