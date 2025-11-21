package ajav.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ajav.exception.OutputFileException;

public class SimulationWriter {
	private static final String filename = "simulation.txt";
	private static BufferedWriter writer;

	private SimulationWriter() {
	}

	public static void init() {
		try {
			SimulationWriter.writer = new BufferedWriter(new FileWriter(filename));
			writer.write("");
		} catch (IOException e) {
			throw new OutputFileException("problem with initiation output file");
		}
	}

	public static void append(String message) {
		try {
			writer.append(message + "\n");
		} catch (IOException e) {
			throw new OutputFileException("problem with writing to output file, message: %s".formatted(message));
		}
	}

	public static void destroy() {
		try {
			writer.close();
		} catch (IOException e) {
			throw new OutputFileException("ploblem with closing output file");
		}
	}
}
