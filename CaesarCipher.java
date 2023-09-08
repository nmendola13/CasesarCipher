import java.io.PrintWriter;

/*
 * A simple implementation of Caesar Cipher.
 *
 * @author Samuel A. Rebelsky
 * @author Noah Mendola
 * @version 1.0 of September 2023
 */

public class CaesarCipher {
//print helper function, takes the n value and str and prints it 
    public static void print (String str, int i) {

        PrintWriter pen = new PrintWriter(System.out, true);
        pen.print("n = " + i + ": ");
            pen.println(str);
    }
// encodes by moving each char over by n
    public static void encode (String str) {
        char[] str1 = str.toCharArray();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < str.length(); j++) {
                int temp = str1[j];
                int charnum = ((temp - 97 + i) % 26 + 97);
                char postChange = (char) charnum;
                str1[j] = postChange;
            }
            String newStr = new String(str1);
            print(newStr, i);
        }
    }
// decodes by moving each char over by n
    public static void decode (String str) {
        char[] str2 = str.toCharArray();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < str.length(); j++) {
                int temp = str2[j];
                int charnum = ((temp - 97 - i + 26) % 26 + 97);
                char postChange = (char) charnum;
                str2[j] = postChange;
            }
            String newStr = new String(str2);
            print(newStr, i);
        }
    }

    //checks for argument requirements and runs either encode or decode depending on arguments
    public static void main (String args[]) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);
          if (args.length != 2) {
              pen.println("Invalid number of arguments");
              System.exit(1);
          }
          String operation = args[0];
          String input = args[1];
         
          if (operation.equals("encode")) {
              encode(input);
          } else if (operation.equals("decode")) {
              decode(input);
          } else {
              pen.println("Valid options are 'encode' or 'decode'");
          }
      }
}



