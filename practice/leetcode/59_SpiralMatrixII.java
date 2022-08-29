class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int x = 1;
        
        while(x <= n*n){
            //left to right
            for(int i = colStart; i <= colEnd; i++){
                res[rowStart][i] = x;
                x++;
            }
            rowStart++;
            
            //up to down
            for(int i = rowStart; i <= rowEnd; i++){
                res[i][colEnd] = x;
                x++;
            }
            colEnd--;
            
            //right to left
            for(int i = colEnd; i >= colStart; i--){
                res[rowEnd][i] = x;
                x++;
            }
            rowEnd--;
            
            //down to up
            for(int i = rowEnd; i >= rowStart; i--){
                res[i][colStart] = x;
                x++;
            }
            colStart++;
        }
        
        return res;
    }
}
