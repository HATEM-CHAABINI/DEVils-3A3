/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;
import Services.EmployeService;
import Services.UtilisateurService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import utilitaire.ControlesaisieJ;

/**
 *
 * @author hatem
 */
public class FXMLInscriptionController implements Initializable{
    ObservableList<String> ListVille = FXCollections.observableArrayList("Tunis","Sfax","Sousse","Kairouan","Bizerte","Gabès","La Soukra","Ariana","Sidi Hassine","El Mourouj","Gafsa","Raoued","Monastir","La Marsa","Ben Arous","Kasserine ","Douar Hicher","Djerba - Houmt Souk","Le Kram","Hammamet","Zarzis","Le Bardo","Médenine","Nabeul","Tataouine","Ben Gardane","Djerba - Midoun ","Béja","M'saken","Radès","Oued Ellil","Moknine","Le Kef","Menzel Bourguiba","Kalâa Kebira ","Sakiet Ezzit ","Mahdia ","Jemmal ","Ksar Hellal ","Sidi Bouzid ","Kélibia ","Sakiet Eddaïer ","La Goulette ","Jendouba ","El Aïn ","Hammam Sousse ","Hammam Lif ","Dar Chaâbane ","El Hamma","Gremda ","Bou Mhel el-Bassatine ","Menzel Temime ","Korba ","Métlaoui ","Soliman ","Téboulba ","Tozeur ","Ezzahra ","Kalâa Seghira ","Mateur ","El Ksar ","Thyna ","La Manouba ","Hammam Chott ","Siliana ","Douz ","Mornag ","Fériana ","Ksour Essef ","Djedeida ","Ras Jebel ","Ghannouch ","Tebourba ","Akouda ","Mégrine ","Den Den ","Chihia ","Redeyef ","Sbeïtla ","Grombalia ","Djerba - Ajim ","El Fahs ","Menzel Jemil ","Chebba ","Takelsa ","Ouerdanine ","Nefta ","Medjez el-Bab ","Bou Salem ","Béni Khiar ","Moularès ","El Jem ","Tinja ","Zaghouan ","Zaouiet Sousse ","Kébili ","Mornaguia ","Tabarka ","Ghardimaou ","Menzel Abderrahmane ","Sahline Moôtmar ","Souk Lahad ","Menzel Bouzelfa ","El Alia ","Thala ","Kalâat el-Andalous ","Bekalta ","Tajerouine ","Ezzouhour ","Carthage ","Zéramdine ","Bembla ","Mahrès ","Kerkennah ","Béni Khalled ","Chenini Nahal ","Meknassy ","Bennane-Bodheur ","El Guettar ","Makthar ","Testour ","Bou Arada ","Ksibet el-Médiouni ","Dahmani ","Sayada","Menzel Hayet","Messaadine"," Mdhilla"," Le Sers"," Bou Argoub"," Skhira"," Téboursouk"," Zriba"," Menzel Ennour"," Mareth"," Ksibet Thrayet"," Agareb"," Regueb"," Sidi Thabet"," Khniss"," Enfida"," Rejiche"," Métouia"," Hajeb El Ayoun"," Gaâfour"," Sidi Bou Ali"," Oudhref"," Bouficha"," Metline"," Raf Raf"," Jérissa"," Aïn Draham"," Ghomrassen"," Sened"," El Haouaria"," Tazarka"," Sidi Ali Ben Aoun"," Hammam Ghezèze"," Oueslatia"," Beni Hassen"," Khalidia"," Menzel Kamel"," Haffouz"," Sidi Ameur"," Bir Mcherga"," Kalaat Senan"," Amiret Hajjaj"," El Maâmoura"," Sbikha"," Bir Lahmar"," El Golâa"," Degache"," Zaouiet Djedidi"," El Krib"," Bou Hajla"," El Maâgoula"," Foussana"," El Hencha"," Nadhour"," Nouvelle Matmata"," Sidi Alouane"," Kerker"," Hergla"," El Bradâa"," Mezzouna"," Nefza"," Touza"," Jemna"," Jebiniana"," Menzel Bouzaiane"," Somâa"," Thélepte"," Zaouiet Kontoch"," Melloulèche"," Borj El Amri"," Sbiba"," Bir El Hafey"," Majel Bel Abbès"," El Batan"," El Hamma du Jérid"," Sakiet Sidi Youssef"," Remada"," Amiret Touazra"," Bouhjar"," Sidi Bou Saïd"," El Ksour"," Jilma"," Lamta"," Chorbane"," Sejnane"," Zarat"," Essouassi"," Ghar El Melh"," Djebel Oust"," Amiret El Fhoul"," Menzel Horr"," Amdoun"," Aousja"," Ouled Chamekh"," El Ghnada"," Azmour"," Nasrallah"," Bargou"," Bir Ali Ben Khalifa"," El Masdour"," Rouhia"," Dar Allouch"," Sidi Bennour"," Cherahil"," Jedelienne"," Bou Merdes"," Dehiba"," El Mida"," Goubellat"," Menzel Mehiri"," Fernana"," Kondar"," Menzel Fersi"," Korbous"," Haïdra"," Cebbala Ouled Asker"," Nebeur"," El Alâa"," Sidi Bou Rouis"," Graïba"," Hebira"," Sidi Makhlouf"," Beni Khedache"," Chebika","El Aroussa","Sidi El Hani"," Kesra"," Kalâat Khasba"," Ouchtata"," Slouguia"," Sidi Ismail"," Ouled Haffouz"," Oued Meliz"," Tamerza"," Menzel Chaker"," Touiref"," Matmata"," Menzel Salem"," Aïn Djeloula"," Echrarda","Beni M'Tir","Aachech"," Al Ahouaz-El Assouda"," Belkhir","Bouchemma"," El Amra"," El Ayoun","Ennasr","Ezzouhour"," Essaïda","Faouar","Fouchana ","Ghezala ","Hadjeb","Hassi El Ferid ","Hazeg Ellouza ","Hazoua ","Hkaima ","Joumine ","Lela ","Menzel El Habib ","Mohamedia ","Mnihla ","Nadhour Sidi Ali Ben Abed ","Ouabed Khazanet ","Rjim Maatoug ","Saouaf ","Sidi Aïch ","Sidi Zid ","Smâr ","Souk Jedid ","Teboulbou ","Thibar ","Tlelsa ","Utique ","Zarzis Nord ","Zelba");
   
