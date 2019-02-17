/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cite_culture;

import Entity.Utilisateur;
import Service.UtilisateurService;
import com.google.zxing.WriterException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilitaire.QRCodeGenerator;
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
    public static void main(String[] args) throws NoSuchAlgorithmException, ClassNotFoundException, IOException, WriterException 
    {
        Date d=new java.sql.Date(2018, 01, 16);
  Utilisateur c=new Utilisateur("hatem18", "Hatem18@gmail.com", "aa", "AA", "Chaabini","Hatem", "Tunis", d,"Rades Foret",2040, "Homme",50459936,18009484);
//    Utilisateur c1=new Utilisateur("hatem2", "Hatem2@gmail.com", "aa", "AA", "Chaabini","Hatem", "Tunis", d,"Rades Foret",2040, "Homme",50459936,20009484);
//    Utilisateur c2=new Utilisateur("hatem3", "Hatem3@gmail.com", "aa", "AA", "Chaabini","Hatem", "Tunis", d,"Rades Foret",2040, "Homme",50459936,30009484);
//    Utilisateur c3=new Utilisateur("hatem4", "Hatem4@gmail.com", "aa", "AA", "Chaabini","Hatem", "Tunis", d,"Rades Foret",2040, "Homme",50459936,40009484);
////        Utilisateur c1=new Utilisateur("hatem2", "Hatem2@gmail.com", "bb", "AA", "Chaabini","Hatem", "Tunis", d,"Rades Foret");
////        Utilisateur c2=new Utilisateur("hatem3", "Hatem3@gmail.com", "cc", "AA", "Chaabini","Hatem", "Tunis", d,"Rades Foret");
////        Utilisateur c3=new Utilisateur("hatem4", "Hatem4@gmail.com", "dd", "AA", "Chaabini","Hatem", "Tunis", d,"Rades Foret");
       // UtilisateurService s=new UtilisateurService();
        //List<Utilisateur>l=new ArrayList<>();
     //   s.ajouterUtilisateur(c);
       // System.out.println(l);
//        s.ajouterUtilisateur(c);
//        s.ajouterUtilisateur(c1);
//        s.ajouterUtilisateur(c2);
//        s.ajouterUtilisateur(c3);
//        

//QRCodeGenerator.generateQRCodeImage("aaaaaaaaaaaa","ada");

   /*   String qr= QRCodeReader.ReadQRCodeImage();
//     //  String qq="QR-Code:hatem3,355b1bbfc96725cdce8f4a2708fda310a80e6d13315aec4e5eed2a75fe8032ce";
//        
  String nq=qr.replace("QR-Code:","");
   //  Utilisateur cs= s.rechercheUtilisateurParQr(nq);
 //  System.out.println(cs.getUsername());
*/
    }
}
