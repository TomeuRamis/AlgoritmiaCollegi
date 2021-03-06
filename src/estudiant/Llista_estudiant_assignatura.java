package estudiant;

import assignatura.Assignatura;

public class Llista_estudiant_assignatura {

    ReferenciaAssignatura cap = null;

    public void inserirRefAssign(Assignatura ass) {
        
        ReferenciaAssignatura rass = new ReferenciaAssignatura(ass);
        
        if (cap == null) {
            cap = rass;
        } else {
            if (cap.getRef().getCodi() > rass.getRef().getCodi()) {
                rass.setSeg(cap);
                cap = rass;
            } else {
                ReferenciaAssignatura aux1 = cap.getSeg();
                ReferenciaAssignatura aux2 = cap;
                if (aux1 != null) {
                    while (aux1.getRef().getCodi() < ass.getCodi() && aux1.getSeg() != null) {
                        aux2 = aux1;
                        aux1 = aux1.getSeg();
                    }
                    if (aux1.getSeg() == null) {
                        aux1.setSeg(rass);
                    } else {
                        rass.setSeg(aux1);
                        aux2.setSeg(rass);
                    }
                } else {
                    rass.setSeg(aux1);
                    aux2.setSeg(rass);
                }
            }
        }
    }

    public ReferenciaAssignatura cercarRefassign(int codi) {
        ReferenciaAssignatura assign = cap;
        if (cap != null) {
            while ((assign.getSeg() != null) && (assign.getRef().getCodi() != codi)) {
                assign = assign.getSeg();
            }
            if (assign.getRef().getCodi() != codi) {
                return null;
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
            res += refAssAux.getRef() + "\n";
            refAssAux = refAssAux.getSeg();
        }
        return res;
    }

}