    ObservableList<String> ListDomaine = FXCollections.observableArrayList("","yoga","dessin","danse","peinture");
    
    
    private JFXTextField fName;
    private JFXTextField lName;
    @FXML
    private JFXTextField pNumber;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField pwd1;
    @FXML
    private JFXPasswordField pwd2;
    @FXML
    private JFXButton registerBtn;
    private JFXTextField path;
    @FXML
    private JFXTextField Nom;
    @FXML
    private JFXTextField Prenom;
    private JFXTextField username;
    @FXML
    private ChoiceBox<String> villeBox;
    @FXML
    private JFXTextField Adr;
    private JFXTextField codep;
    @FXML
    private JFXRadioButton hommebtn;
    @FXML
    private ToggleGroup sexe;
    @FXML
    private JFXRadioButton femmebtn;
    @FXML
    private JFXTextField cin;
    @FXML
    private DatePicker dateNais;
    @FXML
    private ChoiceBox<String> DomaineBox;
    @FXML
    private JFXRadioButton Proffeseurs;
    @FXML
    private JFXRadioButton Maintenace;
    @FXML
    private Label LNom;
    @FXML
    private Label LPren;
    @FXML
    private Label LEmail;
    @FXML
    private Label LAdr;
    @FXML
    private Label LTel;
    @FXML
    private Label LCin;
    @FXML
    private Label LMdp1;
    @FXML
    private Label LMdp2;
    @FXML
    private Label Lsexe;
    @FXML
    private Label LDepartement;
    @FXML
    private Label LDate;
    @FXML
    private ToggleGroup Departement;
    @FXML
    private Label LDomaine;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
           DomaineBox.setValue("");
           DomaineBox.setItems(ListDomaine);
            villeBox.setValue("Tunis");
            villeBox.setItems(ListVille);
    }
    @FXML
    private void registerEmployee(ActionEvent event) throws NoSuchAlgorithmException, ClassNotFoundException, IOException {
        // java.sql.Date daten=java.sql.Date.valueOf(dateNais.getValue());
      //  int codeposta=Integer.valueOf(this.codep.getText());
        //int teli=Integer.valueOf(this.pNumber.getText());
        //int ci=Integer.valueOf(this.cin.getText());
        
        EmployeService es=new EmployeService();
        /************************************************************************/
        
        ControlesaisieJ cn=new ControlesaisieJ();
String NomU = null,PrenomU = null,EmailU = null,Usernameu = null,AdrU = null,mdp1 = null,mdp2,SexeU = null,LienIm = null,roleu=null,DepartementU=null;
int codeposta = 0,teli = 0,cin = 0;
   java.sql.Date daten = null;
int v=0;

        //**********************************************************
         if (!Nom.getText().equals("") && cn.testnomprenom(Nom.getText())){
                 this.LNom.setText("");
                 NomU=Nom.getText();
                 v++;
         }else {
             
             this.LNom.setText("* Nom erroné");
                
         }
         //**********************************************************
         
         if (!Prenom.getText().equals("") && cn.testnomprenom(Prenom.getText())){
                 this.LPren.setText("");
                 PrenomU=Prenom.getText();
                                  v++;

         }else {
             
             this.LPren.setText("* Prenom erroné");

         }
         
         //**********************************************************
         
         
            if (!email.getText().equals("") && cn.mailformat(email.getText())){
               if(es.verifEmail(email.getText())){
                
                this.LEmail.setText("");
                 EmailU=email.getText();
                                  v++;}
               else{
                   this.LEmail.setText("Email deja Utilisé");

               }

         }else {
             
             this.LEmail.setText("* Email erroné");

         }
         
         //**********************************************************
            /*if (!username.getText().equals("") && cn.testUsername(username.getText())){
                if(es.verifUsername(username.getText())){
                 this.LUsername.setText("");
                 Usernameu=username.getText();
                                  v++;}
                else{
                                     this.LUsername.setText("Veuillez Choisir un autre username");

                }

         }else {
             
             this.LUsername.setText("* Username erroné");

         }*/
         
          
         //**********************************************************
            if (!Adr.getText().equals("") && cn.testAdr(Adr.getText())){
                 this.LAdr.setText("");
                 AdrU=Adr.getText();
                                  v++;

         }else {
             
             this.LAdr.setText("* Adresse erroné");

         }
//***************************************************************
       
//***************************************************************
   if (cn.GSM(pNumber.getText())){
        this.LTel.setText("");
        teli=Integer.valueOf(this.pNumber.getText());
                         v++;

    }else
    {
                 this.LTel.setText("* Numero erroné");

    }
        
//***************************************************************
   if (cn.Cin(this.cin.getText())){
      
       this.LCin.setText("");
        cin=Integer.valueOf(this.cin.getText());
                         v++;}
      else
    {
                 this.LCin.setText("* Cin erroné");

    }
 //***************************************************************
if (cn.testpassword(pwd1.getText()))
{
    this.LMdp1.setText("");
    mdp1=pwd1.getText();
                     v++;

}else{
this.LMdp1.setText("* Mot de passe doit contenir 8 caratcter minimum");
}

if(pwd1.getText().equals(pwd2.getText())){
    this.LMdp2.setText("");
    mdp2=pwd2.getText();
                 v++;

}    else{
           this.LMdp1.setText("* Reverifier le mot de passe");
 
            }


        if (dateNais.getValue()!=null){
           daten=java.sql.Date.valueOf(dateNais.getValue());
             if (cn.datenais(daten)){
             this.LDate.setText("");
             v++;
             }else{
             this.LDate.setText("Date erroné");
             }
        }else {
                     this.LDate.setText("Date vide");
}
        
        
//        System.out.println("/////////////d");
//        System.out.println();
//       //            RadioButton button = (RadioButton) sexe.getSelectedToggle();
//         //           SexeU=button.getText();
//
//        System.out.println("/////////////d");
 if (sexe.selectedToggleProperty().getValue() != null){
               RadioButton button = (RadioButton) sexe.getSelectedToggle();
        SexeU=button.getText();
        this.Lsexe.setText("");
        v++;
        }else {
                             this.LDate.setText("* veuillez choisir votre sexe");

        
        }
 
 
 
 if (Departement.selectedToggleProperty().getValue() != null){
               RadioButton buttondep = (RadioButton) Departement.getSelectedToggle();
        DepartementU=buttondep.getText();
        this.LDepartement.setText("");
        v++;
        }else {
                             this.LDate.setText("* veuillez choisir votre sexe");

        
        }
 /************************************************************************/
 
 if (Departement.selectedToggleProperty().getValue() != null){
 if (DepartementU.equals("Proffeseurs")){
     if (DomaineBox.getValue().equals("")){
         v--;
        this.LDomaine.setText("* veuillez choisir votre un domain ou changer de departement");

     }
     else {
             this.LDomaine.setText("");
}
 }
     else {
             this.LDomaine.setText("");}}
 
        System.out.println(v);
       if (v==11){
                  Random r = new Random();
int valeur = 1000 + r.nextInt(9999 - 1000);
            System.out.println(valeur);
            
         Utilisateur c1=new Utilisateur(EmailU,EmailU,mdp1,"",NomU,PrenomU,villeBox.getValue(),daten,AdrU,codeposta,SexeU,teli,cin);
      if (DepartementU.equals("Proffeseurs")){
         c1.setDomaine(DomaineBox.getValue());}
         c1.setDepartement(DepartementU);
         es.ajouterEmploye(c1);
        
    
Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Enregistrer");
            alert.setHeaderText("Utilisateur enregistrer avec sussces");
            Optional<ButtonType> result = alert.showAndWait();
        
        /****************************************************************************/
    

 

}}}
