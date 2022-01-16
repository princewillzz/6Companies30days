// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return 1;
                        else
                            return 0;
                    }
                
                    if(index1 < index2)
                        return 1;
                    else
                        return 0;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
     public String findOrder(String [] dict, int N, int K)
    {
     Map<Character,ArrayList<Character>> adj=new HashMap<>();  
     Map<Character,Integer> indegree=new HashMap<>();
     //creating adjacency list
     for(int i=0;i<dict.length-1;i++){
      String s1=dict[i];
      String s2=dict[i+1];
      for(int j=0;j<s1.length()&&j<s2.length();j++){
         if(s1.charAt(j)!=s2.charAt(j)){
          ArrayList<Character> l=adj.getOrDefault(s1.charAt(j),new ArrayList<>());
          l.add(s2.charAt(j));
          adj.put(s1.charAt(j),l);
          
          //Adding elements in indegree map to calculate indegree of each character later
          if(!indegree.containsKey(s1.charAt(j))){
             indegree.put(s1.charAt(j),0);
          }
          if(!indegree.containsKey(s2.charAt(j))){
             indegree.put(s2.charAt(j),0);
          }
          break;
         }
      }
     }
     //calculating indegree of each element in indegree map using adjacency list;
     for(char ch:indegree.keySet()){
        ArrayList<Character> l=adj.getOrDefault(ch,new ArrayList<>());
        for(char neighbour:l){
         int in=indegree.get(neighbour);
         indegree.put(neighbour,in+1);
        }
     }
     //using topological sort to get the required sequence of characters
     String str="";
     //adding elements with indegree 0 in queue
     Queue<Character> q=new LinkedList<>();
     for(char ch:indegree.keySet()){
       if(indegree.get(ch)==0){
        q.add(ch);
       }
     }
     while(!q.isEmpty()){
        //removing element from queue ans adding it to sequence
        char ch=q.poll();
        str+=ch;
        ArrayList<Character> neighbours=adj.getOrDefault(ch,new ArrayList<>());
        //decreasing indegree by 1 of characters present in the adjacency list of removed character
        for(char neighbour:neighbours){
         int in=indegree.get(neighbour)-1;
         indegree.put(neighbour,in);
         //adding element if indegree is 0
         if(in==0){
            q.add(neighbour);
         }
        }
     }
     return str;  
    }
}