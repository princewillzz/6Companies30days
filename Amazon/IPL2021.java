import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IPL2021 {
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

        int k = Integer.parseInt(in.readLine());

        System.out.println(new Solution().findMaxOfKRange(ar, k));
    }
}


class Solution {
    List<Integer> findMaxOfKRange(int ar[], int k) {

        int maxOfKIndex = -1;

        List<Integer> allMax = new ArrayList<>();

        for (int i = 0; i < ar.length - k + 1; i++) {
            if(maxOfKIndex == i-1) {
                maxOfKIndex = i;
                for (int j = i+1; j < i+k; j++) {
                    if(ar[maxOfKIndex] < ar[j]) {
                        maxOfKIndex = j;
                    }
                }
            } else if(ar[i+k-1] > ar[maxOfKIndex]) {
                maxOfKIndex = i+k-1;
            }

            allMax.add(ar[maxOfKIndex]);
        }

        return allMax;

    }
}