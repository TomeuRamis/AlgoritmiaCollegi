/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignatura;

import estudiant.Estudiant;

/**
 *
 * @author tomeu
 */
public class Llista_assignatura_estudiants {

    /*
    Atributs privats
     */
    protected ReferenciaEstudiant cap = null;

    protected ReferenciaEstudiant[] ll_refestu;
    protected int n_refestu;
    protected int idx = 0;

    public Llista_assignatura_estudiants(int n) {
        this.n_refestu = n;
        this.ll_refestu = new ReferenciaEstudiant[this.n_refestu];
    }

    public boolean esPle() {
        if (idx >= n_refestu) {
            return true;
        }else{
        return false;
        }
    }

    public void inserir(Estudiant estu) {
        ReferenciaEstudiant refestu = new ReferenciaEstudiant(estu);
        ll_refestu[idx] = refestu;
        idx++;
        if(idx >= 2){
            ordenar();
        }
    }

    public void eliminar(){
        for(int i = 0; i < n_refestu; i++){
            ll_refestu[i] = null;
        }
    }
    
    public ReferenciaEstudiant cap(){
        return ll_refestu[0];
    }
    
    public String mostrar(){
        String res = "";
        boolean fi = false;
        
        for(int i =0; i < n_refestu && !fi; i++){
            if(ll_refestu[i] != null){
            res += ll_refestu[i].getRef() + "\n";
            }else{
                fi = true;
            }
        }
        return res;
    }
    
    private void ordenar() {
        final int N = idx;
        ReferenciaEstudiant aux;
        for (int i = 0; i < N - 1; i++) {
            for (int j = N - 2; j >= i; j--) {
                if (primer(ll_refestu[j+1].getRef().getNom(), ll_refestu[j].getRef().getNom()) == ll_refestu[j + 1].getRef().getNom()) {
                    aux = ll_refestu[j + 1];
                    ll_refestu[j + 1] = ll_refestu[j];
                    ll_refestu[j] = aux;
                }
            }
        }
    }

    private String primer(String a, String b) {
        String aux = a;
        int n = 0;
        boolean trobat = false;
        if (a.charAt(n) == b.charAt(n)) {
            while (n < a.length() && !trobat) {
                if (a.charAt(n) > b.charAt(n)) {
                    aux = b;
                    trobat = true;
                } else {
                    n++;
                }
            }
        } else {
            if (a.charAt(n) > b.charAt(n)) {
                aux = b;
            }
        }
        return aux;
    }
}
/* ===========================================================================
    
    public void inserirEstudiant(Estudiant estu) {
        ReferenciaEstudiant refestu = new ReferenciaEstudiant(estu);

        if (cap == null) {
            refestu.setSeg(cap);
            cap = refestu;
        } else {
            if (primer(cap, refestu) == refestu) {
                refestu.setSeg(cap);
                cap = refestu;
            } else {
                ReferenciaEstudiant aux = cap.getSeg();
                ReferenciaEstudiant aux1 = cap;
                boolean trobat = false;

                while (aux != null && !trobat) {
                    if (primer(aux, refestu) == refestu) {
                        refestu.setSeg(aux);
                        aux1.setSeg(refestu);
                        trobat = true;
                    } else {
                        aux1 = aux;
                        aux = aux.getSeg();
                    }
                }
                if (aux == null) {
                    refestu.setSeg(aux);
                    aux1.setSeg(refestu);
                }
            }
        }
    }

    public void eliminarEstudiants() {
        while (cap != null) {
            cap = cap.getSeg();
        }
    }

    public Estudiant mostrarEstudiant() {
        Estudiant estu = null;
        return estu;
    }

    public ReferenciaEstudiant getCap() {
        return cap;
    }

    public String mostrarLlista() {

        ReferenciaEstudiant aux = cap;
        String res = "";

        while (aux != null) {
            res += aux.getRef() + "\n";
            aux = aux.getSeg();
        }

        return res;

    }

    private static ReferenciaEstudiant primer(ReferenciaEstudiant a, ReferenciaEstudiant b) {
        ReferenciaEstudiant aux = a;
        int n = 0;
        boolean trobat = false;
        if (a.getRef().getNom().charAt(n) == b.getRef().getNom().charAt(n)) {
            while (n < a.getRef().getNom().length() && !trobat) {
                if (a.getRef().getNom().charAt(n) > b.getRef().getNom().charAt(n)) {
                    aux = b;
                    trobat = true;
                } else {
                    n++;
                }
            }
        } else {
            if (a.getRef().getNom().charAt(n) > b.getRef().getNom().charAt(n)) {
                aux = b;
            }
        }
        return aux;
    }
}
*/