// { Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	
	    int ans = 0;
	    
	    boolean minus = false;
	    if(str.charAt(0) == '-') {
	        minus = true;
	    }
	    
	    for(int i = minus? 1: 0; i < str.length(); i++) {
	        char ch = str.charAt(i);
	        
	        if(ch < '0' || ch > '9') {
	            return -1;
	        }
	        
	        ans = ans*10 + (int) (ch-'0');
	    }
	    
	    return minus? ans*-1: ans;
    }
}
