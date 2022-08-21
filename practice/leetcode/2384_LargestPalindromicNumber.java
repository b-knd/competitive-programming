//not submitted
/*
Steps:
1. Implement array to keep count of each character occurrences
2. Starting from the largest digit, while the count is larger than 2, we append to result and deduct count by 2
3. If the result is not empty but start with zero, means the whole string is made up of zero, reset arr[0] = 1
   (if there are no number greater than 0, we can return 0 in the end)
4. Reverse sb, append largest number remained, append tail to sb and return
*/

class Solution {
    public String largestPalindromic(String num) {
        int[] arr = new int[10];
        
        //count occurrences of each characters
        for(char c: num.toCharArray()){
            arr[c - '0']++;
        }

        //build palindrome from the largest digit, updating array by -= 2
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            while(arr[i] >= 2){
                sb.append(i);
                arr[i] -= 2;
            }
        }

        if(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.setLength(0);
            arr[0] = 1;
        }

        String tail = new StringBuilder(sb).reverse().toString();
        //append with largest number if exist
        for(int i = 9; i >= 0; i--){
            if(arr[i] > 0){
                sb.append(i);
                break;
            }
        }
        
        sb.append(tail);
        return sb.toString();
    }
}
