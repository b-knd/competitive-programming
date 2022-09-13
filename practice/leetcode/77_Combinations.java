//O((nCk)*k) time complexity, where nCk is all the possible subsets of n
//O((nCk)*k) space complexity

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        
        recurse(res, new ArrayList<>(), n, k, 0);
        
        return res;
    }
    
    public void recurse(List<List<Integer>> res, List<Integer> curr, int n, int k, int prev){
        //combination found
        if(curr.size() == k){
            res.add(new ArrayList<>(curr));
            return;
        }
        //no more elements to choose from
        if(prev == n){
            return;
        }
        
        for(int i = prev+1; i <= n; i++){
            curr.add(i);
            recurse(res, new ArrayList<>(curr), n, k, i);
            curr.remove(curr.size()-1);
        }
    }
}
