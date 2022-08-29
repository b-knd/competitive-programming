//O(MN + Nlogn) time
//O(1) space

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        //sort number ascendingly
        Arrays.sort(nums);
        
        int sum;
        int index;
        //add up element until sum is just before exceeding  query
        for(int i = 0; i < queries.length; i++){
            sum = 0;
            index = 0;
            //if increment by num does not exceed query
            while(index < nums.length && (sum + nums[index]) <= queries[i]){
                sum += nums[index];
                index++;
            }
            queries[i] = index;
        }
        return queries;
    }
}
