package Goldman;

import java.util.Scanner;

class EncodedString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        while (T > 0) {

            String str = sc.nextLine();

            GfG g = new GfG();
            System.out.println(g.encode(str));

            T--;
        }
    }
}

// } Driver Code Ends

class GfG {
    String encode(String str) {
        StringBuilder encoded = new StringBuilder();

        for (int index = 0; index < str.length(); index++) {
            char ch = str.charAt(index);
            int count = 1;

            while ((index + 1) < str.length() && ch == str.charAt(index + 1)) {
                count++;
                index++;
            }

            encoded.append(ch).append(count);
        }

        return encoded.toString();
    }

}