package com.tw.core.util;

/**
 * Created by Vivi on 7/14/15.
 */

import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class MD5Util {

    public String String2MD5(String str2Encode){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            e.printStackTrace();
        }

        char[] charArray = str2Encode.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public String MD5Encode(String str2Encode){
        String MD5String = String2MD5(str2Encode);
        char[] a = MD5String.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }
}
