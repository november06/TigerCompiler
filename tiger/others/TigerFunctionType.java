package tiger.others;

import java.util.ArrayList;
import java.util.Arrays;

public class TigerFunctionType extends TigerType {
//	function print(s : string)
	public final static TigerFunctionType prints = 
			new TigerFunctionType("print", new ArrayList<TigerType>(Arrays.asList(TigerSimpleType.TigerStringType)), null);
//	function printi(i : int)
	public final static TigerFunctionType printi = 
			new TigerFunctionType("printi", new ArrayList<TigerType>(Arrays.asList(TigerSimpleType.TigerIntegerType)), null);
//	function flush()
	public final static TigerFunctionType flush = 
			new TigerFunctionType("flush", new ArrayList<TigerType>(), null);
//	function getchar() : string 
	public final static TigerFunctionType getchar = 
			new TigerFunctionType("getchar", new ArrayList<TigerType>(), TigerSimpleType.TigerStringType);
//	function ord(s : string) : int
	public final static TigerFunctionType ord = 
			new TigerFunctionType("ord", new ArrayList<TigerType>(Arrays.asList(TigerSimpleType.TigerStringType)), TigerSimpleType.TigerIntegerType);
//	function chr(i : int) : string
	public final static TigerFunctionType chr = 
			new TigerFunctionType("chr", new ArrayList<TigerType>(Arrays.asList(TigerSimpleType.TigerIntegerType)), TigerSimpleType.TigerStringType);
//	function size(s : string) : int 
	public final static TigerFunctionType size = 
			new TigerFunctionType("size", new ArrayList<TigerType>(Arrays.asList(TigerSimpleType.TigerStringType)), TigerSimpleType.TigerIntegerType);
//	function substring(s:string,f:int,n:int):string
	public final static TigerFunctionType substring = 
			new TigerFunctionType(
					"substring", 
					new ArrayList<TigerType>(Arrays.asList(
							TigerSimpleType.TigerStringType, 
							TigerSimpleType.TigerIntegerType, 
							TigerSimpleType.TigerIntegerType)), 
					TigerSimpleType.TigerStringType);
//	function concat (s1:string, s2:string):string 
	public final static TigerFunctionType concat = 
			new TigerFunctionType(
					"concat", 
					new ArrayList<TigerType>(Arrays.asList(
							TigerSimpleType.TigerStringType, 
							TigerSimpleType.TigerStringType)), 
					TigerSimpleType.TigerStringType);
//	function not(i : int) : int 
	public final static TigerFunctionType not = 
			new TigerFunctionType(
					"not", 
					new ArrayList<TigerType>(Arrays.asList(
							TigerSimpleType.TigerIntegerType)), 
					TigerSimpleType.TigerIntegerType);
//	function exit(i : int)
	public final static TigerFunctionType exit = 
			new TigerFunctionType("exit", new ArrayList<TigerType>(Arrays.asList(TigerSimpleType.TigerIntegerType)), null);
	
	public TigerFunctionType(String name, ArrayList<TigerType> parameterTypes, TigerType returnType)
	{
		
	}
	
	@Override
	public Boolean match(ArrayList<TigerType> parameters) {
		// TODO Auto-generated method stub
		return super.match(parameters);
	}

	@Override
	public TigerType getReturnType() {
		// TODO Auto-generated method stub
		return super.getReturnType();
	}
}
