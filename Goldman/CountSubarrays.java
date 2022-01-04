package Goldman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// { Driver Code Starts
//Initial Template for Java
import java.util.StringTokenizer;


class CountSubarrays {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSubArrayProductLessThanK(a, n, k));
            
        }
	}
}


class Solution {
    
    public int countSubArrayProductLessThanK(long a[], long n, long k)
    {
        
        int count = 0;
        
        int left = 0, right = 0; long product = 1;
        
        while(right < n) {
            
            product *= a[right];
            
            while(product >= k) {
                product /= a[left];
                left++;
            }
            
            count += right - left + 1;
            
            right++;
            
        }
        
        return count;
    }
}