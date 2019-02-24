/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;
import Entities.Winner;
import Services.UtilisateurService;
import Services.WinnerService;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Nitro
 */
public class WinnerController implements Initializable {

    @FXML
    private Button btnwinner;
    @FXML
    private TextField wintxt;
    @FXML
    private TableView<Winner> tbwinners;
    @FXML
    private TableColumn<Winner, Integer> tbusername;
    @FXML
    private TableColumn<Winner, Date> tbdate;
    @FXML
    private Label lbTitulo1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherall();

    }    
public static String convert(java.sql.Date d) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String text = df.format(d);
		return text;
	}
    @FXML
    private void randombutt(ActionEvent event) {
        try {
            WinnerService win = new WinnerService();
            UtilisateurService us = new UtilisateurService();
            
            Utilisateur user = us.rechercheUtilisateurParCin(win.winnerOfTheDay());
            System.out.println(user);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
              Date date = Date.valueOf(LocalDate.now());
            
            Winner pp = new Winner(date, user.getId());
            
            String DD = convert(win.maxwinnerdate());
            int MAXWINN = DD.length();
            String bb = dateFormat.format(date.getTime());
            int AUTRE = bb.length();
            System.out.println("bb" + AUTRE);
            System.out.println("dd" + MAXWINN);
            ////  String carac = bb+"";
            ///  int lasthope = carac.length();
            ////  System.out.println(lasthope);
            System.out.println("ahmedkkkkkkkkkkkkkk" + DD);
            System.out.println("aaaaaaaaaaaaaaaaaaa" + dateFormat.format(date.getTime()));
            if (bb.equals(DD)) {
                System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("sorry");
                alert.setHeaderText("we have already have a winner for today");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    wintxt.clear();
                    
                }
            } else {
                System.out.println("lllllllllllllllllllllllllllllllllllllllllllll");
                win.add(pp);
                wintxt.setText("The winner of the day is: \n" + user.toString());
                
                /*   String accessToken ="EAACEdEose0cBAI8TkdZBbKKLSVLPuVb0ET9KtZAFKwYZA0aSIHGzoBmAqcHhWNjKd3sZATK5kN7mXeyr737QbGYZBw1xfKoacMqTgVAReKmcRxI8gxkCph8aZBFZBwQOu50ZBo1oMMZAsjVSDpTdI5EaZBqShv5o4pCCJIUXoRHXZAMNOD8zYIWixCypf20dZBPCEGwZD" ;
                FacebookClient fbClien = new DefaultFacebookClient(accessToken);
                FacebookType response = fbClien.publish("me/feed",FacebookType.class,Parameter.with("message", "idim ya 5ra"));
                */
            }
            
            
            String title = "Congratulations sir";
            String message = "The winner of the day is: ";
            //Notifications notification = Notifications.SUCCESS;
            
            TrayNotification tray = new TrayNotification();
            tray.setTitle(title);
            tray.setMessage(message);
           // tray.setNotificationType(NotificationType.NOTICE);
            tray.showAndWait();
            
            
            
            /*
            Image whatsAppImg = new Image("https://cdn4.iconfinder.com/data/icons/iconsimple-logotypes/512/whatsapp-128.png");
            
            tray.setTray("Title", "Message", whatsAppImg, Paint.valueOf("#2A9A84"),AnimationType.SLIDE);
            tray.showAndDismiss(Duration.seconds(4));
            */
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WinnerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    void afficherall() {
        try {
            WinnerService aaa = new WinnerService();
            ///   User aea = new User();
            
            tbwinners.setItems(aaa.displayall());
            
            tbusername.setCellValueFactory(new PropertyValueFactory<>("id_userwinner"));
            tbdate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WinnerController.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

    
}
