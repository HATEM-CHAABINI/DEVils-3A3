/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Cours;
import Services.CoursService;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXDatePicker;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import utilitaire.UploadFarah;

/**
 * FXML Controller class
 *
 * @author Farah
 */


public class CoursController implements Initializable {
    
     @FXML
    private TextField id;

    @FXML
    private ComboBox <String> type;

    @FXML
    private ComboBox<String> idP;

    @FXML
    private TextField nb_places;

  /*  @FXML
    private TextField nb_places_res;
*/
    @FXML
    private ComboBox<String> id_salle;

    @FXML
    private DatePicker date;

    @FXML
    private TextField heure_d;

    @FXML
    private TextField heure_f;

    @FXML
    private Button ajout;

    @FXML
    private Button modif;

    @FXML
    private Button suppr;

    @FXML
    private TableView<Cours> table;

    @FXML
    private TableColumn<Cours, Integer> idC;

    @FXML
    private TableColumn<Cours, String> typee;

    @FXML
    private TableColumn<Cours, Integer> idp;

    @FXML
    private TableColumn<Cours, Integer> nbp;

   /* @FXML
    private TableColumn<Cours, Integer> nbpr;
*/
    @FXML
    private TableColumn<Cours, Integer> idS;

    @FXML
    private TableColumn<Cours, Date> datee;

    @FXML
    private TableColumn<Cours, String> heureD;

    @FXML
    private TableColumn<Cours, String> heureF;

    @FXML
    private TableColumn<Cours, Float> prixx;

    @FXML
    private TextField prix;
    @FXML
    private Button image;
    @FXML
    private TextField imaget;
    @FXML
    private TableColumn<Cours, String> im;
    @FXML
    private TextField rechercher;
   // @FXML
    //private Button rechercherB;
    @FXML
    private Label ddd;
    @FXML
    private Label salle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CoursService ccc;
        
