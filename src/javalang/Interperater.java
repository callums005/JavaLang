package javalang;

import java.util.ArrayList;
import java.util.List;
import javalang.ExecutableCommands.Conditions;
import javalang.ExecutableCommands.GPIO;
import javalang.ExecutableCommands.Mathmatical;
import javalang.ExecutableCommands.Variables;

public class Interperater {
    static List<String> Instructions = null;
    static List<Integer> InstructionOrder = new ArrayList<>(); // Stores the order each line should be executed in
    
    public static void SetInterperationOrder(List<MemoryObject> memory) {
	int i = 0;
	int ifStop = 0;
	while (i < Interperater.Instructions.size()) {
	    if (!";".equals(Character.toString(Instructions.get(i).charAt(0)))) {
		String[] cmd = Instructions.get(i).split(" ");
		boolean ignore = false;
	    
		ExecuteReturn re = new ExecuteReturn(false, "");
		if (cmd[0].equals("NEW")) {
		    if (cmd.length == 3) {
			re = Variables.NEW(memory, cmd[1], cmd[2]);
			ignore = true;
		    }
		    else
			re = new ExecuteReturn(true, "Syntax Error: Invalid number of arguments");
		}
		if (cmd[0].equals("SET")) {
		    if (cmd.length >= 3) {
			ignore = true;
			re = Variables.SET(memory, cmd[1], cmd);
		    }
		    else
			re = new ExecuteReturn(true, "Syntax Error: Invalid number of arguments");
		}

		if (cmd[0].equals("IF")) {
		    ifStop = Integer.parseInt(cmd[4]);

		    ConditionExecuteReturn r = Conditions.IF_STATEMENT(Instructions, i, memory, cmd[1], cmd[2], cmd[3]);
		    if (r.err) {
			System.err.printf("%s. Line [%d]\n", r.msg, i + 1);
			return;
		    } 
		    else {
			if (!r.Condition)
			    i = ifStop;

			for(int k = i + 1; k < ifStop; k++) {
			    InstructionOrder.add(k);
			}
			i = ifStop;
		    }
		}
		else {
		    if (!ignore)
			InstructionOrder.add(i);
		    i++;
		}
		
		if (re.err) {
		    System.err.printf("%s. Line [%d]\n", re.msg, i + 1);
		}
	    }
	}
    } 
    
    public static void Interperate(List<MemoryObject> memory) {
	for (int i = 0; i < InstructionOrder.size(); i++) {
	    InterperateInstruction(InstructionOrder.get(i), memory);
	}
    }
    
    public static void InterperateInstruction(int line, List<MemoryObject> memory) {
	String instruction = Instructions.get(line);
	String[] commands = instruction.split(" ");
	
	ExecuteReturn r = new ExecuteReturn(false, "");
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
		    r = Variables.SET(memory, commands[1], commands);
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
	    default:
		String rmsg = "Error: Undefined keyword \"" + commands[0] + "\"";
		r = new ExecuteReturn(true, rmsg);
		break;
	}
	
	if (r.err) {
	    System.err.printf("%s. Line [%d]\n", r.msg, line + 1);
	}
    }
}
