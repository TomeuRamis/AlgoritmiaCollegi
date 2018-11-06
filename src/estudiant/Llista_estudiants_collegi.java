package estudiant;

public class Llista_estudiants_collegi {

    protected Estudiant cap = null;

    /*
    NO importa inserir els estudiant de forma ordenada en aquesta llista. Però 
    d'aquesta forma podem fer que algunes cerques que es realitzin dins aquesta llista
    siguin mès rapides que si la llista està desordenada.
     */
    public void inserirEstudiant(Estudiant estu) {

        if (cap == null) {
            estu.setSeg(cap);
            cap = estu;
        } else {
            if (primer(cap, estu) == estu) {
                estu.setSeg(cap);
                cap = estu;
            } else {
                Estudiant aux = cap.getSeg();
                Estudiant aux1 = cap;
                boolean trobat = false;

                while (aux != null && !trobat) {
                    if (primer(aux, estu) == estu) {
                        estu.setSeg(aux);
                        aux1.setSeg(estu);
                        trobat = true;
                    } else {
                        aux1 = aux;
                        aux = aux.getSeg();
                    }
                }
                if (aux == null) {
                    estu.setSeg(aux);
                    aux1.setSeg(estu);
                }
            }
        }
    }

    public Estudiant cercarEstudiant(String dni) {
        Estudiant estudiant = cap;
        boolean trobat = false;
        if (cap != null) {
            while (estudiant != null && !trobat) {
                if (estudiant.getDni().equals(dni)) {
                    trobat = true;
                } else {
                    estudiant = estudiant.getSeg();
                }
            }
        }

        return estudiant;
    }

    public void eliminarEstudiant(String dni) {
        Estudiant estu1 = cap;
        Estudiant estu2;
        if (dni.equals(cap.getDni())) {
            cap = cap.getSeg();
        } else {
            while ((estu1.getSeg() != null) && (estu1.getDni().equals(dni))) {
                estu1 = estu1.getSeg();
            }
            if (estu1.getDni().equals(dni)) {
                estu2 = estu1.getSeg();
                estu1.Nodeseg(estu2.getSeg());
                estu2.Nodeseg(null);
            } else {
                System.out.println("No s'ha trobat element");
            }
        }

    }

    /*
    Compara alfabeticament dos strings. Si el primer aniria primer, retorna un
    true, si el segon va primer retorna un false
     */
    private static Estudiant primer(Estudiant a, Estudiant b) {
        Estudiant aux = a;
        int n = 0;
        boolean trobat = false;
        if (a.getNom().charAt(n) == b.getNom().charAt(n)) {
            while (n < a.getNom().length() && !trobat) {
                if (a.getNom().charAt(n) > b.getNom().charAt(n)) {
                    aux = b;
                    trobat = true;
                } else {
                    n++;
                }
            }
        } else {
            if (a.getNom().charAt(n) > b.getNom().charAt(n)) {
                aux = b;
            }
        }
        return aux;
    }

    public String mostrarLlista() {
        Estudiant aux = cap;
        String res = "";

        while (aux != null) {
            res += aux + "\n";
            aux = aux.getSeg();
        }

        return res;
    }
}
