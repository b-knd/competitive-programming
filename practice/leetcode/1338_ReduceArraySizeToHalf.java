class Solution {
    
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        //keep a hashmap to count occurrences for each element
        for(int i: arr){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
      
        //put counts in array and sort array
        int[] array = new int[hm.size()];
        int index = 0;
        for(int i: hm.values()){
            array[index++] = i;
        }
        Arrays.sort(array);
      
        //from the greatest element (last index), add sum until sum exceeds half of initial array size, return count
        int count = 0;
        int sum = 0;
        index = hm.size()-1;
        while(sum < arr.length/2){
            sum += array[index--];
            count++;
        }
        return count;
    }
}
