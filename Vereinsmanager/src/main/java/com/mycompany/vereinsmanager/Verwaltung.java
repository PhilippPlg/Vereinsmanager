/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vereinsmanager;

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
    }

    public void erstelleMannschaft(String Bezeichnung) {

    }

    public void loescheMannschaft(String Bezeichnung) {

    }

    public Mannschaft getMannschaft(String Bezeichnung) {
        //NOT IMPLEMENTED || return passende Mannschaft von mannschaften 
        return null;
    }

    public void bearbeiteTrainingszeiten(String Bezeichnung, Trainingszeit[] Trainingszeiten) {

    }

    public void erstelleMitglied(String Vorname, String Nachname, String Straße,
            String PLZ, String Ort, Date Geburtsdatum, String Email, String TelefonNr) {

    }
    
    public void setzeMitgliedInMannschaft(Mitglied Mitglied, Mannschaft Mannschaft){
        
    }
    
    public void bearbeiteMitglied(String Vorname, String Nachname, String Straße,
            String PLZ, String Ort, Date Geburtsdatum, String Email, String TelefonNr) {
        
    }
    
    public void loescheMitglied (Mitglied Mitglied){
        
    }
    
    public Mitglied getMitglied(String Email){
         //NOT IMPLEMENTED || return passendes Mitglied von Mitglieder 
        return null;
    }
    
    public void erstelleSpiel(Mannschaft eigenesTeam, String GegnerTeam, Date Zeitpunkt) {
        
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
