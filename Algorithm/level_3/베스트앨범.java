import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genresMap = new HashMap();
        
        for(int i = 0; i < genres.length; i++) {
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        ArrayList<String> genre = new ArrayList<>();
        for(String key : genresMap.keySet()) {
            genre.add(key);
        }
        Collections.sort(genre, (o1, o2) -> genresMap.get(o2) - genresMap.get(o1));
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < genre.size(); i++) {
            String g = genre.get(i);
            
            int max1 = -1;
            int first = -1;
            
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && plays[j] > max1) {
                    max1 = plays[j];
                    first = j;
                }
            }
            list.add(first);
            
            int max2 = -1;
            int second = -1;
            
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && plays[j] > max2 && j != first) {
                    max2 = plays[j];
                    second = j;
                }
            }
            
            if(second != -1) list.add(second);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}