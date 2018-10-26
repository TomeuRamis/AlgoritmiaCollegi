package curs;
import assignatura.Assignatura;
/**
 *
 * @author Josep Borràs Sánchez
 */
public class Electronica extends FormacioProfessional{
    
    protected static final String especialitat = "ELECTRÒNICA";
    
    public Electronica(int n_ass, String nom, int codi){
        super(n_ass, nom, codi);
    }
    
    @Override
    public String toString(){
        return"FP = especialitat: "+especialitat+" nom: "+nom+" / codi:"+codi;
    }
    
}
