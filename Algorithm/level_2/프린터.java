import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> wait = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < priorities.length; i++) {
            wait.add(priorities[i]);
        }
        
        while(!wait.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(priorities[i] == wait.peek()) {
                    if(i == location) {
                        return ++answer;
                    }
                    wait.poll();
                    answer++;
                }
            }
        }
        
        return -1;
    }
}