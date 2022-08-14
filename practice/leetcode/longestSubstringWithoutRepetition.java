class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        //this hashmap keep occurence of character and last found index
        HashMap<Character, Integer> hm = new HashMap<>();
        
        //i is the right pointer and j is the left pointer, i is increment until finding repeated character
        for(int i = 0, j = 0; i < s.length(); i++){
            if(hm.containsKey(s.charAt(i))){
                //increment j to be the next index of last found repeated character
                j = Math.max(hm.get(s.charAt(i))+1, j);
            } 
            //keep on updating index of character
            hm.put(s.charAt(i), i);
            //update max (distance between the two pointers)
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
