class Solution {
    public int smallestEvenMultiple(int n) {
        //if n is even, smallest multiple is n itself, otherwise smallest multiple is the product of n and 2
        if(n % 2 == 0){
            return n;
        } else{
            return n * 2;
        }
    }
}
