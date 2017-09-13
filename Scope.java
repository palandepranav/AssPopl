package AssPopl;

import java.util.ArrayList;

public class Scope {
	ArrayList<Symbol> symbols;
	Scope parentScope;
	ArrayList<Scope> childScopes;
	public Scope()
	{
		this.symbols=new ArrayList<Symbol>();
		this.childScopes=new ArrayList<Scope>();
		//this.parentScope=new SymbolTable();
		this.parentScope=null;
		
	}
	
	public ArrayList<Symbol> getSymbols() {
		return symbols;
	}

	public void setSymbols(ArrayList<Symbol> symbols) {
		this.symbols = symbols;
	}

	public Scope getParentScope() {
		return parentScope;
	}

	public void setParentScope(Scope parentScope) {
		this.parentScope = parentScope;
	}

	public ArrayList<Scope> getChildScopes() {
		return childScopes;
	}

	public void setChildScopes(ArrayList<Scope> childScopes) {
		this.childScopes = childScopes;
	}

	public void insert(String name,String type,String kind)
	{	
		Symbol newSymbol=new Symbol(name, type, kind);
		//if(!symbols.contains(newSymbol))
			symbols.add(newSymbol);
		//else
			//System.out.println("newSymbol already present");
	}
	public String toString()
	{	
		StringBuilder s1=new StringBuilder("");
		for  (Symbol s:symbols)
		{
			s1.append(s.toString());
		}
		return new String(s1);
	}
	
	public Symbol findName(String name,ArrayList<Symbol> symbol)
	{	
		if(symbol==null)
			return null;
		for(Symbol s:symbol)
		{
			if((s.identifier).equals(name))
				return s;
		}
		return null;
	}
	public Symbol lookup(String name)
	{
		//SymbolTable tempSymbolTable=new SymbolTable();
		Scope currentScope=this;
		while(currentScope!=null)
		{
			Symbol s=findName(name,currentScope.symbols);
			if(s!=null)
			{
				System.out.print("Found\t");
				return s;
			}
				
			currentScope=currentScope.getParentScope();
			
		}
		//return tempSymbol;
		System.out.println("Not found");
		return null;
	}
	public Scope enter_scope()
	{	
		System.out.println("Entering new scope");
		Scope newScope=new Scope();
		newScope.setParentScope(this);
		(this.childScopes).add(newScope);
		return newScope;
		
	}
	public void exit_scope()
	{
		System.out.println("Exiting current scope");
		if(this.getParentScope()!=null)
		{
			Scope newScope=this.getParentScope();
			newScope.childScopes.remove(this);
		}
		if(this.symbols!=null)
			this.symbols=null;
		if(this.childScopes!=null)
			this.childScopes=null;
	}
	
}
