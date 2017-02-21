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
    	// TODO is there any conversion?
    	if (!leftType.equals(right)) {
    	    throw new TigerTypeException("Assignment type mismatch. ");
    	}
        return null;
    }

    @Override
    public String getTypeName() 
    {
        return "AssignExp";
    }

    @Override
    public void print(Context c)
    {
        c.pushLevel();
        super.print(c);
        print(c, "left: ");
        left.print(c);
        print(c, ":=");
        print(c, "right: ");
        right.print(c);
        c.popLevel();
    }

    private LvalueExp left;
    private Exp right;
}