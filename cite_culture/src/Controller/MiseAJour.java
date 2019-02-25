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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utilitaire.ControlesaisieJ;
import utilitaire.Upload;
import utilitaire.UploadFile;
import utilitaire.UserSession;

/**
 * FXML Controller class
 *
 * @author hatem
 */
public class MiseAJour implements Initializable {

    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField Adr;
    @FXML
    private JFXTextField pNumber;
    @FXML
    private JFXPasswordField ancienpwd;
    @FXML
    private JFXButton updateBtn;
    @FXML
    private ChoiceBox<String> villeBox;
    @FXML
    private JFXTextField codep;
    @FXML
    private JFXPasswordField pwd2;
    @FXML
    private JFXTextField path;
    @FXML
    private JFXPasswordField pwd1;
    @FXML
    private ImageView image;
    @FXML
    private JFXButton SuppBtn;
    Utilisateur u= new Utilisateur();
        ObservableList<String> ListVille = FXCollections.observableArrayList("Tunis","Sfax","Sousse","Kairouan","Bizerte","Gabès","La Soukra","Ariana","Sidi Hassine","El Mourouj","Gafsa","Raoued","Monastir","La Marsa","Ben Arous","Kasserine ","Douar Hicher","Djerba - Houmt Souk","Le Kram","Hammamet","Zarzis","Le Bardo","Médenine","Nabeul","Tataouine","Ben Gardane","Djerba - Midoun ","Béja","M'saken","Radès","Oued Ellil","Moknine","Le Kef","Menzel Bourguiba","Kalâa Kebira ","Sakiet Ezzit ","Mahdia ","Jemmal ","Ksar Hellal ","Sidi Bouzid ","Kélibia ","Sakiet Eddaïer ","La Goulette ","Jendouba ","El Aïn ","Hammam Sousse ","Hammam Lif ","Dar Chaâbane ","El Hamma","Gremda ","Bou Mhel el-Bassatine ","Menzel Temime ","Korba ","Métlaoui ","Soliman ","Téboulba ","Tozeur ","Ezzahra ","Kalâa Seghira ","Mateur ","El Ksar ","Thyna ","La Manouba ","Hammam Chott ","Siliana ","Douz ","Mornag ","Fériana ","Ksour Essef ","Djedeida ","Ras Jebel ","Ghannouch ","Tebourba ","Akouda ","Mégrine ","Den Den ","Chihia ","Redeyef ","Sbeïtla ","Grombalia ","Djerba - Ajim ","El Fahs ","Menzel Jemil ","Chebba ","Takelsa ","Ouerdanine ","Nefta ","Medjez el-Bab ","Bou Salem ","Béni Khiar ","Moularès ","El Jem ","Tinja ","Zaghouan ","Zaouiet Sousse ","Kébili ","Mornaguia ","Tabarka ","Ghardimaou ","Menzel Abderrahmane ","Sahline Moôtmar ","Souk Lahad ","Menzel Bouzelfa ","El Alia ","Thala ","Kalâat el-Andalous ","Bekalta ","Tajerouine ","Ezzouhour ","Carthage ","Zéramdine ","Bembla ","Mahrès ","Kerkennah ","Béni Khalled ","Chenini Nahal ","Meknassy ","Bennane-Bodheur ","El Guettar ","Makthar ","Testour ","Bou Arada ","Ksibet el-Médiouni ","Dahmani ","Sayada","Menzel Hayet","Messaadine"," Mdhilla"," Le Sers"," Bou Argoub"," Skhira"," Téboursouk"," Zriba"," Menzel Ennour"," Mareth"," Ksibet Thrayet"," Agareb"," Regueb"," Sidi Thabet"," Khniss"," Enfida"," Rejiche"," Métouia"," Hajeb El Ayoun"," Gaâfour"," Sidi Bou Ali"," Oudhref"," Bouficha"," Metline"," Raf Raf"," Jérissa"," Aïn Draham"," Ghomrassen"," Sened"," El Haouaria"," Tazarka"," Sidi Ali Ben Aoun"," Hammam Ghezèze"," Oueslatia"," Beni Hassen"," Khalidia"," Menzel Kamel"," Haffouz"," Sidi Ameur"," Bir Mcherga"," Kalaat Senan"," Amiret Hajjaj"," El Maâmoura"," Sbikha"," Bir Lahmar"," El Golâa"," Degache"," Zaouiet Djedidi"," El Krib"," Bou Hajla"," El Maâgoula"," Foussana"," El Hencha"," Nadhour"," Nouvelle Matmata"," Sidi Alouane"," Kerker"," Hergla"," El Bradâa"," Mezzouna"," Nefza"," Touza"," Jemna"," Jebiniana"," Menzel Bouzaiane"," Somâa"," Thélepte"," Zaouiet Kontoch"," Melloulèche"," Borj El Amri"," Sbiba"," Bir El Hafey"," Majel Bel Abbès"," El Batan"," El Hamma du Jérid"," Sakiet Sidi Youssef"," Remada"," Amiret Touazra"," Bouhjar"," Sidi Bou Saïd"," El Ksour"," Jilma"," Lamta"," Chorbane"," Sejnane"," Zarat"," Essouassi"," Ghar El Melh"," Djebel Oust"," Amiret El Fhoul"," Menzel Horr"," Amdoun"," Aousja"," Ouled Chamekh"," El Ghnada"," Azmour"," Nasrallah"," Bargou"," Bir Ali Ben Khalifa"," El Masdour"," Rouhia"," Dar Allouch"," Sidi Bennour"," Cherahil"," Jedelienne"," Bou Merdes"," Dehiba"," El Mida"," Goubellat"," Menzel Mehiri"," Fernana"," Kondar"," Menzel Fersi"," Korbous"," Haïdra"," Cebbala Ouled Asker"," Nebeur"," El Alâa"," Sidi Bou Rouis"," Graïba"," Hebira"," Sidi Makhlouf"," Beni Khedache"," Chebika","El Aroussa","Sidi El Hani"," Kesra"," Kalâat Khasba"," Ouchtata"," Slouguia"," Sidi Ismail"," Ouled Haffouz"," Oued Meliz"," Tamerza"," Menzel Chaker"," Touiref"," Matmata"," Menzel Salem"," Aïn Djeloula"," Echrarda","Beni M'Tir","Aachech"," Al Ahouaz-El Assouda"," Belkhir","Bouchemma"," El Amra"," El Ayoun","Ennasr","Ezzouhour"," Essaïda","Faouar","Fouchana ","Ghezala ","Hadjeb","Hassi El Ferid ","Hazeg Ellouza ","Hazoua ","Hkaima ","Joumine ","Lela ","Menzel El Habib ","Mohamedia ","Mnihla ","Nadhour Sidi Ali Ben Abed ","Ouabed Khazanet ","Rjim Maatoug ","Saouaf ","Sidi Aïch ","Sidi Zid ","Smâr ","Souk Jedid ","Teboulbou ","Thibar ","Tlelsa ","Utique ","Zarzis Nord ","Zelba");
    @FXML
    private Label LEmail;
    @FXML
    private Label LAdr;
    @FXML
    private Label LCodeP;
    @FXML
    private Label LTel;
    @FXML
    private Label LMdp1;
    @FXML
    private Label LMdp2;
    @FXML
    private Label LNvMdp;
    @FXML
    private JFXButton Decoonection;
boolean imageverif=false;
String ancienneimage=null;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // try {
            
