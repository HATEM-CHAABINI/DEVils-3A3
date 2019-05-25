/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import PIMobile.Entite.Reservation;
import PIMobile.Service.ReservationService;
/**
 *
 * @author Nitro
 */
public class CarteFAffiche {
    Form f;
    SpanLabel lb;
        Resources theme ;
    /**
     *
     */
    public CarteFAffiche() {
       
         f = new Form();
        lb = new SpanLabel("");
        theme = UIManager.initFirstTheme("/theme");
        f.add(lb);
        ReservationService cfs=new ReservationService();
        ArrayList<Reservation> list = cfs.getReservation();
        for (Reservation pr : list) {
            Container c = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            cnt.getAllStyles().setPaddingLeft(2);
           
            cnt.add("Date Creation :"+pr.getPrix()+ "");
             

            c.add(cnt);
            f.add(c);
        }
          
}
 public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }}