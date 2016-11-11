package tiger.absyn;
import tiger.TigerValue;
import tiger.TigerType;

public class AssignExp extends Exp
{
    public AssignExp(Integer pos, Exp left, Exp right) {
        // TODO
    }

    @Override
    public void getValue(TigerValue v) { 
        v.SetNil();
     }

    @Override
    void getType(TigerType t) {
        // TODO
    }
}