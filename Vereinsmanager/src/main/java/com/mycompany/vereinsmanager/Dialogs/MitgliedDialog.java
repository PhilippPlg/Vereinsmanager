package com.mycompany.vereinsmanager.Dialogs;

import com.mycompany.vereinsmanager.Enums.EObjektStatus;
import com.mycompany.vereinsmanager.Enums.ESaveObject;
import com.mycompany.vereinsmanager.Enums.ESaveStatus;
import com.mycompany.vereinsmanager.Enums.EZugehoerigkeit;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Timo
 */
public final class MitgliedDialog extends javax.swing.JDialog {
    /**
     * Rolle des Mitglieds
     */
    private static EZugehoerigkeit zugehoerigkeit;
    /**
     * parent Frame
     */
    private StartupWindow parent;
    /**
     * ob es sich um einen neues Mitglied oder ein bestehendes handelt
     */
    private boolean isNew;
    /**
     * Erzeugt einen Mitglieddialog für einen ein bestehendes Mitglied
     * @param zugehoerigkeit EZugehoerigkeit Rolle des Mitglieds
     * @param parent parent Frame
     * @throws IOException 
     */
    public MitgliedDialog(EZugehoerigkeit zugehoerigkeit, StartupWindow parent) throws IOException {
        this(zugehoerigkeit, false, parent);
    }
    /**
     * Erstellt einen neuen Mitgliederdialog für ein neues oder bestehendes Mitglied
     * @param zugehoerigkeit EZugehoerigkeit Rolle des Mitglieds
     * @param isNew boolean ob es sich um ein neues Mitglied handelt oder nicht
     * @param parent parent Frame
     * @throws IOException 
     */
    public MitgliedDialog(EZugehoerigkeit zugehoerigkeit, boolean isNew, StartupWindow parent) throws IOException {
        this.zugehoerigkeit = zugehoerigkeit;
        initComponents();
        setIsNew(isNew);
        setLblBeitrag();
        AddAssignmentItems();
        SetWindowTitle();
        this.parent = parent;
        setCboMannschaftenItems();
    }
    /**
     * Wählt in der Mannschaftscombobox die Mannschaft mit der übergebenen Bezeichnung aus
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
     * Setzt die Mitgliedsrolle in der Zugehörigkeitscombobox
     */
    private void AddAssignmentItems() {
        EZugehoerigkeit[] Assignments = {EZugehoerigkeit.Mitglieder, EZugehoerigkeit.Spieler, EZugehoerigkeit.Trainer};
        cboZugehoerigkeit.removeAllItems();
        for (EZugehoerigkeit Zugehörigkeit : Assignments) {
            cboZugehoerigkeit.addItem(Zugehörigkeit.toString());
        }
    }
    /**
     * Gibt zurück ob es sich um ein neues oder bestehendes Mitglied handelt
     * @return boolean isNew
     */
    public boolean isIsNew() {
        return isNew;
    }
    /**
     * Setzt den Text zum Beitragsfeld je nach Rolle dynamisch
     */
    public final void setLblBeitrag() {
        switch (zugehoerigkeit) {
            case Mitglieder ->
                lblBeitrag.setText("Beitrag");
            case Spieler, Trainer ->
                lblBeitrag.setText("Gehalt");
        }
    }

