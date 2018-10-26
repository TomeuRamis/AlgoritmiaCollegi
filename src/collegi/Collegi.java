package collegi;

import curs.Llista_curs;
import curs.Curs;
import estudiant.Llista_estudiants_collegi;
import estudiant.Estudiant;
import assignatura.Assignatura;
import curs.Electronica;
import curs.Informatica;
import curs.Mecanica;
import curs.Primer;
import curs.Segon;
import assignatura.Obligatoria;
import assignatura.Optativa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Collegi {

    Llista_estudiants_collegi llistEst = new Llista_estudiants_collegi();
    Llista_curs llistCurs = new Llista_curs();
    boolean Onofre = false;

    public void menu() {
        boolean sortir = false;
        int opcio = 0;
        while (!sortir) {
            System.out.println("\n\n****COL·LEGI****\n"
                    + "1. Donar d'alta un curs"
                    + "\n2. Matricular un estudiant"
                    + "\n3. Donar un curs de baixa"
                    + "\n4. Donar de baixa una assignatura"
                    + "\n5. Informació curs"
                    + "\n6. Informació assignatura"
                    + "\n7. Informació estudiant"
                    + "\n0. Exit");
            opcio = llegirNum("\n\nInserir opció: ");
            switch (opcio) {
                case 1:
                    donarAltaCurs();
                    break;
                case 2:
                    matricularEstudiant();
                    break;
                case 3:
                    eliminarCurs();
                    break;
                case 4:
                    eliminarAssignatura();
                    break;
                case 5:
                    infoCurs();
                    break;
                case 6:
                    infoAssignatura();
                    break;
                case 7:
                    infoEstudiant();
                    break;
                case 0:
                    sortir = true;
                    break;
                default:
                    System.out.println("No existeix aquesta opció\n");
            }
        }
    }

    public void donarAltaCurs() {
        Curs curs = null;
        Assignatura assignatura;
        //int nCursos = llegirNum("\nNombre de cursos a inserir: ");
        //for (int i = 0; i < nCursos; i++) {
        //System.out.println("\n-----------curs " + (i + 1) + "----------------");
        int nAss = llegirNum("Nombre de assigantures del curs: ");
        String nomCurs = llegir("Nom del curs: ");
        int codiCurs = llegirNum("Codi del curs: ");
        int tipus = llegirNum("Tipus del curs [1.FP 2.Batxillerat]: ");
        switch (tipus) {
            case 1:
                int especialitat = llegirNum("Especialitat del FP [1. Electrònica 2.Informàtica 3.Mecànica]: ");
                switch (especialitat) {
                    case 1:
                        curs = new Electronica(nAss, nomCurs, codiCurs);
                        break;
                    case 2:
                        curs = new Informatica(nAss, nomCurs, codiCurs);
                        break;
                    case 3:
                        curs = new Mecanica(nAss, nomCurs, codiCurs);
                        break;
                }
                break;
            case 2:
                int cursBatx = llegirNum("Curs de Batxillerat [1.Primer 2.Segon]: ");
                switch (cursBatx) {
                    case 1:
                        curs = new Primer(nAss, nomCurs, codiCurs);
                        break;
                    case 2:
                        curs = new Segon(nAss, nomCurs, codiCurs);
                        break;
                }
                break;
        }

        for (int j = 0; j < nAss; j++) {
            System.out.println("\n-------------assignatura " + (j + 1) + "-------------------------");
            String nomAssign = llegir("Nom de la assignatura: ");
            int codiAssign = llegirNum("Codi de la asssignatura: ");
            int tipusAssign = llegirNum("Tipus de la assignatura [1.Obligatòria 2.Optativa]: ");
            if (tipusAssign == 1) {
                int credits = llegirNum("Nombre de crèdits de la assigantura: ");
                assignatura = new Obligatoria(credits, nomAssign, codiAssign);
            } else {
                int perfil = llegirNum("Perfil de la assigantura optativa [1.Teòric 2.Pràctic]: ");
                assignatura = new Optativa(nomAssign, codiAssign, perfil);
            }
            curs.getList().inserirAssignatura(assignatura);
        }
        this.llistCurs.inserirCurs(curs);
        //}
    }

    public void matricularEstudiant() {
        String nomEst = llegir("Nom del estudiant a matricular: ");
        int codiAssig = llegirNum("Codi de la assignatura on es vol matricular: ");
        Assignatura assign = null;
        Estudiant estu;

        Curs cursAux = this.llistCurs.getCap();
        boolean trobat = false;
        while (cursAux != null && !trobat) {
            assign = cursAux.cercarAssignatura(codiAssig);
            if (assign != null) {
                trobat = true;
            }else{
                cursAux = cursAux.getSeg();
            }
        }
        estu = this.llistEst.cercarEstudiant(nomEst);
        if (estu == null) {
            String DNI = llegir("Estudiant no matriculat. \n"
                    + "Escriu el DNI del estudiant a matricular: ");
            this.llistEst.inserirEstudiant(nomEst, DNI);
            estu = this.llistEst.cercarEstudiant(nomEst);

        }
        estu.inserirAssignatura(assign);
        assign.afegirEstudiant(estu);

        System.out.println("MATRICULAT !!");
    }

    public void eliminarCurs() {
        int codiCurs = llegirNum("Codi del curs a eliminar: ");
        Curs curs = (Curs) this.llistCurs.cercar(codiCurs);
        if (curs != null) {
            Assignatura assAux = curs.getList().getCap();
            int codiAss;
            while (assAux != null) {
                codiAss = assAux.getCodi();
                curs.eliminarAssignautra(codiAss);
                assAux = curs.getList().getCap();
            }
            this.llistCurs.eliminar(codiCurs);
        } else {
            System.out.println("Curs no existent.");
        }
    }

    public void eliminarAssignatura() {
        int codiAss = llegirNum("Codi de la assigantra a eliminar: ");
        int codiCurs = llegirNum("Codi del curs a on pertany la assigantura a eliminar: ");

        Curs curs = (Curs) this.llistCurs.cercar(codiCurs);
//        Assignatura assignatura = curs.cercarAssignatura(codiAss);
//        assignatura.eliminarLlista_assig_est();
        curs.eliminarAssignautra(codiAss);
        System.out.println("Assignatura eliminada correctament");
    }

    public void infoCurs() {
        int codi = llegirNum("Codi del curs a mostrar: ");
        String res = "";
        Curs curs = (Curs) this.llistCurs.cercar(codi);
        if(curs != null){
        res += curs+"\n";
        res += curs.getList().mostrarLlista();
        System.out.println(res);
        }else{
            System.out.println("Curs no existent.");
        }
    }

    public void infoAssignatura() {
        int codiAss = llegirNum("Codi de la assigantura de la que vols obtenir la infromació: ");

        Curs cursAux = this.llistCurs.getCap();
        Assignatura assAux = cursAux.getList().getCap();
        String res = "";
        Boolean trobat = false;
        while (cursAux != null && !trobat) {
            assAux = cursAux.cercarAssignatura(codiAss);
            if(assAux!=null){
            if (assAux.getCodi() == codiAss) {
                trobat = true;
                res += "Curs on es troba la assignatura: \n\n" + cursAux.toString();
                res += "\n\nEstudiants de la assigantura: \n" + assAux.getListEst().mostrarLlista();
            }}else{
                cursAux = cursAux.getSeg();
            }

        }
        System.out.println(res);
    }

    public void infoEstudiant() {
        String res = "";
        String nEstu = llegir("Nom del estudiant: ");     
        Estudiant est = this.llistEst.cercarEstudiant(nEstu);
        if(est != null){
        res = est.getList().mostrarLlista();
        System.out.println(res);
        }else{
            System.out.println("Estudiant no matriculat.");
        }
    }

    // Mètodes de lectura i escriptura de teclat.
    public static int llegirNum(String msg) {
        int x = 0;
        try {
            String s;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(msg);
            s = in.readLine();
            x = Integer.parseInt(s);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return x;
    }

    public String llegir(String msg) {
        System.out.print(msg);
        String aux = "";
        try {
            BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
            aux = bfr.readLine();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
        return aux;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        (new Collegi()).menu();
    }

}
