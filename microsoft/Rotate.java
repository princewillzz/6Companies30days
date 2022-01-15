// { Driver Code Starts
//Initial Template for Java

import java.util.*; 
import java.io.*;
import java.lang.*;

class DriverClass
{
	public static void main(String[] args) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            
            GFG g = new GFG();
            g.rotate(arr);
            printMatrix (arr);
        }
	} 
	
	static void printMatrix(int arr[][]) 
	{ 
		for (int i = 0; i < arr.length; i++) { 
			for (int j = 0; j < arr[0].length; j++) 
				System.out.print(arr[i][j] + " "); 
			System.out.println(""); 
		} 
	} 
}// } Driver Code Ends


//User function Template for Java

class GFG
{
    static void rotate(int matrix[][]) 
    {
        int n = matrix.length;
        int rotated[][] = new int[matrix.length][matrix[0].length];
        
        for(int i = 0; i < n; i++) {
            for(int j = matrix[i].length-1; j >= 0; j--) {
                rotated[n-j-1][i] = matrix[i][j];
            }
        }
        
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rotated[i][j];
            }
        }
    }
}