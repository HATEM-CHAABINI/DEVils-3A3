/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.Service;

import PIMobile.Entite.CarteFidelite;
import PIMobile.Entite.Reservation;

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

/**
 *
 * @author moham
 */
public class ReservationService {
    
     public ArrayList<Reservation> parseListTaskJson(String json) {
            System.out.println(json);
        ArrayList<Reservation> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       System.out.println(tasks);
            
          
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

           System.out.println(list);
            
            for (Map<String, Object> obj : list) {
               
                Reservation e = new Reservation();

                float id = Float.parseFloat(obj.get("prix").toString());
                //float nb = Float.parseFloat(obj.get("nbPoint").toString());
                e.setPrix((int) id);
                //e.setNb_point((int) nb);
                
                System.out.println(e);
                
                listTasks.add(e);

            }

        } catch (IOException ex) {
        }
        
       
        System.out.println(listTasks);
        return listTasks;

    }
     ArrayList<Reservation> listTasks = new ArrayList<>();
     public ArrayList<Reservation> getReservation() {
    
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/frontt/web/app_dev.php/mobile/2/affP");
         con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
          ReservationService ser = new ReservationService();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
}
