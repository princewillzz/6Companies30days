// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    class SubSeq {
        public static boolean isSubSequence(ArrayList<Integer> v1, ArrayList<Integer> v2,
                                     int n, int m) {
    
            if (m == 0) return true;
            if (n == 0) return false;
    
            if (v1.get(n - 1).equals(v2.get(m - 1)))
                return isSubSequence(v1, v2, n - 1, m - 1);
    
            return isSubSequence(v1, v2, n - 1, m);
        }
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int tc = Integer.parseInt(br.readLine().trim());
            while (tc-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                String[] str = br.readLine().trim().split(" ");
                ArrayList<Integer> a = new ArrayList<Integer>();
                for (int i = 0; i < n; i++) {
                    a.add(Integer.parseInt(str[i]));
                }
                Solution g = new Solution();
                ArrayList<Integer> res = g.find3Numbers(a, n);
    
                // wrong format output
                if (!res.isEmpty() && res.size() != 3) {
                    System.out.println(-1);
                }
    
                if (res.isEmpty()) {
                    System.out.println(0);
                } else if ((res.get(0) < res.get(1)) && (res.get(1) < res.get(2)) &&
                           isSubSequence(a, res, n, res.size())) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }// } Driver Code Ends
    
    
    /*Complete the function below*/
    class Solution {
        ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
            int next[] = new int[n];
            Stack<Integer> st = new Stack<>();
            for(int i=n-1;i>=0;i--){
                while(!st.isEmpty() && arr.get(st.peek())<=arr.get(i)) st.pop();
                next[i] = st.isEmpty()?n:st.peek();
                st.push(i);
            }
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                if(next[i]<n && next[next[i]]<n){
                    list.add(arr.get(i));
                    list.add(arr.get(next[i]));
                    list.add(arr.get(next[next[i]]));
                    return list;
                }
            }
            return list;
        }
    }