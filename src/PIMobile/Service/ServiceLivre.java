/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import PIMobile.Entite.Livre;
import PIMobile.Entite.Location;
import PIMobile.Entite.Stat;
import PIMobile.Entite.Utilisateur;
import PIMobile.Entite.commentaire_livre;
import com.codename1.l10n.SimpleDateFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hatem
 */
public class ServiceLivre {
    
    public ArrayList<commentaire_livre> parseListCommentaireJson(String json) {

        ArrayList<commentaire_livre> listComm = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
            
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            for (Map<String, Object> obj : list) {
                commentaire_livre com = new commentaire_livre();
                float id = Float.parseFloat(obj.get("id").toString());
             com.setCommentaire(obj.get("commentaire").toString());             
              Map user = ((Map)obj.get("Locataire")); 
                        Utilisateur u=new Utilisateur();
        Iterator<Map.Entry> itr1 = user.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            Map.Entry pair = itr1.next(); 
                if (pair.getKey().equals("id")){
                    Double d=(Double) pair.getValue();
                   u.setId(d.intValue());
                
                }
                if(pair.getKey().equals("username")){
                    u.setUsername(pair.getValue().toString());
                }
                if(pair.getKey().equals("email")){
                u.setEmail(pair.getValue().toString());}
                if(pair.getKey().equals("nom")){
                u.setNom(pair.getValue().toString());}
                if(pair.getKey().equals("prenom")){
                   u.setPrenom(pair.getValue().toString());
                }
                if(pair.getKey().equals("image")){
                   u.setImage(pair.getValue().toString());
                }
        }              
              Map Livre = ((Map)obj.get("Livre")); 
                        Livre l=new Livre();
        Iterator<Map.Entry> itrliv = Livre.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            Map.Entry pair = itr1.next(); 
                if (pair.getKey().equals("id")){
                    Double d=(Double) pair.getValue();
                   l.setId(d.intValue());
                }
                if(pair.getKey().equals("titre")){
                    l.setTitre(pair.getValue().toString());
                }
                if(pair.getKey().equals("auteur")){
                l.setAuteur(pair.getValue().toString());}
                if(pair.getKey().equals("genre")){
                l.setGenre(pair.getValue().toString());}
                if(pair.getKey().equals("description")){
                   l.setDescription(pair.getValue().toString());
                }
        } 
            com.setLocataire(u);            
            com.setLivre(l);
              com.setId((int) id); 
                listCommentaire.add(com);
            }
        } catch (IOException ex) {
        }
        System.out.println(listCommentaire);
        return listCommentaire;
    }
    
    ArrayList<commentaire_livre> listCommentaire = new ArrayList<>();
     public ArrayList<commentaire_livre> getListCom(int idl){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/front/web/app_dev.php/bibliotheque/Commentaire/all?idl="+idl);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceLivre ser = new ServiceLivre();
                listCommentaire = ser.parseListCommentaireJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCommentaire;
    }
     
     
     
     //////////////////////////////////////////////////////////////////////
     
     
    public ArrayList<Livre> parseListLivreJson(String json) {

        ArrayList<Livre> listLivre = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
           List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            for (Map<String, Object> obj : list) {
                Livre e = new Livre();
                float id = Float.parseFloat(obj.get("id").toString());
                float prix = Float.parseFloat(obj.get("prix").toString());
                float quantite = Float.parseFloat(obj.get("quantite").toString());
                e.setId((int) id);
                e.setAuteur(obj.get("auteur").toString());
                e.setDescription(obj.get("description").toString());
                e.setGenre(obj.get("genre").toString());
                e.setImage(obj.get("image").toString());
                e.setPrix(prix);
                e.setQuantite((int)quantite);
                e.setTitre(obj.get("titre").toString());
                System.out.println(e); 
                listLivre.add(e);
            }
        } catch (IOException ex) {
        }
        System.out.println(listLivre);
        return listLivre;
    }
 
    
       
    
    ArrayList<Livre> listLivre = new ArrayList<>();
    
    public ArrayList<Livre> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/front/web/app_dev.php/bibliotheque/Livre/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceLivre ser = new ServiceLivre();
                listLivre = ser.parseListLivreJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listLivre;
    }
    
     ArrayList<Livre> listLivrer = new ArrayList<>();
    
    public ArrayList<Livre> getList21(String idlivre){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/front/web/app_dev.php/bibliotheque/Livre?key="+idlivre);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceLivre ser = new ServiceLivre();
                listLivrer = ser.parseListLivreJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listLivrer;
    }
    
    
    public ArrayList<Location> parseListLocationJson(String json) {

        ArrayList<Location> listLocation = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
           List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            for (Map<String, Object> obj : list) {
                Location e = new Location();
                float id = Float.parseFloat(obj.get("id").toString());
                e.setId((int) id);
  
          ///////////date location      
                Double batch_date=0D;
                Map date = ((Map)obj.get("dateLocation")); 
                  Iterator<Map.Entry> itr1 = date.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            Map.Entry pair = itr1.next(); 
                if (pair.getKey().equals("timestamp")){
             batch_date= (Double) pair.getValue();}}
        Date dt = new Date ((long) (batch_date * 1000)); 
    SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy");

        e.setDate_location(dt);
    ////////////////date retour             
        date = ((Map)obj.get("dateRetour")); 
        itr1 = date.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            Map.Entry pair = itr1.next(); 
                if (pair.getKey().equals("timestamp")){
             batch_date= (Double) pair.getValue();}}
        dt = new Date ((long) (batch_date * 1000)); 
    sfd = new SimpleDateFormat("dd-MM-yyyy");
        e.setDate_retour(dt);
    ///////////// Locataire
      Map user = ((Map)obj.get("Locataire")); 
          
                        Utilisateur u=new Utilisateur();

         itr1 = user.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            Map.Entry pair = itr1.next(); 
                if (pair.getKey().equals("id")){
                    Double d=(Double) pair.getValue();
                   u.setId(d.intValue());
                
                }
                if(pair.getKey().equals("username")){
                    u.setUsername(pair.getValue().toString());
                 //   System.out.println(u.getUsername());
                }
                if(pair.getKey().equals("email")){
                u.setEmail(pair.getValue().toString());}
                if(pair.getKey().equals("nom")){
                u.setNom(pair.getValue().toString());}
                if(pair.getKey().equals("prenom")){
                   u.setPrenom(pair.getValue().toString());
                }
                if(pair.getKey().equals("image")){
                   u.setImage(pair.getValue().toString());
                }

        }
        e.setLocataire(u);
    //////////////////Livre
              Map Livre = ((Map)obj.get("Livre")); 
          
                        Livre l=new Livre();

        Iterator<Map.Entry> itrliv = Livre.entrySet().iterator(); 
        while (itrliv.hasNext()) { 
            Map.Entry pair = itrliv.next(); 
                if (pair.getKey().equals("id")){
                    Double d=(Double) pair.getValue();
                   l.setId(d.intValue());
                
                }
                if(pair.getKey().equals("titre")){
                    l.setTitre(pair.getValue().toString());
                 //   System.out.println(u.getUsername());
                }
                if(pair.getKey().equals("auteur")){
                l.setAuteur(pair.getValue().toString());}
                if(pair.getKey().equals("genre")){
                l.setGenre(pair.getValue().toString());}
                if(pair.getKey().equals("description")){
                   l.setDescription(pair.getValue().toString());
                }
                if(pair.getKey().equals("image")){
                   l.setImage(pair.getValue().toString());
                }
                  if(pair.getKey().equals("prix")){
                l.setPrix( Float.parseFloat(pair.getValue().toString()));
                }
               }
        e.setLivre(l);
    listLocation.add(e);
            }
        } catch (IOException ex) {
        }
        System.out.println(listLocation);
        return listLocation;
    }
 
    
    ArrayList<Location> listLocation = new ArrayList<>();
    public ArrayList<Location> getListLocation(String username){
      ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/front/web/app_dev.php/bibliotheque/MesLocation/show?username="+username);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceLivre ser = new ServiceLivre();
                listLocation = ser.parseListLocationJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listLocation;
    }
    
    
    
    public void ajouterLocation(Livre l,int iduser,String dated,String datef){
            ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/front/web/app_dev.php/bibliotheque/Location/new?iduser="+ iduser +"&idl="+ l.getId()+"&dated="+dated+"&datef="+datef ;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
public void effacerCommentaire(int id){
            ConnectionRequest con = new ConnectionRequest();
            String Url = "http://localhost/front/web/app_dev.php/bibliotheque/Commentaire/delete?idc="+id ;
             con.setUrl(Url);
            con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
public void AjoutCommentaire(int idl,int iduser,String comm){
            ConnectionRequest con = new ConnectionRequest();
            String Url = "http://localhost/front/web/app_dev.php/bibliotheque/Commentaire/new?idl="+idl+"&iduser="+iduser+"&com="+comm ;
             con.setUrl(Url);
            con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
public void AnnulerLocation(int idl){
       ConnectionRequest con = new ConnectionRequest();
            String Url = "http://localhost/front/web/app_dev.php/bibliotheque/Location/Annuler?idl="+idl ;
             con.setUrl(Url);
            con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
}

 public ArrayList<Stat> parseListStatJson(String json) {

        ArrayList<Stat> listStat = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
           List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            for (Map<String, Object> obj : list) {
                Stat s = new Stat();
               
                float nb = Float.parseFloat(obj.get("nbLocation").toString());
                s.setNbLocation((int)nb);
                s.setTitre(obj.get("titre").toString());
              
                System.out.println(s); 
                listStat.add(s);
            }
        } catch (IOException ex) {
        }
        System.out.println(listStat);
        return listStat;
    }
 
 
    ArrayList<Stat> listStat = new ArrayList<>();
    public ArrayList<Stat> getListStat(){
      ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/front/web/app_dev.php/bibliotheque/Stat");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceLivre ser = new ServiceLivre();
                listStat = ser.parseListStatJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listStat;
    }

}
