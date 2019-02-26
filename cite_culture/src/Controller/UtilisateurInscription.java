/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;
import Services.UtilisateurService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
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
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import utilitaire.ControlesaisieJ;
import utilitaire.UserSession;
import utilitaire.sendSMS;

/**
 * FXML Controller class
 *
 * @author hatem
 */
public class UtilisateurInscription implements Initializable {
    ObservableList<String> ListVille = FXCollections.observableArrayList("Tunis","Sfax","Sousse","Kairouan","Bizerte","Gabès","La Soukra","Ariana","Sidi Hassine","El Mourouj","Gafsa","Raoued","Monastir","La Marsa","Ben Arous","Kasserine ","Douar Hicher","Djerba - Houmt Souk","Le Kram","Hammamet","Zarzis","Le Bardo","Médenine","Nabeul","Tataouine","Ben Gardane","Djerba - Midoun ","Béja","M'saken","Radès","Oued Ellil","Moknine","Le Kef","Menzel Bourguiba","Kalâa Kebira ","Sakiet Ezzit ","Mahdia ","Jemmal ","Ksar Hellal ","Sidi Bouzid ","Kélibia ","Sakiet Eddaïer ","La Goulette ","Jendouba ","El Aïn ","Hammam Sousse ","Hammam Lif ","Dar Chaâbane ","El Hamma","Gremda ","Bou Mhel el-Bassatine ","Menzel Temime ","Korba ","Métlaoui ","Soliman ","Téboulba ","Tozeur ","Ezzahra ","Kalâa Seghira ","Mateur ","El Ksar ","Thyna ","La Manouba ","Hammam Chott ","Siliana ","Douz ","Mornag ","Fériana ","Ksour Essef ","Djedeida ","Ras Jebel ","Ghannouch ","Tebourba ","Akouda ","Mégrine ","Den Den ","Chihia ","Redeyef ","Sbeïtla ","Grombalia ","Djerba - Ajim ","El Fahs ","Menzel Jemil ","Chebba ","Takelsa ","Ouerdanine ","Nefta ","Medjez el-Bab ","Bou Salem ","Béni Khiar ","Moularès ","El Jem ","Tinja ","Zaghouan ","Zaouiet Sousse ","Kébili ","Mornaguia ","Tabarka ","Ghardimaou ","Menzel Abderrahmane ","Sahline Moôtmar ","Souk Lahad ","Menzel Bouzelfa ","El Alia ","Thala ","Kalâat el-Andalous ","Bekalta ","Tajerouine ","Ezzouhour ","Carthage ","Zéramdine ","Bembla ","Mahrès ","Kerkennah ","Béni Khalled ","Chenini Nahal ","Meknassy ","Bennane-Bodheur ","El Guettar ","Makthar ","Testour ","Bou Arada ","Ksibet el-Médiouni ","Dahmani ","Sayada","Menzel Hayet","Messaadine"," Mdhilla"," Le Sers"," Bou Argoub"," Skhira"," Téboursouk"," Zriba"," Menzel Ennour"," Mareth"," Ksibet Thrayet"," Agareb"," Regueb"," Sidi Thabet"," Khniss"," Enfida"," Rejiche"," Métouia"," Hajeb El Ayoun"," Gaâfour"," Sidi Bou Ali"," Oudhref"," Bouficha"," Metline"," Raf Raf"," Jérissa"," Aïn Draham"," Ghomrassen"," Sened"," El Haouaria"," Tazarka"," Sidi Ali Ben Aoun"," Hammam Ghezèze"," Oueslatia"," Beni Hassen"," Khalidia"," Menzel Kamel"," Haffouz"," Sidi Ameur"," Bir Mcherga"," Kalaat Senan"," Amiret Hajjaj"," El Maâmoura"," Sbikha"," Bir Lahmar"," El Golâa"," Degache"," Zaouiet Djedidi"," El Krib"," Bou Hajla"," El Maâgoula"," Foussana"," El Hencha"," Nadhour"," Nouvelle Matmata"," Sidi Alouane"," Kerker"," Hergla"," El Bradâa"," Mezzouna"," Nefza"," Touza"," Jemna"," Jebiniana"," Menzel Bouzaiane"," Somâa"," Thélepte"," Zaouiet Kontoch"," Melloulèche"," Borj El Amri"," Sbiba"," Bir El Hafey"," Majel Bel Abbès"," El Batan"," El Hamma du Jérid"," Sakiet Sidi Youssef"," Remada"," Amiret Touazra"," Bouhjar"," Sidi Bou Saïd"," El Ksour"," Jilma"," Lamta"," Chorbane"," Sejnane"," Zarat"," Essouassi"," Ghar El Melh"," Djebel Oust"," Amiret El Fhoul"," Menzel Horr"," Amdoun"," Aousja"," Ouled Chamekh"," El Ghnada"," Azmour"," Nasrallah"," Bargou"," Bir Ali Ben Khalifa"," El Masdour"," Rouhia"," Dar Allouch"," Sidi Bennour"," Cherahil"," Jedelienne"," Bou Merdes"," Dehiba"," El Mida"," Goubellat"," Menzel Mehiri"," Fernana"," Kondar"," Menzel Fersi"," Korbous"," Haïdra"," Cebbala Ouled Asker"," Nebeur"," El Alâa"," Sidi Bou Rouis"," Graïba"," Hebira"," Sidi Makhlouf"," Beni Khedache"," Chebika","El Aroussa","Sidi El Hani"," Kesra"," Kalâat Khasba"," Ouchtata"," Slouguia"," Sidi Ismail"," Ouled Haffouz"," Oued Meliz"," Tamerza"," Menzel Chaker"," Touiref"," Matmata"," Menzel Salem"," Aïn Djeloula"," Echrarda","Beni M'Tir","Aachech"," Al Ahouaz-El Assouda"," Belkhir","Bouchemma"," El Amra"," El Ayoun","Ennasr","Ezzouhour"," Essaïda","Faouar","Fouchana ","Ghezala ","Hadjeb","Hassi El Ferid ","Hazeg Ellouza ","Hazoua ","Hkaima ","Joumine ","Lela ","Menzel El Habib ","Mohamedia ","Mnihla ","Nadhour Sidi Ali Ben Abed ","Ouabed Khazanet ","Rjim Maatoug ","Saouaf ","Sidi Aïch ","Sidi Zid ","Smâr ","Souk Jedid ","Teboulbou ","Thibar ","Tlelsa ","Utique ","Zarzis Nord ","Zelba");
  Utilisateur uti=new Utilisateur();

