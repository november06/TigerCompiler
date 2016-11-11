package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class BinaryOperationExp extends Exp
{
    public BinaryOperationExp(Integer pos, Exp e1, Integer op, Exp e2) 
    {
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

    }

    private Integer operation;
    private Exp innerExpLeft, innerExpRight;

    public static final Integer PLUS = 0, MINUS = 1, TIMES = 2, DIVIDE = 3
                              , EQ = 4, NE = 5, LT = 6, LE = 7, GT = 8, GE = 9
                              , AND = 10, OR = 11;
}