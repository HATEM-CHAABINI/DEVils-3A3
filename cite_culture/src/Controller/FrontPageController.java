/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.CarteFidelite;
import Entities.Utilisateur;
import Entities.Winner;
import Services.CarteFideliteService;
import Services.WinnerService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import tray.notification.TrayNotification;
import utilitaire.UserSession;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class FrontPageController implements Initializable {

    @FXML
    private MenuButton menub;
    @FXML
    private MenuItem res;
    private Button mesreservation;
    @FXML
    private AnchorPane idDeconnection;
    @FXML
    private MenuItem idMiseAJourCompte;
    @FXML
    private ImageView idDeconnecter;
    @FXML
    private ImageView idimageuser;
    @FXML
    private Label idLabelCompte;
    @FXML
    private Button bb;
    @FXML
    private MenuItem pe;
Utilisateur u = new Utilisateur();
    @FXML
    private MenuItem CarteF;
    @FXML
    private Button Reclamation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              
    UserSession session=new UserSession();
            u=session.getUser();
            String imageSource = "C:/wamp64/"+u.getImage();
            System.out.println("9999999999999999999999999999");
            System.out.println((imageSource));
                       System.out.println("9999999999999999999999999999999");

            Image image1 = new Image(new File(imageSource).toURI().toString());
            
        idimageuser.setImage(image1);
        
        idLabelCompte.setText(u.getUsername());
        WinnerService win = null;
        try {
            win = new WinnerService();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Winner w =win.findbyusername(u.getId());
           
            if(w == null){  String title = "Sorry sir";
            String message = "You are not the winner" ;
           
            
            TrayNotification tray = new TrayNotification();
            tray.setTitle(title);
            tray.setMessage(message);
           
            tray.showAndWait();
            }
            else if(!(w == null))
            {
                String title = "Congrats sir";
            String message = "You are the winner" ;
           
            
            TrayNotification tray = new TrayNotification();
            tray.setTitle(title);
            tray.setMessage(message);
           
            tray.showAndWait();
            }
       
        }

    @FXML
    private void EventHandler(ActionEvent event) {
    }

    @FXML
    private void reser(ActionEvent event) throws IOException {
        
         FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/ticket.fxml"));
        loader.load();
       // SeatCotroller sc=loader.getController();
       // sc.setMovie(idEvent);
        Parent p=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();
    }

    @FXML
    private void MiseAJourCompte(ActionEvent event) throws IOException {
     
FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/MiseAJour.fxml"));
     //   try{
        loader.load();
       // }catch (IOException ex){
        //Logger.getLogger(Connect.class.getName()).log(Level.SEVERE,null,ex);
        
        //}
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.showAndWait();
    }

    @FXML
    private void Deconnecter(MouseEvent event) throws IOException {
         UserSession session=new UserSession();
    session.resetUser();
//        UserSession.clear();
  //      System.err.println(UserSession.getInstance(new Utilisateur()).getUser().getUsername());
        
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

    private void connecter(ActionEvent event) throws IOException {
        
      }

    @FXML
    private void sentToBienvenu(ActionEvent event) throws IOException {
        Stage primaryStage= new Stage();
      
         Parent root = FXMLLoader.load(getClass().getResource("/View/Bienvenu.fxml"));
        Scene scene = new Scene(root);
       
FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Bienvenu.fxml"));
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

    @FXML
    private void proposer(ActionEvent event) throws IOException {
        
if(u.getNom()!=null){
FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/propositionevent.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE,null,ex);
        
        }
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.showAndWait();
        
}else{
        Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("vous n'etes pas connecté");
        alert.setHeaderText("veuillez vous connecter");
        alert.showAndWait();
        
        //alert.showAndWait();
        }
         }

    @FXML
    private void CFC(ActionEvent event) throws ClassNotFoundException {
         UserSession session=new UserSession();
        Utilisateur u= new Utilisateur();
            u=session.getUser();
            System.out.println(u.getId());
            CarteFideliteService cf= new CarteFideliteService();
             CarteFidelite c= cf.findCartebyID(String.valueOf(u.getUsername()));
            if(c!=null)
            {Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
           
            alert2.setHeaderText("Vous avez deja une carte et vous avez ="+c.getNb_point());
            Optional<ButtonType> result1 = alert2.showAndWait(); 
            }
            else{Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Vous n'avez pas une carte voulez vous le creer");
            Optional<ButtonType> result = alert.showAndWait();        
            if (result.get() == ButtonType.OK){
                Date date = Date.valueOf(LocalDate.now());
            
            CarteFidelite b = new CarteFidelite(1000,date,u);
                cf.add(b);
                  Notifications.create()
                    .title("Notification ")
                    .text("Votre Carte a ete Cree avec succes").darkStyle()
                    .showWarning();
//                  
              
            
            }
            
            } 
    }

    

    @FXML
    private void Reclamation(ActionEvent event) {
         FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/GestionRecC.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(Connect.class.getName()).log(Level.SEVERE,null,ex);
        
        }
        GestionRecCController display=loader.getController();
       
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.showAndWait();
    }
    }
        

   
    

