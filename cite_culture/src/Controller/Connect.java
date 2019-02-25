/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;
import Services.UtilisateurService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import utilitaire.ControlesaisieJ;
import utilitaire.QRCodeReader;
import utilitaire.UserSession;
import utilitaire.sendSMS;

/**
 * FXML Controller class
 *
 * @author hatem
 */
public class Connect implements Initializable {
 Utilisateur uti;
    @FXML
    private JFXButton connect;
    @FXML
    private JFXPasswordField pwd1;
    @FXML
    private JFXTextField username;
    @FXML
    private Label LUsername;
    @FXML
    private Label LMdp1;
    @FXML
    private JFXButton connectqr;
    @FXML
    private JFXButton MdpOub;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Connection(ActionEvent event) throws ClassNotFoundException {
        
        
        
                ControlesaisieJ cn=new ControlesaisieJ();
String Usernameu = null,mdp1 = null;

int v=0;
        
  if (!username.getText().equals("") && cn.testUsername(username.getText())){
                 this.LUsername.setText("");
                 Usernameu=username.getText();
                                  v++;

         }else {
             
             this.LUsername.setText("* Username erroné");

         }
if (cn.testpassword(pwd1.getText()))
{
    this.LMdp1.setText("");
    mdp1=pwd1.getText();
                     v++;

}else{
this.LMdp1.setText("* Mot de passe doit contenir 8 caratcter minimum");
}


if (v==2){
    
    
    UtilisateurService us= new UtilisateurService();
    Utilisateur u=new Utilisateur();

u=us.rechercheUtilisateurParUsernameMdp(Usernameu, mdp1);
    System.err.println(u.getUsername());
    //System.out.println(u);

// System.out.println(uti.toString());
//Utilisateur dd= user.getUser();
  //  System.out.println(dd);
if (u.getNom()!= null){
if (u.getEnabled()==1){
   
    
    
    
    
    
    UserSession session=new UserSession();
    session.setUser(u);
    
    
    
    /*UserSession.getInstance(u).getUser();
    System.out.println("77777777777777777777777777777");
        System.out.println(UserSession.getInstance(u).getUser().getNom());
    System.out.println("77777777777777777777777777777");
 */
    FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/MiseAJour.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE,null,ex);
        
        }
        MiseAJour display=loader.getController();
       
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.showAndWait();}else{
Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setHeaderText("Compte bloque ou pas encore activer");
            Optional<ButtonType> result = alert.showAndWait();

}
        
        
}else{
    
Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setHeaderText("acces refusé");
            Optional<ButtonType> result = alert.showAndWait();
    
}
}
 
  

 
        
    }

    @FXML
    private void Connectionqr(ActionEvent event) throws IOException, ClassNotFoundException {
        String CodeQr=QRCodeReader.ReadQRCodeImage();
        
        
  String nq=CodeQr.replace("QR-Code:","");
          UtilisateurService us= new UtilisateurService();
    Utilisateur u=new Utilisateur();
    
u=us.rechercheUtilisateurParQr(nq);
//UserSession.getInstance(u).getUser();
        System.out.println(u.getUsername());
        System.out.println(u.getEnabled());
if (u.getNom()!= null){
if (u.getEnabled()==1){

    UserSession session=new UserSession();
    session.setUser(u);
    
    
    FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/MiseAJour.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE,null,ex);
        
        }
        MiseAJour display=loader.getController();
       
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.showAndWait();}else{
Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setHeaderText("Compte bloque ou pas encore activer");
            Optional<ButtonType> result = alert.showAndWait();

}
        
        
}else{
    
Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setHeaderText("acces refusé");
            Optional<ButtonType> result = alert.showAndWait();
    
}
     /*     UtilisateurService us= new UtilisateurService();
    Utilisateur u=new Utilisateur();

u=us.rechercheUtilisateurParUsernameMdp(Usernameu, mdp1);
    
UserSession.getInstance(u).getUser();*/
    }

    @FXML
    private void MdpOub(ActionEvent event) throws ClassNotFoundException {
                  UtilisateurService us= new UtilisateurService();
    Utilisateur uop=new Utilisateur();
        if (!username.getText().equals("")){
        uop=us.rechercheUtilisateurParUsername(username.getText());
            System.out.println("99999999999999999999");
            System.out.println(uop.getUsername());
            System.out.println("99999999999999999999");
         Random r = new Random();
int valeur = 1000 + r.nextInt(9999 - 1000);
            System.out.println(valeur);
         sendSMS sms=new sendSMS();
         sms.envoitSms(uop.getTelephone(), valeur);
         


FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/ValiderNumMiseAjour.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE,null,ex);
        
        }
        ValiderNumMiseAjour display=loader.getController();
        display.setUN(uop, valeur);
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.showAndWait();
        
        }
    }
    
}
