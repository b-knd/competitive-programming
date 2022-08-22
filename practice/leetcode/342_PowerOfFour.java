class Solution {
    public boolean isPowerOfFour(int n) {
      
        //base cases
        if(n == 0){
            return false;
        } if(n == 1){
            return true;
        }
      
        //recursive call
        if(n % 4 == 0){
            return isPowerOfFour(n/4);
        }
        return false;
    }
}
