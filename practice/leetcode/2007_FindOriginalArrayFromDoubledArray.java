class Solution {
    public int[] findOriginalArray(int[] changed) {
        //odd-length array is definitely not a doubled one
        if(changed.length % 2 != 0){
            return new int[0];
        }
        
        //sort array (O(logn) time)
        Arrays.sort(changed);
        //use linked hashmap to preserve indertion order
        LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
        int[] res = new int[changed.length/2];
        int index = 0;
        
        //count occurrences
        for(int i: changed){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        
        //loop through hashmap and add to result array accordingly
        for(int i: hm.keySet()){
            if(i == 0){
                for(int j = 0; j < hm.get(i)/2; j++){
                    res[index] = i;
                    index++;
                }
            } else {
                while (hm.get(i) > 0 && hm.containsKey(i*2) && hm.get(i*2) > 0){
                    res[index] = i;
                    index++;
                    hm.put(i*2, hm.get(i*2)-1);
                    hm.put(i, hm.get(i)-1);
                }
            }
        }
        
        if(index < res.length){
            return new int[0];
        }
        return res;
    }
}
