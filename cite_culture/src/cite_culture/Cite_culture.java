/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cite_culture;

import Entity.Client;
import Service.ClientService;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilitaire.QRCodeReader;

/**
 *
 * @author hatem
 */
public class Cite_culture extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, ClassNotFoundException, IOException 
    {
        Date d=new java.sql.Date(2018, 01, 16);
//        Client c=new Client("hatem1", "Hatem1@gmail.com", "aa", "AA", "Chaabini","Hatem", "Tunis", d,"Rades Foret");
//        Client c1=new Client("hatem2", "Hatem2@gmail.com", "bb", "AA", "Chaabini","Hatem", "Tunis", d,"Rades Foret");
//        Client c2=new Client("hatem3", "Hatem3@gmail.com", "cc", "AA", "Chaabini","Hatem", "Tunis", d,"Rades Foret");
//        Client c3=new Client("hatem4", "Hatem4@gmail.com", "dd", "AA", "Chaabini","Hatem", "Tunis", d,"Rades Foret");
        ClientService s=new ClientService();
//        s.ajouterClient(c);
//        s.ajouterClient(c1);
//        s.ajouterClient(c2);
//        s.ajouterClient(c3);
//        
       String qr= QRCodeReader.ReadQRCodeImage();
       String qq="QR-Code:hatem3,355b1bbfc96725cdce8f4a2708fda310a80e6d13315aec4e5eed2a75fe8032ce";
        
        String nq=qq.replace("QR-Code:","");
        Client cs= s.rechercheClient(nq);
   System.out.println(cs.getUsername());

    }
}
