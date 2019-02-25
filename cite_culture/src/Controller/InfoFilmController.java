/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Entities.Film;
import Services.FilmService;
import com.sun.deploy.config.JREInfo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import com.sun.javafx.css.Style;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mouna dridi
 */
public class InfoFilmController  implements Initializable  {

   private final FilmService fs=new FilmService();
    @FXML
    private ScrollPane tt;
    
    private Button b=new Button("hamouda");
   // private Label la=new Label("a");
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
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
//		AnchorPane.setTopAnchor(b, (double) 40);
//		b.setPrefHeight(arg0);
		
		
//		b.setLayoutX(30.0);
//		
//		tt.getChildren().add(b);
//		tt.getChildren().ad
		tt.setPrefHeight(900);
		addLabels();
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
		List<Film> maList=fs.tousFilms();
                int p=0;
                int i=0;
                List<Pane> panes=new ArrayList<>();
                HBox hbox = new HBox();
		hbox.setPrefWidth(1750.0);
		hbox.setPrefHeight(310.0);
		hbox.setPadding(new Insets(5, 30, 5, 50));
		hbox.setSpacing(15);
            for(Film f: maList){
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
                    
//                    Label l1 = new Label(k1);
//                     l1.setLayoutY(0);
//                    l1.setLayoutX(0);
//                    l1.setAlignment(Pos.CENTER);
//                    l1.setFitWidth(300);
                    
                    final int kvalue=i;
   plo.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent t) {
          try {
              FXMLLoader loader=new FXMLLoader();
              loader.setLocation(getClass().getResource("/View/voirFilm.fxml"));
              Parent root=loader.load();
              voirFilmController vfc=loader.getController();
              vfc.setFilm(maList.get(kvalue));
              Scene scene = new Scene(root);
              Stage stage=new Stage();              
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(InfoFilmController.class.getName()).log(Level.SEVERE, null, ex);
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

        public void addLabelsWithList(List<Film> maList){
            
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
            for(Film f: maList){
                String k="C:/wamp64/"+maList.get(i).getImage();              
                final String imageURI = new File(k).toURI().toString();
                final Image image = new Image(imageURI);
                String k1=maList.get(i).getTitre(); 
      
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
                Label la=new Label();
                la.setLayoutX(100);
                la.setLayoutY(310);
                la.setText(k1);

                    final int kvalue=i;
   plo.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent t) {
          try {
              FXMLLoader loader=new FXMLLoader();
              loader.setLocation(getClass().getResource("/View/voirFilm.fxml"));
              Parent root=loader.load();
              voirFilmController vfc=loader.getController();
              vfc.setFilm(maList.get(kvalue));
              Scene scene = new Scene(root);
              Stage stage=new Stage();              
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(InfoFilmController.class.getName()).log(Level.SEVERE, null, ex);
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
            List<Film> maList=fs.tousFilmsParDate(java.sql.Date.valueOf(date.getValue()));
            addLabelsWithList(maList);
            }else 
                        {
            vb.getChildren().clear();
            hboxes.clear();
            addLabels();
            }

        }
        
        
       
    private void recherche(ActionEvent event) {
                vb  = new VBox(); 
                hbox=new HBox();
        vb.getChildren().clear();
        tt.setPrefHeight(900);
	
        tt.setContent(vb);
                tt.setPannable(true);

       	vb.setPrefWidth(1920.0);
		String s="abc";
		List<Film> maList=fs.tousFilmsParDate(java.sql.Date.valueOf(date.getValue()));
                int p=0;
                int i=0;
                List<Pane> panes=new ArrayList<>();
                HBox hbox = new HBox();
		hbox.setPrefWidth(1750.0);
		hbox.setPrefHeight(310.0);
		hbox.setPadding(new Insets(5, 30, 5, 50));
		hbox.setSpacing(15);
            for(Film f: maList){
                String k=maList.get(i).getImage().replace('/', '\\');               
                final String imageURI = new File(maList.get(i).getImage()).toURI().toString(); 
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
              loader.setLocation(getClass().getResource("/View/voirFilm.fxml"));
              Parent root=loader.load();
              voirFilmController vfc=loader.getController();
              vfc.setFilm(maList.get(kvalue));
              Scene scene = new Scene(root);
              Stage stage=new Stage();              
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(InfoFilmController.class.getName()).log(Level.SEVERE, null, ex);
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
		tt.setContent(vb);
                tt.setPannable(true);

        
        /*
       vb= new VBox();
       vb.setPrefWidth(1920.0);
       tt=new ScrollPane();

       tt.setContent(vb);
       tt.setPannable(true);
        vb.setPrefWidth(1920.0);
		String s="abc";
		List<Film> maList=fs.tousFilmsParDate(java.sql.Date.valueOf(date.getValue()));
                int p=0;
                int i=0;
                List<Pane> panes=new ArrayList<>();
                HBox hbox = new HBox();
		hbox.setPrefWidth(1750.0);
		hbox.setPrefHeight(310.0);
		hbox.setPadding(new Insets(5, 30, 5, 50));
		hbox.setSpacing(15);
            for(Film f: maList){
                System.out.println(f);
                String k=maList.get(i).getImage().replace('/', '\\');               
                final String imageURI = new File(maList.get(i).getImage()).toURI().toString(); 
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
              loader.setLocation(getClass().getResource("voirFilm.fxml"));
              Parent root=loader.load();
              voirFilmController vfc=loader.getController();
              vfc.setFilm(maList.get(kvalue));
              Scene scene = new Scene(root);
              Stage stage=new Stage();              
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(InfoFilmController.class.getName()).log(Level.SEVERE, null, ex);
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
		tt.setContent(vb);
                tt.setPannable(true);
     */   
    }
}

    

