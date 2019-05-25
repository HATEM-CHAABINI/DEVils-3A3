/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.gui;

import PIMobile.Entite.Livre;
import PIMobile.Entite.Location;
import PIMobile.Entite.Utilisateur;
import PIMobile.Entite.commentaire_livre;
import PIMobile.Service.ServiceLivre;
import PIMobile.Service.UserSession;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import static com.codename1.ui.events.ActionEvent.Type.Response;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.DefaultLookAndFeel;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.TableLayout;
import com.codename1.util.Base64;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hatem
 */
public class GuiLivre {
       Button btn_Afficher;
int idLivre=0;
    Form Form_Gui_Hote;
UserSession session=new UserSession();
        Utilisateur usercon=session.getUser();

    Boolean VerifHoteParticipant = false;

    int verifier_PLace_User = 0;
private List <String> GrosMots=new ArrayList<>();

    ServiceLivre sh = new ServiceLivre();
    int deviceWidth = Display.getInstance().getDisplayWidth();
    Image placeholder = Image.createImage(deviceWidth, deviceWidth, 0xd80000); //square image set to 10% of screen width
    EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
    Image placeholder1 = Image.createImage(deviceWidth, deviceWidth, 0xd80000); //square image set to 10% of screen width
    EncodedImage encImage1 = EncodedImage.createFromImage(placeholder1, false);

    public Form getForm_Gui_Hote() {
        return Form_Gui_Hote;
    }
     
    protected boolean isCurrentInbox() {
        return false;
    }
    
    protected boolean isCurrentTrending() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
    public GuiLivre(){
            this(com.codename1.ui.util.Resources.getGlobalResources());

    }
    public GuiLivre(com.codename1.ui.util.Resources res)  {

 Image selection = res.getImage("selection-in-sidemenu.png");
        
        Image inboxImage = null;
        if(isCurrentInbox()) inboxImage = selection;

        Image trendingImage = null;
        if(isCurrentTrending()) trendingImage = selection;
        
        Image calendarImage = null;
        if(isCurrentCalendar()) calendarImage = selection;
        
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
           Image BibImage=null;
        if(isCurrentStats()) BibImage = selection;

        VerifHoteParticipant = false;
        Form_Gui_Hote = new Form();   
                Form_Gui_Hote.removeAll();

        Form_Gui_Hote.getToolbar().addCommandToSideMenu("Calendar", calendarImage, e -> new CalendarForm(res).show());
Form_Gui_Hote.getToolbar().addCommandToSideMenu("Map", null, e -> {});
        Form_Gui_Hote.getToolbar().addCommandToSideMenu("Trending", trendingImage, e -> new TrendingForm(res).show());
        Form_Gui_Hote.getToolbar().addCommandToSideMenu("Carte", null, e -> new CarteFAffiche().getF().show());
        Form_Gui_Hote.getToolbar().addCommandToSideMenu("Bibliotheque", BibImage, e -> new GuiLivre(res).getForm_Gui_Hote().show());
        Form_Gui_Hote.getToolbar().addCommandToSideMenu("Settings", null, e -> {});
        
        
        Form_Gui_Hote.getToolbar().addCommandToRightBar("Voir mes location", null, e->{
         ////////////////
         List<Location> cl=new ArrayList<>();
  System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                System.out.println(usercon.getUsername());
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            cl=sh.getListLocation(usercon.getUsername());
            System.out.println("sms");
            float prix=0;
            for (Location l:cl){
                prix=(float) (prix+l.getLivre().getPrix());
            }
         //   System.out.println(prix);
       //     System.out.println(cl.toString());
            String sms="Prix Total : "+prix+ " \nDescription : "+cl.toString();
            System.out.println(""+usercon.getTelephone());
            System.out.println(sms);           
            System.out.println("sms");

            Form ajouter = new Form(BoxLayout.y());
                           Button btnsms=new Button();
                           btnsms.addActionListener(l->{
                           String accountSID = "AC3b39728c9e45a651ef14c97e6a332e9b";
                    String authToken = "f9896294eefd6c393cdc46b017948330";
                    String fromPhone = "+12055486870";
                    String destinationPhone = "+216"+usercon.getTelephone();

                    Response<Map> SMS = Rest.post("https://api.twilio.com/2010-04-01/Accounts/" + accountSID + "/Messages.json").
                            queryParam("To", destinationPhone).
                            queryParam("From", fromPhone).
                            queryParam("Body",sms).
                            header("Authorization", "Basic " + Base64.encodeNoNewline((accountSID + ":" + authToken).getBytes())).
                            getAsJsonMap();
                           });
                           btnsms.setText("Envoie facture");
                           ajouter.add(btnsms);
ajouter.getToolbar().addCommandToLeftBar("Back", null, tl -> {
                             Dialog ipp = new InfiniteProgress().showInifiniteBlocking();

                GuiLivre gh = new GuiLivre();
                
                ipp.dispose();
                gh.getForm_Gui_Hote().showBack();

            }
            );


    Container propos = new Container(BoxLayout.y());
        for (Location c : cl) {
            Container cont=addLocation(c);
            Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);

            Style settingsStyle = cont.getAllStyles();
settingsStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
settingsStyle.setBgColor(0xffffff);
settingsStyle.setBgTransparency(255);
settingsStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
settingsStyle.setMargin(Component.BOTTOM, 3);
            
 //settingsStyle.setBorder(RoundRectBorder.create().color(ColorUtil.WHITE).shadowY(0.0f).shadowOpacity(127).rectangle(true));
            
            
       /*settingsStyle.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xffffff).
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));*/
    
            propos.add(cont);   
        }
           
        TextField Prix=new TextField();
       Prix.setText("Prix: "+prix);
       Prix.setEditable(false);
        ajouter.add(Prix);
ajouter.add(propos);
ajouter.show();
        });
Form_Gui_Hote.repaint();
Form_Gui_Hote.refreshTheme();
        
