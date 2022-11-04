class Solution {
    public String reverseVowels(String s) {
      //two pointers concept
        int left = 0;
        int right = s.length()-1;
        ArrayList<Character> vowels = new ArrayList<> (Arrays.asList(new Character[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}));

        String[] split = s.split("");
        while (left < right){
            if(vowels.contains(s.charAt(left))){
                while (left < right && !vowels.contains(s.charAt(right))){
                    right--;
                }
                if (left < right){
                    String tmp = split[left];
                    split[left] = split[right];
                    split[right] = tmp;
                    right--;
                }
            }
            left++;
        }
        return String.join("", split);
    }
}
