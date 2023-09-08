import java.io.PrintWriter;

/*
* A simple implementation of Vigenère Cipher.
*
* @author Samuel A. Rebelsky
* @author Noah Mendola
* @version 1.0 of September 2023
*/

public class VigenereCipher {
    //print helper function, takes the n value and str and prints it 
    public static void print (String str) {

      PrintWriter pen = new PrintWriter(System.out, true);
          pen.println(str);
    }
    // encodes by moving each char over by the corresponding key character
    public static void encode (String str, String key) {
      char[] str1 = str.toCharArray();
      char[] str2 = key.toCharArray();
        for (int j = 0; j < str.length(); j++) {
            int keyIndex = j % key.length(); 
            int temp = str1[j];
            int keytemp = str2[keyIndex];
            int charnum = ((temp - 97 + keytemp) % 26 + 97);
            char postChange = (char) charnum;
            str1[j] = postChange;
        }
        String newStr = new String(str1);
        print(newStr);
      }
    // decodes by moving each char over by n
    public static void decode (String str, String key) {
      char[] str1 = str.toCharArray();
      char[] str2 = key.toCharArray();
        for (int j = 0; j < str.length(); j++) {
            int keyIndex = j % key.length(); 
            int temp = str1[j];
            int keytemp = str2[keyIndex];
            int charnum = ((temp - 97 - keytemp) % 26 + 97);
            char postChange = (char) charnum;
            str1[j] = postChange;
        }
        String newStr = new String(str1);
        print(newStr);
      }
    

    //checks for argument requirements and runs either encode or decode depending on arguments
    public static void main (String args[]) throws Exception {
      PrintWriter pen = new PrintWriter(System.out, true);
        if (args.length != 3) {
            pen.println("Invalid number of arguments");
            System.exit(1);
        }
        String operation = args[0];
        String input = args[1];
        String key = args[2];
      
        if (operation.equals("encode")) {
            encode(input, key);
        } else if (operation.equals("decode")) {
            decode(input, key);
        } else {
            pen.println("Valid options are 'encode' or 'decode'");
        }
    }
}
