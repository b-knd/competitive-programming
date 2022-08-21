class Solution {
    public String smallestNumber(String pattern) {
        //to take care of situation where pattern start from 'D'
        pattern = "I" + pattern;

        StringBuilder res = new StringBuilder();

        int prev = 0;

        for(int i = 0; i < pattern.length();){
            //if next character is 'D', create stack, push incremented prev to stack until no more D, pop and append to result
            if(i < pattern.length()-1 && pattern.charAt(i+1) == 'D'){
                Stack<Integer> stack = new Stack<>();
                do{
                    prev++;
                    stack.push(prev);
                    i++;
                }
                while(i < pattern.length() && pattern.charAt(i) == 'D');

                while(!stack.empty()){
                    res.append(stack.pop());
                }
            //otherwise ('I'), simply increment prev and append to result
            } else {
                prev++;
                res.append(prev);
                i++;
            }
        }
        return res.toString();
    }
}
