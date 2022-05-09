class Solution {
    static int answer;
    
    public void dfs(int[] numbers, int target, int total, int depth) {
        if(depth == numbers.length) {
            if(total == target) answer++;
        } else {
            dfs(numbers, target, total + numbers[depth], depth + 1);
            dfs(numbers, target, total - numbers[depth], depth + 1);
        }
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }
}