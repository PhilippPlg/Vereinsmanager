/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vereinsmanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author Timo
 */
public class MannschaftDialog extends javax.swing.JFrame {

    private boolean IsNew;
    public SelectTrainingszeitenDialog EditTrainingszeitenDialog;

    public ArrayList<Trainingszeit> getTrainingszeiten() {
        return trainingszeiten;
    }

    public void setTrainingszeiten(ArrayList<Trainingszeit> trainingszeiten) {
        this.trainingszeiten = trainingszeiten;
    }
    private ArrayList<Trainingszeit> trainingszeiten;
    private StartupWindow parent;

    public boolean isIsNew() {
        return IsNew;
    }

    public void setIsNew(boolean IsNew) {
        this.IsNew = IsNew;
        SetWindowTitle();
    }

    public JList<String> getLbSpieler() {
        return lbSpieler;
    }

    public void setLbSpieler(JList<String> lbSpieler) {
        this.lbSpieler = lbSpieler;
    }

    public JTextField getTfBezeichnung() {
        return tfBezeichnung;
    }

    public void setTfBezeichnung(JTextField tfBezeichnung) {
        this.tfBezeichnung = tfBezeichnung;
    }

    public JTextField getTfErgebnis() {
        return tfErgebnis;
    }

    public void setTfErgebnis(JTextField tfErgebnis) {
        this.tfErgebnis = tfErgebnis;
    }

    public JTextField getTfNaechstesSpiel() {
        return tfNaechstesSpiel;
    }

    public void setTfNaechstesSpiel(JTextField tfNaechstesSpiel) {
        this.tfNaechstesSpiel = tfNaechstesSpiel;
    }

    public JTextField getTfTrainer() {
        return tfTrainer;
    }

    public void setTfTrainer(JTextField tfTrainer) {
        this.tfTrainer = tfTrainer;
    }

    /**
     * Creates new form MannschaftDialog
     */
    public MannschaftDialog() {

    }

    public MannschaftDialog(StartupWindow parent) {
        this(false, parent);
    }

    public MannschaftDialog(boolean IsNew, StartupWindow parent) {
        initComponents();
        this.parent = parent;
        setIsNew(IsNew);
        SetWindowTitle();
    }

    public void ChangetfBezeichnungCanEdit(Boolean CanEdit) {
        tfBezeichnung.setEditable(CanEdit);
        tfBezeichnung.setEnabled(CanEdit);
    }

    private void SetWindowTitle() {
        String Caption = IsNew ? EObjektStatus.erstellen.toString() : EObjektStatus.bearbeiten.toString();
        String ButtonCaption = IsNew ? ESaveStatus.erstellen.toString() : ESaveStatus.aktualisieren.toString();
        lblÜberschrift.setText("Mannschaft " + Caption);
        btnSpeichern.setText(ButtonCaption);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblÜberschrift = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfBezeichnung = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfTrainer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfErgebnis = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfNaechstesSpiel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbSpieler = new javax.swing.JList<>();
        btnVerwerfen = new javax.swing.JButton();
        btnSpeichern = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblÜberschrift.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblÜberschrift.setText("Mannschaft");

        jLabel2.setText("Bezeichnung");

        jLabel3.setText("Trainingszeiten");

        jLabel4.setText("Trainer");

        jLabel5.setText("Spieler");

        jLabel6.setText("Letztes Ergebnis");

        jLabel7.setText("Nächstes Spiel");

        lbSpieler.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lbSpieler);

        btnVerwerfen.setText("Verwerfen");
        btnVerwerfen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerwerfenActionPerformed(evt);
            }
        });

        btnSpeichern.setText("Speichern");
        btnSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpeichernActionPerformed(evt);
            }
        });

        jButton1.setText("Trainingszeiten bearbeiten");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVerwerfen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSpeichern))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblÜberschrift, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfBezeichnung)
                                        .addComponent(tfTrainer)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(39, 39, 39)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfErgebnis, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tfNaechstesSpiel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(lblWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblÜberschrift, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfBezeichnung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(tfErgebnis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(tfNaechstesSpiel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(tfTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSpeichern)
                    .addComponent(btnVerwerfen))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpeichernActionPerformed
        try {
            ArrayList<Object> ObjekteZumSpeichern = new ArrayList<Object>();
            ArrayList<Mannschaft> OldMannschaften = XMLLoader.loadMannschaft();
            Trainer Testtrainer = new Trainer();
            Testtrainer.setGehalt(9999);
            Mannschaft Mannschaft = new Mannschaft();
            Mannschaft.setBezeichnung(tfBezeichnung.getText());
            Mannschaft.setLetztesErgebnis(new Spiel(new Mannschaft(), "", new Date())); //Spiel erzeugen oder auswählen
            Mannschaft.setTrainingszeiten(trainingszeiten.toArray(new Trainingszeit[trainingszeiten.size()])); //Trainingszeiten????
            Mannschaft.setNaechstesSpiel(new Spiel(new Mannschaft(), "", new Date())); //Spiel erzeugen oder auswählen
            Mannschaft.setTrainer(Testtrainer); //Wähle hier Trainer aus
            ObjekteZumSpeichern.addAll(OldMannschaften);
            ObjekteZumSpeichern.add(Mannschaft);
            XMLSerializer.serializeToXML(ObjekteZumSpeichern, ESaveObject.mannschaft);
        } catch (IOException ex) {
            Logger.getLogger(MannschaftDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSpeichernActionPerformed

    private void btnVerwerfenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerwerfenActionPerformed
        parent.MannschaftDialog.dispose();
    }//GEN-LAST:event_btnVerwerfenActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String bezeichnung = tfBezeichnung.getText();
        if (bezeichnung.isBlank() || bezeichnung.isEmpty()) {
            lblWarning.setText("<html><b>Bezeichnung darf zum anlegen von Trainingszeiten nicht leer sein!</b></html>");
            return;
        } else {
            lblWarning.setText(null);
        }
        ChangetfBezeichnungCanEdit(false);
        EditTrainingszeitenDialog = new SelectTrainingszeitenDialog(this, bezeichnung);
        EditTrainingszeitenDialog.setResizable(false);
        EditTrainingszeitenDialog.setDefaultCloseOperation(SelectTrainingszeitenDialog.DISPOSE_ON_CLOSE);
        EditTrainingszeitenDialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MannschaftDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MannschaftDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MannschaftDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MannschaftDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MannschaftDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSpeichern;
    private javax.swing.JButton btnVerwerfen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lbSpieler;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JLabel lblÜberschrift;
    private javax.swing.JTextField tfBezeichnung;
    private javax.swing.JTextField tfErgebnis;
    private javax.swing.JTextField tfNaechstesSpiel;
    private javax.swing.JTextField tfTrainer;
    // End of variables declaration//GEN-END:variables
}
