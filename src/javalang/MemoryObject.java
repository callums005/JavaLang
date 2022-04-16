package javalang;

public class MemoryObject {
    public String Variable = ""; 
    public String Type = "NULL"; // Either INT, FLOAT, STRING or BOOLEAN
    public String SValue = "";
    public int IValue = 0;
    public float FValue = 0.0f;

    public MemoryObject(String name, String type) {
	Variable = name;
	Type = type;
    }
}