         try {
             ccc = new CoursService();
            // List<String>a=ccc.getNomPrenom();
             
             
          idP.setItems(ccc.getNomPrenom());
          id_salle.setItems(ccc.getDesignationSalle());
        
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        type.getItems().addAll("yoga","dessin","danse","peinture");
        

        type.setValue("yoga");
        
         try {
            CoursService cc = new CoursService();
            table.setItems(cc.afficherCours());
            
            
            idC.setCellValueFactory(new PropertyValueFactory<>("id_cours"));
            typee.setCellValueFactory(new PropertyValueFactory<>("type"));
            idp.setCellValueFactory(new PropertyValueFactory<>("id_prof"));
            nbp.setCellValueFactory(new PropertyValueFactory<>("nb_places"));
            //nbpr.setCellValueFactory(new PropertyValueFactory<>("nb_places_reserve"));
            idS.setCellValueFactory(new PropertyValueFactory<>("id_salle"));
            datee.setCellValueFactory(new PropertyValueFactory<>("date"));
            heureD.setCellValueFactory(new PropertyValueFactory<>("heureDebut"));
            heureF.setCellValueFactory(new PropertyValueFactory<>("heureFin"));
            prixx.setCellValueFactory(new PropertyValueFactory<>("prix"));
            im.setCellValueFactory(new PropertyValueFactory<>("image"));
           // idP.setText(cc.getNomPrenom().toString());
           
        } catch (Exception ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
             setCellValueFromTableToTextField();
             // TODO
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }   
    @FXML
    private void ajouter(ActionEvent event) throws ClassNotFoundException, Exception {
        
//        int idC=Integer.valueOf(this.id.getText());
        String type=this.type.getValue();
        int id_prof=Integer.valueOf(this.ddd.getText());
        int nb_p=Integer.valueOf(this.nb_places.getText());
        //int nb_pr=Integer.valueOf(this.nb_places_res.getText());
        int id_salle=Integer.valueOf(this.salle.getText());
        java.sql.Date Date = java.sql.Date.valueOf(date.getValue());
        String heure_d=this.heure_d.getText();
        String heure_f=this.heure_f.getText();
        float prix=Float.valueOf(this.prix.getText());
        String imagee=this.imaget.getText();
        String ss="";
        UploadFarah aaa = new UploadFarah();
        ss=aaa.upload(imagee);
       //String rp = imagee.replace("\\","/"); 
        Cours e=new Cours(type,id_prof,nb_p,ss,id_salle,Date,heure_d,heure_f,prix );
        CoursService cS=new CoursService();
        cS.ajouterCours(e);
        cS.modifierEtatSalle(this.id_salle.getValue());
        CoursService artc = new CoursService();
        table.setItems(artc.afficherCours());
            
       setCellValueFromTableToTextField();

        
    }
    
    @FXML
    private void modifier(ActionEvent event) throws ClassNotFoundException {
        
       String type=this.type.getValue();
        int id_prof=Integer.valueOf(this.ddd.getText());
        int nb_p=Integer.valueOf(this.nb_places.getText());
        //int nb_pr=Integer.valueOf(this.nb_places_res.getText());
        int id_salle=Integer.valueOf(this.salle.getText());
        java.sql.Date Date = java.sql.Date.valueOf(date.getValue());
        String heure_d=this.heure_d.getText();
        String heure_f=this.heure_f.getText();
        float prix=Float.valueOf(this.prix.getText());
        String imagee=this.imaget.getText();
        
          String rp = imagee.replace("\\","/"); 
        Cours e=new Cours(type,id_prof,nb_p,rp,id_salle,Date,heure_d,heure_f,prix );
        CoursService cS=new CoursService();
        int idC =Integer.valueOf(id.getText());
       // e.setId_cours(idC);
        cS.modifierCours(e,idC);
        CoursService artc = new CoursService();
        table.setItems(artc.afficherCours());
            
        
    }
    
    @FXML
    private void supprimer(ActionEvent event) {
         
            CoursService sa = null;
        try {
            sa = new CoursService();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
            int id_c=Integer.valueOf(this.id.getText());
           sa.supprimerReservation(id_c);
            sa.supprimerNote(id_c);
            sa.supprimerCours(id_c);
           
           sa.modifierEtatSalleNL(this.id_salle.getValue());
            id.clear();
            //type.clear();
            //idP.clear();
            nb_places.clear();
            //salle.clear();
            date.getEditor().clear();
          
            heure_d.clear();
            heure_f.clear();
            prix.clear();
           
                    
          table.setItems(sa.afficherCours());
            
            idC.setCellValueFactory(new PropertyValueFactory<>("id_cours"));
            typee.setCellValueFactory(new PropertyValueFactory<>("type"));
            idp.setCellValueFactory(new PropertyValueFactory<>("id_prof"));
            nbp.setCellValueFactory(new PropertyValueFactory<>("nb_places"));
            //nbpr.setCellValueFactory(new PropertyValueFactory<>("nb_places_reserve"));
            idS.setCellValueFactory(new PropertyValueFactory<>("id_salle"));
            datee.setCellValueFactory(new PropertyValueFactory<>("date"));
            heureD.setCellValueFactory(new PropertyValueFactory<>("heureDebut"));
            heureF.setCellValueFactory(new PropertyValueFactory<>("heureFin"));
            prixx.setCellValueFactory(new PropertyValueFactory<>("prix"));
            im.setCellValueFactory(new PropertyValueFactory<>("image"));
       
          }
    
    
    
     private void setCellValueFromTableToTextField() throws ClassNotFoundException
    {
        CoursService cs=new CoursService();
        
            table.setOnMouseClicked(e -> {
            Cours c1 = table.getItems().get(table.getSelectionModel().getSelectedIndex());
            
           
            id.setText(String.valueOf(c1.getId_cours()));       
            type.setValue(c1.getType());
            String nom="";
            nom=cs.NomProf(c1);
            idP.setValue(nom);
            nb_places.setText(String.valueOf(c1.getNb_places()));
         //   nb_places_res.setText(String.valueOf(c1.getNb_places_res()));
            salle.setText(String.valueOf(c1.getId_salle()));       
             id_salle.setValue(cs.getDes_Salle(c1.getId_salle()));
            //datedebut.setTime(a1.getDateD());
            Date daate=c1.getDate();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(daate);
            date.setValue(LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH)));
            
            
            heure_d.setText(c1.getHeure_debut());
            heure_f.setText(c1.getHeure_fin());


            prix.setText(String.valueOf(c1.getPrix())); 
            imaget.setText(c1.getImage());

            

        });
    }
     @FXML
    private void ajouterFichier(ActionEvent event) throws IOException {
        final FileChooser filechooser = new FileChooser();
        File selectedfile=filechooser.showOpenDialog(null);
        if(selectedfile != null)
        {
            imaget.setText(selectedfile.getAbsolutePath());
            Path source=Paths.get(selectedfile.getAbsolutePath());
            Path destination= Paths.get("D:\\wamp64\\"+selectedfile.getName());
                    
            String s=destination.toString();
            System.out.println(s);
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
    public void rechercher(KeyEvent event) throws ClassNotFoundException
    {
         CoursService sa = null;
        try {
            sa = new CoursService();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!(this.rechercher.getText().equals(""))){
            int id_c=Integer.valueOf(this.rechercher.getText());
          
           
                    
          table.setItems(sa.RechercherCours(id_c));
            
            idC.setCellValueFactory(new PropertyValueFactory<>("id_cours"));
            typee.setCellValueFactory(new PropertyValueFactory<>("type"));
            idp.setCellValueFactory(new PropertyValueFactory<>("id_prof"));
            nbp.setCellValueFactory(new PropertyValueFactory<>("nb_places"));
            //nbpr.setCellValueFactory(new PropertyValueFactory<>("nb_places_reserve"));
            idS.setCellValueFactory(new PropertyValueFactory<>("id_salle"));
            datee.setCellValueFactory(new PropertyValueFactory<>("date"));
            heureD.setCellValueFactory(new PropertyValueFactory<>("heureDebut"));
            heureF.setCellValueFactory(new PropertyValueFactory<>("heureFin"));
            prixx.setCellValueFactory(new PropertyValueFactory<>("prix"));
            im.setCellValueFactory(new PropertyValueFactory<>("image"));
        }else
        {
            CoursService cs= new CoursService();
            table.setItems(cs.afficherCours());
        }
            
            
                   setCellValueFromTableToTextField();
    }

    @FXML
    private void broo(ActionEvent event) {
         try {
             CoursService ccc = new CoursService();
             String str=this.idP.getValue();
             System.out.println(str);
             String[] a=str.split(" ");
             System.out.println(a[0]);
             System.out.println(a[1]);
             int id=ccc.getIdProf(a[0],a[1]);
             System.out.println(id);
             this.ddd.setText(String.valueOf(id));
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
      @FXML
    private void salle(ActionEvent event) {
         try {
             CoursService ccc = new CoursService();
             String str=this.id_salle.getValue();
             System.out.println(str);
             
             int id=ccc.getIdSalle(str);
             System.out.println(id);
             this.salle.setText(String.valueOf(id));
             this.nb_places.setText(String.valueOf(ccc.getNbPlaces(this.id_salle.getValue())));
             
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
