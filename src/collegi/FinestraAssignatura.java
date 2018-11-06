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
public class FinestraAssignatura extends JPanel{
    
    private JButton jbeliminar, jbinformacio, jbaccepta, jbexit;
    
    private JLabel  jlcurs, jlcodi;
    
    private JTextField  jtfcurs, jtfcodi;
    
    private JTextArea   output;
    private JScrollPane scroll;
    
    private int op;
    private Collegi collegi;
    
    public FinestraAssignatura(Collegi collegi){
        this.op = 0;
        this.collegi = collegi;
        
        jbeliminar = new JButton();
        jbinformacio = new JButton();
        jbaccepta = new JButton();
        jbexit = new JButton();
        
        jlcurs = new JLabel();
        jlcodi = new JLabel();
        
        jtfcurs = new JTextField();
        jtfcodi = new JTextField();
        
        output = new JTextArea();
        scroll = new JScrollPane(output);
        
        jbeliminar.setText("Eliminar");
        jbinformacio.setText("Informació");
        jbaccepta.setText("Accepta");
        jbexit.setText("Exit");
        
        jbeliminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                jbEliminarActionPerformed(evt);
            }
        });
        jbinformacio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                jbInformacioActoinPerformed(evt);
            }
        });
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
        
        add(jbeliminar);
        add(jbinformacio);
        add(jbaccepta);
        add(jbexit);
        
        jbeliminar.setBounds(10, 40, 116, 16);
        jbinformacio.setBounds(10,70,116,16);
        jbaccepta.setBounds(300,390,116,16);
        jbexit.setBounds(470,390,116,16);
        
        jlcodi.setText("Codi de l'assignatura:");
        jlcurs.setText("Curs al que pertany:");
        
        add(jlcodi);
        add(jlcurs);
        
        jlcodi.setBounds(200, 25, 150, 16);
        jlcurs.setBounds(200, 55, 150, 16);
        
        add(jtfcodi);
        add(jtfcurs);
        
        jtfcodi.setBounds(360, 25, 75, 16);
        jtfcurs.setBounds(360, 55, 75, 16);
        
        output.setEditable(false);
        output.setLineWrap(true);
        add(scroll);
        scroll.setBounds(200, 150, 386, 190);
        
        disable_all();
    }
    
    public void jbEliminarActionPerformed(ActionEvent evt){
        disable_all();
        this.jtfcodi.setEnabled(true);
        this.jtfcurs.setEnabled(true);
        this.jbaccepta.setEnabled(true);
        this.jbeliminar.setForeground(BLACK);
        this.jbinformacio.setForeground(GRAY);
        op = 1;
    }
    public void jbInformacioActoinPerformed(ActionEvent evt){
        disable_all();
        this.jtfcodi.setEnabled(true);
        this.jbaccepta.setEnabled(true);
        this.jbeliminar.setForeground(GRAY);
        this.jbinformacio.setForeground(BLACK);
        op = 2;
    }
    public void jbAcceptaActionPerformed(ActionEvent evt){
        int codiAss;
        switch(op){
            //Eliminar assigantura
            case 1:
                codiAss = Integer.parseInt(this.jtfcodi.getText());
                int codiCurs = Integer.parseInt(this.jtfcurs.getText());
                this.collegi.eliminarAssignatura(codiCurs, codiAss);
                break;
            //Informació de la assigantura
            case 2:
                codiAss = Integer.parseInt(this.jtfcodi.getText());
                String res = this.collegi.infoAssignatura(codiAss);
                this.output.setText(res);
                break;
        }
    }
    public void jbExitActionPerformed(ActionEvent evt){
        System.exit(0);
    }
    
    private void disable_all(){
        this.jbaccepta.setEnabled(false);
        this.jtfcodi.setEnabled(false);
        this.jtfcodi.setText("");
        this.jtfcurs.setEnabled(false);
        this.jtfcurs.setText("");
        this.output.setText("");
    }
}
