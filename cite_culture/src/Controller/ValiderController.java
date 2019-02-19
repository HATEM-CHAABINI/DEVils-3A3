/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;
import Services.UtilisateurService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import utilitaire.Upload;

/**
 * FXML Controller class
 *
 * @author hatem
 */
public class ValiderController implements Initializable {
int nbra=0;
Utilisateur u;
    @FXML
    private JFXTextField idNum;
    @FXML
    private JFXButton valid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void valider(ActionEvent event) throws ClassNotFoundException, IOException {
        
        System.out.println(nbra);
        
        if (nbra==Integer.valueOf(this.idNum.getText()))
    {
         File f=new File(u.getImage());
        Upload up=new Upload();
   //     String lien =;
          //String LienIm = lien.replace("\\","/");
        u.setImage(up.upload(f,u.getUsername()));
        System.out.println("ooooooooooooooooooooooouiii");
        UtilisateurService us=new UtilisateurService();
                
        us.ajouterUtilisateur(u);
        
    }
    else{
        System.out.println("Code erroné");
    }

        
    }
    
    public void setUN(Utilisateur n,int nbra) throws ClassNotFoundException
    {
        

        this.nbra=nbra;
               this.u=n;

    }    
}
