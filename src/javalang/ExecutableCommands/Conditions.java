package javalang.ExecutableCommands;

import java.util.List;
import javalang.ConditionExecuteReturn;
import javalang.MemoryManager;
import javalang.MemoryObject;

public class Conditions { 
    public static ConditionExecuteReturn IF_STATEMENT(List<String> lines, int currentLine, List<MemoryObject> memory, 
	    String variableA, String operator, String variableB) {
	MemoryObject objA = MemoryManager.GetMemoryObject(memory, variableA);
	MemoryObject objB = MemoryManager.GetMemoryObject(memory, variableB);
	boolean c = false;
	
	if (objA == null)
	    return new ConditionExecuteReturn(true, "Interperation Error: VariableA not defined");
	if (objB == null)
	    return new ConditionExecuteReturn(true, "Interperation Error: VariableB not defined");
	
	if (!objA.Type.equals(objB.Type)) 
	    return new ConditionExecuteReturn(true, "Logic Error: Arguments are not the same type");
	
	if (!operator.equals("==") && 
		!operator.equals("!=") &&
		!operator.equals("<") && 
		!operator.equals("<=") && 
		!operator.equals(">") && 
		!operator.equals(">=")) 
	    return new ConditionExecuteReturn(true, "Logic Error: No operator \"" + operator + "\"");
	
	switch (operator) {
	    case "==":
		if (objA.Type.equals("STRING"))
		    c = objA.SValue.equals(objB.SValue);
		else if (objA.Type.equals("INT") || objA.Type.equals("BOOLEAN"))
		    c = objA.IValue == objB.IValue;
		else if (objA.Type.equals("FLOAT")) 
		    c = objA.FValue == objB.FValue;
		break;
	    case "!=":
		if (objA.Type.equals("STRING")) {
		    c = !objA.SValue.equals(objB.SValue);
		} else if (objA.Type.equals("INT") || objA.Type.equals("BOOLEAN")) {
		    c = objA.IValue != objB.IValue;
		} else if (objA.Type.equals("FLOAT")) {
		    c = objA.FValue != objB.FValue;
		}
		break;
	    case "<":
		if (objA.Type.equals("STRING")) {
		    return new ConditionExecuteReturn(true, "Logic Error: Invalid types for mathmatical operator. ");
		} else if (objA.Type.equals("INT") || objA.Type.equals("BOOLEAN")) {
		    c = objA.IValue < objB.IValue;
		} else if (objA.Type.equals("FLOAT")) {
		    c = objA.FValue < objB.FValue;
		}
		break;
	    case "<=":
		if (objA.Type.equals("STRING")) {
		    return new ConditionExecuteReturn(true, "Logic Error: Invalid types for mathmatical operator. ");
		} else if (objA.Type.equals("INT") || objA.Type.equals("BOOLEAN")) {
		    c = objA.IValue <= objB.IValue;
		} else if (objA.Type.equals("FLOAT")) {
		    c = objA.FValue <= objB.FValue;
		}
		break;
	    case ">":
		if (objA.Type.equals("STRING")) {
		    return new ConditionExecuteReturn(true, "Logic Error: Invalid types for mathmatical operator. ");
		} else if (objA.Type.equals("INT") || objA.Type.equals("BOOLEAN")) {
		    c = objA.IValue > objB.IValue;
		} else if (objA.Type.equals("FLOAT")) {
		    c = objA.FValue > objB.FValue;
		}
		break;
	    case ">=":
		if (objA.Type.equals("STRING")) {
		    return new ConditionExecuteReturn(true, "Logic Error: Invalid types for mathmatical operator. ");
		} else if (objA.Type.equals("INT") || objA.Type.equals("BOOLEAN")) {
		    c = objA.IValue <= objB.IValue;
		} else if (objA.Type.equals("FLOAT")) {
		    c = objA.FValue <= objB.FValue;
		}
		break;
	    default:
		return new ConditionExecuteReturn(true, "Syntax Error: Invalid operator\"" + operator + "\"");
	}
	
	ConditionExecuteReturn r = new ConditionExecuteReturn(false, "");
	r.Condition = c;
	return r;
    }
}
