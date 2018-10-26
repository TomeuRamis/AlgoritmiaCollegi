package estudiant;

public class Llista_estudiants_collegi {

    protected Estudiant cap = null;

    public void inserirEstudiant(String nom, String dni) {
        Estudiant estu = new Estudiant(nom, dni);
        if (cap != null) {
            if (compararAlfabeticament(estu.getNom(), cap.getNom())) {
                estu.setSeg(cap);
                cap = estu;
            } else {
                Estudiant aux1 = cap.getSeg();
                Estudiant aux2 = cap;
                if (aux1 != null) {
                    boolean trobat = false;
                    while (!trobat && aux1 != null) {
                        if (compararAlfabeticament(aux1.getNom(), estu.getNom())) {
                            aux2 = aux1;
                            aux1 = aux1.getSeg();
                        } else {
                            trobat = true;
                        }
                    }
                    estu.setSeg(aux1);
                    aux2.setSeg(estu);
                } else {
                    aux2.setSeg(estu);
                }
            }
        } else {
            cap = estu;

        }
    }

    public Estudiant cercarEstudiant(String nom) {
        Estudiant estudiant = cap;
        boolean trobat = false;
        if (cap != null) {
            while (estudiant != null && !trobat) {
                if (estudiant.getNom().equals(nom)) {
                    System.out.println("estudiant trobat");
                    trobat = true;
                } else {
                    estudiant = estudiant.getSeg();
                }
            }
//            if (estudiant.getNom().equals(nom)) {
//                System.out.print(estudiant.getNom() + "\n");
//            } else {
//                System.out.println("no s'ha trobat element");
//            }
        }

        return estudiant;
    }

    public void eliminarEstudiant(String nom) {
        Estudiant estu1 = cap;
        Estudiant estu2;
        if (nom.equals(cap.getNom())) {
            cap = cap.getSeg();
        } else {
            while ((estu1.getSeg() != null) && (estu1.getNom().equals(nom))) {
                estu1 = estu1.getSeg();
            }
            if (estu1.getNom().equals(nom)) {
                estu2 = estu1.getSeg();
                estu1.Nodeseg(estu2.getSeg());
                estu2.Nodeseg(null);
            } else {
                System.out.println("no s'ha trobat element");
            }
        }

    }

    /*
    Compara alfabeticament dos strings. Si el primer aniria primer, retorna un
    true, si el segon va primer retorna un false
     */
    public static boolean compararAlfabeticament(String nom1, String nom2) {
        char[] n1 = nom1.toCharArray();
        char[] n2 = nom2.toCharArray();
        boolean diferents;
        if (n1.length > n2.length) {
            diferents = true;
        } else {
            diferents = false;
        }
        for (int i = 0; i < n1.length && i < n2.length; i++) {
            if (Character.getNumericValue(n1[i]) > Character.getNumericValue(n2[i])) {
                diferents = true;
                break;
            } else if (Character.getNumericValue(n1[i]) < Character.getNumericValue(n2[i])) {
                diferents = false;
                break;
            }
        }
        return diferents;
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
