class Solution 
{
    public int solution(String s) 
    {
        int answer = s.length();
        
        for(int i = 1; i < s.length(); i++) 
        {
            String tmp = "";
            String pattern = s.substring(0, i);
            int cnt = 1;
            for(int j = i; j < s.length(); j += i) 
            {
                int end = 0;
                if(j + i > s.length()) end = s.length();
                else end = j + i;
                
                if(pattern.equals(s.substring(j, end))) cnt++;
                else 
                {
                    if(cnt > 1) tmp += cnt + pattern;
                    else tmp += pattern;
                    
                    pattern = s.substring(j, end);
                    cnt = 1;
                }
                
                if(end == s.length()) {
                    if(cnt > 1) tmp += cnt + pattern;
                    else tmp += pattern;
                }
            }
            if(answer > tmp.length()) answer = tmp.length();
        }
        return answer;
    }
}