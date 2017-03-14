package tiger.others;

import java.util.HashMap;
import java.util.Map;

public class ScopeContext {
    public ScopeContext()
    {
    	variableFunctions = new HashMap<String, TigerType>();
    	types = new HashMap<String, TigerType>();
    	this.readonly = false;
    }
    
    public ScopeContext(boolean readonly)
    {
    	this();
    	this.readonly = readonly; // TODO varaible is readonly when it's defined in a readonly scope
    }
	
    public static ScopeContext CreateBuiltinScope()
    {
    	ScopeContext result = new ScopeContext(true);
    	
    	// built in types
    	result.addType(TigerSimpleType.TigerIntegerType);
    	result.addType(TigerSimpleType.TigerStringType);
    	
    	// built in functions
//    	function print(s : string)
    	result.addFunction(TigerFunctionType.prints);
//    	function printi(i : int) 
    	result.addFunction(TigerFunctionType.printi);
//    	function flush() 
    	result.addFunction(TigerFunctionType.flush);
//    	function getchar() : string 
    	result.addFunction(TigerFunctionType.getchar);
//    	function ord(s : string) : int
    	result.addFunction(TigerFunctionType.ord);
//    	function chr(i : int) : string
    	result.addFunction(TigerFunctionType.chr);
//    	function size(s : string) : int 
    	result.addFunction(TigerFunctionType.size);
//    	function substring(s:string,f:int,n:int):string
    	result.addFunction(TigerFunctionType.substring);
//    	function concat (s1:string, s2:string):string 
    	result.addFunction(TigerFunctionType.concat);
//    	function not(i : int) : int 
    	result.addFunction(TigerFunctionType.not);
//    	function exit(i : int)
    	result.addFunction(TigerFunctionType.exit);
    	
    	return result;
    }
    
    public void addType(TigerType tType)
    {
    	types.put(tType.getName(), tType); // TODO whether to put the name inside type or not?
    }
    
    public void addType(String aliasName, TigerType tType)
    {
    	types.put(aliasName, tType);
    }
    
    public void addFunction(TigerFunctionType tFunctionType)
    {
    	this.variableFunctions.put(tFunctionType.getName(), tFunctionType);
    }
    
    public void addVariable(String name, TigerType tType)
    {
    	this.variableFunctions.put(name,  tType);
    }
    
    public TigerType findIdentifier(String identifierName)
    {
        return variableFunctions.get(identifierName);
    }
    
    public TigerType findType(String typeName)
    {
    	return types.get(typeName);
    }
	
	Map<String, TigerType> variableFunctions;
    Map<String, TigerType> types;
    boolean readonly;   
    // sequences
}
