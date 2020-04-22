package com.xdx.garbage.common.util;

import java.security.MessageDigest;

public class EncryptionUtil {

    /**
     *
     * @param password
     * @return
     */
    public static String encrypt(String password) {
        String result = null;
        String password1 = "";
        if (password != null) {
            try {
                MessageDigest ca = MessageDigest.getInstance("SHA");
                result = "";
                char pass[] = password.toCharArray();
                for (int i = 0; i < pass.length; i++) {
                    password1 = (String) password1 + pass[i] + "&^./&";
                }
                byte mess[] = password1.getBytes();
                ca.reset();
                byte[] hash = ca.digest(mess);
                result = byte2hex(hash);
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
        return result;
    }

    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";

        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }
}
