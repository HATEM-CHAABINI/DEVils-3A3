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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import PIMobile.Entite.CarteFidelite;

/**
 *
 * @author Nitro
 */
public class CarteFService {
    
     public ArrayList<CarteFidelite> parseListTaskJson(String json) {
            System.out.println(json);
        ArrayList<CarteFidelite> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       System.out.println(tasks);
            
          
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

           System.out.println(list);
            
            for (Map<String, Object> obj : list) {
               
                CarteFidelite e = new CarteFidelite();

                float id = Float.parseFloat(obj.get("idCarteFidelite").toString());
                float nb = Float.parseFloat(obj.get("nbPoint").toString());
                e.setId_carte_fidelite((int) id);
                e.setNb_point((int) nb);
                
                System.out.println(e);
                
                listTasks.add(e);

            }

        } catch (IOException ex) {
        }
        
       
        System.out.println(listTasks);
        return listTasks;

    }
     ArrayList<CarteFidelite> listTasks = new ArrayList<>();
     public ArrayList<CarteFidelite> getCarte() {
    
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/frontt/web/app_dev.php/mobile/affCF");
         con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
          CarteFService ser = new CarteFService();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
}
