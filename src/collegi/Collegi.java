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
import java.awt.BorderLayout;
import static java.awt.Color.BLACK;
import static java.awt.Color.GRAY;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Collegi extends JFrame {

    Llista_estudiants_collegi llistEst = new Llista_estudiants_collegi();
    Llista_curs llistCurs = new Llista_curs();

    private JButton jbcurs;
    private JButton jbassignatura;
    private JButton jbestudiant;
    private JPanel jpanel;
    private BorderLayout layout = new BorderLayout();

    public Collegi() {
        initContent();
    }

    public void initContent() {

        this.setSize(640, 480);
        this.setTitle("GESTIÓ DEL COL·LEGI");
        this.setDefaultCloseOperation(Collegi.EXIT_ON_CLOSE);
        this.setResizable(false);
        getContentPane().setLayout(layout);

        JPanel menu = new JPanel();

        jpanel = new JPanel();
        add(jpanel);

        jbcurs = new JButton();
        jbassignatura = new JButton();
        jbestudiant = new JButton();

        jbcurs.setText("Curs");
        jbassignatura.setText("Assignatura");
        jbestudiant.setText("Estudiant");

        jbcurs.setAlignmentX(Component.LEFT_ALIGNMENT);
        jbassignatura.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbestudiant.setAlignmentX(Component.RIGHT_ALIGNMENT);

        jbcurs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbCursActionPerformed(evt);
            }
        });
        jbassignatura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbAssignaturaActionPerformed(evt);
            }
        });
        jbestudiant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbEstudiantActionPerformed(evt);
            }
        });

        menu.setLayout(new GridLayout(1, 3));
        menu.add(jbcurs);
        menu.add(jbassignatura);
        menu.add(jbestudiant);
        add(menu, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        Collegi c2 = new Collegi();
        c2.setVisible(true);
    }

    public void jbCursActionPerformed(ActionEvent evt) {
        jbcurs.setForeground(BLACK);
        jbassignatura.setForeground(GRAY);
        jbestudiant.setForeground(GRAY);
        remove(jpanel);
        repaint();
        revalidate();

        jpanel = new FinestraCurs(this);
        jpanel.setLayout(null);
        add(jpanel, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    public void jbAssignaturaActionPerformed(ActionEvent evt) {
        jbcurs.setForeground(GRAY);
        jbassignatura.setForeground(BLACK);
        jbestudiant.setForeground(GRAY);
        remove(jpanel);
        repaint();
        revalidate();

        jpanel = new FinestraAssignatura(this);
        jpanel.setLayout(null);
        add(jpanel, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    public void jbEstudiantActionPerformed(ActionEvent evt) {
        jbcurs.setForeground(GRAY);
        jbassignatura.setForeground(GRAY);
        jbestudiant.setForeground(BLACK);
        remove(jpanel);
        repaint();
        revalidate();

        jpanel = new FinestraEstudiant(this);
        jpanel.setLayout(null);
        add(jpanel, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

//    public void menu() {
//        boolean sortir = false;
//        int opcio = 0;
//        while (!sortir) {
//            System.out.println("\n\n****COL·LEGI****\n"
//                    + "1. Donar d'alta un curs"
//                    + "\n2. Matricular un estudiant"
//                    + "\n3. Donar un curs de baixa"
//                    + "\n4. Donar de baixa una assignatura"
//                    + "\n5. Informació curs"
//                    + "\n6. Informació assignatura"
//                    + "\n7. Informació estudiant"
//                    + "\n0. Exit");
//            opcio = llegirNum("\n\nInserir opció: ");
//            switch (opcio) {
//                case 1:
//                    donarAltaCurs();
//                    break;
//                case 2:
//                    matricularEstudiant();
//                    break;
//                case 3:
//                    eliminarCurs();
//                    break;
//                case 4:
//                    eliminarAssignatura();
//                    break;
//                case 5:
//                    infoCurs();
//                    break;
//                case 6:
//                    infoAssignatura();
//                    break;
//                case 7:
//                    infoEstudiant();
//                    break;
//                case 0:
//                    sortir = true;
//                    break;
//                default:
//                    System.out.println("No existeix aquesta opció\n");
//            }
//        }
//    }

    /*
    Crearem un curs. Per crear-lo necessitem un nombre d'assignatures que formen
    el curs a crear. A més, d'un nom i un codi. Després ens demanrà de quin tipus de curs 
    es tracta. un cop creat el curs crearem les assignatures i les inserirem a la
    llista d'assignatures que té un curs. Finalment, ordenarà la llista d'assignatures
    segons el codi de cada una.
     */
    public void donarAltaCurs(int nAss, String nomCurs, int codiCurs, int tipus, int especialitat) {
        Curs curs = null;
        Assignatura assignatura;
        switch (tipus) {
            case 1:
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
                switch (especialitat) {
                    case 1:
                        curs = new Primer(nAss, nomCurs, codiCurs);
                        break;
                    case 2:
                        curs = new Segon(nAss, nomCurs, codiCurs);
                        break;
                }
                break;
        }
          
        for (int i = 0; i < nAss; i++) {           
            curs.inserirAssignatura(i);
        }
        curs.getList().ordenar();
        this.llistCurs.inserirCurs(curs);
    }

    /*
    Primer ens demana el nom de l'estudiant i l'assignatura en la que volem 
    matricular. Mira si l'estudiant està matriculat al col·legi.
    En cas d'estar matriculat no demana el DNI. Mira si l'estudiant ja estava
    matriculat a l'assignatura i en cas de que no estigui matriculat, el matricula a la nova
    assignatura. En cas de no estar matriculat, demanarà el DNI de l'estudiant
    i el matricularà en ambdos llocs (col·legi i assignatura).
     */
    public void matricularEstudiant(String nomEst, String dniEst, int codiAssig) {
//        int codiAssig = llegirNum("Codi de la assignatura on es vol matricular: ");
        Assignatura assign = null;
        Curs cursAux = this.llistCurs.getCap();
        boolean trobat = false;

        while (cursAux != null && !trobat) {
            assign = cursAux.cercarAssignatura(codiAssig);
            if (assign != null) {
                if (assign.getCodi() == codiAssig) {
                    trobat = true;
                }
            } else {
                cursAux = cursAux.getSeg();
            }
        }
        if (!assign.getListEst().esPle()) {
//            String nomEst = llegir("Escriu el nom del estudiant a matricular: ");
//            String dniEst = llegir("DNI del estudiant a matricular: ");
            Estudiant estu = this.llistEst.cercarEstudiant(dniEst);

            if (estu == null) {
                estu = new Estudiant(nomEst, dniEst);
                this.llistEst.inserirEstudiant(estu);
                estu.inserirAssignatura(assign);
                assign.afegirEstudiant(estu);
//                System.out.println("MATRICULAT !!");
                JOptionPane.showMessageDialog(new JFrame(), "Estudiant matriculat correctament");
            } else {
                if (estu.getList().cercarRefassign(codiAssig) == null) {
                    estu.inserirAssignatura(assign);
                    assign.afegirEstudiant(estu);
//                    System.out.println("MATRICULAT !!");
                    JOptionPane.showMessageDialog(new JFrame(), "Estudiant matriculat correctament");
                } else {
//                    System.out.println("Estudiant ja matriculat a aqusta assignatura.");
                    JOptionPane.showMessageDialog(new JFrame(), "L'estudiant ja està matriculat a la assigantura",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        } else {
//            System.out.println("No queden places en la assignatura :(");
            JOptionPane.showMessageDialog(new JFrame(), "No hi ha places lliures a la assigantura",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
    Cerca el curs de la llista de cursos i elimina les seves assignatures una a una,
    eliminant sempre la primera assignatura de la llista.
     */
    public void eliminarCurs(int codiCurs) {
//        int codiCurs = llegirNum("Codi del curs a eliminar: ");
        Curs curs = (Curs) this.llistCurs.cercar(codiCurs);
        if (curs != null) {
            Assignatura assAux = curs.getList().getCap();
            while (assAux != null) {
                curs.eliminarAssignautra(assAux.getCodi());
                assAux = curs.getList().getCap();
            }
            this.llistCurs.eliminar(codiCurs);
            JOptionPane.showMessageDialog(new JFrame(),
                    "Curs eliminat correctament");

        } else {
//            System.out.println("Curs no existent.");
            JOptionPane.showMessageDialog(new JFrame(),
                    "Curs no exsistent",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
    Donada una assignatura i un curs, cercarà dins la seva llista d'assigantures,
    la que s'ha d'eliminar.
     */
    public void eliminarAssignatura(int codiCurs, int codiAss) {
//        int codiAss = llegirNum("Codi de la assigantra a eliminar: ");
//        int codiCurs = llegirNum("Codi del curs a on pertany la assigantura a eliminar: ");

        Curs curs = (Curs) this.llistCurs.cercar(codiCurs);
        curs.eliminarAssignautra(codiAss);
//        System.out.println("Assignatura eliminada correctament");
        JOptionPane.showMessageDialog(new JFrame(),
                "Assigantura eliminada correctament");
    }

    /*
    Cercarem dins la llista de cursos el curs del que s'ha d'informar. Mostra la
    informació del curs i la seva llista d'assignatures. En cas de que el curs
    inserit no existesqui es mostrarà un missatge d'error.
     */
    public String infoCurs(int codi) {
//        int codi = llegirNum("Codi del curs a mostrar: ");
        String res = "\n";
        Curs curs = (Curs) this.llistCurs.cercar(codi);
        if (curs != null) {
            res += curs + "\n";
            res += "\n" + curs.getList().mostrarLlista();
//            System.out.println(res);
        } else {
            JOptionPane.showMessageDialog(new JFrame(),
                    "Curs no exsistent",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }

    /*
    Donat un codi d'una assignatura mirarà de quin curs pertany. A més mostrarà,
    la llista d'estudiants que estan matriculats a l'assignatura.
     */
    public String infoAssignatura(int codiAss) {
//        int codiAss = llegirNum("Codi de la assigantura de la que vols obtenir la infromació: ");

        Curs cursAux = this.llistCurs.getCap();
        Assignatura assAux;
        String res = "";
        Boolean trobat = false;
        while (cursAux != null && !trobat) {
            assAux = cursAux.cercarAssignatura(codiAss);
            if (assAux != null) {
                if (assAux.getCodi() == codiAss) {
                    trobat = true;
                    res += "Curs on es troba la assignatura: \n\n" + cursAux;
                    res += "\n\nEstudiants de la assigantura: \n" + assAux.getListEst().mostrar();
                }
            } else {
                cursAux = cursAux.getSeg();
            }

        }
//        System.out.println(res);
        return res;
    }

    /*
    Donat el nom d'un estudiant cercarà dins la llista d'estudiants del col·legi
    En cas de trobar-lo, imprimirà la llista d'assignatures a les que esta matriculat
    (mitant la llista de referencies associada a cada estudiant). En cas de no trobar 
    l'estudiant en la llista ens mostrara un missatge d'error.
     */
    public String infoEstudiant(String dni_estu) {
        String res = "";
//        String dni_estu = llegir("DNI del estudiant: ");
        Estudiant est = this.llistEst.cercarEstudiant(dni_estu);
        if (est != null) {
            res = est.getList().mostrarLlista();
//            System.out.println(res);
        } else {
//            System.out.println("Estudiant no matriculat.");
            JOptionPane.showMessageDialog(new JFrame(),
                    "Estudiant no matriculat",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }

//    // Mètodes de lectura i escriptura de teclat.
//    public static int llegirNum(String msg) {
//        int x = 0;
//        try {
//            String s;
//            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//            System.out.print(msg);
//            s = in.readLine();
//            x = Integer.parseInt(s);
//        } catch (IOException | NumberFormatException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        return x;
//    }
//
//    public String llegir(String msg) {
//        System.out.print(msg);
//        String aux = "";
//        try {
//            BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//            aux = bfr.readLine();
//        } catch (IOException ioe) {
//            ioe.getMessage();
//        }
//        return aux;
//    }
}
