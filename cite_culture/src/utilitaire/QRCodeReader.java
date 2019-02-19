/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hatem
 */
public class QRCodeReader {
  

    /**
     * @param args the command line arguents
     */
    public static String ReadQRCodeImage() throws IOException {
        

Process process = new ProcessBuilder("\"C:\\Program Files (x86)\\ZBar\\bin\\zbarcam.bat\"").start();
InputStream is = process.getInputStream();
InputStreamReader isr = new InputStreamReader(is);
BufferedReader br = new BufferedReader(isr);
String line;


while ((line = br.readLine()) != null) {
        if (line.contains("QR")){
        break;}

}
       return line;
        
  
    }}
    

