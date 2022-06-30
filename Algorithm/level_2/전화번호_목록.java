import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, String> phoneMap = new HashMap<>();
        
        for(String str : phone_book) {
            phoneMap.put(str, str);
        }
        
        for(String str : phone_book) {
            for(int i = 0; i < str.length(); i++) {
                String s = str.substring(0, i);
                if(phoneMap.containsKey(s)) answer = false;
            }
        }
        
        return answer;
    }
}