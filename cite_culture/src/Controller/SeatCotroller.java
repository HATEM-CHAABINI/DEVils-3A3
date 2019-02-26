/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Reservation;
import Entities.Ticket;
import Entities.Utilisateur;
import Services.ReservationService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utilitaire.UserSession;
import utilitaire.mailReservation;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class SeatCotroller implements Initializable {
    @FXML 
    private Label movieTitle;
    
    private String movieTitleString;
    
    @FXML
    private ComboBox comboBoxSelectTime;
    
   private MovieShow movie1 = new MovieShow();
    private MovieShow movie2 = new MovieShow();
    private MovieShow movie3 = new MovieShow();
    private MovieShow movie4 = new MovieShow();
    private MovieShow movie5 = new MovieShow();
    private MovieShow movie6 = new MovieShow();
    private MovieShow currentMovie = new MovieShow();
    
    private Theater theater1 = new Theater();
    private Theater theater2 = new Theater();
    private Theater theater3 = new Theater();
    private Theater theater4 = new Theater();
    private Theater theater5 = new Theater();
    private Theater theater6 = new Theater();
    private Theater currentTheater = new Theater();
    
    private String currentTheaterID;
    @FXML
    private GridPane seat13;
    @FXML
    private Button btnPurchaseSeats;
    @FXML
    private Label idE;
    
   
    
    
    
    
    void setMovie(int idEvent)
    {
        UserSession session=new UserSession();
        
        Utilisateur ut=new Utilisateur();
        ut=session.getUser();
        
        idE.setText(String.valueOf(idEvent));
        System.out.println("//////////////");
        System.out.println(idE.getText());
        
                try {
            seatList.add(seatA1); seatList.add(seatA2); seatList.add(seatA3); seatList.add(seatA4); seatList.add(seatA5); seatList.add(seatA6);seatList.add(seatA7); seatList.add(seatA8); seatList.add(seatA9);seatList.add(seatA10); seatList.add(seatA11); seatList.add(seatA12);seatList.add(seatB1); seatList.add(seatB2); seatList.add(seatB3);seatList.add(seatB4); seatList.add(seatB5); seatList.add(seatB6);seatList.add(seatB7); seatList.add(seatB8); seatList.add(seatB9);seatList.add(seatB10); seatList.add(seatB11); seatList.add(seatB12);seatList.add(seatC1); seatList.add(seatC2); seatList.add(seatC3);seatList.add(seatC4); seatList.add(seatC5); seatList.add(seatC6);seatList.add(seatC7); seatList.add(seatC8); seatList.add(seatC9);seatList.add(seatC10); seatList.add(seatC11); seatList.add(seatC12);seatList.add(seatD1); seatList.add(seatD2); seatList.add(seatD3);seatList.add(seatD4); seatList.add(seatD5); seatList.add(seatD6);
            seatList.add(seatD7); seatList.add(seatD8); seatList.add(seatD9);
            seatList.add(seatD10); seatList.add(seatD11); seatList.add(seatD12);

            seatList.add(seatE1); seatList.add(seatE2); seatList.add(seatE3);
            seatList.add(seatE4); seatList.add(seatE5); seatList.add(seatE6);
            seatList.add(seatE7); seatList.add(seatE8); seatList.add(seatE9);
            seatList.add(seatE10); seatList.add(seatE11); seatList.add(seatE12);

            seatList.add(seatF1); seatList.add(seatF2); seatList.add(seatF3);
            seatList.add(seatF4); seatList.add(seatF5); seatList.add(seatF6);
            seatList.add(seatF7); seatList.add(seatF8); seatList.add(seatF9);
            seatList.add(seatF10); seatList.add(seatF11); seatList.add(seatF12);

            seatList.add(seatG1); seatList.add(seatG2); seatList.add(seatG3);
            seatList.add(seatG4); seatList.add(seatG5); seatList.add(seatG6);
            seatList.add(seatG7); seatList.add(seatG8); seatList.add(seatG9);
            seatList.add(seatG10); seatList.add(seatG11); seatList.add(seatG12);
            
            seatList.add(seatH1); seatList.add(seatH2); seatList.add(seatH3);
            seatList.add(seatH4); seatList.add(seatH5); seatList.add(seatH6);
            seatList.add(seatH7); seatList.add(seatH8); seatList.add(seatH9);
            seatList.add(seatH10); seatList.add(seatH11); seatList.add(seatH12);
            
            seatList.add(seatI1); seatList.add(seatI2); seatList.add(seatI3);
            seatList.add(seatI4); seatList.add(seatI5); seatList.add(seatI6);
            seatList.add(seatI7); seatList.add(seatI8); seatList.add(seatI9);
            seatList.add(seatI10); seatList.add(seatI11); seatList.add(seatI12);
            
                        
            
            comboBoxSelectTime.getItems().clear();
            Ticket t=new Ticket();
            ReservationService rss=new ReservationService();
            t=rss.getTicket(Integer.valueOf(idE.getText()));
            comboBoxSelectTime.getItems().addAll(
                    "Select Time",
                    t.getTime()                    );
            
            Label seatReference;
            
            // Initializes the seats for the user to view in the GUI.
            for (int i = 0; i < seatList.size(); i++) {
                seatReference = seatList.get(i);
                
                seatReference.setDisable(true);
                if(seatReference.getText().equals("Reserved"))
                {
                    seatReference.setStyle("-fx-border-radius: 5; -fx-background-color: red;");
                }
                 else   
                seatReference.setStyle("-fx-border-radius: 5; -fx-background-color: white;");
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            ReservationService r1=new ReservationService();
            
            String a="";
            List<String> l=new ArrayList<>();
            l=r1.rechercheReservationParId(Integer.valueOf(idE.getText()));
            System.out.println(l);
            
            for (int i=0; i<l.size();i++)
            {
                
                
                a+=","+l.get(i);
                
                
                
            }
            System.out.println(a);
            if (l.size()!=0){
                
                System.out.println(a.replaceAll(","," "));
                a=a.replaceAll(","," ");
                
                
                
                String[] split = a.split(" ");
                System.out.println(split[1]);
//        System.out.println(split[2]);









List<String>ll=new ArrayList<>();
ll = new ArrayList(Arrays.asList(split));

ll.remove(0);
System.out.println(Arrays.toString(split));


int nbs=r1.nbplace(Integer.valueOf(idE.getText()));
                


for (int i=0;i<nbs;i++)
{
    for(int j=0;j<ll.size();j++)
    {
        /*System.out.println("***********************************************");
        System.out.println(ll.get(j));
        System.out.println(seatList.get(i).getId());
        System.out.println("***********************************************");
        
        
        */
        
        if(seatList.get(i).getId().equals(ll.get(j)))
        {
            
            seatList.get(i).setText("Reserved");
            
        }
        // else System.out.println("asba");
    }
}}} catch (ClassNotFoundException ex) {
            Logger.getLogger(SeatCotroller.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            
            
            
            
            
            
            
            
       
            
            
            
            
            
            
            
            
            
            
            
            
            
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            
    }    
    
    // TO-DO | NEED TO GET THE TITLE OF THE WINDOW SET
    private void windowSetUp(ActionEvent event) {
        // Gets the current window casts it to be of type Stage.
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        stage.setTitle("Retro Cinemas - Seat Reservation Selection");
        stage.getIcons().add(new Image("file:\\Other Images\\Popcorn1.png"));
    }
    
    @FXML
    private void mouseEnterOpenSeat(MouseEvent event) {
        Label seatRef = (Label)event.getSource();
        
        if (seatRef.getText().equals("Open"))
            seatRef.setStyle("-fx-background-color: lightblue;");
    }
    
    @FXML
    private void mouseExitOpenSeat(MouseEvent event) {
        Label seatRef = (Label)event.getSource();
        
        if (seatRef.getText().equals("Open"))
            seatRef.setStyle("-fx-background-color: white;");
    }
    
    @FXML
    private void clickOpenSeat(MouseEvent event) {
        Label seat = (Label) event.getSource();
        Label seatRef = getClickedLabelID(seat.getId());
        System.out.println(seat.getId());
        if (seat.getText().equals("Open")) {
            seatRef.setText("Selected");
            seatRef.setStyle("-fx-background-color: orange;");
        }
        else if (seat.getText().equals("Selected")) {
            seatRef.setText("Open");
            seatRef.setStyle("-fx-background-color: white;");
            seatRef.getStylesheets().add("mycss.css");
        }
    }
    
    @FXML
    private void comboBoxSelectionChanged(ActionEvent event) throws ClassNotFoundException {
        
        
        ReservationService r=new ReservationService();
        Ticket t=r.getTicket(Integer.valueOf(idE.getText()));
        
        int nb=r.nbplace(Integer.valueOf(idE.getText()));
        
        
        
        Label seatRef;
        if (!comboBoxSelectTime.getValue().toString().equals("Select temps")) {
            movieTitle.setText(t.getTitre() + " (" + 
            comboBoxSelectTime.getValue().toString() + ")");
            loadSeats();
            
            for (int i = 0; i <nb; i++) {
                seatRef = seatList.get(i);
                seatRef.setDisable(false);
                //seatRef.setStyle("-fx-background-color: transparent;");
                //seatRef.toBack();
                
                
            }
        }
        else {
            movieTitle.setText(movieTitleString);
            
            for (int i = 0; i < nb; i++) {
                seatRef = seatList.get(i);
                seatRef.setDisable(true);
              ///  seatRef.setStyle("-fx-background-color: transparent;");
                //seatRef.toBack();
                //button.setStyle("-fx-background-color: transparent;");
            }
        }
        
        for (int i = 0; i < nb; i++) {
            seatRef = seatList.get(i);

            if (seatRef.getText().toString().equals("Open")) {
                seatRef.setStyle("-fx-background-color: white;");
            }
            else if (seatRef.getText().toString().equals("Selected")) {
                seatRef.setText("Open");
                seatRef.setStyle("-fx-background-color: white;");
            }
        }
    }
    
    public void setMovieTitle(String movieTitle) {
       
        
        this.movieTitle.setText(movieTitle);
        movieTitleString = movieTitle;
    }
    
    private void saveSeatsToFile() {
         
      /*  Theater [] theaters = new Theater [6];
        MovieShow movieReference = new MovieShow();
        
        theaters[0] = theater1;
        theaters[1] = theater2;
        theaters[2] = theater3;
        theaters[3] = theater4;
        theaters[4] = theater5;
        theaters[5] = theater6;
        
        Date date = new Date();
        DateFormat dateFormatted = new SimpleDateFormat("MMddyyyy");
        String filename; 
        
        String [] seats = new String[40];
        
        try {
            // This class is used for writing to a file.
            BufferedWriter out = null;
            
            for (int i = 0; i < theaters.length; i++) {
                filename = "C:/Users/moham/Desctop" + 
                dateFormatted.format(date) + "Theater" + (i + 1) + "save.txt";
                out = new BufferedWriter(new FileWriter(filename));
                
                // First movie from the theater at index i.
                movieReference = theaters[i].getFirstShow();
                seats = movieReference.getSeating();
                
                for (int seat = 0; seat < seats.length; seat++) {
                    out.write(seats[seat]);
                    out.write(" ");
                }
                
                out.write(movieReference.getID());
                out.newLine();
                
                // Second movie from the theater at index i.
                movieReference = theaters[i].getSecondShow();
                seats = movieReference.getSeating();
                
                for (int seat = 0; seat < seats.length; seat++) {
                    out.write(seats[seat]);
                    out.write(" ");
                }
                
                out.write(movieReference.getID());
                out.newLine();
                
                // Third movie from the theater at index i.
                movieReference = theaters[i].getThirdShow();
                seats = movieReference.getSeating();
                
                for (int seat = 0; seat < seats.length; seat++) {
                    out.write(seats[seat]);
                    out.write(" ");
                }
                
                out.write(movieReference.getID());
                out.newLine();
                
                // Fourth movie from the theater at index i.
                movieReference = theaters[i].getFourthShow();
                seats = movieReference.getSeating();
                
                for (int seat = 0; seat < seats.length; seat++) {
                    out.write(seats[seat]);
                    out.write(" ");
                }
                
                out.write(movieReference.getID());
                out.newLine();
               
                out.close();
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
        finally {
            
        }*/
    }
    
    private void saveSeatingMap() {
        try {
            ReservationService r=new ReservationService();
            
            int nb=r.nbplace(Integer.valueOf(idE.getText()));
            Label tempLabel = new Label();
            Ticket t=new Ticket();
            t=r.getTicket(Integer.valueOf(idE.getText()));
            for (int i = 0; i < nb; i++) {
                tempLabel = seatList.get(i);
                currentMovie.setSeat(i, tempLabel.getText());
            }
            
            currentMovie.setTitle(movieTitleString);
            currentMovie.setID(currentTheaterID);
            System.out.println("SaveSeatingMap() - " + movieTitleString);
            
          if (comboBoxSelectTime.getValue().toString().equals(t.getTime())) {
                currentTheater.setFirstShow(currentMovie);
           }
          else   if (comboBoxSelectTime.getValue().toString().equals("1:00 PM")) {
                currentTheater.setSecondShow(currentMovie);
            }
            else if (comboBoxSelectTime.getValue().toString().equals("5:00 PM")) {
                currentTheater.setThirdShow(currentMovie);
            }
            else if (comboBoxSelectTime.getValue().toString().equals("9:00 PM")) {
                currentTheater.setFourthShow(currentMovie);
            }
            
            // Save the current theater with the appropriate theater number.
            if (currentTheaterID.equals("imageMovie1"))
                theater1 = currentTheater;
            else if (currentTheaterID.equals("imageMovie2"))
                theater2 = currentTheater;
            else if (currentTheaterID.equals("imageMovie3"))
                theater3 = currentTheater;
            else if (currentTheaterID.equals("imageMovie4"))
                theater4 = currentTheater;
            else if (currentTheaterID.equals("imageMovie5"))
                theater5 = currentTheater;
            else if (currentTheaterID.equals("imageMovie6"))
                theater6 = currentTheater;
            
            saveSeatsToFile();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SeatCotroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadTheaters(String id, Theater theater1, Theater theater2,
            Theater theater3, Theater theater4, Theater theater5, 
            Theater theater6) {
        
        currentTheaterID = id;
        
        if (id.equals("imageMovie1")) {
            currentMovie.setID(id);
            currentMovie.setTitle(movieTitleString);
            currentTheater = theater1;
        }
        else if (id.equals("imageMovie2")) {
            currentMovie.setID(id);
            currentMovie.setTitle(movieTitleString);
            currentTheater = theater2;
        }
        else if (id.equals("imageMovie3")) {
            currentMovie.setID(id);
            currentMovie.setTitle(movieTitleString);
            currentTheater = theater3;
        }
        else if (id.equals("imageMovie4")) {
            currentMovie.setID(id);
            currentMovie.setTitle(movieTitleString);
            currentTheater = theater4;
        }
        else if (id.equals("imageMovie5")) {
            currentMovie.setID(id);
            currentMovie.setTitle(movieTitleString);
            currentTheater = theater5;
        }
        else if (id.equals("imageMovie6")) {
            currentMovie.setID(id);
            currentMovie.setTitle(movieTitleString);
            currentTheater = theater6;
        }
        
        this.theater1 = theater1;
        this.theater2 = theater2;
        this.theater3 = theater3;
        this.theater4 = theater4;
        this.theater5 = theater5;
        this.theater6 = theater6;
        
        try {
            
            loadTheatersFromFile();
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }
    
    private void loadTheatersFromFile() throws FileNotFoundException {
        // Read in any existing data to populate the theater reservations.
      /*  Date date = new Date();
        DateFormat dateFormatted = new SimpleDateFormat("MMddyyyy");
        
        Scanner input = null;
        String filename;
        
        String movieID;
        String movieTitle;
        String [] seats = new String[40];
        
        MovieShow movieReference;
        ArrayList<MovieShow> movieHolders = new ArrayList<MovieShow>();
        
        Theater [] theaters = new Theater[6];
        theaters[0] = theater1;
        theaters[1] = theater2;
        theaters[2] = theater3;
        theaters[3] = theater4;
        theaters[4] = theater5;
        theaters[5] = theater6;
        
        File file = null;
        
        try {
            for (int i = 0; i < theaters.length; i++) {
                file = new File("C:/Users/Thomas/Documents/RetroCinemas/" + 
                dateFormatted.format(date) + "Theater" + (i + 1) + "save.txt");

                // Checks if the specified file/directory path exists or not.
                // Will throw a new exception if the file isn't found.
                if (file.exists()) {
                    input = new Scanner(file);
                }
                else {
                    System.out.println("File doesn't exist or not found.");
                    throw new FileNotFoundException();
                }

                while (input.hasNext()) {
                    movieReference = new MovieShow();
                    
                    for (int k = 0; k < 40; k++) {
                        seats[k] = input.next();
                        movieReference.setSeat(k, seats[k]);
                    }
                    
                    movieID = input.next();
                    
                    movieReference.setID(movieID);
                    movieHolders.add(movieReference);
                }
                
                theaters[i].setFirstShow(movieHolders.get(0));
                theaters[i].setSecondShow(movieHolders.get(1));
                theaters[i].setThirdShow(movieHolders.get(2));
                theaters[i].setFourthShow(movieHolders.get(3));
                
                // Clear the ArrayList to prepare for next theater index.
                movieHolders.clear();
                
                input.close();
            }
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }
        finally {
            theater1 = theaters[0];
            theater2 = theaters[1];
            theater3 = theaters[2];
            theater4 = theaters[3];
            theater5 = theaters[4];
            theater6 = theaters[5];
        }
*/
    }
    
    private void loadSeats() throws ClassNotFoundException{
        
      ReservationService r=new ReservationService();
        
        int nb=r.nbplace(Integer.valueOf(idE.getText()));
        Ticket t=new Ticket();
        t=r.getTicket(Integer.valueOf(idE.getText()));
      
        System.out.println("**********************************************************");
        System.out.println(seatList);
        
                System.out.println("**********************************************************");

        
        
        // Get the current movie.
        if (comboBoxSelectTime.getValue().toString().equals(t.getTime())) {
            currentMovie = currentTheater.getFirstShow();
            
        }
      else   if (comboBoxSelectTime.getValue().toString().equals("1:00 PM")) {
            currentMovie = currentTheater.getSecondShow();
        }
        else if (comboBoxSelectTime.getValue().toString().equals("5:00 PM")) {
            currentMovie = currentTheater.getThirdShow();
        }
        else if (comboBoxSelectTime.getValue().toString().equals("9:00 PM")) {
            currentMovie = currentTheater.getFourthShow();
        }
        else
            currentMovie = null;
        
        Label seatReference = new Label();
       // String [] seatStats = currentMovie.getSeating();
        
        for (int i = 0; i < nb; i++) {
          //  System.out.println(seatList.get(i).getId());
            seatReference = seatList.get(i);
            
          //  seatReference.setText(seatStats[i]);
            
            
            if (seatList.get(i).getText().toString().equals("Reserved"))
                seatList.get(i).setStyle("-fx-background-color: red;");
            else if (seatReference.getText().toString().equals("Open"))
                seatReference.setStyle("-fx-background: white;");
            else if (seatReference.getText().toString().equals("Selected")) {
                seatReference.setText("Open");
                seatReference.setStyle("-fx-background-color: white;");
            }
            seatList.set(i, seatReference);
        }
        
        currentMovie.setTitle(movieTitleString);
        System.out.println(movieTitleString);
    }
    
    private Label getClickedLabelID(String id) {      
        try {
            Label tempLabel = new Label();
            ReservationService r=new ReservationService();
            
            int nb=r.nbplace(Integer.valueOf(idE.getText()));
            
            for (int i = 0; i < nb; i++) {
                tempLabel = seatList.get(i);
                
                if (tempLabel.getId().equals(id)) {
                    return seatList.get(i);
                }
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SeatCotroller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    @FXML
    private void clickPurchaseSeatsBtn(ActionEvent event) {
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Confirmation");
alert.setHeaderText("veuillez Confirmer");
alert.setContentText("etes-vous sur ?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    
        
        
        
        
        
        
        
        
        
        try {
            ReservationService r1=new ReservationService();
            int nb=r1.nbplace(Integer.valueOf(idE.getText()));
            //float prix=r1.prixEvent(Integer.valueOf(idE.getText()));
            Alert windowAlert = new Alert(Alert.AlertType.INFORMATION);
            Label tempLabel = new Label();
            
            ArrayList<String> purchasedSeats = new ArrayList<String>();
            
            int seatCounter = 0;
            try {
                if (!comboBoxSelectTime.getValue().toString().equals("Select Time")) {
                    
                    for (int i = 0; i < nb; i++) {
                        tempLabel = seatList.get(i);
                        //****
                        if (tempLabel.getText().equals("Selected")) {
                            seatCounter++;
                            System.out.println(seatCounter);
                            purchasedSeats.add(tempLabel.getId()); 
                            
                        }
                    }
                    
                    if (purchasedSeats.size() > 0) {
                        
                        String seatsConfirmed = "";
                        
                        for (int i = 0; i < purchasedSeats.size(); i++) {
                            seatsConfirmed += purchasedSeats.get(i);
                            seatsConfirmed += ",";
                            
                            System.out.println(seatsConfirmed);
                        }
                         float prix=  r1.prixEvent(Integer.valueOf(idE.getText()))*seatCounter;
                        windowAlert.setContentText("vous avez reservez:\n\n" + seatsConfirmed+"\n Prix:"+prix+"DT");
                        windowAlert.setTitle("Reservation Confirmation");
                        mailReservation ma=new mailReservation();
                         UserSession session=new UserSession();
        
        Utilisateur ut=new Utilisateur();
        ut=session.getUser();
                        ma.send(ut.getEmail(),"vous avez reservez:\n\n" + seatsConfirmed+"\n Prix:"+prix+"DT");
                        windowAlert.showAndWait();
                        
                        
                        
                        for (int i = 0; i < nb; i++) {
                            tempLabel = seatList.get(i);
                            // System.out.println("****"+tempLabel.getText());
                            
                            if (tempLabel.getText().equals("Selected")) {
                                tempLabel.setText("Reserved");
                                tempLabel.setStyle("-fx-background-color: red;");
                            }
                        }
                        
                        
                        System.out.println("////////////"+seatsConfirmed+"//////////////");
                        System.out.println(seatCounter);
                        
                        Date d=new java.sql.Date(1999, 02, 03);
                        Date d1=new Date(4, 12, 1997);
                        
                        //Reservation r=new Reservation("ttttt","jkj","hb","hb","hb","hb",7,seatsConfirmed,"hb",seatCounter,seatList.size-seatCounter);
                        //QRCodeGenerator.generateQRCodeImage(seatsConfirmed, seatsConfirmed, seatsConfirmed);
                        // ReservationService r1=new ReservationService();
                      // UserSession session=new UserSession();
        
       // Utilisateur ut=new Utilisateur();
        ut=session.getUser();
                        Reservation a=new Reservation(prix,seatsConfirmed,"",seatCounter,ut.getId(),Integer.valueOf(idE.getText()));
                        
                        r1.ajouterReservation(a);
                        
                        
                        // saveSeatingMap();
                    }
                    else {
                        windowAlert.setContentText("Pas de siege selectionner");
                        windowAlert.setTitle("Pas de selection.");
                        windowAlert.showAndWait();
                    }
                }
                else {
                    windowAlert.setContentText("Pas de siege selectionner");
                    windowAlert.setTitle("Pas de selection.");
                    windowAlert.showAndWait();
                }
            }
            catch (Exception ex) {
                System.out.println(ex.toString() + " was caught and handled.");
                windowAlert.setContentText("Please make a selection.");
                windowAlert.setTitle("No selection.");
                windowAlert.showAndWait();
            }
            finally {
                // ADD METHODS HERE
            }
            
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(SeatCotroller.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
else {
    
}




    }
    
    private ArrayList<Label> seatList = new ArrayList<Label>();
    
    @FXML
    private Label seatA1;
    
    @FXML
    private Label seatA2;
    
    @FXML
    private Label seatA3;
    
    @FXML
    private Label seatA4;
    
    @FXML
    private Label seatA5;
    
    @FXML
    private Label seatA6;
    
    @FXML
    private Label seatA7;
    
    @FXML
    private Label seatA8;
    
    @FXML
    private Label seatA9;
    
    @FXML
    private Label seatA10;
    
    @FXML
    private Label seatA11;
    
    @FXML
    private Label seatA12;
    
    @FXML
    private Label seatB1;
    
    @FXML
    private Label seatB2;
    
    @FXML
    private Label seatB3;
    
    @FXML
    private Label seatB4;
    
    @FXML
    private Label seatB5;
    
    @FXML
    private Label seatB6;
    
    @FXML
    private Label seatB7;
    
    @FXML
    private Label seatB8;
    
    @FXML
    private Label seatB9;
    
    @FXML
    private Label seatB10;
    
    @FXML
    private Label seatB11;
    
    @FXML
    private Label seatB12;
    
    @FXML
    private Label seatC1;
    
    @FXML
    private Label seatC2;
    
    @FXML
    private Label seatC3;
    
    @FXML
    private Label seatC4;
    
    @FXML
    private Label seatC5;
    
    @FXML
    private Label seatC6;
    
    @FXML
    private Label seatC7;
    
    @FXML
    private Label seatC8;
    
    @FXML
    private Label seatC9;
    
    @FXML
    private Label seatC10;
    
    @FXML
    private Label seatC11;
    
    @FXML
    private Label seatC12;
    
    @FXML
    private Label seatD1;
    
    @FXML
    private Label seatD2;
    
    @FXML
    private Label seatD3;
    
    @FXML
    private Label seatD4;
    
    @FXML
    private Label seatD5;
    
    @FXML
    private Label seatD6;
    
    @FXML
    private Label seatD7;
    
    @FXML
    private Label seatD8;
    
    @FXML
    private Label seatD9;
    
    @FXML
    private Label seatD10;
    
    @FXML
    private Label seatD11;
    
    @FXML
    private Label seatD12;
    
    @FXML
    private Label seatE1;
    
    @FXML
    private Label seatE2;
    
    @FXML
    private Label seatE3;
    
    @FXML
    private Label seatE4;
    
    @FXML
    private Label seatE5;
    
    @FXML
    private Label seatE6;
    
    @FXML
    private Label seatE7;
    
    @FXML
    private Label seatE8;
    
    @FXML
    private Label seatE9;
    
    @FXML
    private Label seatE10;
    
    @FXML
    private Label seatE11;
    
    @FXML
    private Label seatE12;
    
    @FXML
    private Label seatF1;
    
    @FXML
    private Label seatF2;
    
    @FXML
    private Label seatF3;
    
    @FXML
    private Label seatF4;
    
    @FXML
    private Label seatF5;
    
    @FXML
    private Label seatF6;
    
    @FXML
    private Label seatF7;
    
    @FXML
    private Label seatF8;
    
    @FXML
    private Label seatF9;
    
    @FXML
    private Label seatF10;
    
    @FXML
    private Label seatF11;
    
    @FXML
    private Label seatF12;
    
    @FXML
    private Label seatG1;
    
    @FXML
    private Label seatG2;
    
    @FXML
    private Label seatG3;
    
    @FXML
    private Label seatG4;
    
    @FXML
    private Label seatG5;
    
    @FXML
    private Label seatG6;
    
    @FXML
    private Label seatG7;
    
    @FXML
    private Label seatG8;
    
    @FXML
    private Label seatG9;
    
    @FXML
    private Label seatG10;
    
    @FXML
    private Label seatG11;
    
    @FXML
    private Label seatG12;
    
    @FXML
    private Label seatH1;
    
    @FXML
    private Label seatH2;
    
    @FXML
    private Label seatH3;
    
    @FXML
    private Label seatH4;
    
    @FXML
    private Label seatH5;
    
    @FXML
    private Label seatH6;
    
    @FXML
    private Label seatH7;
    
    @FXML
    private Label seatH8;
    
    @FXML
    private Label seatH9;
    
    @FXML
    private Label seatH10;
    
    @FXML
    private Label seatH11;
    
    @FXML
    private Label seatH12;
    
    @FXML
    private Label seatI1;
    
    @FXML
    private Label seatI2;
    
    @FXML
    private Label seatI3;
    
    @FXML
    private Label seatI4;
    
    @FXML
    private Label seatI5;
    
    @FXML
    private Label seatI6;
    
    @FXML
    private Label seatI7;
    
    @FXML
    private Label seatI8;
    
    @FXML
    private Label seatI9;
    
    @FXML
    private Label seatI10;
    
    @FXML
    private Label seatI11;
    
    @FXML
    private Label seatI12;
}