    @FXML
    private JFXTextField Nom;
    @FXML
    private JFXTextField Prenom;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField username;
    @FXML
    private DatePicker dateNais;
    @FXML
    private JFXTextField Adr;
    @FXML
    private JFXTextField pNumber;
    @FXML
    private JFXPasswordField pwd1;
    @FXML
    private JFXButton joindrebtn;
    @FXML
    private JFXButton saveButton;
    @FXML
    private Button btnFB;
    @FXML
    private ChoiceBox<String> villeBox;
    @FXML
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
    private JFXPasswordField pwd2;
    @FXML
    private JFXTextField path;
    @FXML
    private Label LNom;
    @FXML
    private Label LPren;
    @FXML
    private Label LEmail;
    @FXML
    private Label LUsername;
    @FXML
    private Label LAdr;
    @FXML
    private Label LCodeP;
    @FXML
    private Label LTel;
    @FXML
    private Label LCin;
    @FXML
    private Label LMdp1;
    @FXML
    private Label LMdp2;
    @FXML
    private Label LImage;
    @FXML
    private Label LDate;
    @FXML
    private Label Lsexe;
    @FXML
    private JFXRadioButton ClientId;
    @FXML
    private JFXRadioButton JournalisteId;
    @FXML
    private ToggleGroup role;
    @FXML
    private Label LRole;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           villeBox.setValue("Tunis");
            villeBox.setItems(ListVille);
            
