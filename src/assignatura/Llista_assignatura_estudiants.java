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

    /*
    Implementació de mètodes de la interfície
     */
    public void inserirEstudiant(Estudiant estu) {
        ReferenciaEstudiant restu = new ReferenciaEstudiant(estu);
        restu.setSeg(cap);
        cap=restu;

    }

    public void eliminarEstudiants() {
        while(cap!=null){
            cap=cap.getSeg();
        }
    }

    public Estudiant mostrarEstudiant() {
        Estudiant estu = null;
        return estu;
    }

    public ReferenciaEstudiant getCap() {
        return cap;
    }
    
    public String mostrarLlista(){
        
        ReferenciaEstudiant aux = cap;
        String res = "";

        while (aux != null) {
            res += aux.getRef() + "\n";
            aux = aux.getSeg();
        }

        return res;
    
    }
}
