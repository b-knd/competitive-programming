class Solution {
    public int[] findArray(int[] pref) {
        
        int temp = pref[0];
      
        for(int i = 1; i < pref.length; i++){
            pref[i] = pref[i] ^ temp;
            temp ^= pref[i];
        }
      
        return pref;
    }
}
