package curs;

import assignatura.Assignatura;
import assignatura.Llista_assignatures;

/**
 *
 * @author Josep Borràs Sánchez
 */
public class Curs {

    /*
    * Ja que un curs tan sols pot constar d'un nombre determinat d'assignatures
    * les organitzarem en un array finit de 10 caselles.
     */
    protected static final int MAX = 10;

    protected String nom;
    protected Llista_assignatures list;
    protected int n_ass;
    protected int codi;

    public Curs(int n_ass, String nom, int codi) {
        if (n_ass <= MAX) {
            this.n_ass = n_ass;
            this.nom = nom;
            this.codi = codi;
            list = new Llista_assignatures();
        } else {
            /* ERROR, un curs tan sols pot tenir com a màxim 10 assignatures*/
        }
    }
    //Camp següent del node curs.
    protected Curs seg;
    // per si finalment implementam la llista d'assignatures amb una llista.
    // En aquest cas s'haura de refer el constructor de curs.
    // public Llista_assignatures ll_a;

    @Override
    public String toString() {
        return "CURS = {nom: " + nom + " | codi: " + codi+"}";
    }

    //     TENIR EN COMPTE QUE LES ASSIGNAUTES HAN D
    //    'ESTAR ORDENADES PER CODI 
    public void inserirAssignatura(Assignatura ass) {
        this.list.inserirAssignatura(ass);
    }

    //
    public Assignatura cercarAssignatura(int codi) {
        Assignatura ass = list.getCap();
        boolean trobat = false;
        while (!trobat && ass != null) {
            if (ass.getCodi() == codi) {
                trobat = true;
            } else {
                ass = ass.getSeg();
            }
        }
        return ass;
    }

    public void eliminarAssignautra(int codi) {
        this.list.eliminar(codi);
    }

    public Curs getSeg() {
        return seg;
    }

    public String getNom() {
        return nom;
    }

    public Llista_assignatures getList() {
        return list;
    }

    public int getN_ass() {
        return n_ass;
    }

    public int getCodi() {
        return codi;
    }

    public void setSeg(Curs seg) {
        this.seg = seg;
    }

}
