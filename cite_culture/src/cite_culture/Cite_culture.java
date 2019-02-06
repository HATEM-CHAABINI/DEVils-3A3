/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cite_culture;

import Entity.Client;
import Service.ClientService;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
    public static void main(String[] args) throws NoSuchAlgorithmException, ClassNotFoundException 
    {
        //launch(args);
        Date d=new java.sql.Date(2018, 01, 16);
        Client c=new Client("hatem123", "Hatem@gmail.com", "aa", "AA", "Chaabini","Hatem", "Tunis", d,"Rades Foret");
        ClientService s=new ClientService();
        s.ajouterClient(c);
    

    }
}
