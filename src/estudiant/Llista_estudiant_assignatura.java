package estudiant;

import assignatura.Assignatura;

public class Llista_estudiant_assignatura {

    ReferenciaAssignatura cap = null;

    public void inserirRefAssign(Assignatura ass) {
        ReferenciaAssignatura rass = new ReferenciaAssignatura(ass);
        rass.setSeg(cap);
        cap = rass;
    }

    public ReferenciaAssignatura cercarRefassign(int codi) {
        ReferenciaAssignatura assign = cap;
        if (cap != null) {
            while ((assign.getSeg() != null) && (assign.getRef().getCodi() != codi)) {
                assign = assign.getSeg();
            }
            if (assign.getRef().getCodi() == codi) {
                System.out.print(assign.getRef().getNom() + "\n");
            } else {
                System.out.println("no s'ha trobat element");
            }
        }
        return assign;
    }

    public void eliminarRefassign(int codi) {
        if (cap != null) {
            ReferenciaAssignatura refAuxElim = cercarRefassign(codi);
            if (refAuxElim == cap) {
                cap = cap.getSeg();
            } else {
                ReferenciaAssignatura refAux = cap;
                boolean trobat = false;
                while (!trobat) {
                    if (refAux.getSeg() == refAuxElim) {
                        refAux.setSeg(refAuxElim.getSeg());
                        trobat = true;
                    } else {
                        refAux = refAux.getSeg();
                    }
                }
            }
        }
    }

    public String mostrarLlista() {
        String res = "";
        ReferenciaAssignatura refAssAux = this.cap;
        while (refAssAux != null) {
            res += refAssAux.getRef().toString() + "\n";
            refAssAux = refAssAux.getSeg();
        }
        return res;
    }

}
