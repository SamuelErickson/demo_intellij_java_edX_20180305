

public class Crypto {
    public static void main(String[] args){
        // Sam Erickson January 2017 Module 3 Project
        // Test text below
        String txt = "ab? c ! def... gh, i? jk l mno p qrs tuv wxyz";
        int key = 2;
        int codeGroupSize = 8;
        String encryptedStr = encryptString(txt,key,codeGroupSize);
        String decryptedStr = decryptString(encryptedStr,key);
        System.out.println("The text starts as: "+txt);
        System.out.println("Which encrypts to: "+encryptedStr);
        System.out.println("And decrypts to: "+decryptedStr);
    }

    public static String normalizeText(String s) {
        // I use replaceAll and a regular expression to streamline
        s = s.replaceAll("[ .,:;'\"!?()]","").toUpperCase();
        return(s);
    }

    public static String obify(String str) {
        String vowels = "[AEIOUY]";
        if (str.isEmpty()){
            return "";
        } else if (str.substring(0,1).matches(vowels)){
            return "OB"+str.substring(0,1)+obify(str.substring(1));
        } else {
            return str.substring(0,1)+obify(str.substring(1));
        }
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String caesarify(String str,int key){
        if (0==str.length()) {
            return "";
        }   else {

            char oldLetter = str.charAt(0);
            String oldAlphabet = shiftAlphabet(0);
            String newAlphabet = shiftAlphabet(key);
            int index = oldAlphabet.indexOf(oldLetter);
            char newLetter = newAlphabet.charAt(index);
            return newLetter+caesarify(str.substring(1),key);
        }
    }

    public static String groupify(String str,int num) {
        if (str.length()==0){
            return "";
        } else if (str.length() < num) {
            int dif = num-str.length();
            for (int i=0;i<dif;i++) {
                str=str+"x";
            }
            return str;
        } else if (str.length() == num) {
            return str;
        } else {
            return str.substring(0,num)+" "+groupify(str.substring(num),num);
        }
    }

    public static String encryptString(String str, int key,int num){
        // key is the integer shift value, num is the code group size
        String normalizedStr = normalizeText(str);
        String obifiedStr = obify(normalizedStr);
        String caesarifiedStr = caesarify(obifiedStr,key);
        String encryptedStr = groupify(caesarifiedStr,num);
        return encryptedStr;
    }

    public static String ungroupify(String str){
        return str.replaceAll("[ x]","");
    }

    public static String deObify(String str) {
        String phrase = "OB[AEIOUY]";
        if (str.length()<3){
            return str;
        } else if (str.substring(0,3).matches(phrase)){
            return str.substring(2,3)+deObify(str.substring(3));
        } else {
            return str.substring(0,1)+deObify(str.substring(1));
        }
    }

    public static String decaesarify(String str, int key){
        if (0==str.length()) {
            return "";
        }   else {
            char oldLetter = str.charAt(0);
            String oldAlphabet = shiftAlphabet(0);
            String newAlphabet = shiftAlphabet(key*-1);
            int index = oldAlphabet.indexOf(oldLetter);
            char newLetter = newAlphabet.charAt(index);
            return newLetter+decaesarify(str.substring(1),key);
        }
    }

    public static String decryptString (String str, int key){
        String ungroupifiedStr = ungroupify(str);
        String decaesarifiedStr = decaesarify(ungroupifiedStr,key);
        String deobifiedStr = deObify(decaesarifiedStr);
        return deobifiedStr;
    }
}
