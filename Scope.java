package AssPopl;

import java.util.ArrayList;
import java.util.Iterator;

public class Scope {
	ArrayList<Symbol> symbols;
	Scope parentScope;
	ArrayList<Scope> childScopes;
	public Scope()
	{
		this.symbols=new ArrayList<>();
		this.childScopes=new ArrayList<>();
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
		if(!symbols.contains(newSymbol))
			symbols.add(newSymbol);
		else
			System.out.println("newSymbol already present");
	}
	public String toString()
	{
		return "";
	}
	
	public Symbol findName(String name,ArrayList<Symbol> symbol)
	{
		for(Symbol s:symbol)
		{
			if(s.identifier==name)
				return s;
		}
		return null;
	}
	public Symbol lookup(String name)
	{
		//SymbolTable tempSymbolTable=new SymbolTable();
		Scope currentScope=this;
		while(currentScope.getParentScope()!=null)
		{
			Symbol s=findName(name,currentScope.symbols);
			if(s!=null)
				return s;
			currentScope=currentScope.getParentScope();
		}
		//return tempSymbol;
		return null;
	}
	public void enter_scope(Scope currentScope)
	{
		Scope newScope=new Scope();
		newScope.setParentScope(currentScope);
		(currentScope.childScopes).add(newScope);
		
	}
	public void exit_scope(Scope currentScope)
	{
		Scope newScope=currentScope.getParentScope();
		newScope.childScopes.remove(currentScope);
		currentScope.symbols=null;
	}
	
}
