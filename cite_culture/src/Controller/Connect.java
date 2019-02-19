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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import utilitaire.ControlesaisieJ;
import utilitaire.QRCodeReader;
import utilitaire.UserSession;

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
    private Button btnFB;
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
    //System.out.println(u);
UserSession.getInstance(u).getUser();
// System.out.println(uti.toString());
//Utilisateur dd= user.getUser();
  //  System.out.println(dd);
if (UserSession.getInstance(u).getUser().getNom()!= null){

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
                stage.showAndWait();
        
        
}else{
    System.out.println("acces refusé");
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
UserSession.getInstance(u).getUser();

if (UserSession.getInstance(u).getUser().getNom()!= null){

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
                stage.showAndWait();
        
        
}else{
    System.out.println("acces refusé");
}
     /*     UtilisateurService us= new UtilisateurService();
    Utilisateur u=new Utilisateur();

u=us.rechercheUtilisateurParUsernameMdp(Usernameu, mdp1);
    
UserSession.getInstance(u).getUser();*/
    }
    
}
