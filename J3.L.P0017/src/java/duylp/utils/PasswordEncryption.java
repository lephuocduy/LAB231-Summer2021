/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Le Phuoc Duy
 */
public class PasswordEncryption {
    
    public static byte[] getSHA256(String input) throws NoSuchAlgorithmException {  
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexStr = new StringBuilder(number.toString(16));
        while (hexStr.length() < 32) {
            hexStr.insert(0, '0');
        }
        return hexStr.toString();
    }
        
}
