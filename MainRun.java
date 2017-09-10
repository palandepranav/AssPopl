package AssPopl;
public class MainRun {
	public static void main(String[] args)
	{
		Scope s=new Scope();
		s.insert("x","function","int->void");
		Symbol newSymbol=s.lookup("x");
		System.out.println(newSymbol.toString());
	}
}
