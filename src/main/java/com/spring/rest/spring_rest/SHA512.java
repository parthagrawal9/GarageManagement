package com.spring.rest.spring_rest;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA512 {
	String getSHA512(String input){
		try {        
            MessageDigest md = MessageDigest.getInstance("SHA-512");  
            byte[] messageDigest = md.digest(input.getBytes()); 
            BigInteger no = new BigInteger(1, messageDigest); 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
	}
}
