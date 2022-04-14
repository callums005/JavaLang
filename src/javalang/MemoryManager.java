package javalang;

import java.util.List;

public class MemoryManager {
    public static MemoryObject GetMemoryObject(List<MemoryObject> memory, String variable) {
	for (int i = 0; i < memory.size(); i++) {
	    MemoryObject el = memory.get(i);
	    
	    if (el.Variable.equals(variable)) {
		return el;
	    }
	}
	
	return null;
    }
    
    public static int GetMemoryLocationOfObject(List<MemoryObject> memory, String variable) {
	for (int i = 0; i < memory.size(); i++) {
	    MemoryObject el = memory.get(i);

	    if (el.Variable.equals(variable)) {
		return i;
	    }
	}

	return -1;
    }
}
