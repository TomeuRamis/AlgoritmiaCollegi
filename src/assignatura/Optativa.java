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

public class Optativa extends Assignatura {

    /*
    Atributs privats no herdats
     */
    private String tipus = "Optativa";
    private Perfil perfil;

    /*
    Constructor
     */
    public Optativa(String nom, int codi, int perfil) {
        super(nom, codi);
        this.perfil = (Perfil.values())[perfil-1];
    }

    @Override
    public String toString() {
        return "Assignatura = {nom: " + nom + " | codi: " + codi + " | tipus: " + tipus + " | perfil: " + perfil + "}";
    }

}
