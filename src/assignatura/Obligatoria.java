/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignatura;

/**
 *
 * @author tomeu
 */
public class Obligatoria extends Assignatura {

    /*
    Atributs privats no heredats
     */
    private String tipus = "Obligatòria";
    private int credits;

    /*
    Constructor
     */
    public Obligatoria(int credits, String nom, int codi) {
        super(nom, codi);
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Assignatura = {nom: " + nom + " | codi: " + codi + " | tipus: " + tipus + " | credits: " + credits+"}";
    }

}
