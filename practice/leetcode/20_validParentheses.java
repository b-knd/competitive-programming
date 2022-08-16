class Solution {
    
    public boolean isValid(String s) {
        //to have valid parentheses, length must be even
        if(s.length() % 2 != 0){
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()){
            //push opening brackets to stack
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else {
                //if the current character is a closing bracket but stack is empty means closing comes before opening so false
                if(stack.empty()) return false;
                //if unmatched brackets found, return false
                if(c == ')' && stack.peek() != '(' || c == ']' && stack.peek() != '[' || c == '}' && stack.peek() != '{'){
                    return false;
                }
                //pop from stack for corrent pairs
                stack.pop();
            }
        }
        //stack is not empty means it has unclosed opening brackets inside
        return stack.empty();
    }
}
