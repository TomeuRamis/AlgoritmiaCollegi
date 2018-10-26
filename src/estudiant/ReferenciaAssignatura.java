/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiant;
import assignatura.Assignatura;
/**
 *
 * @author tomeu
 */
public class ReferenciaAssignatura {
    private Assignatura ref;
    private ReferenciaAssignatura seg;

    public ReferenciaAssignatura(Assignatura ref) {
        this.ref = ref;
        this.seg = null;
    }

    /*
    Mètodes geters i seters
    */
    public Assignatura getRef() {
        return ref;
    }

    public ReferenciaAssignatura getSeg() {
        return seg;
    }

    public void setRef(Assignatura ref) {
        this.ref = ref;
    }

    public void setSeg(ReferenciaAssignatura seg) {
        this.seg = seg;
    }
    
    
    
}
