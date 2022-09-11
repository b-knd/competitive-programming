//O(|S| + |T|) time and space complexity

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        //keep a map for t
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++){
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i), 0)+1);
        }
        
        //unique character needed
        int required = dictT.size();
        //initiate left and right pointer
        int l = 0, r = 0;
        //number of unique characters found
        int formed = 0;
        
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int[] ans = {-1, 0, 0};
        
        //keep on increasing right pointer
        while(r < s.length()){
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0)+1);
            //if character count is correct, increment formed character
            if(dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()){
                formed++;
            }
            
            //we have found all characters
            while(l <= r && formed == required){
                c = s.charAt(l);
                //update if shorter substring is found
                if(ans[0] == -1 || r-l+1 < ans[0]){
                    ans[0] = r-l+1;
                    ans[1] = l; ans[2] = r;
                }
                
                windowCounts.put(c, windowCounts.get(c)-1);
                //this is to check whether the contraction is still valid (once not, exit loop)
                if(dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                
                l++;
            }
            
            r++;
        }
        
        return ans[0] == -1? "": s.substring(ans[1], ans[2] + 1);
    }
}
