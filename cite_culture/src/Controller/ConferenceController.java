/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.TheatreController.sallouma;
import Entities.Conference;
import Entities.Theatre;
import Services.ConferenceService;
import Services.FilmService;
import Services.TheatreService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import utilitaire.ControlesaisieJ;
import utilitaire.UploadImageFilm;

/**
 * FXML Controller class
 *
 * @author mouna dridi
 */
public class ConferenceController implements Initializable {

    @FXML
    private DatePicker datedebut;
    @FXML
    private DatePicker datefin;
    @FXML
    private TableView<Conference> tab;
    @FXML
    private TableColumn<?, ?> idt;
    @FXML
    private TableColumn<?, ?> idd;
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
    private TableColumn<?, ?> idty;
    @FXML
    private TableColumn<?, ?> idi;
    @FXML
    private TableColumn<?, ?> idnb;
    @FXML
    private Button ajouterI_B;
    @FXML
    private JFXButton ajouterB;
    @FXML
    private JFXButton modifierB;
    @FXML
    private JFXButton supprimerB;
    @FXML
    private JFXTextField titre;
    @FXML
    private JFXTextField description;
    @FXML
    private JFXTextField image;
    @FXML
    private JFXTextField salle;
    @FXML
    private JFXTextField prixenfant;
    @FXML
    private JFXTextField prixadulte;
    @FXML
    private JFXTextField prixetudiant;
    @FXML
    private JFXTextField nbrPlace;
    @FXML
    private JFXTextField time;
    @FXML
    private JFXTextField Rid;
    @FXML
    private TableColumn<?, ?> idco;
    @FXML
    private JFXTextField idConference;
    public static String sallouma=null;
    @FXML
    private ComboBox<String> salle1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ConferenceService fs;
        fs = new ConferenceService();
        salle1.setItems(fs.affecterSalle());
        
        
        try {
            ConferenceService artc = new ConferenceService();
            tab.setItems(artc.afficherConference());
            
            
            idco.setCellValueFactory(new PropertyValueFactory<>("idConference"));
            idt.setCellValueFactory(new PropertyValueFactory<>("titre"));
            idd.setCellValueFactory(new PropertyValueFactory<>("description"));
            idi.setCellValueFactory(new PropertyValueFactory<>("image"));
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
            Logger.getLogger(ConferenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       setCellValueFromTableToTextField();
        // TODO
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
    private void ajouter(ActionEvent event) throws Exception {
         ControlesaisieJ cn=new ControlesaisieJ();
        String titre1=this.titre.getText();
        String description1=this.description.getText();
        String image1=sallouma;
//        java.sql.Date dated = java.sql.Date.valueOf(datedebut.getValue());
//        java.sql.Date datef = java.sql.Date.valueOf(datefin.getValue());
 if (datedebut.getValue()!=null && datefin.getValue()!=null ){
        java.sql.Date dated = java.sql.Date.valueOf(datedebut.getValue());
        java.sql.Date datef = java.sql.Date.valueOf(datefin.getValue());
        if(cn.testdateEMB_dateEXP1(dated,datef)==-1){
        //String salle1=this.salle.getText();
        String salle=this.salle1.getValue();
        float prixEnfant=Integer.valueOf(this.prixenfant.getText());
        float prixAdulte=Integer.valueOf(this.prixadulte.getText());
        float prixEtudiant=Integer.valueOf(this.prixetudiant.getText());
        String time1=this.time.getText();
        int nbrplace=Integer.valueOf(this.nbrPlace.getText());
        
        UploadImageFilm up=new UploadImageFilm();
        String path2=up.upload(image.getText());
        
        //String rp = image1.replace('\\','/');  
        System.out.println(path2);
      //  Film e=new Film(titre1,description1,rp,trailer1,dated,datef,salle1,prixEnfant,prixAdulte ,prixEtudiant, time1,nbrplace);
        Conference e=new Conference(titre1,description1,dated,datef,salle,prixEnfant,prixAdulte ,prixEtudiant, time1,path2,nbrplace);
        ConferenceService fS=new ConferenceService();
        fS.ajouterConference(e);
        ConferenceService artc = new ConferenceService();
        tab.setItems(artc.afficherConference());
    }
        else{
        Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setTitle("date erronee");
        alert.setHeaderText("ajoutez une date valide");
        alert.showAndWait();
        }
 }}
    @FXML
    private void modifier(ActionEvent event) {
         java.sql.Date d=java.sql.Date.valueOf(datedebut.getValue());
        java.sql.Date d1=java.sql.Date.valueOf(datefin.getValue());
        float p=Float.valueOf(prixenfant.getText());
        float p1=Float.valueOf(prixadulte.getText());
        float p2=Float.valueOf(prixetudiant.getText());
        int nbr=Integer.valueOf(nbrPlace.getText());
        
        
        ConferenceService fs = new ConferenceService();
        Conference f  = new Conference(titre.getText(),description.getText(),d,d1,salle1.getValue(),p,p1,p2,time.getText(),image.getText(),nbr);
        int id =Integer.valueOf(idConference.getText());
        f.setIdConference(id);
       
        fs.modifierConference(f);
        ConferenceService artc = new ConferenceService();
        tab.setItems(artc.afficherConference());
    }

    @FXML
    private void supprimer(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("supression");
alert.setHeaderText("supprimer un film");
alert.setContentText("Are you ok with this?");

Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK){
        Conference f =new Conference();
        f.setIdConference(Integer.valueOf(idConference.getText()));
        ConferenceService fs=new ConferenceService();
        fs.supprimerConference(f);
            idConference.clear();
            titre.clear();
            description.clear();
            image.clear();
            datedebut.getEditor().clear();
            datefin.getEditor().clear();
            //salle.clear();
            prixenfant.clear();
            prixadulte.clear();
            prixetudiant.clear();
            time.clear();
            nbrPlace.clear();
                    
            tab.setItems(fs.afficherConference());
            
            idco.setCellValueFactory(new PropertyValueFactory<>("idConference"));
            idt.setCellValueFactory(new PropertyValueFactory<>("titre"));
            idd.setCellValueFactory(new PropertyValueFactory<>("description"));
            idi.setCellValueFactory(new PropertyValueFactory<>("image"));
            idD.setCellValueFactory(new PropertyValueFactory<>("dateD"));
            idF.setCellValueFactory(new PropertyValueFactory<>("dateF"));
            ids.setCellValueFactory(new PropertyValueFactory<>("salle"));
            idp.setCellValueFactory(new PropertyValueFactory<>("prixEnfant"));
            idpa.setCellValueFactory(new PropertyValueFactory<>("prixAdulte"));
            idpe.setCellValueFactory(new PropertyValueFactory<>("prixEtudiant"));
            idti.setCellValueFactory(new PropertyValueFactory<>("time1"));
            idnb.setCellValueFactory(new PropertyValueFactory<>("nbrPlace"));
    }}

    @FXML
    private void search(KeyEvent event) {
         ConferenceService sa = new ConferenceService() ;
        if (!(this.Rid.getText().equals(""))){
        int id_conference=Integer.valueOf(this.Rid.getText());
        tab.setItems(sa.rechercheConferenceParID(id_conference));
        idco.setCellValueFactory(new PropertyValueFactory<>("idConference"));
        idt.setCellValueFactory(new PropertyValueFactory<>("titre"));
        idd.setCellValueFactory(new PropertyValueFactory<>("description"));
        idi.setCellValueFactory(new PropertyValueFactory<>("image"));
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
            
            ConferenceService artc = new ConferenceService();
            tab.setItems(artc.afficherConference());
        }
    }
    
    
    
    
            private void setCellValueFromTableToTextField()
    {
        
            tab.setOnMouseClicked(e -> {
            Conference a1 = tab.getItems().get(tab.getSelectionModel().getSelectedIndex());
            
           
            idConference.setText(String.valueOf(a1.getIdConference()));       
            titre.setText(a1.getTitre());
            description.setText(a1.getDescription());
            image.setText(a1.getImage());
            
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
            
            salle1.setValue(a1.getSalle());
            prixenfant.setText(String.valueOf(a1.getPrixEnfant())); 
            //prixenfant.setText(Float.toString(a1.getPrixEnfant()));
            prixadulte.setText(String.valueOf(a1.getPrixAdulte())); 
            prixetudiant.setText(String.valueOf(a1.getPrixEtudiant())); 
            time.setText(a1.getTime1());
            nbrPlace.setText(String.valueOf(a1.getNbrPlace()));
            //nbrPlace.setText(Integer.toString(a1.getNbrPlace()));

            

        });
        
        
        
        
    }

    @FXML
    private void changeplace(ActionEvent event) {
         ConferenceService fs=new ConferenceService();
       int pl= fs.NbrPlace(salle1.getValue());
        this.nbrPlace.setText(String.valueOf(pl));
    }
    
}
