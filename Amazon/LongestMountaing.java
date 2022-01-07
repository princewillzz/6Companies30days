import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestMountaing {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
            List<Integer> inp = Arrays.asList(in.readLine().split(" "))
            .stream()
            .map(ele -> Integer.parseInt(ele))
            .collect(Collectors.toList());

        int ar[] = new int[inp.size()];
            for (int i = 0; i < inp.size(); i++) {
            ar[i] = inp.get(i);
        }

        System.out.println(new Solution().longestMountain(ar));

    }
}

class Solution {
    public int longestMountain(int[] arr) {
        if(arr.length < 3) return 0;
        int max = 0;
        
        int up = 0, down = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i-1]) {
                if(down != 0 && up != 0) {
                    max = Math.max(max, up+down+1);
                    up = 0; down = 0;
                } else if(down != 0) down = 0;
                
                up++;                
            } else if(arr[i] < arr[i-1]) {
                down++;
            } else {
                if(down != 0 && up != 0) {
                    max = Math.max(max, up+down+1);
                }
                up = 0; down = 0;
            }
        }
        
        if(down != 0 && up != 0) {
            max = Math.max(max, up+down+1);
        }
        
        return max;
        
    }
}