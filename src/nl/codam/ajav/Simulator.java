package nl.codam.ajav;

import nl.codam.ajav.exception.WrongAmountOfArgumentsException;

public class Simulator {
	
	public Simulator() {}

	// read the input filename from terminal
	// open the text file
	// convert the input scenario from the file to the simulation
	// close the text file 
	// run the simulation x times (see input scenario for amount)

	
	public static void main(String[] args) {
		//private final String filename = getFilename(args);
		String filename;

		try {
			filename = getFileName(args);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
			return;
		}

		System.out.println("Opening file " + filename + "..");
		
	}

	private static String getFileName(String[] args) {
		if (args.length != 1) {
			throw (new WrongAmountOfArgumentsException("wrong amount of arguments"));
		}
		return args[0];
	};

}
