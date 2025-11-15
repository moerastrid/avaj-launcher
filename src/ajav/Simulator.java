package ajav;

import ajav.exception.InputException;
import ajav.utils.FileUtils;
import java.io.File;

public class Simulator {
	
	public Simulator() {}

	// DONE read the input filename from terminal + return File

	// open the file
	// convert the input scenario from the file to the simulation
	// close the file 
	// run the simulation x times (see input scenario for amount)

	
	public static void main(String[] args) {
		File file;
		try {
			file = FileUtils.getFile(args);
			System.out.println("Opening file %s...".formatted(file));
		} catch (InputException e) {
			System.err.println(e.getMessage());
			return;
		}

		
	}
}
