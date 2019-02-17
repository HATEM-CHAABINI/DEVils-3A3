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
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.scene.image.Image;

import javafx.scene.image.ImageViewBuilder;
import javafx.  scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hatem
 */
public class ImageController implements Initializable {
    ObservableList<String> ListVille = FXCollections.observableArrayList("Tunis","Sfax","Sousse","Kairouan","Bizerte","Gabès","La Soukra","Ariana","Sidi Hassine","El Mourouj","Gafsa","Raoued","Monastir","La Marsa","Ben Arous","Kasserine ","Douar Hicher","Djerba - Houmt Souk","Le Kram","Hammamet","Zarzis","Le Bardo","Médenine","Nabeul","Tataouine","Ben Gardane","Djerba - Midoun ","Béja","M'saken","Radès","Oued Ellil","Moknine","Le Kef","Menzel Bourguiba","Kalâa Kebira ","Sakiet Ezzit ","Mahdia ","Jemmal ","Ksar Hellal ","Sidi Bouzid ","Kélibia ","Sakiet Eddaïer ","La Goulette ","Jendouba ","El Aïn ","Hammam Sousse ","Hammam Lif ","Dar Chaâbane ","El Hamma","Gremda ","Bou Mhel el-Bassatine ","Menzel Temime ","Korba ","Métlaoui ","Soliman ","Téboulba ","Tozeur ","Ezzahra ","Kalâa Seghira ","Mateur ","El Ksar ","Thyna ","La Manouba ","Hammam Chott ","Siliana ","Douz ","Mornag ","Fériana ","Ksour Essef ","Djedeida ","Ras Jebel ","Ghannouch ","Tebourba ","Akouda ","Mégrine ","Den Den ","Chihia ","Redeyef ","Sbeïtla ","Grombalia ","Djerba - Ajim ","El Fahs ","Menzel Jemil ","Chebba ","Takelsa ","Ouerdanine ","Nefta ","Medjez el-Bab ","Bou Salem ","Béni Khiar ","Moularès ","El Jem ","Tinja ","Zaghouan ","Zaouiet Sousse ","Kébili ","Mornaguia ","Tabarka ","Ghardimaou ","Menzel Abderrahmane ","Sahline Moôtmar ","Souk Lahad ","Menzel Bouzelfa ","El Alia ","Thala ","Kalâat el-Andalous ","Bekalta ","Tajerouine ","Ezzouhour ","Carthage ","Zéramdine ","Bembla ","Mahrès ","Kerkennah ","Béni Khalled ","Chenini Nahal ","Meknassy ","Bennane-Bodheur ","El Guettar ","Makthar ","Testour ","Bou Arada ","Ksibet el-Médiouni ","Dahmani ","Sayada","Menzel Hayet","Messaadine"," Mdhilla"," Le Sers"," Bou Argoub"," Skhira"," Téboursouk"," Zriba"," Menzel Ennour"," Mareth"," Ksibet Thrayet"," Agareb"," Regueb"," Sidi Thabet"," Khniss"," Enfida"," Rejiche"," Métouia"," Hajeb El Ayoun"," Gaâfour"," Sidi Bou Ali"," Oudhref"," Bouficha"," Metline"," Raf Raf"," Jérissa"," Aïn Draham"," Ghomrassen"," Sened"," El Haouaria"," Tazarka"," Sidi Ali Ben Aoun"," Hammam Ghezèze"," Oueslatia"," Beni Hassen"," Khalidia"," Menzel Kamel"," Haffouz"," Sidi Ameur"," Bir Mcherga"," Kalaat Senan"," Amiret Hajjaj"," El Maâmoura"," Sbikha"," Bir Lahmar"," El Golâa"," Degache"," Zaouiet Djedidi"," El Krib"," Bou Hajla"," El Maâgoula"," Foussana"," El Hencha"," Nadhour"," Nouvelle Matmata"," Sidi Alouane"," Kerker"," Hergla"," El Bradâa"," Mezzouna"," Nefza"," Touza"," Jemna"," Jebiniana"," Menzel Bouzaiane"," Somâa"," Thélepte"," Zaouiet Kontoch"," Melloulèche"," Borj El Amri"," Sbiba"," Bir El Hafey"," Majel Bel Abbès"," El Batan"," El Hamma du Jérid"," Sakiet Sidi Youssef"," Remada"," Amiret Touazra"," Bouhjar"," Sidi Bou Saïd"," El Ksour"," Jilma"," Lamta"," Chorbane"," Sejnane"," Zarat"," Essouassi"," Ghar El Melh"," Djebel Oust"," Amiret El Fhoul"," Menzel Horr"," Amdoun"," Aousja"," Ouled Chamekh"," El Ghnada"," Azmour"," Nasrallah"," Bargou"," Bir Ali Ben Khalifa"," El Masdour"," Rouhia"," Dar Allouch"," Sidi Bennour"," Cherahil"," Jedelienne"," Bou Merdes"," Dehiba"," El Mida"," Goubellat"," Menzel Mehiri"," Fernana"," Kondar"," Menzel Fersi"," Korbous"," Haïdra"," Cebbala Ouled Asker"," Nebeur"," El Alâa"," Sidi Bou Rouis"," Graïba"," Hebira"," Sidi Makhlouf"," Beni Khedache"," Chebika","El Aroussa","Sidi El Hani"," Kesra"," Kalâat Khasba"," Ouchtata"," Slouguia"," Sidi Ismail"," Ouled Haffouz"," Oued Meliz"," Tamerza"," Menzel Chaker"," Touiref"," Matmata"," Menzel Salem"," Aïn Djeloula"," Echrarda","Beni M'Tir","Aachech"," Al Ahouaz-El Assouda"," Belkhir","Bouchemma"," El Amra"," El Ayoun","Ennasr","Ezzouhour"," Essaïda","Faouar","Fouchana ","Ghezala ","Hadjeb","Hassi El Ferid ","Hazeg Ellouza ","Hazoua ","Hkaima ","Joumine ","Lela ","Menzel El Habib ","Mohamedia ","Mnihla ","Nadhour Sidi Ali Ben Abed ","Ouabed Khazanet ","Rjim Maatoug ","Saouaf ","Sidi Aïch ","Sidi Zid ","Smâr ","Souk Jedid ","Teboulbou ","Thibar ","Tlelsa ","Utique ","Zarzis Nord ","Zelba");

