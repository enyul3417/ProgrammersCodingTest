import java.util.*;

class Solution {
    static ArrayList<String> allRoute = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        boolean[] isVisited = new boolean[tickets.length];
        int cnt = 0;
        
        dfs("ICN", "ICN", tickets, cnt, isVisited);
        
        Collections.sort(allRoute);
        
        String[] answer = allRoute.get(0).split(" ");
        return answer;
    }
    
    public void dfs(String start, String route, String[][] tickets, int cnt, boolean[] isVisited) {
        if(cnt == tickets.length) {
            allRoute.add(route);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals(start) && isVisited[i] == false) {
                isVisited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1, isVisited);
                isVisited[i] = false;
            }
        }
    }
}