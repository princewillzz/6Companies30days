
import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
       
        
        // List<List<Integer>> anagramsIndex = new ArrayList<ArrayList<>>();
        
        List<List<String>> anagrams = new ArrayList<List<String>>();
        for(int index = 0; index < string_list.length; index++) {
        
            String currentWord = string_list[index];
            int foundAt = -1;
            // check for all the string before it
            for(int groupIndex = 0; groupIndex < anagrams.size(); groupIndex++) {
                List<String> group = anagrams.get(groupIndex);
                String toCheck = group.get(group.size()-1);
                
                
                // check anagramity of toCheck and currentWord
                boolean isAna = checkIfAnagram(currentWord, toCheck);
                // System.out.println(currentWord + " " + toCheck + " " + isAna);
                if(isAna) {
                    foundAt = groupIndex;
                    break;
                }
                
            }
            
            
            // if found put it in the position
            if(foundAt != -1) {
                anagrams.get(foundAt).add(currentWord);
            }
            else // else put it in the back or last
                {
                    List<String> temp = new ArrayList<String>();
                    temp.add(currentWord);
                    anagrams.add(temp);
                    
                }
            
        }
        
        
        return anagrams;
    }
    
    boolean checkIfAnagram(String currentWord, String toCheck) {
        
        
        if(currentWord.length() != toCheck.length()) return false;
        
        HashMap<Character, Integer> h1 = new HashMap<>(), h2 = new HashMap<>();
        
        for(int i = 0; i < currentWord.length(); i++) {
            if(h1.containsKey(currentWord.charAt(i))) {
                h1.put(currentWord.charAt(i), h1.get(currentWord.charAt(i)) + 1);
            } else {
                h1.put(currentWord.charAt(i), 1);
            }
            
            if(h2.containsKey(toCheck.charAt(i))) {
                h2.put(toCheck.charAt(i), h2.get(toCheck.charAt(i)) + 1);
            } else {
                h2.put(toCheck.charAt(i), 1);
            }
        }
    
        
        for(int i = 0; i < toCheck.length(); i++) {
            char ch = toCheck.charAt(i);
            if(h1.get(ch) != h2.get(ch)) return false;
        }
        
        
        
        return true;
    }
}
