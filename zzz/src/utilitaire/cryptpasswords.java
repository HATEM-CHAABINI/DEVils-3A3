/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author hatem
 */
public class cryptpasswords {
    
    private String Password; 

    public cryptpasswords() {
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public String cryptme(String Password) throws NoSuchAlgorithmException{
  MessageDigest md = MessageDigest.getInstance( "SHA-256" );
  // Change this to UTF-16 if needed
    md.update( Password.getBytes( StandardCharsets.UTF_8 ) );
    byte[] digest = md.digest();
  String hex = String.format( "%064x", new BigInteger( 1, digest ) );
  return hex ;
    }
    
}