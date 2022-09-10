//insertion sort: in-place, unstable
//O(N^2) time complexity
//O(1) space complexity

class Solution {
    public void sortColors(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            int key = nums[i];
            int j = i-1;
            
            while(j >= 0 && nums[j] > key){
                nums[j+1] = nums[j];
                j -= 1;
            }
            nums[j+1] = key;
        }
    }
}
