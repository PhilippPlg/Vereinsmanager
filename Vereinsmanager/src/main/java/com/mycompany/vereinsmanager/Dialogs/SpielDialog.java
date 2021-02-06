/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vereinsmanager.Dialogs;

import com.mycompany.vereinsmanager.Entities.Mannschaft;
import com.mycompany.vereinsmanager.Entities.NormalesMitglied;
import com.mycompany.vereinsmanager.Entities.Profispieler;
import com.mycompany.vereinsmanager.Entities.Spiel;
import com.mycompany.vereinsmanager.Enums.EObjektStatus;
import com.mycompany.vereinsmanager.Enums.ESaveObject;
import com.mycompany.vereinsmanager.Enums.ESaveStatus;
import com.mycompany.vereinsmanager.main.StartupWindow;
import static com.mycompany.vereinsmanager.main.Validator.isValidDate;
import static com.mycompany.vereinsmanager.main.Validator.isValidTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.mycompany.vereinsmanager.main.XMLLoader;
import com.mycompany.vereinsmanager.main.XMLSerializer;
import java.io.IOException;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Timo
 */
public class SpielDialog extends javax.swing.JDialog {

    private StartupWindow parent;

    public boolean isIsNew() {
        return IsNew;
    }

    public void setIsNew(boolean IsNew) {
        this.IsNew = IsNew;
        SetWindowTitle();
        this.cboMannschaft.setEnabled(IsNew);
        this.cboMannschaft.setEditable(IsNew);
        this.tfGegner.setEnabled(IsNew);
        this.tfGegner.setEditable(IsNew);
        if (!IsNew) {
            setcboMannschaftItems(cboMannschaft.getSelectedItem().toString());
        }
    }

    public JTextField getTfAnfangszeit() {
        return tfAnfangszeit;
    }

    public void setTfAnfangszeit(String Anfangszeit) {
        this.tfAnfangszeit.setText(Anfangszeit);
    }

    public JList<String> getLbSpieler() {
        return lbSpieler;
    }

    public void setLbSpieler(ArrayList<String> Spieler) {
        DefaultListModel model = new DefaultListModel();
        model.addAll(Spieler);
        this.lbSpieler.setModel(model);
    }

    public JTextField getTfGegner() {
        return tfGegner;
    }

    public void setTfGegner(String Gegner) {
        this.tfGegner.setText(Gegner);
    }

    public Mannschaft getMannschaft() throws IOException {
        ArrayList<Mannschaft> tempMannschaften = XMLLoader.loadMannschaft();
        Mannschaft eigeneMannschaft = new Mannschaft();
        for (Mannschaft cMannschaft : tempMannschaften) {
            if (cMannschaft.getBezeichnung().equals(cboMannschaft.getModel().getSelectedItem().toString())) {
                eigeneMannschaft = cMannschaft;
                break;
            }
        }
        return eigeneMannschaft;
    }

    public JTextField getTfOrt() {
        return tfOrt;
    }

    public void setTfOrt(String Ort) {
        this.tfOrt.setText(Ort);
    }

    public JList<String> getTfSpieler() {
        return lbSpieler;
    }

    public void setTfSpieler(JList<String> tfSpieler) {
        this.lbSpieler = tfSpieler;
    }

    public JTextField getTfDatum() {
        return tfDatum;
    }

    public void setTfDatum(String tfDatum) {
        this.tfDatum.setText(tfDatum);
    }
    private boolean IsNew;

    /**
     * Creates new form MannschaftDialog
     */
    public SpielDialog() throws IOException {
        setCboMannschaftenItems();
    }

    public SpielDialog(StartupWindow parent) throws IOException {
        this(false, parent);
    }

    public SpielDialog(boolean IsNew, StartupWindow parent) throws IOException {
        initComponents();
        setIsNew(IsNew);
        this.parent = parent;
        setCboMannschaftenItems();
        SetWindowTitle();

    }

    private void SetWindowTitle() {
        String Caption = IsNew ? EObjektStatus.erstellen.toString() : EObjektStatus.bearbeiten.toString();
        String ButtonCaption = IsNew ? ESaveStatus.erstellen.toString() : ESaveStatus.aktualisieren.toString();
        lblÜberschrift.setText("Spiel " + Caption);
        btnSpeichern.setText(ButtonCaption);
    }

