package curs;
import assignatura.Assignatura;
/**
 *
 * @author Josep Borràs Sánchez
 */
public class Informatica extends FormacioProfessional{
    
    protected static final String ESPECIALITAT = "INFORMÀTICA"; 
    
    public Informatica(int n_ass, String nom, int codi){
        super(n_ass,nom, codi);
        
    }
    
    @Override
    public String toString(){
        return"Curs = { nom: "+nom+" | codi:"+codi+" | tipus: FP |"
                + " especialitat: "+ESPECIALITAT+"}";
    }
}
