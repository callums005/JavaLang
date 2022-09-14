package javalang;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    public static List<String> ReadFile(String path) {
	try {
	    File file = new File(path);
	    Scanner reader = new Scanner(file);
	    List<String> FileContent = new ArrayList<String>();

	    while (reader.hasNextLine()) {
		String data = reader.nextLine();
		FileContent.add(data);
	    }
	    reader.close();

	    return FileContent;
	} catch (FileNotFoundException e) {
		System.err.println("An error occured.");
		e.printStackTrace();
		return null;
	}
    }
}
