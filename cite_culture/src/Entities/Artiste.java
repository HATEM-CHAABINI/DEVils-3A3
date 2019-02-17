/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import utilitaire.cryptpasswords;

/**
 *
 * @author hatem
 */
public class Artiste {
    
private int id;
private String username;
private String username_canonical;
private String email;
private String email_canonical;	
private int enabled;
private String salt;
private String password;
private Date last_login;
private int locked;
private int expired;
private Date expires_at;
private String confirmation_token;	
private Date password_requested_at;
private String roles 	;
private int credentials_expired;
private Date credentials_expire_at;
private String departement;
private String qr;
private String image;
private String nom;
private String prenom;
private String ville;
private Date date_naissance;
private String bio;
private String domaine;
private int note;
private String adresse;
private int code_postal;
private String sexe;
private int telephone;
private int cin;
    public Artiste() {
    }

public Artiste (String username,String email,String password,String image,String nom,String prenom,String ville,Date date_nais,String adresse,int code_postal,String sexe,int telephone,int cin) throws NoSuchAlgorithmException
{       cryptpasswords encryption = new cryptpasswords() ; // SHA256 ENCRYPTION

    this.username=username;
    this.username_canonical=username;
    this.email=email;
    this.email_canonical=email;
    this.enabled=0;
    this.salt=null;
    this.password=  encryption.cryptme(password);
    this.last_login=null;
    this.locked=0;
    this.expired=0;
    this.expires_at=null;
    this.confirmation_token=null;
    this.password_requested_at=null;
    this.roles= "a:1:{i:0;s:15:\"ROLE_ARTISTE\";}" ;
    this.credentials_expired=0;
    this.credentials_expire_at=null;
    this.departement=null;
    this.qr=username+','+ encryption.cryptme(password);
    this.image=image;

    this.nom=nom;
    this.prenom=prenom;
    this.ville=ville;
    this.date_naissance=date_nais;
    this.bio=null;
    this.domaine=null;
    this.note=0;
    this.adresse=adresse;
    this.code_postal=code_postal;
    this.sexe=sexe;
    this.telephone=telephone;
    this.cin=cin;
}

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public int getExpired() {
        return expired;
    }

    public void setExpired(int expired) {
        this.expired = expired;
    }

    public Date getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Date expires_at) {
        this.expires_at = expires_at;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public Date getPassword_requested_at() {
        return password_requested_at;
    }

    public void setPassword_requested_at(Date password_requested_at) {
        this.password_requested_at = password_requested_at;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getCredentials_expired() {
        return credentials_expired;
    }

    public void setCredentials_expired(int credentials_expired) {
        this.credentials_expired = credentials_expired;
    }

    public Date getCredentials_expire_at() {
        return credentials_expire_at;
    }

    public void setCredentials_expire_at(Date credentials_expire_at) {
        this.credentials_expire_at = credentials_expire_at;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", username=" + username + ", username_canonical=" + username_canonical + ", email=" + email + ", email_canonical=" + email_canonical + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", last_login=" + last_login + ", locked=" + locked + ", expired=" + expired + ", expires_at=" + expires_at + ", confirmation_token=" + confirmation_token + ", password_requested_at=" + password_requested_at + ", roles=" + roles + ", credentials_expired=" + credentials_expired + ", credentials_expire_at=" + credentials_expire_at + ", departement=" + departement + ", qr=" + qr + ", image=" + image + ", nom=" + nom + ", prenom=" + prenom + ", ville=" + ville + ", date_naissance=" + date_naissance + ", bio=" + bio + ", domaine=" + domaine + ", note=" + note + ", adresse=" + adresse + ", code_postal=" + code_postal + ", sexe=" + sexe + ", telephone=" + telephone + '}';
    }
}
