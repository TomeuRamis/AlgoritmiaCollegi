package curs;

import assignatura.Assignatura;
import assignatura.Llista_assignatures;
import assignatura.Obligatoria;
import assignatura.Optativa;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
    protected int codi;

    public Curs(int n_ass, String nom, int codi) {
        if (n_ass <= MAX) {
            this.nom = nom;
            this.codi = codi;
            list = new Llista_assignatures(n_ass);
        } else {
            /* ERROR, un curs tan sols pot tenir com a màxim 10 assignatures*/
        }
    }
    //Camp següent del node curs.
    protected Curs seg;
    // per si finalment implementam la llista d'assignatures amb una llista.
    // En aquest cas s'haura de refer el constructor de curs.
    // public Llista_assignatures ll_a;

    public void inserirAssignatura(int i) {
        String[] possiblesAss = {"Obligatòria", "Optativa"};
        String[] possiblesPerfils = {"Teòrica", "Pràctica"};
        Assignatura assignatura;
        int perf;

        String nom_as = JOptionPane.showInputDialog(new JFrame(), "Nom de l'assignatura nº" + (i + 1));
        int codi_as = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(), "Codi de l'assignatura nº" + (i + 1)));
        String tipusAss = (String) JOptionPane.showInputDialog(new JFrame(),
                "Tipus de l'assigantura nº" + (i + 1), "Tipus assigantura", JOptionPane.QUESTION_MESSAGE, null, possiblesAss, possiblesAss[0]);
        if (tipusAss.equals("Obligatòria")) {
            int credits = Integer.parseInt(JOptionPane.showInputDialog(new JFrame(), "Crèdits de l'assigantura nº" + (i + 1)));
            assignatura = new Obligatoria(credits, nom_as, codi_as);
        } else {
            String perfil = (String) JOptionPane.showInputDialog(new JFrame(),
                    "Tipus de l'assigantura nº" + (i + 1), "Tipus assigantura", JOptionPane.QUESTION_MESSAGE, null, possiblesPerfils, possiblesPerfils[0]);
            if (perfil.equals("Teòrica")) {
                perf = 1;
            } else {
                perf = 2;
            }
            assignatura = new Optativa(nom_as, codi_as, perf);
        }
        this.list.inserirAssignatura(assignatura, i);
    }

    public Assignatura cercarAssignatura(int codi) {
//        Assignatura ass = list.getCap();
//        boolean trobat = false;
//        while (!trobat && ass != null) {
//            if (ass.getCodi() == codi) {
//                trobat = true;
//            } else {
//                ass = ass.getSeg();
//            }
//        }
        return list.cercar(codi);
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

    public int getCodi() {
        return codi;
    }

    public void setSeg(Curs seg) {
        this.seg = seg;
    }

    @Override
    public String toString() {
        return "CURS = {nom: " + nom + " | codi: " + codi + "}";
    }
}
