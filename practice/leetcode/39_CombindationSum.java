class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        recurse(0, candidates, res, new ArrayList<>(), target);
        return new ArrayList<>(res);
    }
    
    
    public void recurse(int i, int[] candidates, List<List<Integer>> res, List<Integer> curr, int target){
        //base case
        if(target == 0){
            if(curr.size() > 0){
                res.add(new ArrayList<>(curr));
            }
            return;
        } 
        if(i == candidates.length){
            return;
        }
        
        //if current index element still can be deducted from target, recurse on same index again
        if(candidates[i] <= target){
            curr.add(candidates[i]);
            recurse(i, candidates, res, curr, target-candidates[i]);
            //backtrack
            curr.remove(curr.size()-1);
        }
        
        //move on with next index
        recurse(i+1, candidates, res, curr, target);
    }
}
