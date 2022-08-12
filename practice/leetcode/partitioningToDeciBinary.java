class Solution {
    //find the maximum digit in the string
    public int minPartitions(String n) {
        int max = 0;
        for(Character c: n.toCharArray()){
            max = Math.max(max, c-'0');
        }
        return max;
    }
}
