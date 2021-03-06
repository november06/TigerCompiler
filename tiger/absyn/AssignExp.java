package tiger.absyn;
import tiger.TigerValue;
import tiger.others.*;

public class AssignExp extends Exp
{
    public AssignExp(Integer pos, LvalueExp left, Exp right) {
        super(pos);

        this.left = left; 
        this.right = right;
    }

    @Override
    public TigerType getType(Context c) throws TigerTypeException  {
        // verify
    	TigerType leftType = left.getType(c);
    	TigerType rightType = right.getType(c);

    	if (leftType.equals(right)
    	|| ((leftType instanceof TigerRecordType) && rightType == TigerRecordType.TigerNilType)) {
    		return null;
    	}
        
        throw new TigerTypeException("Assignment type mismatch. ");
    }

    @Override
    public String getTypeName() 
    {
        return "AssignExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushIndentLevel();
        super.print(c);
        print(c, "left: ");
        left.print(c);
        print(c, ":=");
        print(c, "right: ");
        right.print(c);
        c.popIndentLevel();
    }

    private LvalueExp left;
    private Exp right;
}