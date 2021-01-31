/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vereinsmanager.Dialogs;

import com.mycompany.vereinsmanager.Enums.EObjektStatus;
import com.mycompany.vereinsmanager.Enums.ESaveObject;
import com.mycompany.vereinsmanager.Enums.ESaveStatus;
import com.mycompany.vereinsmanager.Enums.EZugehörigkeit;
import com.mycompany.vereinsmanager.Entities.Mannschaft;
import com.mycompany.vereinsmanager.Entities.NormalesMitglied;
import com.mycompany.vereinsmanager.Entities.Profispieler;
import com.mycompany.vereinsmanager.main.StartupWindow;
import com.mycompany.vereinsmanager.Entities.Trainer;
import com.mycompany.vereinsmanager.main.XMLLoader;
import com.mycompany.vereinsmanager.main.XMLSerializer;
import static com.mycompany.vereinsmanager.main.Validator.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/**
 *
 * @author Timo
 */
public class SpielerDialog extends javax.swing.JDialog {

    private static EZugehörigkeit Zugehörigkeit;
    private StartupWindow parent;
    private boolean IsNew;
    private String cboMannschaftName;

    public void setCboMannschaftName(String cboMannschaftName) {
        try {
            this.cboMannschaftName = cboMannschaftName;
            setCboMannschaftenItems();
            cboMannschaft.getModel().setSelectedItem(cboMannschaftName);
        } catch (IOException ex) {
            Logger.getLogger(SpielerDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form MannschaftDialog
     */
    public SpielerDialog() {

    }

    public SpielerDialog(EZugehörigkeit Zugehörigkeit, StartupWindow parent) throws IOException {
        this(Zugehörigkeit, false, parent);
    }

    public SpielerDialog(EZugehörigkeit Zugehörigkeit, boolean IsNew, StartupWindow parent) throws IOException {
        this.Zugehörigkeit = Zugehörigkeit;
        initComponents();
        setIsNew(IsNew);
        AddAssignmentItems();
        SetWindowTitle();
        this.parent = parent;
        setCboMannschaftenItems();
    }

    private void AddAssignmentItems() {
        EZugehörigkeit[] Assignments = {EZugehörigkeit.Mitglieder, EZugehörigkeit.Spieler, EZugehörigkeit.Trainer};
        cboZugehörigkeit.removeAllItems();
        for (EZugehörigkeit Zugehörigkeit : Assignments) {
            cboZugehörigkeit.addItem(Zugehörigkeit.toString());
        }
    }

    public boolean isIsNew() {
        return IsNew;
    }

    public void setIsNew(boolean IsNew) {
        this.IsNew = IsNew;
        SetWindowTitle();
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public void setTfEmail(String Email) {
        this.tfEmail.setText(Email);
    }

    public JTextField getTfGeburtsdatum() {
        return tfGeburtsdatum;
    }

    public void setTfGeburtsdatum(String Geburtsdatum) {
        this.tfGeburtsdatum.setText(Geburtsdatum);
    }

    public JTextField getTfNachname() {
        return tfNachname;
    }

    public void setTfNachname(String Nachname) {
        this.tfNachname.setText(Nachname);
    }

    public JTextField getTfOrt() {
        return tfOrt;
    }

    public void setTfOrt(String Ort) {
        this.tfOrt.setText(Ort);
    }

    public JTextField getTfPLZ() {
        return tfPLZ;
    }

    public void setTfPLZ(String PLZ) {
        this.tfPLZ.setText(PLZ);
    }

    public JTextField getTfStraße() {
        return tfStraße;
    }

    public void setTfStraße(String Straße) {
        this.tfStraße.setText(Straße);
    }

    public JTextField getTfTelefon() {
        return tfTelefon;
    }

    public void setTfTelefon(String Telefon) {
        this.tfTelefon.setText(Telefon);
    }

    public JTextField getTfVorname() {
        return tfVorname;
    }

    public void setTfVorname(String Vorname) {
        this.tfVorname.setText(Vorname);
    }

    private void SetWindowTitle() {
        String Caption = IsNew ? EObjektStatus.erstellen.toString() : EObjektStatus.bearbeiten.toString();
        String ButtonCaption = IsNew ? ESaveStatus.erstellen.toString() : ESaveStatus.aktualisieren.toString();
        switch (Zugehörigkeit) {
            case Mitglieder:
                lblÜberschrift.setText("Mitglied " + Caption);
                cboZugehörigkeit.setSelectedIndex(0);
                break;
            case Spieler:
                lblÜberschrift.setText("Spieler " + Caption);
                cboZugehörigkeit.setSelectedIndex(1);
                break;
            case Trainer:
                lblÜberschrift.setText("Trainer " + Caption);
                cboZugehörigkeit.setSelectedIndex(2);
                break;
        }
        btnSpeichern.setText(ButtonCaption);
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
        tfVorname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfStraße = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfPLZ = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfNachname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfGeburtsdatum = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfOrt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfTelefon = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cboZugehörigkeit = new javax.swing.JComboBox<>();
        cboMannschaft = new javax.swing.JComboBox<>();
        btnVerwerfen = new javax.swing.JButton();
        btnSpeichern = new javax.swing.JButton();
        lblWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        lblÜberschrift.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblÜberschrift.setText("Mannschaft (erstellen / bearbeiten / anzeigen)");

        jLabel2.setText("Vorname");

        jLabel3.setText("Straße");

        jLabel4.setText("PLZ");

        jLabel6.setText("Nachname");

        jLabel7.setText("Geburtsdatum");

        jLabel8.setText("Ort");

        jLabel9.setText("Telefon");

        jLabel10.setText("Email");

        jLabel11.setText("Zugehörigkeit");

        jLabel13.setText("Mannschaft");

        cboZugehörigkeit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboMannschaft.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblÜberschrift, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfVorname, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfStraße, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfPLZ, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfNachname, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfGeburtsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(tfOrt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(tfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(cboZugehörigkeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnVerwerfen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSpeichern))
                                    .addComponent(cboMannschaft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblÜberschrift, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfVorname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(tfStraße, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(tfNachname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(tfGeburtsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(tfPLZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8)
                    .addComponent(tfOrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(tfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(cboZugehörigkeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cboMannschaft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSpeichern)
                    .addComponent(btnVerwerfen))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpeichernActionPerformed
        try {
            Date geb = null;
            String vorname = tfVorname.getText();
            String nachname = tfNachname.getText();
            String strasse = tfStraße.getText();
            String plz = tfPLZ.getText();
            String ort = tfOrt.getText();
            String telefon = tfTelefon.getText();
            String email = tfEmail.getText();
            String gebRaw = tfGeburtsdatum.getText();
            // html damit der linebreak im label funktioniert, sehr hässlich
            String warning = "<html>";
            if (!isValidEmail(email)) {
                warning += "Die Email-Adresse ist falsch formatiert.<br>";
            }
            if (!isValidDate(gebRaw)) {
                warning += "Das Geburtsdatum ist falsch formatiert.";
            } else {
                // parts[2]=Jahre || parts[1]=Monate || parts[0]=Tage
                String[] parts = gebRaw.split("\\.");
                // https://docs.oracle.com/javase/8/docs/api/java/util/Date.html
                // A year y is represented by the integer y - 1900.
                // A month is represented by an integer from 0 to 11; 0 is January, 1 is February, and so forth; thus 11 is December.
                // A date (day of month) is represented by an integer from 1 to 31 in the usual manner.
                geb = new Date(Integer.parseInt(parts[2]) - 1900, Integer.parseInt(parts[1]) - 1, Integer.parseInt(parts[0]));
            }
            if (warning.equals("<html>")) {
                ArrayList<Object> ObjekteZumSpeichern = new ArrayList<Object>();
                ESaveObject SaveObject = ESaveObject.normalesMitglied;
                switch (Zugehörigkeit) {
                    case Mitglieder:
                        ArrayList<NormalesMitglied> mitglieder = XMLLoader.loadMitglieder();
                        SaveObject = ESaveObject.normalesMitglied;
                        if (!IsNew) {
                            for (NormalesMitglied cmitglied : mitglieder) {
                                if (vorname.equals(cmitglied.getVorname()) && nachname.equals(cmitglied.getNachname())) {
                                    mitglieder.remove(cmitglied);
                                    break;
                                }
                            }
                        }

                        NormalesMitglied mitglied = new NormalesMitglied(vorname, nachname, strasse, plz, ort, geb, email, telefon);
                        ObjekteZumSpeichern.addAll(mitglieder);
                        ObjekteZumSpeichern.add(mitglied);
                        break;

                    case Spieler:
                        ArrayList<Profispieler> profis = XMLLoader.loadProfiSpieler();
                        SaveObject = ESaveObject.profiSpieler;

                        if (!IsNew) {
                            for (Profispieler cspieler : profis) {
                                if (vorname.equals(cspieler.getVorname()) && nachname.equals(cspieler.getNachname())) {
                                    profis.remove(cspieler);
                                    break;
                                }
                            }
                        }

                        Profispieler spieler = new Profispieler(vorname, nachname, strasse, plz, ort, geb, email, telefon);
                        spieler.setMannschaft(cboMannschaft.getSelectedItem().toString());
                        profis.add(spieler);
                        ObjekteZumSpeichern.addAll(profis);
                        break;

                    case Trainer:
                        ArrayList<Trainer> trainers = XMLLoader.loadTrainer();
                        SaveObject = ESaveObject.trainer;

                        if (!IsNew) {
                            for (Trainer cTrainer : trainers) {
                                if (vorname.equals(cTrainer.getVorname()) && nachname.equals(cTrainer.getNachname())) {
                                    trainers.remove(cTrainer);
                                    break;
                                }
                            }
                        }

                        Trainer trainer = new Trainer(vorname, nachname, strasse, plz, ort, geb, email, telefon);
                        trainers.add(trainer);
                        ObjekteZumSpeichern.addAll(trainers);
                        break;
                }
                XMLSerializer.serializeToXML(ObjekteZumSpeichern, SaveObject);
                lblWarning.setText("<html><b>Das Mitglied wurde gespeichert!</b></html>");
                parent.SpielerDialog.dispose();
            } else {
                warning += "</html>";
                lblWarning.setText(warning);
            }
        } catch (IOException ex) {
            Logger.getLogger(SpielerDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSpeichernActionPerformed

    private void btnVerwerfenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerwerfenActionPerformed
        parent.SpielerDialog.dispose();
    }//GEN-LAST:event_btnVerwerfenActionPerformed

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
            java.util.logging.Logger.getLogger(SpielerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpielerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpielerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpielerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SpielerDialog(Zugehörigkeit, null).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(SpielerDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSpeichern;
    private javax.swing.JButton btnVerwerfen;
    private javax.swing.JComboBox<String> cboMannschaft;
    private javax.swing.JComboBox<String> cboZugehörigkeit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JLabel lblÜberschrift;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfGeburtsdatum;
    private javax.swing.JTextField tfNachname;
    private javax.swing.JTextField tfOrt;
    private javax.swing.JTextField tfPLZ;
    private javax.swing.JTextField tfStraße;
    private javax.swing.JTextField tfTelefon;
    private javax.swing.JTextField tfVorname;
    // End of variables declaration//GEN-END:variables
}
