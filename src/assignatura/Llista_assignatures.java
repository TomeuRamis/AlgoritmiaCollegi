/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignatura;

import collegi.AccesLlista;

/**
 *
 * @author tomeu
 */
public class Llista_assignatures implements AccesLlista {

    /*
    Atributs privats
     */
    protected Assignatura cap = null;

    /*
    Implementació de mètodes de la interfície
     */
    public void inserirAssignatura(Assignatura ass) {

        if (cap == null) {
            cap = ass;
        } else {
            if (cap.getCodi() > ass.getCodi()) {
                ass.setSeg(cap);
                cap = ass;
            } else {
                Assignatura aux1 = cap.getSeg();
                Assignatura aux2 = cap;
                if (aux1 != null) {
                    while (aux1.getCodi() < ass.getCodi() && aux1.getSeg() != null) {
                        aux2 = aux1;
                        aux1 = aux1.getSeg();
                    }
                    ass.setSeg(aux1);
                    aux2.setSeg(ass);
                } else {
                    ass.setSeg(aux1);
                    aux2.setSeg(ass);
                }
            }
        }
    }

    public Object cercar(int codi) {
        Assignatura aux = cap;
        boolean trobat = false;

        while (!trobat && cap != null) {
            if (codi == aux.getCodi()) {
                trobat = true;
            } else {
                aux = aux.getSeg();
            }
        }
        return aux;
    }

    @Override
    public void eliminar(int codi) {
        if (cap.getCodi() == codi) {
            cap.eliminarLlista_assig_est();
            cap.eliminarEstudiants();
            cap = cap.getSeg();
            System.out.println("Eliminat correctement");
//            NO S'UTILITZA MAI. SEMPRE ELIMINAM LA CAPÇALERA
        } else {
            Assignatura aux = cap;
            boolean trobat = false;

            while (!trobat && aux.getSeg() != null) {
                if (aux.getSeg().getCodi() == codi) {
                    aux.eliminarLlista_assig_est();
                    aux.eliminarEstudiants();
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
    public String mostrarLlista() {
        Assignatura aux = cap;
        String res = "";

        while (aux != null) {
            res += aux + "\n";
            res += aux.mostrarEstudiants() + "\n";
            aux = aux.getSeg();
        }

        return res;
    }

    public Assignatura getCap() {
        return cap;
    }

}
