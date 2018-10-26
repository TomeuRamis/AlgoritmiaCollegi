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
public class ReferenciaEstudiant {
    
    /*
    Atributs privats
    */
    
    Estudiant ref;
    ReferenciaEstudiant seg = null;

    public ReferenciaEstudiant(Estudiant ref) {
        this.ref = ref;
    }

    public Estudiant getRef() {
        return ref;
    }

    public ReferenciaEstudiant getSeg() {
        return seg;
    }

    public void setRef(Estudiant ref) {
        this.ref = ref;
    }

    public void setSeg(ReferenciaEstudiant seg) {
        this.seg = seg;
    }

    
}