         ////////////////////
                         
           Container produtcs = new Container(BoxLayout.y());
        Form_Gui_Hote.removeAll();
        for (Livre h : sh.getList2()) {
            produtcs.add(addItems(h)); 
        }
                  
Button btn_Hote = new Button("Afficher Statistique");
        btn_Hote.addActionListener(e->{         
             Dialog ip = new InfiniteProgress().showInifiniteBlocking();
            StatLivre gh = new StatLivre();
            ip.dispose();
            gh.createPieChartForm().show();
        });
       Form_Gui_Hote.add(btn_Hote);
        Form_Gui_Hote.add(produtcs);
Form_Gui_Hote.repaint();
Form_Gui_Hote.refreshTheme();
        
        
        
    }
public Container addComm(commentaire_livre c){
        Image placeholders = Image.createImage(deviceWidth/6, deviceWidth/6, 0xd80000); //square image set to 10% of screen width
    EncodedImage encImages = EncodedImage.createFromImage(placeholders, false);
     Tabs t = new Tabs();
        t.hideTabs();
        Style s = UIManager.getInstance().getComponentStyle("Button");
        FontImage radioEmptyImage = FontImage.createMaterial(FontImage.MATERIAL_RADIO_BUTTON_UNCHECKED, s);
        FontImage radioFullImage = FontImage.createMaterial(FontImage.MATERIAL_RADIO_BUTTON_CHECKED, s);
        ((DefaultLookAndFeel) UIManager.getInstance().getLookAndFeel()).setRadioButtonImages(radioFullImage, radioEmptyImage, radioFullImage, radioEmptyImage);
       
        Container usern = new Container(BoxLayout.y());
        Container p = new Container(BoxLayout.x());
         System.out.println("aaa");
            URLImage urls = URLImage.createToStorage(encImages, c.getLocataire().getImage(), "http://localhost/front/web/uploads/images/"+ c.getLocataire().getImage());
            ImageViewer is = new ImageViewer(urls);
        p.add(BoxLayout.encloseY(is));
        Label username=new Label("   Username: "+c.getLocataire().getUsername());
        Style settingsStyle = username.getAllStyles();
settingsStyle.setFgColor(0x8235ef);
        usern.add(username);
       // p.add(usern);
        
               // p.add(new Label("\n"));
                p.add(new Label(c.getCommentaire()));

        Button btn_Details = new Button();
          btn_Details.setText("Supprimer");
if(c.getLocataire().getId()==usercon.getId()){
          p.add(btn_Details);}
          btn_Details.addActionListener(bt -> {
      sh.effacerCommentaire(c.getId());
      Dialog dlg = new Dialog("Bienvenue");
    Style dlgStyle = dlg.getDialogStyle();
    dlgStyle.setBorder(Border.createEmpty());
    dlgStyle.setBgTransparency(255);
    dlgStyle.setBgColor(0xffffff);

    Label title = dlg.getTitleComponent();
//    title.setIcon(finalDuke.scaledHeight(title.getPreferredH()));
    title.getUnselectedStyle().setFgColor(0xff);
    title.getUnselectedStyle().setAlignment(Component.LEFT);

    dlg.setLayout(BoxLayout.y());
    Label blueLabel = new Label();
    blueLabel.setShowEvenIfBlank(true);
    blueLabel.getUnselectedStyle().setBgColor(0xff);
    blueLabel.getUnselectedStyle().setPadding(1, 1, 1, 1);
    blueLabel.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
    dlg.add(blueLabel);
    TextArea ta = new TextArea("Votre commentaire a ete supprimer");
    ta.setEditable(false);
    ta.setUIID("DialogBody");
    ta.getAllStyles().setFgColor(0);
    dlg.add(ta);

    Label grayLabel = new Label();
    grayLabel.setShowEvenIfBlank(true);
    grayLabel.getUnselectedStyle().setBgColor(0xcccccc);
    grayLabel.getUnselectedStyle().setPadding(1, 1, 1, 1);
    grayLabel.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
    dlg.add(grayLabel);

    Button ok = new Button(new Command("OK"));
    ok.getAllStyles().setBorder(Border.createEmpty());
    ok.getAllStyles().setFgColor(0);
    dlg.add(ok);
    dlg.showDialog();
                     });
usern.add(p);
        //setFgColor(0x8235ef);
return usern;
}
    
