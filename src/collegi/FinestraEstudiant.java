/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegi;

import static java.awt.Color.BLACK;
import static java.awt.Color.GRAY;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author JosepB
 */
public class FinestraEstudiant extends JPanel {
    
    private JButton jbmatricular, jbinformacio, jbaccepta, jbexit;
    
    private JLabel  jlcodi_ass, jldni, jlnom;
    
    private JTextField  jtfcodi_ass, jtfdni, jtfnom;
    
    private JTextArea   output;
    private JScrollPane scroll;
    
    private Collegi collegi;
    private int op;
    
    public FinestraEstudiant(Collegi collegi){
        this.collegi = collegi;
        this.op = 0;
    
        this.jbaccepta = new JButton();
        this.jbexit = new JButton();
        this.jbinformacio = new JButton();
        this.jbmatricular = new JButton();
        
        this.jlcodi_ass = new JLabel();
        this.jldni  = new JLabel();
        this.jlnom  = new JLabel();
        
        this.jtfcodi_ass = new JTextField();
        this.jtfdni = new JTextField();
        this.jtfnom = new JTextField();
        
        this.output = new JTextArea();
        this.scroll = new JScrollPane(output);
        
        this.jbaccepta.setText("Accepta");
        this.jbexit.setText("Exit");
        this.jbinformacio.setText("Informació");
        this.jbmatricular.setText("Matricular");
        
        jbaccepta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                jbAcceptaActionPerformed(evt);
            }
        });
        jbexit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                jbExitActionPerformed(evt);
            }
        });
        jbmatricular.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                jbMatricularActionPerformed(evt);
            }
        });
        jbinformacio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                jbInformacioActionPerformed(evt);
            }
        });
        
        add(jbaccepta);
        add(jbexit);
        add(jbinformacio);
        add(jbmatricular);
        
        this.jbmatricular.setBounds(10, 10, 116, 16);
        this.jbinformacio.setBounds(10, 70, 116, 16);
        this.jbaccepta.setBounds(300, 390, 116, 16);
        this.jbexit.setBounds(470, 390, 116, 16);
        
        this.jlcodi_ass.setText("Codi de l'assignatura:");
        this.jldni.setText("DNI estudiant:");
        this.jlnom.setText("Nom estudiant:");
        
        add(jlcodi_ass);
        add(jldni);
        add(jlnom);
        
        this.jlnom.setBounds(200, 25, 150, 16);
        this.jldni.setBounds(200, 50, 150, 16);
        this.jlcodi_ass.setBounds(200,75,150,16);
        
        add(this.jtfcodi_ass);
        add(this.jtfdni);
        add(this.jtfnom);
        
        this.jtfnom.setBounds(360, 25, 116, 16);
        this.jtfdni.setBounds(360, 50, 116, 16);
        this.jtfcodi_ass.setBounds(360, 75, 75, 16);
        
        output.setEditable(false);
        output.setLineWrap(true);
        add(scroll);
        scroll.setBounds(200, 150, 386, 190);
        
        disable_all();
    }

    public void jbInformacioActionPerformed(ActionEvent evt){
        disable_all();
        this.jtfdni.setEnabled(true);
        this.jbaccepta.setEnabled(true);
        this.jbmatricular.setForeground(GRAY);
        this.jbinformacio.setForeground(BLACK);
        op = 1;
    }
    
    public void jbMatricularActionPerformed(ActionEvent evt){
        disable_all();
        this.jtfdni.setEnabled(true);
        this.jtfcodi_ass.setEnabled(true);
        this.jtfnom.setEnabled(true);
        this.jbaccepta.setEnabled(true);
        this.jbmatricular.setForeground(BLACK);
        this.jbinformacio.setForeground(GRAY);
        op = 2;
    }
    public void jbAcceptaActionPerformed(ActionEvent evt){
        String dni;
        switch(op){
            //Informació del estudiant
            case 1:
                dni = this.jtfdni.getText();
                String res = this.collegi.infoEstudiant(dni);
                this.output.setText(res);
                break;
            //Matricular estudiant
            case 2:
                dni = dni = this.jtfdni.getText();
                String nom = this.jtfnom.getText();
                int codiAss = Integer.parseInt(this.jtfcodi_ass.getText());
                this.collegi.matricularEstudiant(nom, dni, codiAss);
                break;
    }
    }
    
    public void jbExitActionPerformed(ActionEvent evt){
        System.exit(0);
    }
    
    
    private void disable_all(){
        this.jbaccepta.setEnabled(false);
        this.jtfcodi_ass.setEnabled(false);
        this.jtfcodi_ass.setText("");
        this.jtfdni.setEnabled(false);
        this.jtfdni.setText("");
        this.jtfnom.setEnabled(false);
        this.jtfnom.setText("");
        this.output.setText("");
    }
}
