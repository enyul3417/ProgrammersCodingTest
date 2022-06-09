import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) 
    {
        List<String> list = new ArrayList();
        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < record.length; i++) 
        {
            String[] temp = record[i].split(" ");
            if(temp[0].equals("Enter")) 
            {
                map.put(temp[1], temp[2]);
                list.add(temp[1] + "님이 들어왔습니다.");
            }
            else if(temp[0].equals("Leave"))
            {
                list.add(temp[1] + "님이 나갔습니다.");
            } 
            else 
            {
                map.put(temp[1], temp[2]);
            }
        }

        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            int index = s.indexOf("님");
            String id = s.substring(0, index);
            answer[i] = map.get(id) + s.substring(index);
        }

        return answer;
    }
}