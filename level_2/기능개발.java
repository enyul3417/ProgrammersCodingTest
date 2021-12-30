import java.lang.Math;
import java.lang.Math;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            queue.add((int)Math.ceil((double)(100 - progresses[i])/speeds[i]));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int days1 = queue.poll();
        int cnt = 1;
        int days2 = 0;
        
        while(!queue.isEmpty()) {
            days2 = queue.poll();
            if(days1 >= days2) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                days1 = days2;
            }
        }
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}