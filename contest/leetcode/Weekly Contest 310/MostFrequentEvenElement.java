class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i: nums){
            if(i % 2 == 0){
                hm.put(i, hm.getOrDefault(i, 0)+1);
            }
        }
        
        if(hm.size() == 0){
            return -1;
        }
        
        int res = -1;
        for(int i: hm.keySet()){
            if(res == -1){
                res = i;
            } else{
                if(hm.get(i) > hm.get(res)){
                    res = i;
                } else if(hm.get(i) == hm.get(res) && i < res){
                    res = i;
                }
            }
        }
        return res;
    }
}
