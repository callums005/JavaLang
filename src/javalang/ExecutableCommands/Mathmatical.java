package javalang.ExecutableCommands;

import java.util.List;
import javalang.ExecuteReturn;
import javalang.MemoryManager;
import javalang.MemoryObject;

public class Mathmatical {
    public static ExecuteReturn ADD(List<MemoryObject> memory, String resultVariable, String variableA, String variableB) {
	MemoryObject objA = MemoryManager.GetMemoryObject(memory, variableA);
	MemoryObject objB = MemoryManager.GetMemoryObject(memory, variableB);
	
	if (objA == null)
	    return new ExecuteReturn(true, "Interperation Error: VariableA not defined");
	if (objB == null)
	    return new ExecuteReturn(true, "Interperation Error: VariableB not defined");
	
	Variables.SET(memory, resultVariable, Integer.toString((objA.IValue + objB.IValue)));
	return new ExecuteReturn(false, "");
    }
    
    public static ExecuteReturn SUB(List<MemoryObject> memory, String resultVariable, String variableA, String variableB) {
	MemoryObject objA = MemoryManager.GetMemoryObject(memory, variableA);
	MemoryObject objB = MemoryManager.GetMemoryObject(memory, variableB);

	if (objA == null) {
	    return new ExecuteReturn(true, "Interperation Error: VariableA not defined");
	}
	if (objB == null) {
	    return new ExecuteReturn(true, "Interperation Error: VariableB not defined");
	}

	Variables.SET(memory, resultVariable, Integer.toString((objA.IValue - objB.IValue)));
	return new ExecuteReturn(false, "");
    }
    
    public static ExecuteReturn MUL(List<MemoryObject> memory, String resultVariable, String variableA, String variableB) {
	MemoryObject objA = MemoryManager.GetMemoryObject(memory, variableA);
	MemoryObject objB = MemoryManager.GetMemoryObject(memory, variableB);

	if (objA == null) {
	    return new ExecuteReturn(true, "Interperation Error: VariableA not defined");
	}
	if (objB == null) {
	    return new ExecuteReturn(true, "Interperation Error: VariableB not defined");
	}

	Variables.SET(memory, resultVariable, Integer.toString((objA.IValue * objB.IValue)));
	return new ExecuteReturn(false, "");
    }
    
    public static ExecuteReturn DIV(List<MemoryObject> memory, String resultVariable, String variableA, String variableB) {
	MemoryObject objA = MemoryManager.GetMemoryObject(memory, variableA);
	MemoryObject objB = MemoryManager.GetMemoryObject(memory, variableB);

	if (objA == null) {
	    return new ExecuteReturn(true, "Interperation Error: VariableA not defined");
	}
	if (objB == null) {
	    return new ExecuteReturn(true, "Interperation Error: VariableB not defined");
	}

	Variables.SET(memory, resultVariable, Integer.toString((objA.IValue / objB.IValue)));
	return new ExecuteReturn(false, "");
    }
}