    @FXML
    private ImageView image;
    @FXML
    private JFXTextField pNumber;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField pwd1;
    @FXML
    private JFXPasswordField pwd2;
    @FXML
    private JFXButton updateBtn;
    @FXML
    private JFXTextField path;
    @FXML
    private ChoiceBox<String> villeBox;
    @FXML
    private JFXTextField Adr;
    @FXML
    private JFXTextField codep;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXButton SuppBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            UtilisateurService s=new UtilisateurService();
            int i=0;
            Utilisateur c=s.rechercheUtilisateurParCin(892);
//            String telo= Integer.toString(i);
      this.path.setText(c.getImage());
//            this.pNumber.setText(Integer.toString(c.getTelephone()));
            
            String imageSource = c.getImage();
            Image image1 = new Image(new File(imageSource).toURI().toString());
            
            image.setImage(image1);
            
            pNumber.setText(Integer.toString(c.getTelephone()));
            email.setText(c.getEmail());
            villeBox.setValue(c.getVille());
            villeBox.setItems(ListVille);
            Adr.setText(c.getAdresse());

            codep.setText(Integer.toString(c.getCode_postal()));
            username.setText(c.getUsername());
//            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void Update(ActionEvent event) throws IOException, ClassNotFoundException {
        
        
Path source=Paths.get(this.path.getText());
Path destination= Paths.get("C:\\wamp64\\www\\image_pdf\\"+this.username.getText()+"_ image.png");
       String rp = destination.toString().replace("\\","/");
        System.out.println(rp);
Files.copy(source, destination,StandardCopyOption.REPLACE_EXISTING);
            UtilisateurService s=new UtilisateurService();

        if (this.pwd1.getText().trim().isEmpty()){
            s.updateUtilisateur(this.username.getText(),this.email.getText(),Integer.valueOf(this.pNumber.getText()),this.villeBox.getValue(),this.Adr.getText(),Integer.valueOf(this.codep.getText()),"",rp);
        }else
        {
            s.updateUtilisateur(this.username.getText(),this.email.getText(),Integer.valueOf(this.pNumber.getText()),this.villeBox.getValue(),this.Adr.getText(),Integer.valueOf(this.codep.getText()),this.pwd1.getText(),rp);
        }
    }

    @FXML
    private void joinde(MouseEvent event) {
          System.out.println("aaaaaaaaaa");
    FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);

		if (selectedFile != null) {

			this.path.setText(selectedFile.getAbsolutePath());}  
                    String imageSource = this.path.getText();
            Image image1 = new Image(new File(imageSource).toURI().toString());
            
            image.setImage(image1);
            
                
    }

    @FXML
    private void Delete(ActionEvent event) throws ClassNotFoundException {
        try {
            UtilisateurService s=new UtilisateurService();
            s.SupprimerCompteUtilisateur(username.getText());
//            Stage stage = (Stage) SuppBtn.getScene().getWindow();
//            // do what you have to do
//            stage.close();
//            
           













FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/inscription.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOpacity(1);
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 650, 500));
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            
            stage.show();
            
            
            
            
                Label secondLabel = new Label("Element supprimer");
 
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
 
                Scene secondScene = new Scene(secondaryLayout, 230, 100);
 
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Second Stage");
                newWindow.setScene(secondScene);
 
                // Set position of second window, related to primary window.
        
                newWindow.show();

        } catch (IOException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    }

    

