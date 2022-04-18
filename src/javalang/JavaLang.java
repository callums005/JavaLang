package javalang;

import java.util.ArrayList;
import java.util.List;

public class JavaLang {

    public static void main(String[] args) {
	Interperater.Instructions = FileHandler.ReadFile(args[0]);
	List<MemoryObject> memory = new ArrayList<>();
	
	Interperater.SetInterperationOrder(memory);
	
	Interperater.Interperate(memory);
    }    
}
