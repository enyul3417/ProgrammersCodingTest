import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> times = new LinkedList<>();
        
        for(int i = 0; i < prices.length; i++) {
            int time = 0;
            for(int j = i; j < prices.length; j++) {
                if(prices[i] > prices[j] || j == prices.length - 1) {
                    times.add(time);
                    break;
                }
                time++;
            }
        }
        
        int[] answer = new int[times.size()];
        int i = 0;
        while(!times.isEmpty()) {
            answer[i++] = times.poll();
        }
        
        return answer;
    }
}