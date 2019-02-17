/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfxml;

import Entity.Utilisateur;
import Service.UtilisateurService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author hatem
 */
public class FXMLInscriptionController {
 
    @FXML
    private JFXTextField fName;
    @FXML
    private JFXTextField lName;
    @FXML
    private JFXTextField idNo;
    @FXML
    private JFXTextField pNumber;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField pwd1;
    @FXML
    private JFXPasswordField pwd2;
    @FXML
    private JFXButton registerBtn;
    
    @FXML
    private void registerEmployee(ActionEvent event) throws NoSuchAlgorithmException, ClassNotFoundException {
        System.out.println("You  me!");
        Date d=new Date(2018, 4, 7);
       Utilisateur c=new Utilisateur(fName.getText(), email.getText(), pwd1.getText(), fName.getText(), fName.getText(), lName.getText(), fName.getText(),d,fName.getText(), 0,"homme", Integer.valueOf(pNumber.getText()), Integer.valueOf(pNumber.getText()));
         UtilisateurService s=new UtilisateurService();
        //List<Utilisateur>l=new ArrayList<>();
        s.ajouterUtilisateur(c);
        //System.out.println(this.fName.getText());
        
//        String a=this.fName.getText();
//        this.email.setText(a);
//        
    }   
}