    UserSession session=new UserSession();
    
            u=session.getUser();
              this.path.setText(u.getImage());
//            this.pNumber.setText(Integer.toString(c.getTelephone()));
            
            ancienneimage=this.path.getText();

            String imageSource = "C:/wamp64/"+u.getImage();
            System.out.println("9999999999999999999999999999");
            System.out.println((imageSource));
                       System.out.println("9999999999999999999999999999999");

            Image image1 = new Image(new File(imageSource).toURI().toString());
            
            image.setImage(image1);
            
            pNumber.setText(Integer.toString(u.getTelephone()));
            email.setText(u.getEmail());
            villeBox.setValue(u.getVille());
            villeBox.setItems(ListVille);
            Adr.setText(u.getAdresse());

            codep.setText(Integer.toString(u.getCode_postal()));
            username.setText(u.getUsername());
     /*   } catch (ClassNotFoundException ex) {
            Logger.getLogger(MiseAJour.class.getName()).log(Level.SEVERE, null, ex);
        }
   */ }    

    @FXML
    private void Update(ActionEvent event) throws IOException, ClassNotFoundException, Exception {
                ControlesaisieJ cn=new ControlesaisieJ();
                     UtilisateurService us=new UtilisateurService();

       int v=0;
        if (!email.getText().equals("") && cn.mailformat(email.getText())){
               if(us.verifEmailUpdate(email.getText(),u.getUsername())){
                
                this.LEmail.setText("");
                 
                                  v++;}
               else{
                   this.LEmail.setText("Email deja Utilisé");

               }

         }else {
             
             this.LEmail.setText("* Email erroné");

         }
        
            if (!Adr.getText().equals("") && cn.testAdr(Adr.getText())){
                 this.LAdr.setText("");
                
                                  v++;

         }else {
             
             this.LAdr.setText("* Adresse erroné");

         }
            
            
                  
    if (cn.Poste(codep.getText())){
        this.LCodeP.setText("");
                         v++;

    }else
    {
                 this.LCodeP.setText("* Code Postale erroné");

    }
//***************************************************************
   if (cn.GSM(pNumber.getText())){
        this.LTel.setText("");
                         v++;

    }else
    {
                 this.LTel.setText("* Numero erroné");

    }
   
   
   //***************************************************************

     if (cn.testpassword(pwd1.getText()) || pwd1.getText().equals(""))
{
    this.LMdp1.setText("");
                     v++;

}else{
this.LMdp1.setText("* Mot de passe doit contenir 8 caratcter minimum");
}

if(pwd1.getText().equals(pwd2.getText())){
    this.LMdp2.setText("");
                 v++;

}    else{
           this.LMdp1.setText("* Reverifier votre mot de passe");
 
            }
   //***************************************************************
   
   
   
   if (!(ancienneimage.equals(this.path.getText()))){
        this.imageverif=true;
   }
   
   
if (us.verfierMotDePasse(this.ancienpwd.getText(),this.username.getText())|| (this.ancienpwd.getText().equals("")&& pwd1.getText().equals("")) ){

this.LNvMdp.setText("");
                     v++;

}else{
this.LNvMdp.setText("Mot de passe incorrecte");

}
        if (v==7){
            if (imageverif==true){
        File f=new File(this.path.getText());
        
  UploadFile up=new UploadFile();
   //     String lien =;
          //String LienIm = lien.replace("\\","/");
        u.setImage(up.upload(f.getAbsolutePath()));

//Upload up=new Upload();
      //  u.setImage(up.upload(f,u.getUsername()));

        if (this.pwd1.getText().trim().isEmpty()){
            us.updateUtilisateur(this.username.getText(),this.email.getText(),Integer.valueOf(this.pNumber.getText()),this.villeBox.getValue(),this.Adr.getText(),Integer.valueOf(this.codep.getText()),"",u.getImage());
        }else
        {
            us.updateUtilisateur(this.username.getText(),this.email.getText(),Integer.valueOf(this.pNumber.getText()),this.villeBox.getValue(),this.Adr.getText(),Integer.valueOf(this.codep.getText()),this.pwd1.getText(),u.getImage());
        }
    }else{
                /*****************/
                
                  if (this.pwd1.getText().trim().isEmpty()){
            us.updateUtilisateurSansImage(this.username.getText(),this.email.getText(),Integer.valueOf(this.pNumber.getText()),this.villeBox.getValue(),this.Adr.getText(),Integer.valueOf(this.codep.getText()),"");
        }else
        {
            us.updateUtilisateurSansImage(this.username.getText(),this.email.getText(),Integer.valueOf(this.pNumber.getText()),this.villeBox.getValue(),this.Adr.getText(),Integer.valueOf(this.codep.getText()),this.pwd1.getText());
        }
                
                /****************/
                
            }}
        else{
        
            System.out.println("famma mochkla");
        }}

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
               
                                    UtilisateurService us=new UtilisateurService();

            us.SupprimerCompteUtilisateur(username.getText());
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

    @FXML
    private void DecoonectionAct(ActionEvent event) throws ClassNotFoundException {
    //    System.out.println(UserSession.getInstance(new Utilisateur()).getUser().getUsername());

    UserSession session=new UserSession();
    session.resetUser();
//        UserSession.clear();
  //      System.err.println(UserSession.getInstance(new Utilisateur()).getUser().getUsername());
        

FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/connection.fxml"));
        try{
        loader.load();
        }catch (IOException ex){
        Logger.getLogger(UtilisateurInscription.class.getName()).log(Level.SEVERE,null,ex);
        
        }
      
                Parent p =loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
    }

    }

    

