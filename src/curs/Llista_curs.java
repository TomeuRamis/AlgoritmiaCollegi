/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curs;

import collegi.AccesLlista;

/**
 *
 * @author JosepB
 */
public class Llista_curs implements AccesLlista {

    private Curs cap;

    public Llista_curs() {
        cap = null;
    }

    public void inserirCurs(Curs nouCurs) {
        nouCurs.seg = cap;
        cap = nouCurs;

    }

    @Override
    public Object cercar(int codi) {
        Curs aux = cap;
        boolean trobat = false;

        while (!trobat && aux != null) {
            if (aux.getCodi() == codi) {
                trobat = true;
            } else {
                aux = aux.getSeg();
            }
        }
        return aux;
    }

    @Override
    public String mostrarLlista() {
        Curs aux = cap;
        String res = "";

        while (aux != null) {
            res += aux + "\n";
            aux = aux.getSeg();
        }

        return res;
    }

    @Override
    public void eliminar(int codi) {
        if (cap.getCodi() == codi) {
            cap = cap.getSeg();
            System.out.println("Eliminat correctement");
        } else {
            Curs aux = cap;
            boolean trobat = false;

            while (!trobat && aux.getSeg() != null) {
                if (aux.getSeg().getCodi() == codi) {
                    aux.setSeg(aux.getSeg().getSeg());
                    trobat = true;
                    System.out.println("Eliminat correctement");
                } else {
                    aux = aux.getSeg();
                }
            }
        }
    }

    @Override
    public Curs getCap() {
        return cap;
    }

}
