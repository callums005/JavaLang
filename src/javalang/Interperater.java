package javalang;

import java.util.List;
import javalang.ExecutableCommands.GPIO;
import javalang.ExecutableCommands.Mathmatical;
import javalang.ExecutableCommands.Variables;

public class Interperater {
    public static void InterperateInstruction(String instruction, int line, List<MemoryObject> memory) {
	String[] commands = instruction.split(" ");
	
	ExecuteReturn r;
	switch (commands[0]) {
	    case "IN":
		if (commands.length == 2)
		    r = GPIO.IN(memory, commands[1]);
		else
		    r = new ExecuteReturn(true, "Invalid number of arguments");
		break;
	    case "OUT":
		if (commands.length == 2)
		    r = GPIO.OUT(memory, commands[1]);
		else
		    r = new ExecuteReturn(true, "Invalid number of arguments");
		break;
	    case "NEW":
		if (commands.length == 3)
		    r = Variables.NEW(memory, commands[1], commands[2]);
		else
		    r = new ExecuteReturn(true, "Invalid number of arguments");
		break;
	    case "SET":
		if (commands.length >= 3)
		    r = Variables.SET(memory, commands[1], commands);
		else
		    r = new ExecuteReturn(true, "Invalid number of arguments");
		break;
	    case "DEL":
		if (commands.length == 2)
		    r = Variables.DEL(memory, commands[1]);
		else
		    r = new ExecuteReturn(true, "Invalid number of arguments");
		break;
	    case "ADD":
		if (commands.length == 4)
		    r = Mathmatical.ADD(memory, commands[1], commands[2], commands[3]);
		else
		    r = new ExecuteReturn(true, "Invalid number of arguments");
		break;
	    case "SUB":
		if (commands.length == 4) {
		    r = Mathmatical.SUB(memory, commands[1], commands[2], commands[3]);
		} else {
		    r = new ExecuteReturn(true, "Invalid number of arguments");
		}
		break;
	    case "MUL":
		if (commands.length == 4) {
		    r = Mathmatical.MUL(memory, commands[1], commands[2], commands[3]);
		} else {
		    r = new ExecuteReturn(true, "Invalid number of arguments");
		}
		break;
	    case "DIV":
		if (commands.length == 4) {
		    r = Mathmatical.DIV(memory, commands[1], commands[2], commands[3]);
		} else {
		    r = new ExecuteReturn(true, "Invalid number of arguments");
		}
		break;
	    default:
		String rmsg = "Error: Undefined keyword \"" + commands[0] + "\"";
		r = new ExecuteReturn(true, rmsg);
		break;
	}
	
	if (r.err) {
	    System.err.printf("%s. Line [%d]\n", r.msg, line);
	}
    }
}
