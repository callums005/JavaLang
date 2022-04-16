package javalang;

public class MemoryObject {
    public String Variable = ""; 
    public String Type = "NULL"; // Either INT, STRING or BOOLEAN
    public String SValue = "";
    public int IValue = 0;

    public MemoryObject(String name, String type) {
	Variable = name;
	Type = type;
    }
}
