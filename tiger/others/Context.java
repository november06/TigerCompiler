package tiger.others;
//import tiger.TigerValue;
//simport tiger.TigerType;
import java.util.ArrayList;


public class Context 
{
    public Context()
    {
        this.indent = 0;
        this.loop = 0;
        scopes = new ArrayList<ScopeContext>();
        // built in types and functions
        scopes.add(ScopeContext.CreateBuiltinScope());
    }

    public Integer getIndent() {
        return indent;
    }

    public void pushIndentLevel() {
        indent++;
    }

    public void popIndentLevel() {
        indent--;
    }

    
    public Integer getLoop() {
        return loop;
    }

    public void pushLoopLevel() {
        loop++;
    }

    public void popLoopLevel() {
        loop--;
    }
    
    public void startScope() {
    	scopes.add(new ScopeContext());
    }
    
	// TODO scopes 
	//     let
	//     function
	//     for index variable
    public void startScope(boolean readonly) {
    	// TODO read only, call start scope without parameter
    	scopes.add(new ScopeContext(readonly));
    }
    
    public void endScope() {
    	scopes.remove(scopes.size() - 1);
    }
    
    // TODO end type declaration sequence: resolve all the type alias, multiple names map to 1 type
    public void onVariableDeclaration()
    {
    	// TODO let end
    	//      function end
    	//      for index variable
    }
    
    public void onFunctionDeclaration()
    {
    	// TODO when function declaration encountered
    	// recursive functions may be defined here, no two functions could have the same name
    	
    	// all functions in this sequence will begin the scope here (IMPORTANT this is not the same as variables)
    }
    
    public void onTypeDeclaration()
    {
    	
    }

    public TigerType findIdentifierType(String variableName)
    {
        int index = scopes.size() - 1;
        while (index >= 0)
        {
        	ScopeContext sc = scopes.get(index);
        	TigerType potentialResult = sc.findIdentifier(variableName);
        	if (potentialResult != null)
        	{
        		return potentialResult;
        	}
        	
        	index--;
        }
        return null;
    }

    public TigerType findType(String typeName)
    {
        int index = scopes.size() - 1;
        while (index >= 0)
        {
        	ScopeContext sc = scopes.get(index);
        	TigerType potentialResult = sc.findType(typeName);
        	if (potentialResult != null)
        	{
        		return potentialResult;
        	}
        	
        	index--;
        }
        return null;
    }
    
    public void addType(TigerType t)
    {
    	currentContext().addType(t);
    }
    
    public void addType(String aliasName, TigerType t)
    {
    	currentContext().addType(aliasName, t);
    }
    
    public void addFunction(TigerFunctionType t)
    {
    	currentContext().addFunction(t);
    }
    
    public void addVariable(String name, TigerType t)
    {
    	currentContext().addVariable(name, t);
    }

    private ScopeContext currentContext()
    {
    	return scopes.get(scopes.size() - 1);
    }
    
    // bool is in function sequences
    //      is in type sequences
    // record/array variable table (global scope ?   redefined?)
    
    private Integer indent;
    private Integer loop;
    private ArrayList<ScopeContext> scopes;
}