public Container addLocation(Location l){
        Image placeholders = Image.createImage(deviceWidth/6, deviceWidth/6, 0xd80000); //square image set to 10% of screen width
    EncodedImage encImages = EncodedImage.createFromImage(placeholders, false);
     Tabs t = new Tabs();
        t.hideTabs();
        Style s = UIManager.getInstance().getComponentStyle("Button");
        FontImage radioEmptyImage = FontImage.createMaterial(FontImage.MATERIAL_RADIO_BUTTON_UNCHECKED, s);
        FontImage radioFullImage = FontImage.createMaterial(FontImage.MATERIAL_RADIO_BUTTON_CHECKED, s);
        ((DefaultLookAndFeel) UIManager.getInstance().getLookAndFeel()).setRadioButtonImages(radioFullImage, radioEmptyImage, radioFullImage, radioEmptyImage);
       
        Container usern = new Container(BoxLayout.y());
        Container p = new Container(BoxLayout.x());
         System.out.println("aaa");
         System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    System.out.println(l.getLivre().getImage());
         System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            URLImage urls = URLImage.createToStorage(encImages, l.getLivre().getImage(), "http://localhost/front/web/uploads/images/"+ l.getLivre().getImage());
            ImageViewer is = new ImageViewer(urls);
        p.add(BoxLayout.encloseY(is));
        Label username=new Label("   Titre: "+l.getLivre().getTitre());
        Style settingsStyle = username.getAllStyles();
settingsStyle.setFgColor(0x8235ef);
        usern.add(username);
       // p.add(usern);
        
               // p.add(new Label("\n"));
               SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy");

        String dateD="Location: "+sfd.format(l.getDate_location());
        
                p.add(new Label(dateD));
                
        Button btn_Details = new Button();
          btn_Details.setText("Annuler");
          p.add(btn_Details);
          btn_Details.addActionListener(bt -> {
                                   if(Dialog.show("Vous allez annuler location ", "livre: "+l.getLivre().getTitre(), "Oui", "Annuler")) {

              
              sh.AnnulerLocation(l.getId());
               Dialog ipp = new InfiniteProgress().showInifiniteBlocking();
                GuiLivre gh = new GuiLivre();
                ipp.dispose();
                gh.getForm_Gui_Hote().showBack();
                                   }
          
          });
usern.add(p);
        //setFgColor(0x8235ef);
return usern;
}
    

    public Container addItems(Livre h) {
        Tabs t = new Tabs();
        t.hideTabs();
        Style s = UIManager.getInstance().getComponentStyle("Button");
        FontImage radioEmptyImage = FontImage.createMaterial(FontImage.MATERIAL_RADIO_BUTTON_UNCHECKED, s);
        FontImage radioFullImage = FontImage.createMaterial(FontImage.MATERIAL_RADIO_BUTTON_CHECKED, s);
        ((DefaultLookAndFeel) UIManager.getInstance().getLookAndFeel()).setRadioButtonImages(radioFullImage, radioEmptyImage, radioFullImage, radioEmptyImage);

         
        Container img = new Container(BoxLayout.x());

        Label nom = new Label();


        Container p = new Container(BoxLayout.y());
            URLImage urls = URLImage.createToStorage(encImage, h.getImage(), "http://localhost/front/web/uploads/images/"+ h.getImage());
            ImageViewer is = new ImageViewer(urls);
        p.add(BoxLayout.encloseY(is));
        Label titrlabel=new Label(h.getTitre());
        titrlabel.setAlignment(titrlabel.CENTER);
        p.add(titrlabel);
        Button btn_Details = new Button();
        btn_Details.addActionListener(e -> {
                     idLivre=h.getId();               
                Form DetailsHote = new Form();
                         Dialog ip = new InfiniteProgress().showInifiniteBlocking();
            DetailsHote.getToolbar().addCommandToLeftBar("Back", null, tl -> {
                             Dialog ipp = new InfiniteProgress().showInifiniteBlocking();
                GuiLivre gh = new GuiLivre();
                ipp.dispose();
                gh.getForm_Gui_Hote().showBack();
            });
              DetailsHote.getToolbar().addCommandToRightBar("Ajouter un Commentaire", null, tl -> {
               Form ajouter = new Form(BoxLayout.y());
                 ajouter.getToolbar().addCommandToLeftBar("Back", null, tls -> {
                             Dialog ipp = new InfiniteProgress().showInifiniteBlocking();
                GuiLivre gh = new GuiLivre();
                ipp.dispose();
                gh.getForm_Gui_Hote().showBack();
            });
            int i = 0;
            
            TextComponent CommentaireTextField = new TextComponent().label("Description");           
         
            
            
           
            ajouter.add(CommentaireTextField);
            
            
            Button btn = new Button("Envoyer");

            
          btn.addActionListener(e2->{
                       Dialog ips = new InfiniteProgress().showInifiniteBlocking();
                       boolean verifgros=false;
                        GrosMots.add("BONJOUR");
            GrosMots.add("SALUT");
            String skoj="iih";
            String result = CommentaireTextField.getText().toUpperCase();
             
            for(String gros:GrosMots){
                if(result.contains(gros)){
                verifgros=true;
                break;
                }
            }
              System.out.println(verifgros);
            if(verifgros==false){
                                         if(Dialog.show("Vous allez Ajouter", "Commentaire: "+CommentaireTextField.getText(), "Oui", "Annuler")) {
sh.AjoutCommentaire(h.getId(),usercon.getId(), CommentaireTextField.getText());}}else{
                  Dialog dlg = new Dialog("Attention");
    Style dlgStyle = dlg.getDialogStyle();
    dlgStyle.setBorder(Border.createEmpty());
    dlgStyle.setBgTransparency(255);
    dlgStyle.setBgColor(0xffffff);

    Label title = dlg.getTitleComponent();
//    title.setIcon(finalDuke.scaledHeight(title.getPreferredH()));
    title.getUnselectedStyle().setFgColor(0xff);
    title.getUnselectedStyle().setAlignment(Component.LEFT);

    dlg.setLayout(BoxLayout.y());
    Label blueLabel = new Label();
    blueLabel.setShowEvenIfBlank(true);
    blueLabel.getUnselectedStyle().setBgColor(0xff);
    blueLabel.getUnselectedStyle().setPadding(1, 1, 1, 1);
    blueLabel.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
    dlg.add(blueLabel);
    TextArea ta = new TextArea("Votre Commentaire contient des gros mots");
    ta.setEditable(false);
    ta.setUIID("DialogBody");
    ta.getAllStyles().setFgColor(0);
    dlg.add(ta);

    Label grayLabel = new Label();
    grayLabel.setShowEvenIfBlank(true);
    grayLabel.getUnselectedStyle().setBgColor(0xcccccc);
    grayLabel.getUnselectedStyle().setPadding(1, 1, 1, 1);
    grayLabel.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
    dlg.add(grayLabel);

    Button ok = new Button(new Command("OK"));
    ok.getAllStyles().setBorder(Border.createEmpty());
    ok.getAllStyles().setFgColor(0);
    dlg.add(ok);
    dlg.showDialog();

            }
    //sh.AjoutProp(typeTextField.getText(), DescriptionTextField.getText(), titreTextField.getText());
          
              
            GuiLivre gh = new GuiLivre();
            ips.dispose();
           
            gh.Form_Gui_Hote.showBack();
            
        });
            ajouter.add(btn);
            
            
            
            ajouter.show();
            });
            DetailsHote.removeAll();
            Container ctn = new Container(BoxLayout.y());
            p.getParent().removeComponent(img);
            ctn.addComponent(img);
            p.getParent().removeComponent(t);
            ctn.add(t);
            TextArea lbl1 = new TextArea(h.getDescription());
            lbl1.setEditable(false);
            lbl1.setFocusable(false);
            lbl1.setUIID("Label");
            URLImage url = URLImage.createToStorage(encImage1, h.getImage(), "http://localhost/front/web/uploads/images/"+ h.getImage());
                            ImageViewer i = new ImageViewer(url);
                            Image Original = i.getImage();
                            Label label1 = new Label(Original);
                            int w = Original.getWidth();
                            int he = Original.getHeight();
                            Image maskImage = Image.createImage(w, he);
                            Graphics g = maskImage.getGraphics();
                            g.setAntiAliased(true);
                            g.setColor(0x000000);
                            g.fillRect(0, 0, w, he);
                            g.setColor(0xffffff);
                            g.fillArc(0, 0, w, he, 0, 360);
                            Label label2 = new Label(maskImage);
                            //img.addComponent(label2);
                            Object mask = maskImage.createMask();

                            Image maskedImage = Original.applyMask(mask);
                            Label label3 = new Label(maskedImage);

                            ctn.add(label3);

                        

          ctn.add(new Label(h.getAuteur()));
        ctn.add(new Label(h.getTitre()));
                   ctn.add(lbl1);

                    
Picker dated = new Picker();
dated.setType(Display.PICKER_TYPE_DATE);
dated.setDate(new Date());
                
Picker datef = new Picker();
datef.setType(Display.PICKER_TYPE_DATE);
datef.setDate(new Date());

                    Button btn_Louer = new Button();

ctn.add((new Label("Date Debut")));
ctn.add(dated);
ctn.add((new Label("Date Fin")));
ctn.add(datef);
ctn.add(btn_Louer);
            DetailsHote.add(ctn);
ip.dispose();
if(h.getQuantite()<1){
btn_Louer.setText("Quantite insuffisante");
btn_Louer.setEnabled(false);
}else{
btn_Louer.setText("Louer");
}      DetailsHote.show();
   btn_Louer.addActionListener(bt -> {
     String date=dated.getText().charAt(6)+""+dated.getText().charAt(7);
                          int an=Integer.parseInt(date)+2000;
                          date=an+"-"+dated.getText().charAt(3)+""+dated.getText().charAt(4)+"-"+dated.getText().charAt(0)+""+dated.getText().charAt(1);
                         System.out.println(date);
     String date2=datef.getText().charAt(6)+""+datef.getText().charAt(7);
                          int an2=Integer.parseInt(date2)+2000;
                          date2=an2+"-"+datef.getText().charAt(3)+""+datef.getText().charAt(4)+"-"+datef.getText().charAt(0)+""+datef.getText().charAt(1);
                         System.out.println(date2);
                     
String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                         if(Dialog.show("Vous allez louer", "livre: "+h.getTitre(), "Oui", "Annuler")) {
                             System.out.println("444444444444444444444");
                             System.out.println(date.compareTo(date2));
                             System.out.println(today.compareTo(date));
                             System.out.println("444444444444444444444");

    if(date.compareTo(date2)<=0 && today.compareTo(date)<=0 && h.getQuantite()>0){
        h.setQuantite(h.getQuantite()-1);
                         sh.ajouterLocation(h,usercon.getId(),date, date2);
                         Dialog dlg = new Dialog("Bienvenue");
    Style dlgStyle = dlg.getDialogStyle();
    dlgStyle.setBorder(Border.createEmpty());
    dlgStyle.setBgTransparency(255);
    dlgStyle.setBgColor(0xffffff);

    Label title = dlg.getTitleComponent();
//    title.setIcon(finalDuke.scaledHeight(title.getPreferredH()));
    title.getUnselectedStyle().setFgColor(0xff);
    title.getUnselectedStyle().setAlignment(Component.LEFT);

    dlg.setLayout(BoxLayout.y());
    Label blueLabel = new Label();
    blueLabel.setShowEvenIfBlank(true);
    blueLabel.getUnselectedStyle().setBgColor(0xff);
    blueLabel.getUnselectedStyle().setPadding(1, 1, 1, 1);
    blueLabel.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
    dlg.add(blueLabel);
    TextArea ta = new TextArea("Votre Location a ete Confirmer");
    ta.setEditable(false);
    ta.setUIID("DialogBody");
    ta.getAllStyles().setFgColor(0);
    dlg.add(ta);

    Label grayLabel = new Label();
    grayLabel.setShowEvenIfBlank(true);
    grayLabel.getUnselectedStyle().setBgColor(0xcccccc);
    grayLabel.getUnselectedStyle().setPadding(1, 1, 1, 1);
    grayLabel.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
    dlg.add(grayLabel);

    Button ok = new Button(new Command("OK"));
    ok.getAllStyles().setBorder(Border.createEmpty());
    ok.getAllStyles().setFgColor(0);
    dlg.add(ok);
    dlg.showDialog();
    }else{
    Dialog dlg = new Dialog("Bienvenue");
    Style dlgStyle = dlg.getDialogStyle();
    dlgStyle.setBorder(Border.createEmpty());
    dlgStyle.setBgTransparency(255);
    dlgStyle.setBgColor(0xffffff);

    Label title = dlg.getTitleComponent();
//    title.setIcon(finalDuke.scaledHeight(title.getPreferredH()));
    title.getUnselectedStyle().setFgColor(0xff);
    title.getUnselectedStyle().setAlignment(Component.LEFT);

    dlg.setLayout(BoxLayout.y());
    Label blueLabel = new Label();
    blueLabel.setShowEvenIfBlank(true);
    blueLabel.getUnselectedStyle().setBgColor(0xff);
    blueLabel.getUnselectedStyle().setPadding(1, 1, 1, 1);
    blueLabel.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
    dlg.add(blueLabel);
    TextArea ta = new TextArea("Erreru verifier date");
    ta.setEditable(false);
    ta.setUIID("DialogBody");
    ta.getAllStyles().setFgColor(0);
    dlg.add(ta);

    Label grayLabel = new Label();
    grayLabel.setShowEvenIfBlank(true);
    grayLabel.getUnselectedStyle().setBgColor(0xcccccc);
    grayLabel.getUnselectedStyle().setPadding(1, 1, 1, 1);
    grayLabel.getUnselectedStyle().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
    dlg.add(grayLabel);

    Button ok = new Button(new Command("OK"));
    ok.getAllStyles().setBorder(Border.createEmpty());
    ok.getAllStyles().setFgColor(0);
    dlg.add(ok);
    dlg.showDialog();
    }}
   });
   List<commentaire_livre> cl=new ArrayList<>();
    cl=sh.getListCom(h.getId());
    Container Commentaire = new Container(BoxLayout.y());
        for (commentaire_livre c : cl) {
            Container cont=addComm(c);
            Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);

            Style settingsStyle = cont.getAllStyles();
settingsStyle.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xffffff).
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
            Commentaire.add(cont);   
                    settingsStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);  
settingsStyle.setBgColor(0xffffff);
settingsStyle.setBgTransparency(255);
settingsStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
settingsStyle.setMargin(Component.BOTTOM, 3);

        }
ctn.add(Commentaire);
        });
        btn_Details.setText("Details");
        p.add(btn_Details);
        return p;
    }


}
