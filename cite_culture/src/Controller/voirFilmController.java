/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author mouna dridi
 */
import Entities.Film;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class voirFilmController implements Initializable{
   
    @FXML
    private URL location;

    @FXML
    private ImageView im;

    @FXML
    private Label titre;

    @FXML
    private Label desc;

    @FXML
    private Label time;

    @FXML
    private Button trailer;

    @FXML
    private Button reserver;

    void setFilm(Film f){
 
        desc.setText(f.getDescription());
        titre.setText(f.getTitre());
        final String imageURI = new File(f.getImage()).toURI().toString(); 
        final Image image = new Image(imageURI);
               
System.out.println(f.getImage());
        im.setImage(image);
        time.setText(f.getTime1());
        trailer.setOnAction((event) -> {
            try {
                Desktop.getDesktop().browse(new URL(f.getTrailer()).toURI());
            } catch (URISyntaxException ex) {
                Logger.getLogger(voirFilmController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(voirFilmController.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
      
        
    }
}

