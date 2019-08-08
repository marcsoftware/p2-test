package com.revature.dao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.security.*;

@Entity
@Table(name = "user_accounts")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    public User() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = hash(password);
    }
   

    

  

    public User( String username, String password) {
        
        this.username = username;
        this.password = hash(password);
        
    }

   

    @Override
    public String toString() {
        return "USER-RECORD [ id=" + id + ", username=" + username + ", password=" + password + "]";
    }

    public String hash(String password){
        //
        String data = password;
         
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");//TODO replace MD5
            messageDigest.update(data.getBytes());
            byte[] messageDigestMD5 = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte bytes : messageDigestMD5) {
                stringBuffer.append(String.format("%02x", bytes & 0xff));
            }
 
            password=stringBuffer.toString();
        } catch (NoSuchAlgorithmException exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }
       return password;
   }

}