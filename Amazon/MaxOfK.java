// { Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> values = new ArrayList<>();
        int maxIndex = 0;
        for(int i = 0; i < k; i++) {
            if(arr[maxIndex] < arr[i]) {
                maxIndex = i;
            }
        }
        
        for(int i = 0; i < n-k+1; i++) {
            
            if(maxIndex < i) {
                maxIndex = i;
                int j = i;
                while(j < i+k) {
                    if(arr[maxIndex] < arr[j]) {
                        maxIndex = j;
                    }
                    j++;
                }
            } else if(arr[maxIndex] < arr[i+k-1]) {
                maxIndex = i+k-1;
            }
            
            values.add(arr[maxIndex]);
            
        }
        
        
        return values;
    }
}