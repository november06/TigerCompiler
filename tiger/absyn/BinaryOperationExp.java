package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class BinaryOperationExp extends Exp
{
    public static final Integer PLUS = 0;
    public static final Integer MINUS = 1;
    public static final Integer TIMES = 2;
    public static final Integer DIVIDE = 3;
    public static final Integer EQ = 4;
    public static final Integer NE = 5;
    public static final Integer LT = 6;
    public static final Integer LE = 7;
    public static final Integer GT = 8;
    public static final Integer GE = 9;
    public static final Integer AND = 10;
    public static final Integer OR = 11;

    public BinaryOperationExp(Integer pos, Exp e1, Integer op, Exp e2) 
    {
        super(pos);

        innerExpLeft = e1;
        innerExpRight = e2;

        operation = op;
    }

    @Override
    public void getValue(TigerValue v) {
        // TODO
    }

    @Override
    public void getType(TigerType v) {
        // TODO
    }

    @Override
    public String getTypeName() 
    {
        return "BinaryOperationExp";
    }

    @Override
    public void print()
    {
        super.print();

        // TODO validation integer type left and right ?
        innerExpLeft.print();
/*
        switch (operation)
        {
            case BinaryOperationExp.PLUS:
            System.out.print("PLUS");
            break;
            case BinaryOperationExp.MINUS:
            System.out.print("MINUS");
            break;
            case BinaryOperationExp.TIMES:
            System.out.print("TIMES");
            break;
            case BinaryOperationExp.DIVIDE:
            System.out.print("DIVIDE");
            break;
            case BinaryOperationExp.EQ:
            System.out.print("EQ");
            break;
            case BinaryOperationExp.NE:
            System.out.print("NE");
            break; 
            case BinaryOperationExp.LT:
            System.out.print("LT");
            break; 
            case BinaryOperationExp.LE:
            System.out.print("LE");
            break; 
            case BinaryOperationExp.GT:
            System.out.print("GT");
            break; 
            case BinaryOperationExp.GE:
            System.out.print("GE");
            break; 
            case BinaryOperationExp.AND: 
            System.out.print("AND");
            break; 
            case BinaryOperationExp.OR: 
            System.out.print("OR");
            break;
        }
        */

        if (operation == BinaryOperationExp.PLUS)
        {
            System.out.print("PLUS");
        }
        else if (operation == BinaryOperationExp.MINUS)
        {
            System.out.print("MINUS");
        }
        else if (operation == BinaryOperationExp.TIMES)
        {
            System.out.print("TIMES");
        }
        else if (operation == BinaryOperationExp.DIVIDE)
        {
            System.out.print("DIVIDE");
        }
        else if (operation == BinaryOperationExp.EQ)
        {
            System.out.print("EQ");
        }
        else if (operation == BinaryOperationExp.NE)
        {
            System.out.print("NE");
        }
        else if (operation == BinaryOperationExp.LT)
        {
            System.out.print("LT");
        }
        else if (operation == BinaryOperationExp.LE) 
        {
            System.out.print("LE");
        } 
        else if (operation == BinaryOperationExp.GT)
        {
            System.out.print("GT");
        } 
        else if (operation == BinaryOperationExp.GE)
        {
            System.out.print("GE");
        } 
        else if (operation == BinaryOperationExp.AND)
        {
            System.out.print("AND");
        } 
        else if (operation == BinaryOperationExp.OR)
        {
            System.out.print("OR");
        } 

        innerExpRight.print();
    }

    private Integer operation;
    private Exp innerExpLeft, innerExpRight;
}