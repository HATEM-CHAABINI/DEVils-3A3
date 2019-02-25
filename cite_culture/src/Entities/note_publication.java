/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author acer
 */
public class note_publication {
    private int ref_note ;
    private int ref_pub;
    private String nomutilisateur;
    private int note ;

    public int getRef_note() {
        return ref_note;
    }

    public String getNomutilisateur() {
        return nomutilisateur;
    }

    public void setRef_pub(int ref_pub) {
        this.ref_pub = ref_pub;
    }

    public int getRef_pub() {
        return ref_pub;
    }

    public int getNote() {
        return note;
    }

    public note_publication( int ref_pub,String nomutilisateur) {
       
        this.ref_pub=ref_pub;
        this.nomutilisateur = nomutilisateur;
       
    }

    public void setRef_note(int ref_note) {
        this.ref_note = ref_note;
    }

    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public void setNote(int note) {
        this.note = note;
    }
    
    
}
