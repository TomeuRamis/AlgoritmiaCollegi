package curs;
import assignatura.Assignatura;
/**
 *
 * @author Josep Borràs Sánchez
 */
public class FormacioProfessional extends Curs {
    
    public FormacioProfessional(int n_ass, String nom, int codi){
        super(n_ass,nom,codi);
    }
    
    @Override
    public String toString(){
        return"FP = nom: "+nom+" / codi:"+codi;
    }
}