    public void setCboMannschaftName(String cboMannschaftName) {
        try {
            setCboMannschaftenItems();
            cboMannschaft.getModel().setSelectedItem(cboMannschaftName);
        } catch (IOException ex) {
            Logger.getLogger(SpielerDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setCboMannschaftenItems() throws IOException {
        ArrayList<Mannschaft> mannschaften = XMLLoader.loadMannschaft();
        ArrayList<String> mannschaftsNamen = new ArrayList<String>();
        for (Mannschaft cMannschaft : mannschaften) {
            mannschaftsNamen.add(cMannschaft.getBezeichnung());
        }
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addAll(mannschaftsNamen);
        cboMannschaft.setModel(model);
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
        jLabel3 = new javax.swing.JLabel();
        tfAnfangszeit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfDatum = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfGegner = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfOrt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbSpieler = new javax.swing.JList<>();
        btnSpeichern = new javax.swing.JButton();
        btnVerwerfen = new javax.swing.JButton();
        lblWarning = new javax.swing.JLabel();
        cboMannschaft = new javax.swing.JComboBox<>();
        btnLoeschen = new javax.swing.JButton();

        lblÜberschrift.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblÜberschrift.setText("Spiel");

        jLabel2.setText("Eigene Mannschaft");

        jLabel3.setText("Anfangszeit");

        jLabel4.setText("Datum");

        jLabel5.setText("Spieler");

        jLabel6.setText("Gegner");

        jLabel7.setText("Ort");

        lbSpieler.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lbSpieler);

        btnSpeichern.setText("Speichern");
        btnSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpeichernActionPerformed(evt);
            }
        });

