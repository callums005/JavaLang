package javalang.ExecutableCommands;

import java.util.List;
import javalang.ExecuteReturn;
import javalang.MemoryManager;
import javalang.MemoryObject;

public class Variables {
    public static ExecuteReturn NEW(List<MemoryObject> memory, String type, String variableName) {
	if (!type.equals("STRING") && !type.equals("INT")) 
	    return new ExecuteReturn(true, "Interperation Error: Variable type not supported");
	
	int loc = MemoryManager.GetMemoryLocationOfObject(memory, variableName);
	if (loc < 0) {
	    memory.add(new MemoryObject(variableName, type));
	    return new ExecuteReturn(false, "");
	}
	
	return new ExecuteReturn(true, "Interperation Error: Variable already defined. Cannot redefine variables");
    }
    
    public static ExecuteReturn SET(List<MemoryObject> memory, String variableName, String value) {
	int loc = MemoryManager.GetMemoryLocationOfObject(memory, variableName);
	if (loc < 0) {
	    return new ExecuteReturn(true, "Interperation Error: Variable not defined");
	}
	MemoryObject obj = memory.get(loc);
	
	if (obj != null) {
	    if (obj.Type.equals("STRING")) {
		obj.SValue = value;
	    } else if (obj.Type.equals("INT")) {
		obj.IValue = Integer.parseInt(value);
	    }

	    memory.set(MemoryManager.GetMemoryLocationOfObject(memory, variableName), obj);
	    return new ExecuteReturn(false, "");
	} else {
	    return new ExecuteReturn(true, "Interperation Error: Variable not defined");
	}
    }
    
    public static ExecuteReturn DELETE(List<MemoryObject> memory, String variableName) {
	int loc = MemoryManager.GetMemoryLocationOfObject(memory, variableName);
	if (loc < 0) {
	    return new ExecuteReturn(true, "Interperation Error: Variable not defined");
	}
	memory.remove(loc);
	
	return new ExecuteReturn(false, "");
    }
}
