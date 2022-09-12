
class Solution {
    public int partitionString(String s) {
        int count = 0;
        int[] cnt = new int[26];
        for(int i = 0; i < s.length();){
            Arrays.fill(cnt, 0);
            while(i < s.length() && cnt[s.charAt(i)-'a'] == 0){
                cnt[s.charAt(i)-'a']++;
                i++;
            }
            count++;
        }
        return count;
    }
}
