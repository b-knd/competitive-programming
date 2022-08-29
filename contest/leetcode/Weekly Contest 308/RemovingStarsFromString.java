//O(N) time
//O(N) space

//using stack
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            //pop previous element if '*', else push to stack
            if(c == '*'){
                stack.pop();
            } else{
                stack.push(c);
            }
        }
      
        //build up result and return
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        return sb.toString();
    }
}
