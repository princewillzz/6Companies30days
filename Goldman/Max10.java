package Goldman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Max10 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        Arrays.asList("9 7 812 21 0 21 43 12 -12 12 2 023 21 0 231 0 21 1000 1400 1060 2000 100 100 999 899".split(" "))
            .stream()
            .forEach(_it -> {
                int item = Integer.parseInt(_it);
                heap.add(item);
                if(heap.size() > 10) {
                    heap.poll();
                }
            });

        // for(Object item: heap.toArray()) {
        //     System.out.print(item + " ");
        // }
        
        // System.out.println();
        while(!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        } 
        System.out.println();
        

        br.close();
    }
}
// 9 7 812 21 0 21 43 12 -12 12 2 023 21 0 231 0 21 1000 1000 1000 1000 100 100 999 899