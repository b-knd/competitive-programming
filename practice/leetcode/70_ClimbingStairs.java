//O(n) time complexity
//O(1) space complexity

class Solution {
    public int climbStairs(int n) {
        //no ways
        if(n <= 0) return 0;
        //1 way to get to n=1 by taking 1 step
        if(n == 1) return 1;
        //2 ways to get to n=2 by taking either 2 '1' steps or a 2-steps leap
        if(n == 2) return 2;
        
        //starting point is n = 3, n-1 = 2, n-2 = 1
        int oneStepBefore = 2;
        int twoStepBefore = 1;
        int allWays = 0;
        
        for(int i = 3; i <= n; i++){
            allWays = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = allWays;
        }
        
        return allWays;
    }
}
