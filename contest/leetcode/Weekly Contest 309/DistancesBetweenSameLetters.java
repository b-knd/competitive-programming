class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] disCount = new int[26];
        Arrays.fill(disCount, -1);
        for(int i = 0; i < s.length(); i++){
            //first occurrence
            if(disCount[s.charAt(i)-'a'] == -1){
                disCount[s.charAt(i)-'a'] = i;
            }
            //second occurrence
            else {
                //find difference and check against distance array, return false if incorrect
                int ltrs = Math.abs(disCount[s.charAt(i)-'a'] - i)-1;
                if(distance[s.charAt(i)-'a'] != ltrs){
                    return false;
                }
            }
        }
        return true;
    }
}
