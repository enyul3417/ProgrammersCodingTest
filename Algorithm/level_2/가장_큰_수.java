import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, (a,b)->{
            return (b+a).compareTo(a+b);
        });
        
        if(nums[0].equals("0")) answer = "0";
        else {
            for(int i = 0; i < nums.length; i++) 
                answer += nums[i];
        }

           
        
        return answer;
    }
}