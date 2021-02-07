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
import java.util.Date;
import com.mycompany.vereinsmanager.main.XMLLoader;
import com.mycompany.vereinsmanager.main.XMLSerializer;
import java.io.IOException;
import java.util.ArrayList;
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
public final class SpielDialog extends javax.swing.JDialog {

    /**
     * parent Frame
     */
    private StartupWindow parent;
    /**
     * ob es sich um ein neues Spiel handelt oder um ein schon bestehendes
     */
    private boolean isNew;

    /**
     * Erstellt neuen Spieldialog
     */
    public SpielDialog() throws IOException {
        setCboMannschaftenItems();
    }
    /**
     * Erstellt neuen Spieldialog zum Erstellen und Bearbeiten von Spielen
     * @param isNew boolean ob es sich um ein neues Spiel oder ein bestehendes handelt
     * @param parent parent Frame
     * @throws IOException 
     */
    public SpielDialog(boolean isNew, StartupWindow parent) throws IOException {
        initComponents();
        setIsNew(isNew);
        this.parent = parent;
        setCboMannschaftenItems();
        SetWindowTitle();
    }
    
    /**
     *
     * @return boolean true bei einem neuen Spiel, sonst false
     */
    public boolean isIsNew() {
        return isNew;
    }

    /**
     * aktiviert/deaktiviert die Eingabefelder zum Spiel die bei neuen oder
     * bestehenden Spielen nicht angezeigt oder bearbeitet werden dürfen
     * @param isNew boolean true für ein neues Spiel, sonst false
     */
    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
        SetWindowTitle();
        this.cboMannschaft.setEnabled(isNew);
        this.cboMannschaft.setEditable(isNew);
        this.tfGegner.setEnabled(isNew);
        this.tfGegner.setEditable(isNew);
        this.btnLoeschen.setEnabled(!isNew);
        this.tfAnfangszeit.setEditable(isNew);
        this.tfDatum.setEditable(isNew);
        if (!isNew) {
            setcboMannschaftItems(cboMannschaft.getSelectedItem().toString());
        }
    }
    /**
     * Setzt Anfangszeit in das Anfangszeitfeld
     * @param anfangszeit
     */
    public void setTfAnfangszeit(String anfangszeit) {
        this.tfAnfangszeit.setText(anfangszeit);
    }
    /**
     * Setzt eine ArrayList von Spielername in das Spielerlistenfeld lbSpieler
     * @param spieler ArrayList
     */
    public void setLbSpieler(ArrayList<String> spieler) {
        DefaultListModel model = new DefaultListModel();
        model.addAll(spieler);
        this.lbSpieler.setModel(model);
    }

    /**
     * Setzt den übergebenen Gegner in das Gegnereingabefeld
     * @param gegner Name des Gegners
     */
    public void setTfGegner(String gegner) {
        this.tfGegner.setText(gegner);
    }

    /**
     * Versteckt Ergebnisfeld und -hinweis
     */
    public void hideErgebnis() {
        lblErgebnis.setVisible(false);
        tfErgebnis.setVisible(false);
        tfErgebnis.setEditable(false);
        lblErgebnisHinweis.setVisible(false);
    }
    /**
     * Gibt die ausgewählte eigene Mannschaft zurück
     * @return Mannschaft die ausgewählte eigene Mannschaft
     * @throws IOException 
     */
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

    /**
     * Setzt einen Text in das Orteingabefeld
     * @param ort Ort der in das Textfeld geschrieben wird
     */
    public void setTfOrt(String ort) {
        this.tfOrt.setText(ort);
    }
    /**
     * Setzt einen Liste von Spielern in das Spielerfeld
     * @param spielerListe JList der Spielernamen
     */
    public void setTfSpieler(JList<String> spielerListe) {
        this.lbSpieler = spielerListe;
    }

    /**
     * Setzt einen Datumsstring in das Datumseingabefeld
     * @param datum String Datum im Format dd.MM.YYYY
     */
    public void setTfDatum(String datum) {
        this.tfDatum.setText(datum);
    }

    /**
     * Setzt dynamische Texte für Überschrift und Button
     */
    private void SetWindowTitle() {
        String Caption = isNew ? EObjektStatus.erstellen.toString() : EObjektStatus.bearbeiten.toString();
        String ButtonCaption = isNew ? ESaveStatus.erstellen.toString() : ESaveStatus.aktualisieren.toString();
        lblÜberschrift.setText("Spiel " + Caption);
        btnSpeichern.setText(ButtonCaption);
    }
    /**
     * ruft setCboMannschaftenItems() auf um alle Mannschaften aus dem XMLFile zu laden
     * und dann wählt die Mannschaft mit dem übergebenen Namen in der combobox aus
     * @param cboMannschaftName Mannschaftsname
     */
    public void setCboMannschaftName(String cboMannschaftName) {
        try {
            setCboMannschaftenItems();
            cboMannschaft.getModel().setSelectedItem(cboMannschaftName);
        } catch (IOException ex) {
            Logger.getLogger(MitgliedDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Lädt alle Mannschaften aus dem XMLFile und setzt diese als model in die 
     * combobox ein
     * @throws IOException 
     */
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
        lblErgebnis = new javax.swing.JLabel();
        tfErgebnis = new javax.swing.JTextField();
        lblErgebnisHinweis = new javax.swing.JLabel();

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

        lblErgebnis.setText("Ergebnis");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(btnLoeschen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerwerfen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSpeichern))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblÜberschrift, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfAnfangszeit, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                            .addComponent(tfDatum, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                            .addComponent(cboMannschaft, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblErgebnis)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblErgebnisHinweis, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(tfGegner)
                                                .addComponent(tfOrt, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                                .addComponent(tfErgebnis))))))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblÜberschrift, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(tfAnfangszeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cboMannschaft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(lblErgebnis)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfGegner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfOrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfErgebnis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblErgebnisHinweis))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSpeichern)
                            .addComponent(btnVerwerfen)
                            .addComponent(btnLoeschen))
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addComponent(lblWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerwerfenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerwerfenActionPerformed
        parent.SpielDialog.dispose();
    }//GEN-LAST:event_btnVerwerfenActionPerformed

    private void btnSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpeichernActionPerformed
        try {
            Date date = null;
            String eigenesTeam = "";
            Boolean existiertBereits = false;
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
                warning += "Die Startzeit ist fasch formatiert.<br>";
            }
            if (!isValidDate(datum) || datum.isEmpty()) {
                warning += "Das Datum ist falsch formatiert";
            } else {
                // parts[2]=Jahre || parts[1]=Monate || parts[0]=Tage
                String[] parts = datum.split("\\.");
                // https://docs.oracle.com/javase/8/docs/api/java/util/Date.html
                // A year y is represented by the integer y - 1900.
                // A month is represented by an integer from 0 to 11; 0 is January, 1 is February, and so forth; thus 11 is December.
                // A date (day of month) is represented by an integer from 1 to 31 in the usual manner.
                date = new Date(Integer.parseInt(parts[2]) - 1900, Integer.parseInt(parts[1]) - 1, Integer.parseInt(parts[0]), Integer.parseInt(anfangszeit.split(":")[0]), Integer.parseInt(anfangszeit.split(":")[1]));
                // Das Datum muss nur in der Zukunft liegen wenn ein neues Spiel erstellt wird
                if (isNew && !date.after(new Date())) {
                    warning += "Das Datum muss in der Zukunft liegen!";
                }
            }

            if (warning.equals("<html>")) {
                ArrayList<Spiel> spiele = XMLLoader.loadSpiel();
                ArrayList<Object> ObjekteZumSpeichern = new ArrayList<>();
                ESaveObject SaveObject = ESaveObject.spiel;

                String actualCaption = eigenesTeam + " gegen " + gegner;
                for (Spiel cSpiel : spiele) {
                    String spielCaption = cSpiel.getEigenesTeam() + " gegen " + cSpiel.getGegnerTeam();
                    if (spielCaption.equals(actualCaption)) {
                        if (!isNew) {
                            spiele.remove(cSpiel);
                        } else {
                            lblWarning.setText(lblWarning.getText() + " <html><b>" + spielCaption + " existiert bereits<br></b></html>");
                            existiertBereits = true;
                        }
                        break;
                    }
                }

                if (existiertBereits) {
                    return;
                }

                Spiel newSpiel = new Spiel(eigenesTeam, gegner, date, ort);
                spiele.add(newSpiel);
                ObjekteZumSpeichern.addAll(spiele);
                XMLSerializer.serializeToXML(ObjekteZumSpeichern, SaveObject);
                lblWarning.setText("<html><b>Das Spiel wurde gespeichert!</b></html>");
                parent.SpielDialog.dispose();
                parent.allesAktualisieren();
            } else {
                warning += "</html>";
                lblWarning.setText(warning);
            }
        } catch (IOException ex) {
            Logger.getLogger(MitgliedDialog.class.getName()).log(Level.SEVERE, null, ex);
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
            parent.allesAktualisieren();
            parent.SpielDialog.dispose();
        } catch (IOException ex) {
            Logger.getLogger(MannschaftDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoeschenActionPerformed

    private void cboMannschaftItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMannschaftItemStateChanged
        setcboMannschaftItems(evt.getItem().toString());
    }//GEN-LAST:event_cboMannschaftItemStateChanged

    /**
     * Lädt die Spieler der übergebenen Mannschaft in die Spielerliste lbSpieler
     * @param mannschaftsName
     */
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
    private javax.swing.JLabel lblErgebnis;
    private javax.swing.JLabel lblErgebnisHinweis;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JLabel lblÜberschrift;
    private javax.swing.JTextField tfAnfangszeit;
    private javax.swing.JTextField tfDatum;
    private javax.swing.JTextField tfErgebnis;
    private javax.swing.JTextField tfGegner;
    private javax.swing.JTextField tfOrt;
    // End of variables declaration//GEN-END:variables
}
