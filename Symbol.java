package AssPopl;

public class Symbol {
	String identifier;
	String type;
	String kind;
	public Symbol(String identifier, String type, String kind) {
		this.identifier = identifier;
		this.type = type;
		this.kind = kind;
		
	}
	@Override
	public String toString() {
		return "Symbol [identifier=" + identifier + ", type=" + type + ", kind=" + kind + "]";
	}
	
	
}
