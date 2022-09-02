//O(max(M, N)) time complexity where M and N are lengths of a and b
//O(max(M, N)) space complexity which is the size of "res"

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        
        int carry = 0;
        int sum;
        int x;
        int y;
        
        while(a.length() > 0 || b.length() > 0 || carry > 0){
            x = a.length() > 0? Integer.parseInt(a.substring(a.length()-1)): 0;
            y = b.length() > 0? Integer.parseInt(b.substring(b.length()-1)): 0;
            sum = x + y + carry;
            
            a = a.length() > 0? a.substring(0, a.length()-1): a;
            b = b.length() > 0? b.substring(0, b.length()-1): b;
            carry = sum / 2;
            res.append(sum % 2);
            sum /= 2;
        }
        
        return res.reverse().toString();
    }
}
