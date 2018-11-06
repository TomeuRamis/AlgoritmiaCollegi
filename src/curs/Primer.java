package curs;
import assignatura.Assignatura;
/**
 *
 * @author Josep Borràs Sánchez
 */
public class Primer extends Batxiller{
    
    protected static final String any= "PRIMER";
    
    public Primer(int n_ass, String nom, int codi){
        super(n_ass,nom, codi);
    }
    
    @Override
    public String toString(){
        return "Curs = { nom: "+nom+" | codi: "+codi+" | tipus: Batxillerat | any: "+any+" }";
    }
    
}
