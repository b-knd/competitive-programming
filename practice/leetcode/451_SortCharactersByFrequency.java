class Solution {
    public String frequencySort(String s) {
        //count occurrence of characters and store in hashmap
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c: s.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }
        
        //put info from hashmap into priority queue, arranged based on occurence in a descending manner
        PriorityQueue<char[]> queue = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        for(char c: hm.keySet()){
            queue.add(new char[] {c, (char)hm.get(c).intValue()});
        }
        
        //build result string by popping off from priority queue
        StringBuilder sb = new StringBuilder();
        while(queue.size()>0){
            char[] temp = queue.poll();
            for(int i = 0; i < temp[1]; i++){
                sb.append(temp[0]);
            }
        }
        return sb.toString();
    }
}
