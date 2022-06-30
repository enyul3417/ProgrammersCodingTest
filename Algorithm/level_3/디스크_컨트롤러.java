import java.util.*;

class Solution 
{
    public int solution(int[][] jobs) 
    {
        int answer = 0;
        
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); 
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int i = 0;
        int time = jobs[0][0];
        while(i < jobs.length || !queue.isEmpty()) 
        {
            while(i < jobs.length && jobs[i][0] <= time)
                queue.add(jobs[i++]);
            
            if(queue.isEmpty()) 
            {
                time = jobs[i][0];
                queue.add(jobs[i++]);
            }
            
            int[] temp = queue.poll();
            time += temp[1];
            answer += time - temp[0];
            
        }
        
        return answer / jobs.length;
    }

}