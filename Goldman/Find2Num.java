package Goldman;

// { Driver Code Starts
// Initial Template for Java
import java.io.BufferedReader;
import java.io.InputStreamReader;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int ar[], int n) {
        int ans[] = new int[2];
        
        for(int i = 0; i < n; i++) {
            if(ar[Math.abs(ar[i]) - 1] > 0) {
                ar[Math.abs(ar[i])-1] *= -1;
            } else {
                ans[0] = Math.abs(ar[i]);
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(ar[i] > 0) {
                ans[1] = i+1;
            }
        }
        
        return ans;
    }
}