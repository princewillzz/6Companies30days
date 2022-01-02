package Goldman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PrintAnagramsOptimised {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] words = (br.readLine().split(" "));

        Solution solution = new Solution();
        List<List<String>> groups = solution.groupAnagrams(words);

        System.out.println(groups);

    }
}

class Solution {

    List<List<String>> groupAnagrams(String[] words) {
        
        HashMap<String, List<String>> groupIndexer = new HashMap<>();

        for (String word : words) {
            char wordArray[] = word.toCharArray();
            Arrays.sort(wordArray);
            String sortedString = String.valueOf(wordArray);

            if(!groupIndexer.containsKey(sortedString)) {
                groupIndexer.put(sortedString, new ArrayList<>());
            }

            List<String> group = groupIndexer.get(sortedString);
            group.add(word);
            groupIndexer.put(sortedString, group);
        }

        // return groupIndexer.values().stream().collect(Collectors.toList());
        return new ArrayList<>(groupIndexer.values());

    }
}