       /*try {
            uti=UserSession.getInstance(uti).getUser();
           System.out.println("///////////*************");
   System.out.println(uti.getNom());
           System.out.println("///////////*************");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilisateurInscription.class.getName()).log(Level.SEVERE, null, ex);
        
    }*/}    

    @FXML
    private void joinde(ActionEvent event) {
           FileChooser fileChooser = new FileChooser();
           
 FileChooser.ExtensionFilter imageFilter
                = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
  fileChooser.getExtensionFilters().add(imageFilter);
		File selectedFile = fileChooser.showOpenDialog(null);

		if (selectedFile != null) {

			this.path.setText(selectedFile.getAbsolutePath());
    }}

    @FXML
    private void register(ActionEvent event) throws IOException, NoSuchAlgorithmException, ClassNotFoundException {
      
                       UtilisateurService s= new UtilisateurService();

        System.out.println("You uvijinddddnvddddddddddddddddddddddddddddu me!");
          
        ControlesaisieJ cn=new ControlesaisieJ();
String NomU = null,PrenomU = null,EmailU = null,Usernameu = null,AdrU = null,mdp1 = null,mdp2,SexeU = null,LienIm = null,roleu=null;
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
               if(s.verifEmail(email.getText())){
                
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
            if (!username.getText().equals("") && cn.testUsername(username.getText())){
                if(s.verifUsername(username.getText())){
                 this.LUsername.setText("");
                 Usernameu=username.getText();
                                  v++;}
                else{
                                     this.LUsername.setText("Veuillez Choisir un autre username");

                }

         }else {
             
             this.LUsername.setText("* Username erroné");

         }
         
          
         //**********************************************************
            if (!Adr.getText().equals("") && cn.testAdr(Adr.getText())){
                 this.LAdr.setText("");
                 AdrU=Adr.getText();
                                  v++;

         }else {
             
             this.LAdr.setText("* Adresse erroné");

         }
//***************************************************************
       
    if (cn.Poste(codep.getText())){
        this.LCodeP.setText("");
        codeposta=Integer.valueOf(this.codep.getText());
                         v++;

    }else
    {
                 this.LCodeP.setText("* Code Postale erroné");

    }
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
      if (s.verifCin(Integer.valueOf(this.cin.getText()))){
       this.LCin.setText("");
        cin=Integer.valueOf(this.cin.getText());
                         v++;}
      else{
      this.LCin.setText("Cin deja Utilisé");
      }

    }else
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
           this.LMdp1.setText("* Reverifier votre mot de passe");
 
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
 /************************************************************************/
 if (role.selectedToggleProperty().getValue() != null){
               RadioButton buttonr = (RadioButton) role.getSelectedToggle();
        roleu=buttonr.getText();
        this.LRole.setText("");
        v++;
        }else {
                             this.LDate.setText("* veuillez choisir votre Role");

        
        }
 
 if (!path.getText().equals(""))
 {
 
//Path source=Paths.get(this.path.getText());
//Path destination= Paths.get("C:\\wamp64\\www\\image_pdf\\"+this.username.getText()+"_ image.png");
  //     LienIm = destination.toString().replace("\\","/");
    //    System.out.println(rp);
//Files.copy(source, destination,StandardCopyOption.REPLACE_EXISTING);
  v++;      
 this.LImage.setText("");
 
 }else{
 this.LImage.setText("* Veuillez inserer une image");
 
 } 
       if (v==14){
                  Random r = new Random();
int valeur = 1000 + r.nextInt(9999 - 1000);
            System.out.println(valeur);
         Utilisateur c1=new Utilisateur(Usernameu,EmailU,mdp1,this.path.getText(),NomU,PrenomU,villeBox.getValue(),daten,AdrU,codeposta,SexeU,teli,cin);
       c1.setRoles(roleu);
         
         /*
         sendSMS sms=new sendSMS();
         sms.envoitSms(teli, valeur);

*/
//this.uti=UserSession.getInstance(c1).getUser();
  


FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/valider.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(UtilisateurInscription.class.getName()).log(Level.SEVERE,null,ex);
        
        }
        ValiderController display=loader.getController();
        display.setUN(c1, valeur);
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.showAndWait();
      
  //  c1=new Utilisateur();
      //  }
       
    


/* 
       
        java.sql.Date daten=java.sql.Date.valueOf(dateNais.getValue());
 
       
         */ 
        /*else{
        
        
        
        
        
        
        
        
        
        
Path source=Paths.get(this.path.getText());
Path destination= Paths.get("C:\\wamp64\\www\\image_pdf\\"+this.username.getText()+"_ image.png");
       String rp = destination.toString().replace("\\","/");
        System.out.println(rp);
Files.copy(source, destination,StandardCopyOption.REPLACE_EXISTING);
        System.out.println("*******************************");
        
           RadioButton button = (RadioButton) sexe.getSelectedToggle();
        System.out.println("*******************************");
*/    

//Utilisateur c1=new Utilisateur(this.username.getText(),email.getText(),pwd1.getText(),rp,Nom.getText(),Prenom.getText(),villeBox.getValue(),daten,Adr.getText(),codeposta,button.getText(),teli,ci);

 //  Utilisateur c=new Utilisateur(fName.getText(), email.getText(), pwd1.getText(),rp, fName.getText(), lName.getText(), fName.getText(),d,fName.getText(), 0,"homme", Integer.valueOf(pNumber.getText()), Integer.valueOf(pNumber.getText()));
  //       UtilisateurService s=new UtilisateurService();

    //   s.ajouterUtilisateur(c1);
    }
}
}
    


