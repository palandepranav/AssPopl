package AssPopl;

public class MainRun {
	
	public static void main(String[] args)
	{
		Scope s=new Scope();
		s.insert("x","function","int->void");
		Scope s1=s.enter_scope();
		s1.insert("y","function","int->void");
		Symbol newSymbol=s1.lookup("x");
		System.out.println(newSymbol.toString());
		s.exit_scope();
		//System.out.println(s.toString());
		Symbol newSymbol1=s1.lookup("x");
		//System.out.println(newSymbol1.toString());
	}
	
}
