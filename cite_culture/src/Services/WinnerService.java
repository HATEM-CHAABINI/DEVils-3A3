/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import IServices.IWinnerService;
import Entities.Utilisateur;

import java.sql.Date;
import javafx.collections.ObservableList;
import Dao.MyDB;

import Entities.Winner;
import java.sql.Statement;
/**
 *
 * @author ahmed
 */
public class WinnerService implements IWinnerService {

    Connection conn;
     
     public WinnerService() throws ClassNotFoundException {
                this.conn = MyDB.getInstance().getConnexion();

    }

    private List<Integer> integers = new ArrayList<>();

    
    public Utilisateur executeDBQuery(String query) {
        Utilisateur user = null;
        PreparedStatement preparedStatement;
        try {

            preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new Utilisateur();
                user.setId(resultSet.getInt(1));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public Boolean isValidWinnerUser(int w_id) {
        Utilisateur userWinner;
        boolean f_return = false;
       

              userWinner = executeDBQuery("SELECT * from fos_user where id = " + (w_id));
       

            
        /*Here we will get the list of the last 7 winners*/
        List<Winner> winners = new ArrayList<>();
        String req = "SELECT DISTINCT * FROM winner ORDER BY winner_date DESC LIMIT 7";
        
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Winner winner = new Winner(resultSet.getInt(1),(resultSet.getDate(2)), resultSet.getInt(3));
                winners.add(winner);
               
            }
        } catch (SQLException ex) {
        }

        /*Here we will check if the randomly found winner user 
        wasn't in the list of the last 7 winners (one user shouldn't win twice a week)*/
        Boolean userfound = false;
        int index = 0;
        while (userfound == false && index < winners.size()) {
            if (winners.get(index).getId_userwinner() == w_id) {
                userfound = true;
            }

            index++;
        }
        //check idrandomUserId
        if (userfound == false && userWinner != null) {
            f_return = true;
        }

        return f_return;
    }

    @Override
    public int winnerOfTheDay() {
        
        
        Utilisateur userWinner=new Utilisateur() ;
        int Min = executeDBQuery("SELECT MIN(id) FROM fos_user").getId();
        
        int randomUserId;
        int Max = executeDBQuery("SELECT MAX(id) FROM fos_user").getId();
        
        do {
            randomUserId = (int) ((Math.random() * ((Max - Min) + 1)) +  Min);
            
        } while (!isValidWinnerUser(randomUserId));
        System.out.println("hedhy e thenyaaa");
        System.err.println(randomUserId);
        
        
        ///////////////////////////////////////////////////////////
        
        Utilisateur a = new Utilisateur();
        
//SELECT * FROM fos_user WHERE (roles like "%ROLE_UTILISATEUR%" and cin= 10009484 )

            String sql = "SELECT * FROM fos_user WHERE roles like '%ROLE_UTILISATEUR%'  and id ='" + randomUserId + "';";

            try {
                Statement stl = conn.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    a.setId(rs.getInt("id"));
                    a.setCin(rs.getInt("cin"));
                    a.setNom(rs.getString("nom"));
                    a.setUsername(rs.getString("username"));
                    a.setPrenom(rs.getString("prenom"));
                    a.setEmail(rs.getString("email"));
                    a.setPassword(rs.getString("password"));
                    a.setAdresse(rs.getString("adresse"));
                  a.setRoles(rs.getString("roles"));
                  a.setImage(rs.getString("image"));
                  a.setVille(rs.getString("ville"));
                  a.setTelephone(rs.getInt("telephone"));
                  a.setCode_postal(rs.getInt("code_postal"));
                a.setDate_naissance(rs.getDate("date_naissance"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        
        
        
        
        return a.getCin();
    }

   
    
    @Override
    public void add(Winner t) {

        String req = "insert into winner (winner_date,id_userwinner) values (?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
             preparedStatement.setDate(1,t.getDate());
            preparedStatement.setInt(2, t.getId_userwinner());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(WinnerService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public java.sql.Date convert(String date) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date1 = sdf1.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());

        return sqlDate;
    }

    public static String convert(java.sql.Date d) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String text = df.format(d);
        return text;
    }

    @Override
    public int findbydate(String date) {
        int winnerId = 0;
        String req = "select * from winner where winner_date =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setDate(2, convert(date));

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(WinnerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    

    

    

    @Override
    public List<Winner> getAll() {
        List<Winner> winners = new ArrayList<>();
        String req = "select * from client";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Winner winner = new Winner(resultSet.getInt(1),resultSet.getDate(2), resultSet.getInt(3));
                winners.add(winner);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return winners;
    }

    @Override
    public Date maxwinnerdate() {
        Date d = null ;
        String req = "SELECT MAX(winner_date) FROM winner";
        PreparedStatement preparedStatement;
        try {
          preparedStatement = conn.prepareStatement(req); 
            ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()) {
                 System.out.println(req);
              d= resultSet.getDate(1);

            }
/////           d= resultSet.getDate(1);
        } catch (SQLException ex) {
            Logger.getLogger(WinnerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
        
         
    }

    

    @Override
    public ObservableList<Winner> displayall() {
        
         ObservableList<Winner> listeCarte=FXCollections.observableArrayList();
        String req= "select * from winner";
        PreparedStatement preparedStatement;
        
        try {
            preparedStatement=conn.prepareStatement(req);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
             Winner winner = new Winner(resultSet.getInt(1),resultSet.getDate(2),resultSet.getInt(3)) ;
                listeCarte.add(winner);
                
            }
        } catch (SQLException ex) {
           
        }
        return listeCarte;
    }

    @Override
    public Winner findbyusername(int userId) {
        
         Winner winner = null;
      String req = "select * from winner where id_userwinner =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(req);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
             while(resultSet.next()){
              winner = new Winner(resultSet.getInt(1),resultSet.getDate(2),resultSet.getInt(3)) ;
             }
    }   catch (SQLException ex) {
            Logger.getLogger(WinnerService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return winner;
    }

    @Override
    public String identifywithrole(String r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    



}
