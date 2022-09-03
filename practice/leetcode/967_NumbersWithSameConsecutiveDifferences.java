//O(2^N) time complexity (similar to a depth first search where we build solution one by one, each recursion call branch to two other for curr-k and curr+k)
//O(2^N) space complexity (recursion: O(N) space, list to keep result which could amount to 9*2^(N-1) space so overal O(2^N) space complexity)

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> arrList = new ArrayList<>();
        
        for(int i = 1; i <= 9; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            recursion(arrList, n, k, i, sb);
        }
        
        return arrList.stream().mapToInt(Integer::intValue).toArray();  
    }
    
    public void recursion(List<Integer> arrList, int n, int k, int curr, StringBuilder sb){
        //base case
        if(sb.length() == n){
            arrList.add(Integer.parseInt(sb.toString()));
            return;
        }
        int len = sb.length();
        
        if(curr - k >= 0){
            sb.append(curr-k);
            recursion(arrList, n, k, curr-k, sb);
        }
        sb.setLength(len);
        if(curr + k < 10 && curr-k != curr+k){
            sb.append(curr+k);
            recursion(arrList, n, k, curr+k, sb);
        }
    }
}
