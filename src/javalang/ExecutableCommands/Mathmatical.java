package javalang.ExecutableCommands;

import java.util.List;
import javalang.ExecuteReturn;
import javalang.MemoryManager;
import javalang.MemoryObject;

public class Mathmatical {
    public static ExecuteReturn ADD(List<MemoryObject> memory, String resultVariable, String variableA, String variableB) {
	MemoryObject objA = MemoryManager.GetMemoryObject(memory, variableA);
	MemoryObject objB = MemoryManager.GetMemoryObject(memory, variableB);
	MemoryObject resultObj = MemoryManager.GetMemoryObject(memory, resultVariable);
	
	if (objA == null)
	    return new ExecuteReturn(true, "Interperation Error: VariableA not defined");
	if (objB == null)
	    return new ExecuteReturn(true, "Interperation Error: VariableB not defined");
	if (resultObj == null)
	    return new ExecuteReturn(true, "Interperation Error: ResultVariable not defined");
	
	if (!objA.Type.equals("INT") && !objA.Type.equals("FLOAT"))
	    return new ExecuteReturn(true, "Interperation Error: VariableA is not a number");
	if (!objB.Type.equals("INT") && !objB.Type.equals("FLOAT"))
	    return new ExecuteReturn(true, "Interperation Error: VariableB is not a number");
	
	String[] arr = new String[1];
	if (resultObj.Type.equals("INT"))
	    arr[0] = Integer.toString((objA.IValue + objB.IValue));
	else if (resultObj.Type.equals("FLOAT"))
	    arr[0] = Float.toString((objA.FValue + objB.FValue));
	Variables.SET(memory, resultVariable, arr);
	return new ExecuteReturn(false, "");
    }
    
    public static ExecuteReturn SUB(List<MemoryObject> memory, String resultVariable, String variableA, String variableB) {
	MemoryObject objA = MemoryManager.GetMemoryObject(memory, variableA);
	MemoryObject objB = MemoryManager.GetMemoryObject(memory, variableB);
	MemoryObject resultObj = MemoryManager.GetMemoryObject(memory, resultVariable);

	if (objA == null) {
	    return new ExecuteReturn(true, "Interperation Error: VariableA not defined");
	}
	if (objB == null) {
	    return new ExecuteReturn(true, "Interperation Error: VariableB not defined");
	}
	if (resultObj == null) {
	    return new ExecuteReturn(true, "Interperation Error: ResultVariable not defined");
	}

	if (!objA.Type.equals("INT") && !objA.Type.equals("FLOAT")) {
	    return new ExecuteReturn(true, "Interperation Error: VariableA is not a number");
	}
	if (!objB.Type.equals("INT") && !objB.Type.equals("FLOAT")) {
	    return new ExecuteReturn(true, "Interperation Error: VariableB is not a number");
	}

	String[] arr = new String[1];
	if (resultObj.Type.equals("INT")) {
	    arr[0] = Integer.toString((objA.IValue - objB.IValue));
	} else if (resultObj.Type.equals("FLOAT")) {
	    arr[0] = Float.toString((objA.FValue - objB.FValue));
	}
	Variables.SET(memory, resultVariable, arr);
	return new ExecuteReturn(false, "");
    }
    
    public static ExecuteReturn MUL(List<MemoryObject> memory, String resultVariable, String variableA, String variableB) {
	MemoryObject objA = MemoryManager.GetMemoryObject(memory, variableA);
	MemoryObject objB = MemoryManager.GetMemoryObject(memory, variableB);
	MemoryObject resultObj = MemoryManager.GetMemoryObject(memory, resultVariable);

	if (objA == null) {
	    return new ExecuteReturn(true, "Interperation Error: VariableA not defined");
	}
	if (objB == null) {
	    return new ExecuteReturn(true, "Interperation Error: VariableB not defined");
	}
	if (resultObj == null) {
	    return new ExecuteReturn(true, "Interperation Error: ResultVariable not defined");
	}

	if (!objA.Type.equals("INT") && !objA.Type.equals("FLOAT")) {
	    return new ExecuteReturn(true, "Interperation Error: VariableA is not a number");
	}
	if (!objB.Type.equals("INT") && !objB.Type.equals("FLOAT")) {
	    return new ExecuteReturn(true, "Interperation Error: VariableB is not a number");
	}

	String[] arr = new String[1];
	if (resultObj.Type.equals("INT")) {
	    arr[0] = Integer.toString((objA.IValue * objB.IValue));
	} else if (resultObj.Type.equals("FLOAT")) {
	    arr[0] = Float.toString((objA.FValue * objB.FValue));
	}
	Variables.SET(memory, resultVariable, arr);
	return new ExecuteReturn(false, "");
    }
    
    public static ExecuteReturn DIV(List<MemoryObject> memory, String resultVariable, String variableA, String variableB) {
	MemoryObject objA = MemoryManager.GetMemoryObject(memory, variableA);
	MemoryObject objB = MemoryManager.GetMemoryObject(memory, variableB);
	MemoryObject resultObj = MemoryManager.GetMemoryObject(memory, resultVariable);

	if (objA == null) {
	    return new ExecuteReturn(true, "Interperation Error: VariableA not defined");
	}
	if (objB == null) {
	    return new ExecuteReturn(true, "Interperation Error: VariableB not defined");
	}
	if (resultObj == null) {
	    return new ExecuteReturn(true, "Interperation Error: ResultVariable not defined");
	}

	if (!objA.Type.equals("INT") && !objA.Type.equals("FLOAT")) {
	    return new ExecuteReturn(true, "Interperation Error: VariableA is not a number");
	}
	if (!objB.Type.equals("INT") && !objB.Type.equals("FLOAT")) {
	    return new ExecuteReturn(true, "Interperation Error: VariableB is not a number");
	}

	String[] arr = new String[1];
	if (resultObj.Type.equals("INT")) {
	    arr[0] = Integer.toString((objA.IValue / objB.IValue));
	} else if (resultObj.Type.equals("FLOAT")) {
	    arr[0] = Float.toString((objA.FValue / objB.FValue));
	}
	Variables.SET(memory, resultVariable, arr);
	return new ExecuteReturn(false, "");
    }
}
