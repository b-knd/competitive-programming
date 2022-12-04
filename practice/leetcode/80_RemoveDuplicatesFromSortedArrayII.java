class Solution {
    public int removeDuplicates(int[] nums) {
        //two pointers: start point to insertion position, pointer point to element currently being checked
        int start = 0;
        int pointer = 0;
      
        //keep track of number of occurrence of current element
        int count = 1;
        //previous element being checked
        int prev = Integer.MAX_VALUE;
      
        while(pointer < nums.length){
            //occur before, update count, otherwise reset count to 1 and update prev element
            if(nums[pointer] == prev){
                count++;
            } else{
                count = 1; //resetting
                prev = nums[pointer];
            }
            
            //rewrite array at start position with element pointed
            nums[start] = nums[pointer];
            
            //if count is still <= 2, increment start
            //otherwise, start unchanged to simulate removing of element at the start position
            if(count <= 2){
                start++;
            }
            
            //move on to next element
            pointer++;
        }
      
        //return result, size is the same as value of 'start'
        return start;
    }
}
