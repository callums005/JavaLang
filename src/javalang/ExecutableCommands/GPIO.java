package javalang.ExecutableCommands;

import java.util.List;
import java.util.Scanner;
import javalang.ExecuteReturn;
import javalang.MemoryManager;
import javalang.MemoryObject;

public class GPIO {
    public static ExecuteReturn IN(List<MemoryObject> memory, String variableName) {
	int loc = MemoryManager.GetMemoryLocationOfObject(memory, variableName);
	if (loc < 0) return new ExecuteReturn(true, "Interperation Error: Variable not defined");
	MemoryObject obj = memory.get(loc);

	if (obj != null) {
	    System.out.println("USER INPUT:");
	    Scanner scanner = new Scanner(System.in);
	    if (obj.Type.equals("STRING")) {
		obj.SValue = scanner.nextLine();
	    } else if (obj.Type.equals("INT")) {
		obj.IValue = scanner.nextInt();
	    }
	    
	    memory.set(MemoryManager.GetMemoryLocationOfObject(memory, variableName), obj);
	    return new ExecuteReturn(false, "");
	} else {
	    return new ExecuteReturn(true, "Interperation Error: Variable not defined");
	}
    }
    
    public static ExecuteReturn OUT(List<MemoryObject> memory, String variableName) {
	MemoryObject obj = MemoryManager.GetMemoryObject(memory, variableName);
	
	if (obj != null) {
	    if (obj.Type.equals("STRING")) {
		System.out.println(obj.SValue);
	    }
	    else if (obj.Type.equals("INT")) {
		System.out.println(obj.IValue);
	    }
	    return new ExecuteReturn(false, "");
	}
	else {
	    return new ExecuteReturn(true, "Interperation Error: Variable not defined");
	}
    }
}
