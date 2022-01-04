package Goldman;

import java.util.Scanner;

public class GCDOfStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(gcdOfStrings(sc.next(), sc.next()));
        sc.close();
    }
    
    public static String gcdOfStrings(String str1, String str2) {
        
        if(!(str1+str2).equals(str2+str1)) return "";
        else if(str1.equals(str2)) return str1;
        else if(str1.length() < str2.length()) {
            return gcdOfStrings(str1, str2.substring(str1.length()));
        } else {
            return gcdOfStrings(str2, str1.substring(str2.length()));
        }
        
    }
}