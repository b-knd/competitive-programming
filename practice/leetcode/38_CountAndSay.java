//recursion
class Solution {
    public String countAndSay(int n) {
        //base case
        if(n == 1){
            return "1";
        }
        //count previous (recursion)
        return count(countAndSay(n-1));
    }
    
    
    public String count(String str){
       
        StringBuilder sb = new StringBuilder();
       
        for(int i = 0; i < str.length();){
            //count occurrence of current character, at least one (if counting from the current one)
            int count = 1;
            
            //while within index bound and next character is same as current, increment i and count
            while(i < str.length()-1 && str.charAt(i+1) == str.charAt(i)){
                i++;
                count++;
            }
            
            //append digit count and digit itself to string builder
            sb.append(count).append(str.charAt(i));
            
            //move one to next character
            i++;
        }
        return sb.toString();    
    }
}
