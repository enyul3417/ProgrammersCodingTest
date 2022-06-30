import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] man1 = {1, 2, 3, 4, 5};
        int[] man2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] man3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = {0, 0, 0};
        
        for(int i = 0; i < answers.length; i++) 
        {
            if(answers[i] == man1[i % man1.length]) scores[0]++;
            if(answers[i] == man2[i % man2.length]) scores[1]++;
            if(answers[i] == man3[i % man3.length]) scores[2]++;
        }
        
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < scores.length; i++)
            if(max == scores[i]) list.add(i + 1);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}