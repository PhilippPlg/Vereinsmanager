/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vereinsmanager.Entities;

import java.util.Date;

/**
 *
 * @author masia
 */
public class Verwaltung {

    public Mannschaft[] mannschaften;
    public Spiel[] spiele;
    public Mitglied[] mitglieder;

    public Verwaltung() {
        this.mannschaften = new Mannschaft[10];
        this.spiele = new Spiel[10];
        this.mitglieder = new Mitglied[10];
    }

    public void erstelleMannschaft(String bezeichnung) {
        Mannschaft mannschaft = new Mannschaft(bezeichnung);
        for (int i = 0; i < mannschaften.length; i++) {
            if(mannschaften[i] == null) {
                mannschaften[i] = mannschaft;
            }
        }
    }

    public void loescheMannschaft(String bezeichnung) {
        for (int i = 0; i < mannschaften.length; i++) {
            if(mannschaften[i].getBezeichnung().equalsIgnoreCase(bezeichnung)) {
                mannschaften[i] = null;
            }
        }
    }

    public Mannschaft getMannschaft(String bezeichnung) {
        for (int i = 0; i < mannschaften.length; i++) {
            if(mannschaften[i].getBezeichnung().equalsIgnoreCase(bezeichnung)) {
                return mannschaften[i];
            }
        }
        return null;
    }

    public void bearbeiteTrainingszeiten(String bezeichnung, Trainingszeit[] trainingszeiten) {
        Mannschaft mannschaft = getMannschaft(bezeichnung);
        if(mannschaft != null) {
            mannschaft.setTrainingszeiten(trainingszeiten);
        }
    }

    public void erstelleMitglied(String vorname, String nachname, String straße,
            String plz, String ort, Date geburtsdatum, String email, String telefonNr) {
        Mitglied mitglied = new Mitglied(vorname, nachname, straße, plz, ort, geburtsdatum, email, telefonNr);
        for (int i = 0; i < mitglieder.length; i++) {
            if(mitglieder[i] == null) {
                mitglieder[i] = mitglied;
            }
        }
    }
    
    public void bearbeiteMitglied(String Vorname, String Nachname, String Straße,
            String PLZ, String Ort, Date Geburtsdatum, String Email, String TelefonNr) {
        // No unique identifier to change data
    }
    
    public void loescheMitglied (Mitglied mitglied){
        for (int i = 0; i < mitglieder.length; i++) {
            if(mitglieder[i].equals(mitglied)) {
                mitglieder[i] = null;
            }
        }
    }
    
    public Mitglied getMitglied(String email){
        for (int i = 0; i < mitglieder.length; i++) {
            if(mitglieder[i].getEmail().equalsIgnoreCase(email)) {
                return mitglieder[i];
            }
        }
        return null;
    }
    
    public void erstelleSpiel(Mannschaft eigenesTeam, String gegnerTeam, Date zeitpunkt) {
        Spiel spiel = new Spiel(eigenesTeam, gegnerTeam, zeitpunkt);
        for (int i = 0; i < spiele.length; i++) {
            if(spiele[i] == null) {
                spiele[i] = spiel;
            }
        }
    }
    
    public Spiel getSpiel(Mannschaft Mannschaft, Date Zeitpunkt){
         //NOT IMPLEMENTED || return passendes Spiel von Spielen 
        return null;
    }
    
    public void loescheSpiel (Spiel Spiel){
    }
    
     public void bearbeiteSpiel(Spiel Spiel, Mannschaft eigenesTeam, String GegnerTeam, Date Zeitpunkt) {
        
    }
     
     public void trageErgebnisEin (Spiel Spiel, int eigenePunkte, int Gegnerpunkte) {
         
     }
     
     public NormalesMitglied[] getMitgliederMitAusstehendenBetrag(){
          //NOT IMPLEMENTED || return passende Mitglieder von Mitglieder
         return null;
     }
     
     public void gleicheBeitragAus(Mitglied Mitglied, double Betrag){
         
     }
     
     public void setzeZuZahlendenBeitrag(double Betrag){
         
     }
     
     
    
}
