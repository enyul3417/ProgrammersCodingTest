import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            heap.offer(scoville[i]);
        }
        
        while(heap.peek() < K) {
            if(heap.size() == 1) return -1;
            
            int first = heap.poll();
            int second = heap.poll();
            
            heap.offer(first + (second * 2));
            answer++;
        }
        
        return answer;
    }
}