/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Film;
import Services.FilmService;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author mouna dridi
 */
public class FilmController implements Initializable {

    @FXML
    private Button ajouterB;
    @FXML
    private TextField titre;
    @FXML
    private TextField description;
    @FXML
    private DatePicker datedebut;
    @FXML
    private DatePicker datefin;
    @FXML
    private TextField salle;
    @FXML
    private TextField prixenfant;
    @FXML
    private TextField prixadulte;
    @FXML
    private TextField prixetudiant;
    @FXML
    private TextField time;
    @FXML
    private Button supprimerB;
    @FXML
    private Button modifierB;
    @FXML
    private TableView<Film> tab;
    @FXML
    private TableColumn<?, ?> idf;
    @FXML
    private TableColumn<?, ?> idd;
    @FXML
    private TableColumn<?, ?> idtr;
    @FXML
    private TableColumn<?, ?> idD;
    @FXML
    private TableColumn<?, ?> idF;
    @FXML
    private TableColumn<?, ?> ids;
    @FXML
    private TableColumn<?, ?> idp;
    @FXML
    private TableColumn<?, ?> idpa;
    @FXML
    private TableColumn<?, ?> idpe;
    @FXML
    private TableColumn<?, ?> idti;
    @FXML
    private TableColumn<?, ?> idnb;
    @FXML
    private TableColumn<?, ?> idt;
    @FXML
    private TextField image;
    @FXML
    private TextField trailer;
    @FXML
    private TextField nbrPlace;
    @FXML
    private Button ajouterI_B;
    @FXML
    private Button ajouterT_B;
    @FXML
    private TextField idFilm;
    @FXML
    private TextField Rid;
    @FXML
    private TableColumn<?, ?> idty;
    @FXML
    private TableColumn<?, ?> idi;
    public static String sallouma=null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            FilmService artc = new FilmService();
            tab.setItems(artc.afficherFilm());
            
            
            idf.setCellValueFactory(new PropertyValueFactory<>("idFilm"));
            idt.setCellValueFactory(new PropertyValueFactory<>("titre"));
            idd.setCellValueFactory(new PropertyValueFactory<>("description"));
            idi.setCellValueFactory(new PropertyValueFactory<>("image"));
            idtr.setCellValueFactory(new PropertyValueFactory<>("trailer"));
            idD.setCellValueFactory(new PropertyValueFactory<>("dateD"));
            idF.setCellValueFactory(new PropertyValueFactory<>("dateF"));
            ids.setCellValueFactory(new PropertyValueFactory<>("salle"));
            idp.setCellValueFactory(new PropertyValueFactory<>("prixEnfant"));
            idpa.setCellValueFactory(new PropertyValueFactory<>("prixAdulte"));
            idpe.setCellValueFactory(new PropertyValueFactory<>("prixEtudiant"));
            idti.setCellValueFactory(new PropertyValueFactory<>("time1"));
            idnb.setCellValueFactory(new PropertyValueFactory<>("nbrPlace"));
            idty.setCellValueFactory(new PropertyValueFactory<>("typeEvent"));
        } catch (Exception ex) {
            Logger.getLogger(FilmController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       setCellValueFromTableToTextField();
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) throws ClassNotFoundException {
        String titre1=this.titre.getText();
        String description1=this.description.getText();
        String image1=sallouma;
        String trailer1=this.trailer.getText();
        java.sql.Date dated = java.sql.Date.valueOf(datedebut.getValue());
        java.sql.Date datef = java.sql.Date.valueOf(datefin.getValue());
        String salle1=this.salle.getText();
        float prixEnfant=Integer.valueOf(this.prixenfant.getText());
        float prixAdulte=Integer.valueOf(this.prixadulte.getText());
        float prixEtudiant=Integer.valueOf(this.prixetudiant.getText());
        String time1=this.time.getText();
        int nbrplace=Integer.valueOf(this.nbrPlace.getText());
        
        
        String rp = image1.replace('\\','/');  
      //  Film e=new Film(titre1,description1,rp,trailer1,dated,datef,salle1,prixEnfant,prixAdulte ,prixEtudiant, time1,nbrplace);
        Film e=new Film(trailer1,titre1,description1,dated,datef,salle1,prixEnfant,prixAdulte ,prixEtudiant, time1,rp,nbrplace);
        FilmService fS=new FilmService();
        fS.ajouterFilm(e);
        FilmService artc = new FilmService();
        tab.setItems(artc.afficherFilm());
        
    }

    @FXML
    private void supprimer(ActionEvent event) throws ClassNotFoundException {
        
        Film f =new Film();
        f.setIdFilm(Integer.valueOf(idFilm.getText()));
        FilmService fs=new FilmService();
        fs.supprimerFilm(f);
         idFilm.clear();
            titre.clear();
            description.clear();
            image.clear();
            trailer.clear();
            datedebut.getEditor().clear();
            datefin.getEditor().clear();
            salle.clear();
            prixenfant.clear();
            prixadulte.clear();
            prixetudiant.clear();
            time.clear();
            nbrPlace.clear();
                    
            tab.setItems(fs.afficherFilm());
            
            idf.setCellValueFactory(new PropertyValueFactory<>("idFilm"));
            idt.setCellValueFactory(new PropertyValueFactory<>("titre"));
            idd.setCellValueFactory(new PropertyValueFactory<>("description"));
            idi.setCellValueFactory(new PropertyValueFactory<>("image"));
            idtr.setCellValueFactory(new PropertyValueFactory<>("trailer"));
            idD.setCellValueFactory(new PropertyValueFactory<>("dateD"));
            idF.setCellValueFactory(new PropertyValueFactory<>("dateF"));
            ids.setCellValueFactory(new PropertyValueFactory<>("salle"));
            idp.setCellValueFactory(new PropertyValueFactory<>("prixEnfant"));
            idpa.setCellValueFactory(new PropertyValueFactory<>("prixAdulte"));
            idpe.setCellValueFactory(new PropertyValueFactory<>("prixEtudiant"));
            idti.setCellValueFactory(new PropertyValueFactory<>("time1"));
            idnb.setCellValueFactory(new PropertyValueFactory<>("nbrPlace"));
       
    }

    @FXML
    private void modifier(ActionEvent event) throws ClassNotFoundException {
        
        java.sql.Date d=java.sql.Date.valueOf(datedebut.getValue());
        java.sql.Date d1=java.sql.Date.valueOf(datefin.getValue());
        float p=Float.valueOf(prixenfant.getText());
        float p1=Float.valueOf(prixadulte.getText());
        float p2=Float.valueOf(prixetudiant.getText());
        int nbr=Integer.valueOf(nbrPlace.getText());
        
        
        FilmService fs = new FilmService();
        Film f  = new Film(trailer.getText(),titre.getText(),description.getText(),d,d1,salle.getText(),p,p1,p2,time.getText(),image.getText(),nbr);
        int id =Integer.valueOf(idFilm.getText());
        f.setIdFilm(id);
       
        fs.modifierFilm(f);
        FilmService artc = new FilmService();
        tab.setItems(artc.afficherFilm());
        
    }

    @FXML
    private void ajouterFichier(ActionEvent event) throws IOException {
        final FileChooser filechooser = new FileChooser();
        File selectedfile=filechooser.showOpenDialog(null);
        if(selectedfile != null)
        {
            image.setText(selectedfile.getAbsolutePath());
            Path source=Paths.get(selectedfile.getAbsolutePath());
            Path destination= Paths.get("C:\\wamp64\\www\\filmImage\\"+selectedfile.getName());
                        
           sallouma=destination.toString();
            System.out.println(sallouma);
//            System.out.println(s.indexOf("\\"));                    
//            String rp = s.replace("\\","/");
//                   
            //String rp = s.replace("\\","/");    
                //String dp=rp.replace("/", "\\");
                   // System.out.println(dp);
                    
                    
            //copie
            Files.copy(source, destination,StandardCopyOption.REPLACE_EXISTING);
            
        }
    }

    @FXML
    private void ajouterVideo(ActionEvent event) throws MalformedURLException, URISyntaxException, IOException {
                Desktop.getDesktop().browse(new URL("https://www.youtube.com/").toURI());
                
    }

    @FXML
    private void search(KeyEvent event) {
        FilmService sa = new FilmService() ;
        if (!(this.Rid.getText().equals(""))){
        int id_film=Integer.valueOf(this.Rid.getText());
        tab.setItems(sa.rechercheFilmParID(id_film));
        idf.setCellValueFactory(new PropertyValueFactory<>("idFilm"));
        idt.setCellValueFactory(new PropertyValueFactory<>("titre"));
        idd.setCellValueFactory(new PropertyValueFactory<>("description"));
        idi.setCellValueFactory(new PropertyValueFactory<>("image"));
        idtr.setCellValueFactory(new PropertyValueFactory<>("trailer"));
        idD.setCellValueFactory(new PropertyValueFactory<>("dateD"));
        idF.setCellValueFactory(new PropertyValueFactory<>("dateF"));
        ids.setCellValueFactory(new PropertyValueFactory<>("salle"));
        idp.setCellValueFactory(new PropertyValueFactory<>("prixEnfant"));
        idpa.setCellValueFactory(new PropertyValueFactory<>("prixAdulte"));
        idpe.setCellValueFactory(new PropertyValueFactory<>("prixEtudiant"));
        idti.setCellValueFactory(new PropertyValueFactory<>("time1"));
        idty.setCellValueFactory(new PropertyValueFactory<>("typeEvent"));
        idnb.setCellValueFactory(new PropertyValueFactory<>("nbrPlace"));
        
        }else {
            
            FilmService artc = new FilmService();
            tab.setItems(artc.afficherFilm());
        }
    }
    
    
    
    
        
        private void setCellValueFromTableToTextField()
    {
        
            tab.setOnMouseClicked(e -> {
            Film a1 = tab.getItems().get(tab.getSelectionModel().getSelectedIndex());
            
           
            idFilm.setText(String.valueOf(a1.getIdFilm()));       
            titre.setText(a1.getTitre());
            description.setText(a1.getDescription());
            image.setText(a1.getImage());
            trailer.setText(a1.getTrailer());
            
            //datedebut.setTime(a1.getDateD());
            Date date=a1.getDateD();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            datedebut.setValue(LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH)));
            //datefin.setDate(a1.getDateF());
            Date date1=a1.getDateD();
            Calendar calendar1 = new GregorianCalendar();
            calendar1.setTime(date1);
            datefin.setValue(LocalDate.of(calendar1.get(Calendar.YEAR),calendar1.get(Calendar.MONTH)+1,calendar1.get(Calendar.DAY_OF_MONTH)));
            
            salle.setText(a1.getSalle());
            prixenfant.setText(String.valueOf(a1.getPrixEnfant())); 
            //prixenfant.setText(Float.toString(a1.getPrixEnfant()));
            prixadulte.setText(String.valueOf(a1.getPrixAdulte())); 
            prixetudiant.setText(String.valueOf(a1.getPrixEtudiant())); 
            time.setText(a1.getTime1());
            nbrPlace.setText(String.valueOf(a1.getNbrPlace()));
            //nbrPlace.setText(Integer.toString(a1.getNbrPlace()));

            

        });
        
        
        
        
    }
    
}
