
package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {


        StringBuilder bd = new StringBuilder();
        int key = 0;
        String in = "";
        String out = "";
        String mode = "";
        String data = "";
        String alg = "";


        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-in")) {
                in = args[i + 1];
            } else if (args[i].equals("-out")) {
                out = args[i + 1];
            } else if (args[i].equals("-mode")) {
                mode = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                data = args[i + 1];
            } else if (args[i].equals("-alg")) {
                alg = args[i + 1];
            }

        }
        if (alg.equals("shift")) {
            theChoiceForShift(mode, bd, key, data, in, out, alg);
        } else {
            theChoice(mode, bd, key, data, in, out, alg);
        }
    }

    public static void theChoiceForShift(String mode, StringBuilder bd, int key, String data, String in, String out, String alg) throws IOException {

        if (mode.equals("")) {
            mode = "enc";
        }

        switch (mode) {

            case "enc":
                if (data.equals("") && in.equals("")) {
                    System.out.println(encryptionShift(data, key, bd));
                } else if (!data.equals("") && !in.equals("")) {
                    System.out.println(encryptionShift(data, key, bd));
                } else if (out.equals("")) {
                    if (!in.equals("") && data.equals("")) {
                        File file = new File(in);
                        Scanner sc = new Scanner(file);
                        String data2 = sc.nextLine();
                        String encrypted = encryptionShift(data2, key, bd);
                        System.out.println(encrypted);
                    }
                } else if (!in.equals("") && data.equals("")) {
                    File file = new File(in);
                    File file2 = new File(out);
                    FileWriter writer = new FileWriter(file2);
                    Scanner sc = new Scanner(file);
                    String fileMessage = sc.nextLine();
                    String fileMessageDec = encryptionShift(fileMessage, key, bd);
                    writer.write(fileMessageDec);
                    sc.close();
                    writer.close();

                } else {
                    encryptionShift(data, key, bd);
                }
                break;
            case "dec":
                if (data.equals("") && in.equals("")) {
                    System.out.println(decryptionShift(data, key, bd));
                } else if (!data.equals("") && !in.equals("")) {
                    System.out.println(decryptionShift(data, key, bd));
                } else if (out.equals("")) {
                    if (!in.equals("") && data.equals("")) {
                        File file = new File(in);
                        Scanner sc = new Scanner(file);
                        String data2 = sc.nextLine();
                        System.out.println(decryptionShift(data2, key, bd));
                    }
                } else if (!in.equals("") && data.equals("")) {
                    File file = new File(in);
                    File file2 = new File(out);
                    FileWriter writer = new FileWriter(file2);
                    Scanner sc = new Scanner(file);
                    String fileMessage = sc.nextLine();
                    String fileMessageDec = decryptionShift(fileMessage, key, bd);
                    writer.write(fileMessageDec);
                    sc.close();
                    writer.close();

                } else {
                    decryptionShift(data, key, bd);
                }
                break;
            default:
                encryptionShift(data, key, bd);
        }


    }

    public static String encryptionShift(String message, int key, StringBuilder bd) {
        final String ALPHABETSMALL = "abcdefghijklmnopqrstuvwxyz";
        final String ALPHABETBIG = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        char[] charArray = message.toCharArray();

        for (int i = 0; i < charArray.length; i++) {


            int encryptPos = 0;
            char encryptChar;

            if (Character.isUpperCase(charArray[i])) {
                int pos = ALPHABETBIG.indexOf(charArray[i]);

                encryptPos = (key + pos) % 26;
                encryptChar = ALPHABETBIG.charAt(encryptPos);

            } else if (Character.isLowerCase(charArray[i])) {
                int pos = ALPHABETSMALL.indexOf(charArray[i]);
                encryptPos = (key + pos) % 26;
                encryptChar = ALPHABETSMALL.charAt(encryptPos);
            } else {
                encryptChar = charArray[i];
            }
            bd.append(encryptChar);
        }
        return String.valueOf(bd);

    }

    public static String decryptionShift(String message, int key, StringBuilder bd) {

        final String ALPHABETSMALL = "abcdefghijklmnopqrstuvwxyz";
        final String ALPHABETBIG = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char[] charArray = message.toCharArray();

        for (int i = 0; i < charArray.length; i++) {


            int decryptPos = 0;
            char decryptChar;

            if (Character.isUpperCase(charArray[i])) {
                int pos = ALPHABETBIG.indexOf(charArray[i]);

                decryptPos = (pos - key) % 26;
                if (decryptPos < 0) {
                    decryptPos = ALPHABETBIG.length() + decryptPos;
                }
                decryptChar = ALPHABETBIG.charAt(decryptPos);

            } else if (Character.isLowerCase(charArray[i])) {
                int pos = ALPHABETSMALL.indexOf(charArray[i]);
                decryptPos = (pos - key) % 26;
                if (decryptPos < 0) {
                    decryptPos = ALPHABETSMALL.length() + decryptPos;
                }
                decryptChar = ALPHABETSMALL.charAt(decryptPos);
            } else {
                decryptChar = charArray[i];
            }
            bd.append(decryptChar);
        }

        return String.valueOf(bd);

    }

    public static void theChoice(String mode, StringBuilder bd, int key, String data, String in, String out, String alg) throws IOException {

        if (mode.equals("")) {
            mode = "enc";
        }

        switch (mode) {

            case "enc":
                if (data.equals("") && in.equals("")) {
                    System.out.println(encryption(data, key, bd));
                } else if (!data.equals("") && !in.equals("")) {
                    System.out.println(encryption(data, key, bd));
                } else if (out.equals("")) {
                    if (!in.equals("") && data.equals("")) {
                        File file = new File(in);
                        Scanner sc = new Scanner(file);
                        String data2 = sc.nextLine();
                        String encrypted = encryption(data2, key, bd);
                        System.out.println(encrypted);
                    }
                } else if (!in.equals("") && data.equals("")) {
                    File file = new File(in);
                    File file2 = new File(out);
                    FileWriter writer = new FileWriter(file2);
                    Scanner sc = new Scanner(file);
                    String fileMessage = sc.nextLine();
                    String fileMessageDec = encryption(fileMessage, key, bd);
                    writer.write(fileMessageDec);
                    sc.close();
                    writer.close();

                } else {
                    encryption(data, key, bd);
                }
                break;
            case "dec":
                if (data.equals("") && in.equals("")) {
                    System.out.println(decryption(data, key, bd));
                } else if (!data.equals("") && !in.equals("")) {
                    System.out.println(decryption(data, key, bd));
                } else if (out.equals("")) {
                    if (!in.equals("") && data.equals("")) {
                        File file = new File(in);
                        Scanner sc = new Scanner(file);
                        String data2 = sc.nextLine();
                        System.out.println(decryption(data2, key, bd));
                    }
                } else if (!in.equals("") && data.equals("")) {
                    File file = new File(in);
                    File file2 = new File(out);
                    FileWriter writer = new FileWriter(file2);
                    Scanner sc = new Scanner(file);
                    String fileMessage = sc.nextLine();
                    String fileMessageDec = decryption(fileMessage, key, bd);
                    writer.write(fileMessageDec);
                    sc.close();
                    writer.close();

                } else {
                    decryption(data, key, bd);
                }
                break;
            default:
                encryption(data, key, bd);
        }

    }


    public static String decryption(String cypherText, int key, StringBuilder bd) {


        for (int i = 0; i < cypherText.length(); i++) {
            int number1 = cypherText.charAt(i) - key;

            bd.append((char) number1);

        }
        return String.valueOf(bd);
    }


    public static String encryption(String message, int key, StringBuilder bd) {

        for (int i = 0; i < message.length(); i++) {

            int number1 = message.charAt(i) + key;

            bd.append((char) number1);

        }
        return String.valueOf(bd);
    }

}