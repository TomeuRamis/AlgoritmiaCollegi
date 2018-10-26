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
public class Assignatura {

    /*
    Atributs privats
     */
    protected String nom;
    protected int codi;
    protected Llista_assignatura_estudiants listEst;
    protected Assignatura seg;

    /*
    Mètodes de servei
     */
    public Assignatura(String nom, int codi) {
        this.nom = nom;
        this.codi = codi;
        this.listEst = new Llista_assignatura_estudiants();
        this.seg = null;
    }

    public void eliminarLlista_assig_est() {
        ReferenciaEstudiant refEstAux = this.listEst.getCap();
        while (refEstAux != null) {
            refEstAux.getRef().eliminarAssignatura(codi);
            refEstAux= refEstAux.getSeg();
        }
    }

    public void afegirEstudiant(Estudiant est) {
        this.listEst.inserirEstudiant(est);
    }

    public void eliminarEstudiants() {
        this.listEst.eliminarEstudiants();
    }

    public String mostrarEstudiants() {
        String res = "";
        ReferenciaEstudiant refEstAux = this.listEst.getCap();
        while(refEstAux != null){
            res += refEstAux.getRef().toString()+"\n";
            refEstAux = refEstAux.getSeg();
        }
        return res;    
    }

    /*
    Mètodes getters i setters
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public void setListEst(Llista_assignatura_estudiants listEst) {
        this.listEst = listEst;
    }

    public void setSeg(Assignatura seg) {
        this.seg = seg;
    }

    public String getNom() {
        return nom;
    }

    public int getCodi() {
        return codi;
    }

    public Llista_assignatura_estudiants getListEst() {
        return listEst;
    }

    public Assignatura getSeg() {
        return seg;
    }

}
