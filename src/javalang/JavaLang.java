package javalang;

import java.util.List;
import java.util.ArrayList;

import javalang.FileHandler;
import javalang.Interperater;
import javalang.MemoryObject;

public class JavaLang {

    public static void main(String[] args) {
	List<String> instructions = FileHandler.ReadFile(args[0]);
	List<MemoryObject> memory = new ArrayList<>();
	
	for (int i = 0; i < instructions.size(); i++) {	    
	    if (!";".equals(Character.toString(instructions.get(i).charAt(0)))) {
		Interperater.InterperateInstruction(instructions.get(i), i + 1, memory);
	    }
	}
    }    
}
