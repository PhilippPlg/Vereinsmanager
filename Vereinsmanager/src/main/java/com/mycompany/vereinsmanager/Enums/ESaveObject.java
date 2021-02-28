package com.mycompany.vereinsmanager.Enums;

/**
 * Enum für die verschiedenen zu speicherden Typen der Vereinsverwaltung
 * @author Timo
 */
public enum ESaveObject {
    
    /**
     * Mannschaft {@link Mannschaft}, wird in mannschaft.xml gespeichert
     */
    mannschaft,
    
    /**
     * Trainer {@link Trainer}, wird in trainer.xml gespeichert
     */
    trainer,
    
    /**
     * NormalesMitglied {@link NormalesMitglied}, wird in normalesMitglied.xml gespeichert
     */
    normalesMitglied,
    
    /**
     * ProfiSpieler {@link ProfiSpieler}, wird in profiSpieler.xml gespeichert
     */
    profiSpieler,
    
    /**
     * Spiel {@link Spiel}, wird in spiel.xml gespeichert
     */
    spiel,
    
    /**
     * Trainingszeit {@link Trainingszeit}, wird in mannschaft.xml im jeweiligen Mannschaftszweig gespeichert
     */
    trainingsZeit
}
