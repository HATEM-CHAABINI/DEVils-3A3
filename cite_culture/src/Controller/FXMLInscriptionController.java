/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;
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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;

/**
 *
 * @author hatem
 */
public class FXMLInscriptionController implements Initializable{
    ObservableList<String> ListVille = FXCollections.observableArrayList("Tunis","Sfax","Sousse","Kairouan","Bizerte","Gabès","La Soukra","Ariana","Sidi Hassine","El Mourouj","Gafsa","Raoued","Monastir","La Marsa","Ben Arous","Kasserine ","Douar Hicher","Djerba - Houmt Souk","Le Kram","Hammamet","Zarzis","Le Bardo","Médenine","Nabeul","Tataouine","Ben Gardane","Djerba - Midoun ","Béja","M'saken","Radès","Oued Ellil","Moknine","Le Kef","Menzel Bourguiba","Kalâa Kebira ","Sakiet Ezzit ","Mahdia ","Jemmal ","Ksar Hellal ","Sidi Bouzid ","Kélibia ","Sakiet Eddaïer ","La Goulette ","Jendouba ","El Aïn ","Hammam Sousse ","Hammam Lif ","Dar Chaâbane ","El Hamma","Gremda ","Bou Mhel el-Bassatine ","Menzel Temime ","Korba ","Métlaoui ","Soliman ","Téboulba ","Tozeur ","Ezzahra ","Kalâa Seghira ","Mateur ","El Ksar ","Thyna ","La Manouba ","Hammam Chott ","Siliana ","Douz ","Mornag ","Fériana ","Ksour Essef ","Djedeida ","Ras Jebel ","Ghannouch ","Tebourba ","Akouda ","Mégrine ","Den Den ","Chihia ","Redeyef ","Sbeïtla ","Grombalia ","Djerba - Ajim ","El Fahs ","Menzel Jemil ","Chebba ","Takelsa ","Ouerdanine ","Nefta ","Medjez el-Bab ","Bou Salem ","Béni Khiar ","Moularès ","El Jem ","Tinja ","Zaghouan ","Zaouiet Sousse ","Kébili ","Mornaguia ","Tabarka ","Ghardimaou ","Menzel Abderrahmane ","Sahline Moôtmar ","Souk Lahad ","Menzel Bouzelfa ","El Alia ","Thala ","Kalâat el-Andalous ","Bekalta ","Tajerouine ","Ezzouhour ","Carthage ","Zéramdine ","Bembla ","Mahrès ","Kerkennah ","Béni Khalled ","Chenini Nahal ","Meknassy ","Bennane-Bodheur ","El Guettar ","Makthar ","Testour ","Bou Arada ","Ksibet el-Médiouni ","Dahmani ","Sayada","Menzel Hayet","Messaadine"," Mdhilla"," Le Sers"," Bou Argoub"," Skhira"," Téboursouk"," Zriba"," Menzel Ennour"," Mareth"," Ksibet Thrayet"," Agareb"," Regueb"," Sidi Thabet"," Khniss"," Enfida"," Rejiche"," Métouia"," Hajeb El Ayoun"," Gaâfour"," Sidi Bou Ali"," Oudhref"," Bouficha"," Metline"," Raf Raf"," Jérissa"," Aïn Draham"," Ghomrassen"," Sened"," El Haouaria"," Tazarka"," Sidi Ali Ben Aoun"," Hammam Ghezèze"," Oueslatia"," Beni Hassen"," Khalidia"," Menzel Kamel"," Haffouz"," Sidi Ameur"," Bir Mcherga"," Kalaat Senan"," Amiret Hajjaj"," El Maâmoura"," Sbikha"," Bir Lahmar"," El Golâa"," Degache"," Zaouiet Djedidi"," El Krib"," Bou Hajla"," El Maâgoula"," Foussana"," El Hencha"," Nadhour"," Nouvelle Matmata"," Sidi Alouane"," Kerker"," Hergla"," El Bradâa"," Mezzouna"," Nefza"," Touza"," Jemna"," Jebiniana"," Menzel Bouzaiane"," Somâa"," Thélepte"," Zaouiet Kontoch"," Melloulèche"," Borj El Amri"," Sbiba"," Bir El Hafey"," Majel Bel Abbès"," El Batan"," El Hamma du Jérid"," Sakiet Sidi Youssef"," Remada"," Amiret Touazra"," Bouhjar"," Sidi Bou Saïd"," El Ksour"," Jilma"," Lamta"," Chorbane"," Sejnane"," Zarat"," Essouassi"," Ghar El Melh"," Djebel Oust"," Amiret El Fhoul"," Menzel Horr"," Amdoun"," Aousja"," Ouled Chamekh"," El Ghnada"," Azmour"," Nasrallah"," Bargou"," Bir Ali Ben Khalifa"," El Masdour"," Rouhia"," Dar Allouch"," Sidi Bennour"," Cherahil"," Jedelienne"," Bou Merdes"," Dehiba"," El Mida"," Goubellat"," Menzel Mehiri"," Fernana"," Kondar"," Menzel Fersi"," Korbous"," Haïdra"," Cebbala Ouled Asker"," Nebeur"," El Alâa"," Sidi Bou Rouis"," Graïba"," Hebira"," Sidi Makhlouf"," Beni Khedache"," Chebika","El Aroussa","Sidi El Hani"," Kesra"," Kalâat Khasba"," Ouchtata"," Slouguia"," Sidi Ismail"," Ouled Haffouz"," Oued Meliz"," Tamerza"," Menzel Chaker"," Touiref"," Matmata"," Menzel Salem"," Aïn Djeloula"," Echrarda","Beni M'Tir","Aachech"," Al Ahouaz-El Assouda"," Belkhir","Bouchemma"," El Amra"," El Ayoun","Ennasr","Ezzouhour"," Essaïda","Faouar","Fouchana ","Ghezala ","Hadjeb","Hassi El Ferid ","Hazeg Ellouza ","Hazoua ","Hkaima ","Joumine ","Lela ","Menzel El Habib ","Mohamedia ","Mnihla ","Nadhour Sidi Ali Ben Abed ","Ouabed Khazanet ","Rjim Maatoug ","Saouaf ","Sidi Aïch ","Sidi Zid ","Smâr ","Souk Jedid ","Teboulbou ","Thibar ","Tlelsa ","Utique ","Zarzis Nord ","Zelba");
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
    @FXML
    private JFXTextField path;
    @FXML
    private JFXButton joindrebtn;
    @FXML
    private JFXTextField Nom;
    @FXML
    private JFXTextField Prenom;
    @FXML
    private JFXTextField username;
    @FXML
    private ChoiceBox<String> villeBox;
    @FXML
    private JFXTextField Adr;
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
    private DatePicker dateNais;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        try {
//            UtilisateurService s=new UtilisateurService();
//            int i=0;
//            Utilisateur c=s.rechercheUtilisateurParCin(22);
//            
            villeBox.setValue("Tunis");
            villeBox.setItems(ListVille);
////                      
////Date date=c.getDate_naissance();
////Calendar calendar = new GregorianCalendar();
////calendar.setTime(date);
////         dateNais.setValue(LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH)));
////            System.out.println(calendar.get(Calendar.YEAR));
////            System.out.println(calendar.get(Calendar.MONTH)+1);
////            System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
////        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(FXMLInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    @FXML
//    public void initialize(URL url, ResourceBundle rb) {
//                System.out.println("You mjjje!");
//
//        villeBox.setValue("Tunis");
//        villeBox.setItems(ListVille);
//    }
    }
    @FXML
    private void registerEmployee(ActionEvent event) throws NoSuchAlgorithmException, ClassNotFoundException, IOException {
        System.out.println("You uvijinddddnvddddddddddddddddddddddddddddu me!");
       // Date d=new Date(2018, 4, 7);
        java.sql.Date daten=java.sql.Date.valueOf(dateNais.getValue());
        int codeposta=Integer.valueOf(this.codep.getText());
        int teli=Integer.valueOf(this.pNumber.getText());
        int ci=Integer.valueOf(this.cin.getText());
        
        
Path source=Paths.get(this.path.getText());
Path destination= Paths.get("C:\\wamp64\\www\\image_pdf\\"+this.username.getText()+"_ image.png");
       String rp = destination.toString().replace("\\","/");
        System.out.println(rp);
Files.copy(source, destination,StandardCopyOption.REPLACE_EXISTING);
        System.out.println("*******************************");
        
           RadioButton button = (RadioButton) sexe.getSelectedToggle();
        System.out.println("*******************************");
    Utilisateur c1=new Utilisateur(this.username.getText(),email.getText(),pwd1.getText(),rp,Nom.getText(),Prenom.getText(),villeBox.getValue(),daten,Adr.getText(),codeposta,button.getText(),teli,ci);

 //       Utilisateur c=new Utilisateur(fName.getText(), email.getText(), pwd1.getText(),rp, fName.getText(), lName.getText(), fName.getText(),d,fName.getText(), 0,"homme", Integer.valueOf(pNumber.getText()), Integer.valueOf(pNumber.getText()));
         UtilisateurService s=new UtilisateurService();

       s.ajouterUtilisateur(c1);
    }   

    @FXML
    private void joinde(ActionEvent event) throws IOException {
        
        FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);

		if (selectedFile != null) {

			this.path.setText(selectedFile.getAbsolutePath());
//                        
//Path source=Paths.get(selectedFile.getAbsolutePath());
//Path destination= Paths.get("C:\\wamp64\\www\\image_pdf\\"+fName+"_"+selectedFile.getName());
////                    
////String s=destination.toString();
////                    System.out.println(s);
////System.out.println(s.indexOf("\\"));                    
////String rp = s.replace("\\","/");
////                    System.out.println(rp);
////String dp=rp.replace("/", "\\");
////                    System.out.println(dp);
////                   
//                    
////copie
//Files.copy(source, destination,StandardCopyOption.REPLACE_EXISTING);


    }
}

}
