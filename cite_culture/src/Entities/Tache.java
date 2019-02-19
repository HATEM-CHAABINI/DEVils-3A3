/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Nitro
 */
public class Tache {
    private int id_tache;
    private int id_rec;
    private int id_employe;
    private String desc;

   

    public Tache(int id_employe,int id_rec, String desc) {
        this.id_rec=id_rec;
        this.id_employe = id_employe;
        this.desc = desc;
    }

    public Tache(int id_tache, int id_rec, int id_employe, String desc) {
        this.id_tache = id_tache;
        this.id_rec = id_rec;
        this.id_employe = id_employe;
        this.desc = desc;
    }

    public int getId_tache() {
        return id_tache;
    }

    public int getId_employe() {
        return id_employe;
    }

    public String getDesc() {
        return desc;
    }

    

    public void setId_tache(int id_tache) {
        this.id_tache = id_tache;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    @Override
    public String toString() {
        return "Tache{" + "id_tache=" + id_tache + ", id_rec=" + id_rec + ", id_employe=" + id_employe + ", desc=" + desc + '}';
    }

   

    
    
    
    
    
    
}
