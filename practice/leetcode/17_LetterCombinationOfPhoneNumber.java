class Solution {
    private static String[] table = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        recurse(new StringBuilder(), result, digits);
        return result;
    }
    
    public void recurse(StringBuilder curr, List<String> res, String digits){
        if(digits.length() == 0){
            if(curr.length() > 0){
                res.add(curr.toString());
            }
            return;
        }
        int len = curr.length();
        int currInteger = Integer.parseInt(digits.substring(0, 1));
        for(char c: table[currInteger-2].toCharArray()){
            curr.append(c);
            recurse(curr, res, digits.substring(1));
            curr.setLength(len);
        }
    }
}
