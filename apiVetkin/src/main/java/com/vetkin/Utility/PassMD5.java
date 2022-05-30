package com.vetkin.Utility;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.security.MD5Encoder;

public class PassMD5 {

     

    public static String passMD5(String senha) {

        String senhaEncode= senha;
        MessageDigest m;

        try {
			m = MessageDigest.getInstance("MD5");
	        m.update(senhaEncode.getBytes(),0,senhaEncode.length());
	        senhaEncode = new BigInteger(1,m.digest()).toString(16);
	        
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



        return senhaEncode;
    }

}
