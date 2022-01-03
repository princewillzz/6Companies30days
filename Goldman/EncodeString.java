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

            // Space optimum
            char chars[] = str.toCharArray();
            int length = g.encode2(chars);
            for (int i = 0; i < length; i++) {
                System.out.print(chars[i]);
            } System.out.println();

            T--;
        }
        sc.close();
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

            encoded.append(ch);
            if(count > 1)
                encoded.append(count);
        }

        return encoded.toString();
    }

    // Space optimised
    int encode2(char chars[]) {

        int indexToEdit = 0;

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int countCh = 1;

            while (i+1 < chars.length && ch == chars[i+1]) {
                countCh++;
                i++;
            }

            chars[indexToEdit++] = ch;
            if(countCh > 1) {
                String countString = String.valueOf(countCh);
                for (int j = 0; j < countString.length(); j++) {
                    chars[indexToEdit++] = countString.charAt(j);
                }
            }
        }

        return indexToEdit;
    }

}