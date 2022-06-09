import java.util.*;

class Solution {
    public int[] solution(String[] operations) 
    {
        Queue<Integer> minQueue = new PriorityQueue<>();
        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) 
        {
            String[] temp = operations[i].split(" ");
            int num = Integer.parseInt(temp[1]);
            
            switch(temp[0]) {
                case "I":
                    minQueue.add(num);
                    maxQueue.add(num);
                    break;
                case "D":
                    if(num == 1) // 최댓값 삭제
                    {
                        if(!maxQueue.isEmpty()) {
                            int max = maxQueue.poll();
                            minQueue.remove(max);
                        }
                    }
                    else // 최솟값 삭제
                    {
                        if(!minQueue.isEmpty()) {
                            int min = minQueue.poll();
                            maxQueue.remove(min);
                        }
                    }
                    break;
            }            
        }
        int max = maxQueue.peek() == null ? 0 : maxQueue.peek();
        int min = minQueue.peek() == null ? 0 : minQueue.peek();
        
        int[] answer = {max, min};
        return answer;
        
    }
}