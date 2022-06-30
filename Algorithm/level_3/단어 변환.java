class Solution {
    static int answer = 99999;
	
	public static int solution(String begin, String target, String[] words) 
	{
		for(int i = 0; i < words.length; i++) 
		{
			if(compare(begin, words[i]) <= 1) 
			{
				boolean[] check = new boolean[words.length];
				check[i] = true;
				dfs(target, words, check, i, 1);
			}
		}
		
		return answer == 99999 ? 0 : answer;    
	}
	
	public static void dfs(String target, String[] words, boolean[] check, int current, int cnt) 
	{
		if(words[current].equals(target)) 
		{
			answer = Math.min(answer, cnt);
			return;
		}
		
		for(int i = 0; i < words.length; i++) 
		{
			if(!check[i] && compare(words[current], words[i]) == 1) 
            {
				check[i] = true;
				dfs(target, words, check, i, cnt + 1);
				check[i] = false;
			}
		}
	}
	
	public static int compare(String begin, String word) 
	{
		int cmp = 0;
		
		for(int i = 0; i < begin.length(); i++)
			if(begin.charAt(i) != word.charAt(i))
				cmp++;
		
		return cmp;
		
	}
}