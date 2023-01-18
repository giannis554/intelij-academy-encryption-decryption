public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        String message = "Bjqhtrj yt mdujwxpnqq!";
        int key = 5;
        //System.out.println(encryptionShift(message, key, stringBuilder));
        System.out.println(decryptionShift(message, key, stringBuilder));

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
}