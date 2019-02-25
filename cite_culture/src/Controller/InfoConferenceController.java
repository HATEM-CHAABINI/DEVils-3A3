/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Conference;
import Entities.Theatre;
import Services.ConferenceService;
import Services.TheatreService;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mouna dridi
 */
public class InfoConferenceController implements Initializable {
    private final ConferenceService fs=new ConferenceService();
    @FXML
    private ScrollPane tt;
    
    private Button b=new Button("hamouda");
//   Style s=new S
//    Class CommandsController = getClass();
    List<HBox> hboxes=new ArrayList<>();
    VBox vb=new VBox();
    @FXML
    private HBox hbox;
    @FXML
    private DatePicker date;
    @FXML
    private VBox gvbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tt.setPrefHeight(900);
        addLabels();
        // TODO
    }

private Pane createPopupContent(final ImageView wiz) {
    final Label unfortunateEvent = new Label();
    unfortunateEvent.setWrapText(true);
    unfortunateEvent.setTextAlignment(TextAlignment.CENTER);
    unfortunateEvent.setMaxWidth(wiz.getImage().getWidth());
    final Button wand = new Button("xyzzy");
    final Pane wizBox = new Pane();
    wizBox.setPrefSize(400, 400);
    wizBox.setStyle("-fx-background-color:white;");
    wizBox.getChildren().addAll(
      wiz,
      wand,
      unfortunateEvent
    );
    wand.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent t) {
        unfortunateEvent.setText(
          "Zap! The wizard has turned you into a\n" 
        );
      }
    });
    
    return wizBox;
  }


public void addLabels(){
            
		vb.setPrefWidth(1920.0);
		String s="abc";
		List<Conference> maList=fs.tousConferences();
                int p=0;
                int i=0;
                List<Pane> panes=new ArrayList<>();
                HBox hbox = new HBox();
		hbox.setPrefWidth(1750.0);
		hbox.setPrefHeight(310.0);
		hbox.setPadding(new Insets(5, 30, 5, 50));
		hbox.setSpacing(15);
            for(Conference f: maList){
                String k="C:/wamp64/"+maList.get(i).getImage();              
                final String imageURI = new File(k).toURI().toString(); 
                System.out.println("//////////////////////////");
                System.out.println(imageURI);
                System.out.println("//////////////////////////");
                final Image image = new Image(imageURI);
                String k1=maList.get(i).getTitre(); 
                Label la=new Label();
                la.setLayoutX(100);
                la.setLayoutY(310);
                la.setText(k1);

               
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
              loader.setLocation(getClass().getResource("/View/voirConference.fxml"));
              Parent root=loader.load();
              VoirConferenceController vfc=loader.getController();
              vfc.setConference(maList.get(kvalue));
              Scene scene = new Scene(root);
              Stage stage=new Stage();              
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(InfoConferenceController.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      });
 
          
    
                Pane l=new Pane();
                
                l.setStyle("-fx-background-color: rgba(99,168,48,0.5);-fx-background-radius: 10 10 10 10;");
		l.setPrefSize(300, 300);
                l.getChildren().addAll(im,plo,la);
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
		tt.setContent(vb);
                tt.setPannable(true);

	}



public void addLabelsWithList(List<Conference> maList){
            
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
            for(Conference f: maList){
                 String k="C:/wamp64/"+maList.get(i).getImage();              
                final String imageURI = new File(k).toURI().toString(); 
                final Image image = new Image(imageURI);
                String k1=maList.get(i).getTitre(); 
                Label la=new Label();
                la.setLayoutX(100);
                la.setLayoutY(310);
                la.setText(k1);
               
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
              loader.setLocation(getClass().getResource("/View/voirFilm.fxml"));
              Parent root=loader.load();
              VoirConferenceController vfc=loader.getController();
              vfc.setConference(maList.get(kvalue));
              Scene scene = new Scene(root);
              Stage stage=new Stage();              
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(InfoConferenceController.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      });
 
          
    
                Pane l=new Pane();
                
                l.setStyle("-fx-background-color: rgba(99,168,48,0.5);-fx-background-radius: 10 10 10 10;");
		l.setPrefSize(300, 300);
                l.getChildren().addAll(im,plo,la);
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
		tt.setContent(vb);
                tt.setPannable(true);

	}



@FXML
        public void affWhere(ActionEvent event){
            vb.getChildren().clear();
            hboxes.clear();
            if(date.getValue() != null){
            List<Conference> maList=fs.tousConferencesParDate(java.sql.Date.valueOf(date.getValue()));
            addLabelsWithList(maList);
            }else 
                        {
            vb.getChildren().clear();
            hboxes.clear();
            addLabels();
            }

        }

    
}
