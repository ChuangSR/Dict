//package com.cc68;
//
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        String t1 = "02G41柜nanobot";
//        String t2 = "柜.mp3nanobot02G41";
//        System.out.println(calculateMD5(t2));
//    }
//
//    public static String calculateMD5(String input) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            byte[] hashBytes = md.digest(input.getBytes());
//
//            // Convert the byte array to hexadecimal representation
//            StringBuilder hexString = new StringBuilder();
//            for (byte hashByte : hashBytes) {
//                String hex = Integer.toHexString(0xFF & hashByte);
//                if (hex.length() == 1) {
//                    hexString.append('0');  // Padding for single digit
//                }
//                hexString.append(hex);
//            }
//
//            return hexString.toString();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
