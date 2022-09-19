//O(N) time complexity: single iteration
//O(1) space complexity

class Solution {
    public int longestContinuousSubstring(String s) {
      
        int max = 1;
        
        for(int i = 0; i < s.length(); ){
            int temp = 1;
            while(i < s.length()-1 && s.charAt(i+1)-s.charAt(i) == 1){
                temp++;
                i++;
            }
            max = Math.max(temp, max);
            i++;
        }
        
        return max;
    }
}
