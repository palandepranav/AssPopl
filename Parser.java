package AssPopl;

public class Parser {
	
	public static void main(String[] args) {
		Scope scope=new Scope();
		String s="{x=1;y=2; {z=3;}}";
		s = s.replace('\n', ' ');
        s = s.replace("{", "{\n");
        s = s.replace("}", "}\n");
		String[] splitString = (s.split("(?=[{=}])"));
	        System.out.println(splitString.length);
	        for (String string : splitString)
	        {
	        	System.out.println();
	        }
	        for (String string : splitString) {
	            //System.out.println(string);
	        	if(string.equals("{"))
	        		scope.enter_scope();
	        	
	        }
	        
	        
	}
}
