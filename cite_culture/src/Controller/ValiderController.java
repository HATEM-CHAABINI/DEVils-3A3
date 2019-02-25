/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;
import Services.JournalisteService;
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
import utilitaire.UploadFile;

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
    private void valider(ActionEvent event) throws ClassNotFoundException, IOException, Exception {
        
        System.out.println(nbra);
        
        if (nbra==Integer.valueOf(this.idNum.getText()))
    {
         File f=new File(u.getImage());
        UploadFile up=new UploadFile();
   //     String lien =;
          //String LienIm = lien.replace("\\","/");
        u.setImage(up.upload(f.getAbsolutePath()));
        System.out.println("ooooooooooooooooooooooouiii");
      
        if (u.getRoles().equals("Client")){
        UtilisateurService us=new UtilisateurService();
                
        us.ajouterUtilisateur(u);}else{
        
            JournalisteService js=new JournalisteService();
            js.ajouterJournaliste(u);
        }
        
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
