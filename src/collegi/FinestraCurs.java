package collegi;

import static java.awt.Color.BLACK;
import static java.awt.Color.GRAY;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Josep Borràs Sánchez, Bartomeu Ramis Tarrago
 */
public class FinestraCurs extends JPanel {
    private int op;

//int que indicarà la opció seleccionada
    private JButton jbcrear;
    private JButton jbeliminar;
    private JButton jbinformacio;
    private JButton jbaccepta;
    private JButton jbexit;

    private JComboBox jcbfp, jcbbatx;
    private String[] t_fp = {"-Seleciona-", "Electrònica", "Informàtica", "Mecànica"};
    private String[] t_batx = {"-Seleciona-", "Primer", "Segon"};

    private JLabel jlnom;
    private JLabel jlcodi;
    private JLabel jln_ass;
    private JLabel jlfp, jlbatx;

    private JTextField jtfnom;
    private JTextField jtfcodi;
    private JTextField jtfn_ass;

    private JTextArea output;
    private JScrollPane scroll;
    Collegi collegi;
    int tipusCurs = 0;

    public FinestraCurs(Collegi collegi) {
        this.op = 0;
        this.collegi = collegi;
        jbcrear = new JButton();
        jbeliminar = new JButton();
        jbinformacio = new JButton();
        jbaccepta = new JButton();
        jbexit = new JButton();

        jlnom = new JLabel();
        jlcodi = new JLabel();
        jln_ass = new JLabel();
        jlfp = new JLabel();
        jlbatx = new JLabel();

        jtfnom = new JTextField();
        jtfcodi = new JTextField();
        jtfn_ass = new JTextField();

        jcbfp = new JComboBox(t_fp);
        jcbbatx = new JComboBox(t_batx);

        output = new JTextArea();
        scroll = new JScrollPane(output);

        jbcrear.setText("Crear");
        jbeliminar.setText("Eliminar");
        jbinformacio.setText("Informació");
        jbaccepta.setText("Accepta");
        jbexit.setText("Exit");

        jbaccepta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbAcceptaActionPerformed(evt);
            }
        });
        jbcrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbCrearActionPerformed(evt);
            }
        });
        jbeliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        jbinformacio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbInformacioActionPerformed(evt);
            }
        });
        jbexit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

        add(jbcrear);
        add(jbeliminar);
        add(jbinformacio);
        add(jbaccepta);
        add(jbexit);

        jbcrear.setBounds(10, 10, 116, 16);
        jbeliminar.setBounds(10, 40, 116, 16);
        jbinformacio.setBounds(10, 70, 116, 16);
        jbaccepta.setBounds(300, 390, 116, 16);
        jbexit.setBounds(470, 390, 116, 16);

        jlnom.setText("Nom:");
        jlcodi.setText("Codi:");
        jln_ass.setText("Nombre d'assignatura:");
        jlfp.setText("FP");
        jlbatx.setText("Batxillerat");

        add(jlnom);
        add(jlcodi);
        add(jln_ass);
        add(jlfp);
        add(jlbatx);

        jlnom.setBounds(200, 25, 150, 16);
        jlcodi.setBounds(200, 50, 150, 16);
        jlfp.setBounds(200, 75, 150, 16);
        jlbatx.setBounds(200, 100, 150, 16);
        jln_ass.setBounds(200, 125, 150, 16);

        add(jtfnom);
        add(jtfcodi);
        add(jtfn_ass);

        jtfnom.setBounds(360, 25, 150, 16);
        jtfcodi.setBounds(360, 50, 75, 16);
        jtfn_ass.setBounds(360, 125, 75, 16);

        add(jcbfp);
        add(jcbbatx);

        jcbfp.setBounds(360, 75, 150, 16);
        jcbbatx.setBounds(360, 100, 150, 16);

        jcbfp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jcbfpActionPerformed(evt);
            }
        });
        jcbbatx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jcbbatxActionPerformed(evt);
            }
        });

        add(scroll);
        scroll.setBounds(200, 150, 386, 190);
        output.setEditable(false);
        output.setLineWrap(true);

        disable_all();
    }

    public void jcbbatxActionPerformed(ActionEvent evt) {
        jcbfp.setEnabled(false);
        this.tipusCurs = 2;
    }

    public void jcbfpActionPerformed(ActionEvent evt) {
        jcbbatx.setEnabled(false);
        this.tipusCurs = 1;
    }

    public void jbCrearActionPerformed(ActionEvent evt) {
        this.jbaccepta.setEnabled(true);
        this.jcbbatx.setEnabled(true);
        this.jcbfp.setEnabled(true);
        this.jtfcodi.setEnabled(true);
        this.jtfn_ass.setEnabled(true);
        this.jtfnom.setEnabled(true);
        this.jbcrear.setForeground(BLACK);
        this.jbeliminar.setForeground(GRAY);
        this.jbinformacio.setForeground(GRAY);
        op = 1;

    }

    public void jbEliminarActionPerformed(ActionEvent evt) {
        disable_all();
        this.jtfcodi.setEnabled(true);
        this.jbaccepta.setEnabled(true);
        this.jbcrear.setForeground(GRAY);
        this.jbeliminar.setForeground(BLACK);
        this.jbinformacio.setForeground(GRAY);
        op = 2;
    }

    public void jbInformacioActionPerformed(ActionEvent evt) {
        disable_all();
        this.jtfcodi.setEnabled(true);
        this.jbaccepta.setEnabled(true);
        this.jbcrear.setForeground(GRAY);
        this.jbeliminar.setForeground(GRAY);
        this.jbinformacio.setForeground(BLACK);
        op = 3;
    }

    public void jbAcceptaActionPerformed(ActionEvent evt) {
        int codiCurs;
        switch (op) {
            //Crear una nova ssigantura
            case 1:
                int nAss,
                 tipus,
                 especialitat;
                String nomCurs;
                nAss = Integer.parseInt(this.jtfn_ass.getText());
                codiCurs = Integer.parseInt(this.jtfcodi.getText());
                nomCurs = this.jtfnom.getText();
                tipus = this.tipusCurs;
                if (tipus == 1) {
                    especialitat = this.jcbfp.getSelectedIndex();
                } else {
                    especialitat = this.jcbbatx.getSelectedIndex();
                }
                this.collegi.donarAltaCurs(nAss, nomCurs, codiCurs, tipus, especialitat);
                break;

            //Eliminar un curs
            case 2:
                codiCurs = Integer.parseInt(this.jtfcodi.getText());
                this.collegi.eliminarCurs(codiCurs);
                break;
            //Informacó del curs
            case 3:
                codiCurs = Integer.parseInt(this.jtfcodi.getText());
                this.output.setText(this.collegi.infoCurs(codiCurs));
                break;
        }
    }

    public void jbExitActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void disable_all() {
        this.jbaccepta.setEnabled(false);
        this.jcbbatx.setEnabled(false);
        this.jcbbatx.setSelectedIndex(0);
        this.jcbfp.setEnabled(false);
        this.jcbfp.setSelectedIndex(0);
        this.jtfcodi.setEnabled(false);
        this.jtfcodi.setText("");
        this.jtfn_ass.setEnabled(false);
        this.jtfn_ass.setText("");
        this.jtfnom.setEnabled(false);
        this.jtfnom.setText("");
        this.output.setText("");
    }
}
