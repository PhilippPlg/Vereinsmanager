package com.mycompany.vereinsmanager.Enums;

/**
 * Enum für die verschiedenen zu speicherden Typen der Vereinsverwaltung
 * @author Timo
 */
public enum ESaveObject {
    
    /**
     * {@link com.mycompany.vereinsmanager.Entities.Mannschaft}, wird in mannschaft.xml gespeichert
     */
    mannschaft,
    
    /**
     * {@link com.mycompany.vereinsmanager.Entities.Trainer}, wird in trainer.xml gespeichert
     */
    trainer,
    
    /**
     * {@link com.mycompany.vereinsmanager.Entities.NormalesMitglied}, wird in normalesMitglied.xml gespeichert
     */
    normalesMitglied,
    
    /**
     * {@link com.mycompany.vereinsmanager.Entities.Profispieler}, wird in profiSpieler.xml gespeichert
     */
    profiSpieler,
    
    /**
     * {@link com.mycompany.vereinsmanager.Entities.Spiel}, wird in spiel.xml gespeichert
     */
    spiel,
    
    /**
     * {@link com.mycompany.vereinsmanager.Entities.Trainingszeit}, wird in mannschaft.xml im jeweiligen Mannschaftszweig gespeichert
     */
    trainingsZeit
}
