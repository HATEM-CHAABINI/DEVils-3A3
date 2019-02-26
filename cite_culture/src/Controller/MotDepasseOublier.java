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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import utilitaire.ControlesaisieJ;

/**
 * FXML Controller class
 *
 * @author hatem
 */
public class MotDepasseOublier implements Initializable {
Utilisateur u;

    @FXML
    private JFXPasswordField pwd1;
    @FXML
    private Label LMdp1;
    @FXML
    private JFXButton idUpdateMdp;
    @FXML
    private JFXPasswordField pwd2;
    @FXML
    private Label LMdp2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void UpdateMdp(ActionEvent event) throws ClassNotFoundException, IOException {
        int v=0;
        UtilisateurService us=new UtilisateurService();
                ControlesaisieJ cn=new ControlesaisieJ();
if (cn.testpassword(pwd1.getText()))
{
    this.LMdp1.setText("");
    
                     v++;

}else{
this.LMdp1.setText("* Mot de passe doit contenir 8 caratcter minimum");
}

if(pwd1.getText().equals(pwd2.getText())){
    this.LMdp2.setText("");
                 v++;

}    else{
           this.LMdp1.setText("* Reverifier votre mot de passe");
 
            }
        if (v==2){
            us.updateMdpUtilisateur(u.getUsername(),pwd1.getText() ,u.getEmail());
          
  Stage primaryStage= new Stage();
      
         Parent root = FXMLLoader.load(getClass().getResource("/View/connection.fxml"));
        Scene scene = new Scene(root);
       
FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/connection.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE,null,ex);
        
        }
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
              
        
               

         final Node source =(Node) event.getSource();
        final Stage stage2= (Stage)source.getScene().getWindow();
        

        stage2.close();
        
                 stage.show();
        }
        
    }
    
    public void setUt2(Utilisateur n) throws ClassNotFoundException
    {
        

               this.u=n;

    }    
}