    /**
     * Setzt ob es sich um ein neues oder bestehendes Mitglied handelt.
     * Aktiviert/Deaktiviert entsprechend die Eingabefelder
     * @param isNew
     */
    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
        SetWindowTitle();
        this.tfVorname.setEnabled(isNew);
        this.tfVorname.setEditable(isNew);
        this.tfNachname.setEnabled(isNew);
        this.tfNachname.setEditable(isNew);
        this.tfGeburtsdatum.setEnabled(isNew);
        this.tfGeburtsdatum.setEditable(isNew);
        this.btnLoeschen.setEnabled(!isNew);
    }
    /**
     * Setzt den übergebenen Betrag in das Beitragseingabefeld
     * @param beitrag 
     */
    public void setTfBeitrag(String beitrag) {
        this.tfBeitrag.setText(beitrag);
    }
    /**
     * Setzt die übergebene Email-Adresse in das Emaileingabefeld ein
     * @param email 
     */
    public void setTfEmail(String email) {
        this.tfEmail.setText(email);
    }
    /**
     * Setzt den übergebenen Datumsstring in das Geburtsdatumeingabefeld
     * @param geburtsDatum 
     */
    public void setTfGeburtsdatum(String geburtsDatum) {
        this.tfGeburtsdatum.setText(geburtsDatum);
    }
    /**
     * Setzt den übergebenen Nachnamen in das Nachnameneingabefeld
     * @param nachname 
     */
    public void setTfNachname(String nachname) {
        this.tfNachname.setText(nachname);
    }
    /**
     * Setzt den übergebenen Ort in das Ortseingabefeld
     * @param ort 
     */
    public void setTfOrt(String ort) {
        this.tfOrt.setText(ort);
    }
    /**
     * Setzt die übergebene Postleitzahl in das Postleitzahleingabefeld
     * @param plz 
     */
    public void setTfPLZ(String plz) {
        this.tfPLZ.setText(plz);
    }
    /**
     * Setzt die übergebene Straße in das Straßeneingabefeld
     * @param strasse 
     */
    public void setTfStrasse(String strasse) {
        this.tfStrasse.setText(strasse);
    }
    /**
     * Setzt die übergebene Telefonnummer in das Telefonnummerneingabefeld
     * @param telefonNr 
     */
    public void setTfTelefon(String telefonNr) {
        this.tfTelefon.setText(telefonNr);
    }
    /**
     * Setzt den übergebenen Vornamen in das Vornameneingabefeld
     * @param vorname 
     */
    public void setTfVorname(String vorname) {
        this.tfVorname.setText(vorname);
    }
    /**
     * Bestimmt und setzt die Überschrift des Windows und den ausgewählten Wert
     * der Zugehörigkeitscombobox dynamisch anhand der Mitgliedsrolle (Zugehörigkeit)
     */
    private void SetWindowTitle() {
        String Caption = isNew ? EObjektStatus.erstellen.toString() : EObjektStatus.bearbeiten.toString();
        String ButtonCaption = isNew ? ESaveStatus.erstellen.toString() : ESaveStatus.aktualisieren.toString();
        switch (zugehoerigkeit) {
            case Mitglieder:
                lblUeberschrift.setText("Mitglied " + Caption);
                cboZugehoerigkeit.setSelectedIndex(0);
                break;
            case Spieler:
                lblUeberschrift.setText("Spieler " + Caption);
                cboZugehoerigkeit.setSelectedIndex(1);
                break;
            case Trainer:
                lblUeberschrift.setText("Trainer " + Caption);
                cboZugehoerigkeit.setSelectedIndex(2);
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

        lblUeberschrift = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfVorname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfStrasse = new javax.swing.JTextField();
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
        cboZugehoerigkeit = new javax.swing.JComboBox<>();
        cboMannschaft = new javax.swing.JComboBox<>();
        btnVerwerfen = new javax.swing.JButton();
        btnSpeichern = new javax.swing.JButton();
        lblWarning = new javax.swing.JLabel();
        btnLoeschen = new javax.swing.JButton();
        lblBeitrag = new javax.swing.JLabel();
        tfBeitrag = new javax.swing.JTextField();

        lblUeberschrift.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUeberschrift.setText("Mannschaft (erstellen / bearbeiten / anzeigen)");

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

        cboZugehoerigkeit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboZugehoerigkeit.setEnabled(false);

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

        btnLoeschen.setText("Löschen");
        btnLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoeschenActionPerformed(evt);
            }
        });

        lblBeitrag.setText("Beitrag/Gehalt");

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
                            .addComponent(lblUeberschrift, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfVorname, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfStrasse, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(tfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBeitrag))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfBeitrag)
                                    .addComponent(cboZugehoerigkeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(btnLoeschen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnVerwerfen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSpeichern))
                                    .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(cboMannschaft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUeberschrift, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfVorname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(tfStrasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(cboZugehoerigkeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cboMannschaft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfBeitrag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBeitrag)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSpeichern)
                    .addComponent(btnVerwerfen)
                    .addComponent(btnLoeschen))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpeichernActionPerformed
        try {
            Date geb = null;
            double betrag = 0;
            String vorname = tfVorname.getText();
            String nachname = tfNachname.getText();
            String strasse = tfStrasse.getText();
            String plz = tfPLZ.getText();
            String ort = tfOrt.getText();
            String telefon = tfTelefon.getText();
            String email = tfEmail.getText();
            String gebRaw = tfGeburtsdatum.getText();
            String betragRaw = tfBeitrag.getText();
            // html damit der linebreak im label funktioniert, sehr hässlich
            String warning = "<html>";
            if (!isValidEmail(email)) {
                warning += "Die Email-Adresse ist falsch formatiert.<br>";
            }
            if (!isValidDate(gebRaw)) {
                warning += "Das Geburtsdatum ist falsch formatiert.<br>";
            } else {
                // parts[2]=Jahre || parts[1]=Monate || parts[0]=Tage
                String[] parts = gebRaw.split("\\.");
                // https://docs.oracle.com/javase/8/docs/api/java/util/Date.html
                // A year y is represented by the integer y - 1900.
                // A month is represented by an integer from 0 to 11; 0 is January, 1 is February, and so forth; thus 11 is December.
                // A date (day of month) is represented by an integer from 1 to 31 in the usual manner.
                geb = new Date(Integer.parseInt(parts[2]) - 1900, Integer.parseInt(parts[1]) - 1, Integer.parseInt(parts[0]));
            }
            if (!isValidGeldBetrag(betragRaw)) {
                warning += "Der Beitrag ist falsch formatiert.";
            } else {
                betrag = Double.parseDouble(betragRaw.replace(',', '.'));
            }
            if (warning.equals("<html>")) {
                ArrayList<Object> ObjekteZumSpeichern = new ArrayList<Object>();
                ESaveObject SaveObject = ESaveObject.normalesMitglied;
                Boolean existiertBereits = false;
                switch (zugehoerigkeit) {
                    case Mitglieder:
                        ArrayList<NormalesMitglied> mitglieder = XMLLoader.loadMitglieder();
                        SaveObject = ESaveObject.normalesMitglied;

                        for (NormalesMitglied cmitglied : mitglieder) {
                            if (vorname.equals(cmitglied.getVorname()) && nachname.equals(cmitglied.getNachname())) {
                                if (!isNew) {
                                    mitglieder.remove(cmitglied);
                                } else {
                                    lblWarning.setText("<html><b>" + cmitglied.getVorname() + " " + cmitglied.getNachname() + " existiert bereits</b></html>");
                                    existiertBereits = true;
                                }
                                break;
                            }
                        }
                        
                        NormalesMitglied mitglied = new NormalesMitglied(vorname, nachname, strasse, plz, ort, geb, email, telefon, betrag);
                        Object Mannschaft = cboMannschaft.getSelectedItem();
                        if (Mannschaft != null) {
                            mitglied.setMannschaft(Mannschaft.toString());
                        }
                        mitglieder.add(mitglied);
                        ObjekteZumSpeichern.addAll(mitglieder);
                        break;

                    case Spieler:
                        ArrayList<Profispieler> profis = XMLLoader.loadProfiSpieler();
                        SaveObject = ESaveObject.profiSpieler;

                        for (Profispieler cspieler : profis) {
                            if (vorname.equals(cspieler.getVorname()) && nachname.equals(cspieler.getNachname())) {
                                if (!isNew) {
                                    profis.remove(cspieler);
                                } else {
                                    lblWarning.setText("<html><b>" + cspieler.getVorname() + " " + cspieler.getNachname() + " existiert bereits</b></html>");
                                    existiertBereits = true;
                                }
                                break;
                            }
                        }

                        Profispieler spieler = new Profispieler(vorname, nachname, strasse, plz, ort, geb, email, telefon, betrag);
                        Object bMannschaft = cboMannschaft.getSelectedItem();
                        if (bMannschaft != null) {
                            spieler.setMannschaft(bMannschaft.toString());
                        }
                        profis.add(spieler);
                        ObjekteZumSpeichern.addAll(profis);
                        break;

                    case Trainer:
                        ArrayList<Trainer> trainers = XMLLoader.loadTrainer();
                        SaveObject = ESaveObject.trainer;

                        for (Trainer cTrainer : trainers) {
                            if (vorname.equals(cTrainer.getVorname()) && nachname.equals(cTrainer.getNachname())) {
                                if (!isNew) {
                                    trainers.remove(cTrainer);
                                } else {
                                    lblWarning.setText("<html><b>" + cTrainer.getVorname() + " " + cTrainer.getNachname() + " existiert bereits</b></html>");
                                    existiertBereits = true;
                                }

                                break;
                            }
                        }

                        Trainer trainer = new Trainer(vorname, nachname, strasse, plz, ort, geb, email, telefon, betrag);
                        trainers.add(trainer);
                        ObjekteZumSpeichern.addAll(trainers);
                        break;
                }
                if (existiertBereits) {
                    return;
                }
                XMLSerializer.serializeToXML(ObjekteZumSpeichern, SaveObject);
                lblWarning.setText("<html><b>Das Mitglied wurde gespeichert!</b></html>");
                parent.allesAktualisieren();
                parent.SpielerDialog.dispose();
            } else {
                warning += "</html>";
                lblWarning.setText(warning);
            }
        } catch (IOException ex) {
            Logger.getLogger(MitgliedDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSpeichernActionPerformed

    private void btnVerwerfenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerwerfenActionPerformed
        parent.SpielerDialog.dispose();
    }//GEN-LAST:event_btnVerwerfenActionPerformed

    private void btnLoeschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoeschenActionPerformed
        try {
            ArrayList<Object> neueObjekte = new ArrayList();
            String vorname = tfVorname.getText();
            String nachname = tfNachname.getText();
            int result = JOptionPane.showConfirmDialog(null, "Möchten Sie das aktuelle Element wirklich löschen?", "Löschen?", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.NO_OPTION) {
                return;
            }

            switch (zugehoerigkeit) {
                case Mitglieder:
                    ArrayList<NormalesMitglied> OldMitglieder = XMLLoader.loadMitglieder();
                    for (NormalesMitglied cmitglied : OldMitglieder) {
                        if (vorname.equals(cmitglied.getVorname()) && nachname.equals(cmitglied.getNachname())) {
                            OldMitglieder.remove(cmitglied);
                            break;
                        }
                    }
                    neueObjekte.addAll(OldMitglieder);
                    XMLSerializer.serializeToXML(neueObjekte, ESaveObject.normalesMitglied);
                    break;
                case Spieler:
                    ArrayList<Profispieler> OldSpieler = XMLLoader.loadProfiSpieler();
                    for (Profispieler cSpieler : OldSpieler) {
                        if (vorname.equals(cSpieler.getVorname()) && nachname.equals(cSpieler.getNachname())) {
                            OldSpieler.remove(cSpieler);
                            break;
                        }
                    }
                    neueObjekte.addAll(OldSpieler);
                    XMLSerializer.serializeToXML(neueObjekte, ESaveObject.profiSpieler);
                    break;
                case Trainer:
                    ArrayList<Trainer> OldTrainer = XMLLoader.loadTrainer();
                    for (Trainer cTrainer : OldTrainer) {
                        if (vorname.equals(cTrainer.getVorname()) && nachname.equals(cTrainer.getNachname())) {
                            OldTrainer.remove(cTrainer);
                            break;
                        }
                    }
                    neueObjekte.addAll(OldTrainer);
                    XMLSerializer.serializeToXML(neueObjekte, ESaveObject.trainer);
                    break;
            }
            parent.allesAktualisieren();
            parent.SpielerDialog.dispose();
        } catch (IOException ex) {
            Logger.getLogger(MitgliedDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoeschenActionPerformed

    public void changeStatecboMannschaften(Boolean isEnabled) {
        cboMannschaft.setEnabled(isEnabled);
        cboMannschaft.setEditable(isEnabled);
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
            java.util.logging.Logger.getLogger(MitgliedDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MitgliedDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MitgliedDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MitgliedDialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MitgliedDialog(zugehoerigkeit, null).setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(MitgliedDialog.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoeschen;
    private javax.swing.JButton btnSpeichern;
    private javax.swing.JButton btnVerwerfen;
    private javax.swing.JComboBox<String> cboMannschaft;
    private javax.swing.JComboBox<String> cboZugehoerigkeit;
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
    private javax.swing.JLabel lblBeitrag;
    private javax.swing.JLabel lblUeberschrift;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JTextField tfBeitrag;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfGeburtsdatum;
    private javax.swing.JTextField tfNachname;
    private javax.swing.JTextField tfOrt;
    private javax.swing.JTextField tfPLZ;
    private javax.swing.JTextField tfStrasse;
    private javax.swing.JTextField tfTelefon;
    private javax.swing.JTextField tfVorname;
    // End of variables declaration//GEN-END:variables
}
