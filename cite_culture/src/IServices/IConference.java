/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Conference;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author mouna dridi
 */
public interface IConference {
    public void ajouterConference(Conference t);
    public ObservableList<Conference> afficherConference();
    public void modifierConference(Conference t);
    public void supprimerConference(Conference t);
    public int RetourIdEvent(Conference t);
    public ObservableList<Conference> rechercheConferenceParID(int id);

    /**
     *
     * @return
     */
    public  List<Conference> tousConferences();
    public  List<Conference> tousConferencesParDate(java.sql.Date d);
    public ObservableList<String> affecterSalle();

    
}
