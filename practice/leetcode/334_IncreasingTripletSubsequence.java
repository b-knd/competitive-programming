//O(n) time complexity
//O(1) space complexity

//basically shifted and updating a and b, once both have values and we found another one greater than b, triplet exists
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for(int n: nums){
            if(n <= a) a = n;
            else if (n <= b) b = n;
            else return true;
        }
        return false;
    }
}
