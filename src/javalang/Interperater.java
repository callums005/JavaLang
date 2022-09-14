package javalang;

import java.util.List;
import javalang.ExecutableCommands.Conditions;
import javalang.ExecutableCommands.GPIO;
import javalang.ExecutableCommands.Mathmatical;
import javalang.ExecutableCommands.Variables;

public class Interperater {
    public static List<String> Instructions = null; 
    private static boolean LastConditionState = false;
    
    public static void Interperate(List<MemoryObject> memory) {
    int linePointer = 0;
	
	while (linePointer < Instructions.size()) {
	    int nextLine = InterperateInstruction(linePointer, memory);
	
	    if (nextLine == 0) {
		linePointer++;
	    }
	    else {
		linePointer = nextLine;
	    }
	}
	
    }
    
    public static int InterperateInstruction(int line, List<MemoryObject> memory) {
	String instruction = Instructions.get(line);
	String[] commands = instruction.split(" ");
	
	ExecuteReturn r = new ExecuteReturn(false, "");
	ConditionExecuteReturn cr = new ConditionExecuteReturn(false, "");
	switch (commands[0]) {
	    case "IN":
		if (commands.length == 2)
		    r = GPIO.IN(memory, commands[1]);
		else
		    r = new ExecuteReturn(true, "Syntax Error: Invalid number of arguments");
		break;
	    case "OUT":
		if (commands.length == 2)
		    r = GPIO.OUT(memory, commands[1]);
		else
		    r = new ExecuteReturn(true, "Syntax Error: Invalid number of arguments");
		break;
	    case "NEW":
		if (commands.length == 3) {
		    r = Variables.NEW(memory, commands[1], commands[2]);
		}
		else
		    r = new ExecuteReturn(true, "Syntax Error: Invalid number of arguments");
		break;
	    case "SET":
		if (commands.length >= 3) {
		    r = Variables.SET(memory, commands[1], commands, false);
		} else
		    r = new ExecuteReturn(true, "Syntax Error: Invalid number of arguments");
		break;
	    case "DEL":
		if (commands.length == 2)
		    r = Variables.DEL(memory, commands[1]);
		else
		    r = new ExecuteReturn(true, "Syntax Error: Invalid number of arguments");
		break;
	    case "ADD":
		if (commands.length == 4)
		    r = Mathmatical.ADD(memory, commands[1], commands[2], commands[3]);
		else
		    r = new ExecuteReturn(true, "Syntax Error: Invalid number of arguments");
		break;
	    case "SUB":
		if (commands.length == 4) {
		    r = Mathmatical.SUB(memory, commands[1], commands[2], commands[3]);
		} else {
		    r = new ExecuteReturn(true, "Syntax Error: Invalid number of arguments");
		}
		break;
	    case "MUL":
		if (commands.length == 4) {
		    r = Mathmatical.MUL(memory, commands[1], commands[2], commands[3]);
		} else {
		    r = new ExecuteReturn(true, "Syntax Error: Invalid number of arguments");
		}
		break;
	    case "DIV":
		if (commands.length == 4) {
		    r = Mathmatical.DIV(memory, commands[1], commands[2], commands[3]);
		} else {
		    r = new ExecuteReturn(true, "Syntax Error: Invalid number of arguments");
		}
		break;
	    case "IF":
		if (commands.length == 5) {
		    if (Integer.parseInt(commands[4]) > Instructions.size())
			r = new ExecuteReturn(true, "Interperator Error: line " + commands[4] + " does not exist");
		    else {
			cr = Conditions.IF_STATEMENT(memory, commands[1], commands[2], commands[3]);
			
			if (!cr.err)
			    LastConditionState = cr.Condition;
			
			if (!cr.Condition && !cr.err) {
			    return Integer.parseInt(commands[4]);
			} else if (cr.err) {
			    System.err.printf("%s. Line [%d]\n", cr.msg, line + 1);
			}
		    }
		} else {
		    r = new ExecuteReturn(true, "Syntax Error: Invalid number of arguments");
		}
		break;
	    case "ELSE":
		if (commands.length == 2) {
		    if (LastConditionState) {
			return Integer.parseInt(commands[1]);
		    }
		} else {
		    r = new ExecuteReturn(true, "Syntax Error: Invalid number of arguments");
		}
		break;
	    default:
		String rmsg = "Error: Undefined keyword \"" + commands[0] + "\"";
		r = new ExecuteReturn(true, rmsg);
		break;
	}
	
	if (r.err) {
	    System.err.printf("%s. Line [%d]\n", r.msg, line + 1);
	}
	
	return 0;
    }
}
