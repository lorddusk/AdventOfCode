package nl.lang2619;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Tim on 12/4/2015.
 */
public class Day4 {

    static String input = "ckczppom";
    static int inputExtra = 0;
    static String hashText = "";
    private static MessageDigest md;

    public static void main(String[] args) {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //part1();
        part2();
    }

    private static void part2() {
        while (!hashText.startsWith("000000")) {
            String checkInput = input + inputExtra;
            md.update(checkInput.getBytes());
            byte[] byteData = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashText = sb.toString();
            inputExtra++;
        }
        System.out.println(hashText);
        System.out.println(inputExtra - 1);
    }

    private static void part1() {
        while (!hashText.startsWith("00000")) {
            String checkInput = input + inputExtra;
            md.update(checkInput.getBytes());
            byte[] byteData = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashText = sb.toString();
            inputExtra++;
        }
        System.out.println(hashText);
        System.out.println(inputExtra - 1);
    }
}

