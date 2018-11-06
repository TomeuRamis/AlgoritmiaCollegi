package curs;

import assignatura.Assignatura;
/**
 *
 * @author Josep Borràs Sánchez
 */
public class Batxiller extends Curs{
    
    public Batxiller(int n_ass, String nom, int codi){
        super(n_ass, nom, codi);
    }
    
    @Override
    public String toString(){
        return"Curs = {nom: "+nom+" | codi:" + codi + " }";
    }
}
