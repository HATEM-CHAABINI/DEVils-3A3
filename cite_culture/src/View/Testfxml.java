/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entities.Utilisateur;
import Services.JournalisteService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilitaire.UserSession;

/**
 *
 * @author hatem
 */
public class Testfxml extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("infoFilm.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
//ss
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        UserSession us=new UserSession();
        JournalisteService js=new JournalisteService();
        Utilisateur uti=new Utilisateur();
        //uti=js.rechercheJournalisteParCin(0);
        us.setUser(uti);
        launch(args);
    }
    
}
