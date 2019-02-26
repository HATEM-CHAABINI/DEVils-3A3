/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Cours;
import Services.CoursService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Farah
 */
public class ReservationCoursController implements Initializable  {

    

       @FXML
    private ScrollPane scroll;
    
    List<HBox> hboxes=new ArrayList<>();
    VBox vb=new VBox();
    @FXML
    private HBox hbox;
    @FXML
    private VBox vbox;
    @FXML
    private ComboBox<String> type;

        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        type.getItems().addAll("yoga","dessin","danse","peinture","tout");
        scroll.setPrefHeight(900);
           try {
               addLabels();
               // TODO
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ReservationCoursController.class.getName()).log(Level.SEVERE, null, ex);
           }
    }    
    public void addLabels() throws ClassNotFoundException{
    CoursService cs =new CoursService();
		vb.setPrefWidth(1920.0);
		String s="abc";
		List<Cours> maList=cs.afficherCours();
                int p=0;
                int i=0;
                List<Pane> panes=new ArrayList<>();
                HBox hbox = new HBox();
		hbox.setPrefWidth(1750.0);
		hbox.setPrefHeight(310.0);
		hbox.setPadding(new Insets(5, 30, 5, 50));
		hbox.setSpacing(15);
            for(Cours f: maList){
                 String k="D:/wamp64/"+maList.get(i).getImage();              
                final String imageURI = new File(k).toURI().toString(); 
               
                
                
                
                final Image image = new Image(imageURI);
               
                    ImageView im=new ImageView(image);
                    im.setLayoutY(0);
                    im.setLayoutX(0);
                    im.setFitHeight(300);
                    im.setFitWidth(300);
                    Button plo=new Button("");
                    plo.setPrefSize(300, 300);
                    plo.setLayoutX(0);
                    plo.setLayoutY(0);
                    plo.setStyle("-fx-background-color: transparent;");

                    final int kvalue=i;
   plo.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent t) {
          try {
              FXMLLoader loader=new FXMLLoader();
              loader.setLocation(getClass().getResource("/View/detailsCours.fxml"));
              Parent root=loader.load();
              DetailsCoursController vfc=loader.getController();
              vfc.setCours(maList.get(kvalue));
              
              Scene scene = new Scene(root);
              Stage stage=new Stage();              
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(ReservationCoursController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(ReservationCoursController.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      });
 
          
    
                Pane l=new Pane();
                
                l.setStyle("-fx-background-color: rgba(145,212,255,0.5);-fx-background-radius: 10 10 10 10;");
		l.setPrefSize(300, 300);
                l.getChildren().addAll(im,plo);
		panes.add(l);
                if(p==3 || i==(maList.size()-1)){
                    hbox.getChildren().addAll(panes);
			
		hboxes.add(hbox);
                    hbox=new HBox();
                    hbox.setPrefWidth(1750.0);
                    hbox.setPrefHeight(310.0);
                    hbox.setPadding(new Insets(5, 30, 5, 50));
                    hbox.setSpacing(15);
                    panes.clear();
                    p=-1;
                }
                   p++;   
                   i++;
            }
            	vb.getChildren().addAll(hboxes);
		scroll.setContent(vb);
                scroll.setPannable(true);

	}
    public void addLabelsWithList(List<Cours> maList){
            
		vb.setPrefWidth(1920.0);
		String s="abc";
                int p=0;
                int i=0;
                List<Pane> panes=new ArrayList<>();
                HBox hbox = new HBox();
		hbox.setPrefWidth(1750.0);
		hbox.setPrefHeight(310.0);
		hbox.setPadding(new Insets(5, 30, 5, 50));
		hbox.setSpacing(15);
            for(Cours f: maList){
                 String k="D:/wamp64/"+maList.get(i).getImage();              
                final String imageURI = new File(k).toURI().toString(); 
                final Image image = new Image(imageURI);
               
                    ImageView im=new ImageView(image);
                    im.setLayoutY(0);
                    im.setLayoutX(0);
                    im.setFitHeight(300);
                    im.setFitWidth(300);
                    Button plo=new Button("");
                    plo.setPrefSize(300, 300);
                    plo.setLayoutX(0);
                    plo.setLayoutY(0);
                    plo.setStyle("-fx-background-color: transparent;");

                    final int kvalue=i;
   plo.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent t) {
          try {
              FXMLLoader loader=new FXMLLoader();
              loader.setLocation(getClass().getResource("detailsCours.fxml"));
              Parent root=loader.load();
              DetailsCoursController vfc=loader.getController();
              vfc.setCours(maList.get(kvalue));
              Scene scene = new Scene(root);
              Stage stage=new Stage();              
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(ReservationCoursController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(ReservationCoursController.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      });
 
          
    
                Pane l=new Pane();
                
                l.setStyle("-fx-background-color: rgba(99,168,48,0.5);-fx-background-radius: 10 10 10 10;");
		l.setPrefSize(300, 300);
                l.getChildren().addAll(im,plo);
		panes.add(l);
                if(p==3 || i==(maList.size()-1)){
                    hbox.getChildren().addAll(panes);
			
		hboxes.add(hbox);
                    hbox=new HBox();
                    hbox.setPrefWidth(1750.0);
                    hbox.setPrefHeight(310.0);
                    hbox.setPadding(new Insets(5, 30, 5, 50));
                    hbox.setSpacing(15);
                    panes.clear();
                    p=-1;
                }
                   p++;   
                   i++;
            }
            	vb.getChildren().addAll(hboxes);
		scroll.setContent(vb);
                scroll.setPannable(true);

	}

        public void affWhere(ActionEvent event) throws ClassNotFoundException{
           
             CoursService cs =new CoursService();
            
            vb.getChildren().clear();
            hboxes.clear();
            if(type.getValue() != null){
            List<Cours> maList=cs.RechercherCourspartype(type.getValue());
            addLabelsWithList(maList);
           if(type.getValue().equals("tout"))
            {
                addLabels();
                
            }
            }
             
             
//            else 
//                        {
//            vb.getChildren().clear();
//            hboxes.clear();
//            addLabels();
//            }

        }
    
}
