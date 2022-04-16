package javalang.ExecutableCommands;

import java.util.List;
import javalang.ExecuteReturn;
import javalang.MemoryManager;
import javalang.MemoryObject;

public class Variables {
    public static ExecuteReturn NEW(List<MemoryObject> memory, String type, String variableName) {
	if (!type.equals("STRING") && !type.equals("INT") && !type.equals("BOOLEAN")) 
	    return new ExecuteReturn(true, "Interperation Error: Variable type not supported");
	
	int loc = MemoryManager.GetMemoryLocationOfObject(memory, variableName);
	if (loc < 0) {
	    memory.add(new MemoryObject(variableName, type));
	    return new ExecuteReturn(false, "");
	}
	
	return new ExecuteReturn(true, "Interperation Error: Variable already defined. Cannot redefine variables");
    }
    
    public static ExecuteReturn SET(List<MemoryObject> memory, String variableName, String[] value) {
	int loc = MemoryManager.GetMemoryLocationOfObject(memory, variableName);
	if (loc < 0) {
	    return new ExecuteReturn(true, "Interperation Error: Variable not defined");
	}
	MemoryObject obj = memory.get(loc);
	
	if (obj != null) {
	    if (obj.Type.equals("STRING")) {
		String v = "";
		
		for (int i=2; i < value.length; i++) {
		    v += (value[i] + " ");
		}
		
		obj.SValue = v;
	    } else if (obj.Type.equals("INT")) {
		try {
		    obj.IValue = Integer.parseInt(value[value.length - 1]);
		}
		catch (Exception e) {
		    return new ExecuteReturn(true, "Interperation Error: Unable to convert STRING to INT");
		}
		
	    } else if (obj.Type.equals("BOOLEAN")) {
		if (value[value.length - 1].equals("TRUE")) {
		    obj.IValue = 1;
		}
		else if (value[value.length - 1].equals("FALSE")) {
		    obj.IValue = 0;
		}
		else {
		    return new ExecuteReturn(true, "Interperation Error: Invalid boolean state. Ensure value is in block capitals");
		}
	    }

	    memory.set(MemoryManager.GetMemoryLocationOfObject(memory, variableName), obj);
	    return new ExecuteReturn(false, "");
	} else {
	    return new ExecuteReturn(true, "Interperation Error: Variable not defined");
	}
    }
    
    public static ExecuteReturn DEL(List<MemoryObject> memory, String variableName) {
	int loc = MemoryManager.GetMemoryLocationOfObject(memory, variableName);
	if (loc < 0) {
	    return new ExecuteReturn(true, "Interperation Error: Variable not defined");
	}
	memory.remove(loc);
	
	return new ExecuteReturn(false, "");
    }
}
