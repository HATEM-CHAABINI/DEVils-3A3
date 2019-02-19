package utilitaire;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
 
public class sendSMS {
//        public static void main(String[] args) {
  public sendSMS()    {}
  public void envoitSms(int num,int valeur){
            
		try {
                                System.out.println("envoie sms");

			// Construct data
			String apiKey = "apikey=" + "RYrN/HA5iVY-XHmbSh2M0DbtsmK2tGXGDldb2JbJWO	";
			String message = "&message=" + valeur;
			String sender = "&sender=" + "CITECULTURE";
			String numbers = "&numbers=+216" +num;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			//return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			//return "Error "+e;
		}
	}
           
    
}


///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package testsms;
//
//import com.nexmo.client.NexmoClient;
//import com.nexmo.client.NexmoClientException;
//import com.nexmo.client.sms.SmsSubmissionResponse;
//import com.nexmo.client.sms.SmsSubmissionResponseMessage;
//import com.nexmo.client.sms.messages.TextMessage;
//import java.io.IOException;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//
///**
// *
// * @author hatem
// */
//public class Testsms extends Application {
//    
//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) throws IOException, NexmoClientException {
//       NexmoClient client = new NexmoClient.Builder()
//  .apiKey("280bca94")
//  .apiSecret("l40wzhvHGc1OS9Js")
//  .build();
//
//String messageText = "Hello from Nexmo";
//TextMessage message = new TextMessage("Nexmo", "216", messageText);
//
//SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);
//
//for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
//    System.out.println(responseMessage);
//}
//    }
//    
////}
//
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//
//public class Example {
//    // Find your Account Sid and Token at twilio.com/console
//    public static final String ACCOUNT_SID = "ACbf5f5f9a2ec9193982ef6157fa499379";
//    public static final String AUTH_TOKEN = "501f2099375b1591df45ee046bc9b136";
//
//    public static void main(String[] args) {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        Message message = Message.creator(
//                new com.twilio.type.PhoneNumber("+21650459936"),
//                new com.twilio.type.PhoneNumber("+21650459936"),
//                "This is the ship that made the Kessel Run in fourteen parsecs?")
//            .create();
//
//        System.out.println(message.getSid());
//    }
//}