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

    protected Assignatura[] llista_ass;
    protected int n_ass;

    public Llista_assignatures(int n) {
        llista_ass = new Assignatura[n];
        this.n_ass = n;
    }

    public void inserirAssignatura(Assignatura ass, int i) {
        llista_ass[i] = ass;
    }

    public void ordenar() {
        final int N = llista_ass.length;
        Assignatura aux;
        for (int i = 0; i < N - 1; i++) {
            for (int j = N - 2; j >= i; j--) {
                if (llista_ass[j].getCodi() < llista_ass[j + 1].getCodi()) {
                    aux = llista_ass[j + 1];
                    llista_ass[j + 1] = llista_ass[j];
                    llista_ass[j] = aux;
                }
            }
        }
    }

    @Override
    public Assignatura getCap() {
        return llista_ass[0];
    }

    @Override
    public String mostrarLlista() {
        String res = "";
        boolean fi = false;

        for (int i = 0; i < n_ass && !fi; i++) {
            if (llista_ass[i] == null) {
                fi = true;
            } else {
                res += llista_ass[i] + "\n";
                res += llista_ass[i].mostrarEstudiants() + "\n";
            }
        }

        return res;
    }

    @Override
    public Assignatura cercar(int codi) {
        Assignatura aux = null;
        int i = 0;
        boolean trobat = false;

        while (i < n_ass && !trobat) {
            if (llista_ass[i].getCodi() == codi) {
                aux = llista_ass[i];
                trobat = true;
            }else{
                i++;
            }
        }
        return aux;
    }
    /*
    Crea un nou array en el que copiarà les assignatures que ja tenia el curs, menys
    l'assignatura borrada. Després canviem la llista d'assignatures del curs per
    la nova llista. (amb una assignatura menys)
    */
    @Override
    public void eliminar(int codi) {
        Assignatura[] aux = new Assignatura[n_ass];
        int i = 0;
        boolean trobat = false;

        while (i < n_ass && !trobat) {
            if (llista_ass[i].getCodi() != codi) {
                aux[i] = llista_ass[i];
                i++;
            } else {
                trobat = true;
                llista_ass[i].eliminarLlista_assig_est();
                llista_ass[i].eliminarEstudiants();
                for (int j = i; j < (n_ass - 1); j++) {
                    aux[j] = llista_ass[j + 1];
                }
            }
        }

        llista_ass = aux;

    }
}