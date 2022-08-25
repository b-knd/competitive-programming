class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for(char a: magazine.toCharArray()){
            cnt[a-'a']++;
        }
        
        for(char a: ransomNote.toCharArray()){
            cnt[a-'a']--;
            if(cnt[a-'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