        btnVerwerfen.setText("Verwerfen");
        btnVerwerfen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerwerfenActionPerformed(evt);
            }
        });

        cboMannschaft.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMannschaft.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMannschaftItemStateChanged(evt);
            }
        });

        btnLoeschen.setText("Löschen");
        btnLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoeschenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLoeschen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerwerfen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSpeichern))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblÜberschrift, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfAnfangszeit, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(tfDatum, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(cboMannschaft, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfGegner, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfOrt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblÜberschrift, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfAnfangszeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(cboMannschaft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfGegner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfOrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSpeichern)
                    .addComponent(btnVerwerfen)
                    .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoeschen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerwerfenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerwerfenActionPerformed
        parent.SpielDialog.dispose();
    }//GEN-LAST:event_btnVerwerfenActionPerformed

    private void btnSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpeichernActionPerformed
        try {
            Date geb = null;

            String eigenesTeam = "";
            Object mannschaft = cboMannschaft.getSelectedItem();
            if (mannschaft != null) {
                eigenesTeam = mannschaft.toString();
            }
            String gegner = tfGegner.getText();
            String anfangszeit = tfAnfangszeit.getText();
            String datum = tfDatum.getText();
            String ort = tfOrt.getText();
            // html damit der linebreak im label funktioniert, sehr hässlich
            String warning = "<html>";
            if (!isValidTime(anfangszeit)) {
                warning += "Die Startzeit ist fasch formatiert.\\n";
            }
            if (!isValidDate(datum)) {
                warning += "Das Datum ist falsch formatiert";
            }
            //DateFormat format = new SimpleDateFormat("dd.MM.YYYY", Locale.GERMAN);
            //Date zukunftsDate = format.parse(datum);
            //if (!zukunftsDate.after(new Date())) {
            //  warning += "Das Datum muss in der Zukunft liegen!";
            //}

            if (warning.equals("<html>")) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY HH:mm");
                try {
                    Date date = dateFormat.parse(datum + " " + anfangszeit);
                    ArrayList<Spiel> spiele = XMLLoader.loadSpiel();
                    ArrayList<Object> ObjekteZumSpeichern = new ArrayList<Object>();
                    ESaveObject SaveObject = ESaveObject.spiel;

                    if (!IsNew) {
                        String actualCaption = eigenesTeam + " gegen " + gegner;
                        for (Spiel cSpiel : spiele) {
                            String spielCaption = cSpiel.getEigenesTeam() + " gegen " + cSpiel.getGegnerTeam();
                            if (spielCaption.equals(actualCaption)) {
                                spiele.remove(cSpiel);
                                break;
                            }
                        }
                    }

                    Spiel newSpiel = new Spiel(eigenesTeam, gegner, date, ort);
                    spiele.add(newSpiel);
                    ObjekteZumSpeichern.addAll(spiele);
                    XMLSerializer.serializeToXML(ObjekteZumSpeichern, SaveObject);
                    lblWarning.setText("<html><b>Das Spiel wurde gespeichert!</b></html>");
                    parent.SpielDialog.dispose();
                    parent.AllesAktualisieren();
                } catch (ParseException e) {
                    Logger.getLogger(SpielerDialog.class.getName()).log(Level.SEVERE, null, e);
                }

            } else {
                warning += "</html>";
                lblWarning.setText(warning);
            }
        } catch (IOException ex) {
            Logger.getLogger(SpielerDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSpeichernActionPerformed

    private void btnLoeschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoeschenActionPerformed
        try {
            int result = JOptionPane.showConfirmDialog(null, "Möchten Sie das aktuelle Element wirklich löschen?", "Löschen?", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.NO_OPTION) {
                return;
            }
            ArrayList<Spiel> OldSpiele = XMLLoader.loadSpiel();
            ArrayList<Object> neueSpiele = new ArrayList();
            for (Spiel cSpiel : OldSpiele) {
                if ((cboMannschaft.getSelectedItem().toString() + " gegen " + tfGegner.getText())
                        .equals(cSpiel.getEigenesTeam() + " gegen " + cSpiel.getGegnerTeam())) {
                    OldSpiele.remove(cSpiel);
                    break;
                }
            }
            neueSpiele.addAll(OldSpiele);
            XMLSerializer.serializeToXML(neueSpiele, ESaveObject.spiel);
            parent.AllesAktualisieren();
            parent.SpielDialog.dispose();
        } catch (IOException ex) {
            Logger.getLogger(MannschaftDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoeschenActionPerformed

    private void cboMannschaftItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMannschaftItemStateChanged
        setcboMannschaftItems(evt.getItem().toString());
    }//GEN-LAST:event_cboMannschaftItemStateChanged

    private void setcboMannschaftItems(String mannschaftsName) {
        try {
            ArrayList<String> teamSpieler = new ArrayList<>();
            ArrayList<Profispieler> alleSpieler = XMLLoader.loadProfiSpieler();
            ArrayList<NormalesMitglied> alleMitglieder = XMLLoader.loadMitglieder();
            for (Profispieler cSpieler : alleSpieler) {
                String cMannschaftsName = cSpieler.getMannschaft();

                if (cMannschaftsName == null || mannschaftsName == null) {
                    continue;
                }
                if (cMannschaftsName.equals(mannschaftsName)) {
                    teamSpieler.add(cSpieler.getVorname() + " " + cSpieler.getNachname());
                }
                break;
            }
            for (NormalesMitglied cMitglied : alleMitglieder) {
                String cMannschaftsName = cMitglied.getMannschaft();
                if (cMannschaftsName == null || mannschaftsName == null) {
                    continue;
                }
                if (cMannschaftsName.equals(mannschaftsName)) {
                    teamSpieler.add(cMitglied.getVorname() + " " + cMitglied.getNachname());
                }
                break;
            }
            this.setLbSpieler(teamSpieler);
        } catch (IOException ex) {
            Logger.getLogger(SpielDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(SpielDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpielDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpielDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpielDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SpielDialog().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(SpielDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoeschen;
    private javax.swing.JButton btnSpeichern;
    private javax.swing.JButton btnVerwerfen;
    private javax.swing.JComboBox<String> cboMannschaft;
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
    private javax.swing.JTextField tfAnfangszeit;
    private javax.swing.JTextField tfDatum;
    private javax.swing.JTextField tfGegner;
    private javax.swing.JTextField tfOrt;
    // End of variables declaration//GEN-END:variables
}
