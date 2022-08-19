class Solution {
    public boolean isPossible(int[] nums) {
        int prev = Integer.MIN_VALUE, p1 = 0, p2 = 0, p3 = 0;
        
        int curr = 0, c1 = 0, c2 = 0, c3 = 0, count = 0;
        
        for(int i = 0; i < nums.length; prev = curr, p1 = c1, p2 = c2, p3 = c3){
            for(curr = nums[i], count = 0; i < nums.length && nums[i] == curr; i++){
                count++;
            }
            
            if(curr != prev + 1){
                if(p1 != 0 || p2 != 0){
                    return false;
                }
                c1 = count;
                c2 = 0;
                c3 = 0;
            } else{
                if(p1 + p2 > count){
                    return false;
                }
                c2 = p1;
                c3 = p2 + Math.min(p3, count-p1-p2);
                c1 = Math.max(0, count-p1-p2-p3);
            }
        }
        return p1 == 0 && p2 == 0;
    }
}
