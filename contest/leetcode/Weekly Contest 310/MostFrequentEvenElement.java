class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        //keep count of the occurrences of even elements using hashmap
        for(int i: nums){
            if(i % 2 == 0){
                hm.put(i, hm.getOrDefault(i, 0)+1);
            }
        }
        
        //no even element found
        if(hm.size() == 0){
            return -1;
        }
        
        //find the most frequent occurring even element
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
