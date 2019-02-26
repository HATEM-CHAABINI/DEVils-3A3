/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Conference;
import Entities.Theatre;
import Entities.Utilisateur;
import Services.RatingService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import utilitaire.UserSession;

/**
 * FXML Controller class
 *
 * @author mouna dridi
 */
public class VoirConferenceController implements Initializable {

    @FXML
    private ImageView im;
    @FXML
    private Label date;
    @FXML
    private JFXButton reserver;
    @FXML
    private JFXTextField titre;
    @FXML
    private JFXTextField time;
    @FXML
    private JFXTextArea descr;
    @FXML
    private Rating rating;
    @FXML
    private Label msg;
    int idEvent;
    String imageURI=null;
    String ima=null;
    String t=null;
    String info=null;
    String heure=null;
    String dd=null;
    int i=0;
    @FXML
    private JFXTextField d;
    @FXML
    private Label moyenne;
    @FXML
    private JFXButton fb;
    Utilisateur u = new Utilisateur();

        
        
        void setConference(Conference f){
        idEvent=f.getIdEvent();
        RatingService fS=new RatingService();
        float cal=fS.calculer(idEvent);
        rating.ratingProperty().set(cal);
        moyenne.setText(String.valueOf(cal));
        descr.setText(f.getDescription());
        titre.setText(f.getTitre());
        imageURI = new File("C:/wamp64/"+f.getImage()).toURI().toString(); 
        final Image image = new Image(imageURI);
               
        System.out.println(f.getImage());
        //titre.setTitre(f.getTitre());
        im.setImage(image);
        time.setText(f.getTime1());
        d.setText(String.valueOf(f.getDateD()));
        //date.setText(f.getDateD());
//        Date date1=f.getDateD();
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(date1);
//        date.setText(LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH)));
//       
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       UserSession session=new UserSession();
    
            u=session.getUser();
        // TODO
    }    


    @FXML
    private void ajouterRating(MouseEvent event) throws IOException {
        
         int note;
      
if(u.getNom()!=null){
          rating.ratingProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number t, Number t1) {
                
                msg.setText(t1.toString());
                System.out.println("*************");
                System.out.println(t1.toString());
                System.out.println(idEvent);
         if (i==0){
           
                RatingService fS=new RatingService();
                fS.ajouterRate(u.getId(),idEvent,t1.intValue());
                System.out.println("**************");
        i++;
         } }
            
            
        });}   else{
        Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("vous n'etes pas connecté");
        alert.setHeaderText("veuillez vous connecter");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
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
        //alert.showAndWait();
        }

    }

    @FXML
    private void partager(ActionEvent event) throws FileNotFoundException, MalformedURLException, IOException {
        if(u.getNom()!=null){
        ima=imageURI.replace('/', '\\'); 
        String file = new URL(ima).getPath();
        System.out.println("/////////////////////////");
        System.out.println(imageURI);
        System.out.println("/////////////////////////");
        System.out.println("******************");
        System.out.println(ima);
        System.out.println("******************");
        t=titre.getText();
        dd=d.getText();
        heure=time.getText();
        info =t+"\n"+dd+"\n"+heure;
        String access="EAAfl1TLe9i8BACrnrHzhaoXQnPtZAgnyjUvyHbDDHVsLWp8U2ZBbCSMO7SlUdE0GZB91BUrZCQQ4lySTYKYxTkZCHqDZAm6IujPy6cL887CjVkFG8r2lTrlgP0rTZB4Wr4n6mi4seFQlQiZCbbpiG9BSpo5gAc5TjsjWf3ECsZChzKXZBAhZCZCGXsmySZA8AZCZCOY5hxZCDpCEbXxU8wZDZD";
        FacebookClient fbC= new DefaultFacebookClient(access);
//        User me = fbC.fetchObject("me", User.class);
        FileInputStream f= new FileInputStream(new File(ima.replace("file:\\","")));
        FacebookType r= fbC.publish("me/photos",FacebookType.class , BinaryAttachment.with(file,f),Parameter.with("message",info));
        System.out.println("fb.com/"+r.getId());
    }else{
        Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("vous n'etes pas connecté");
        alert.setHeaderText("veuillez vous connecter");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
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
    
    
    
    
    }

    @FXML
    private void ajouterConf(ActionEvent event) throws IOException {
         System.out.println(idEvent);
        //Ticket t=new Ticket();
       // t.setId(idEvent);
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/seat.fxml"));
        loader.load();
        SeatCotroller sc=loader.getController();
        sc.setMovie(idEvent);
        Parent p=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();
    }
    
    
}
