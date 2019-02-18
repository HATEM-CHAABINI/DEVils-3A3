/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author mouna dridi
 */
public class PropositionEvent {
    private int idPEvent;
    private String typeEvent;
    private String description;
    private String titre;
    private String etat;
    private String username;

    public PropositionEvent(String typeEvent, String description, String titre,String username) {
        this.typeEvent = typeEvent;
        this.description = description;
        this.titre = titre;
        this.etat="non validé";
        this.username=username;
    }

    public PropositionEvent() {
    }
    

    public int getIdPEvent() {
        return idPEvent;
    }

    public String getTypeEvent() {
        return typeEvent;
    }

    public String getDescription() {
        return description;
    }

    public String getTitre() {
        return titre;
    }

    public void setIdPEvent(int idPEvent) {
        this.idPEvent = idPEvent;
    }

    public void setTypeEvent(String typeEvent) {
        this.typeEvent = typeEvent;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


}
