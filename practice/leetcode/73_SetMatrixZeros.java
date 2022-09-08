//O(1) space solution
//use first col and first row cell as flags
class Solution {
    public void setZeroes(int[][] matrix) {   
        //indication for first column
        boolean isCol = false;
      
        for(int i = 0; i < matrix.length; i++){
            //if first column contains zero, set isCol to true (we need to change first col to all zero in the end)
            if(matrix[i][0] == 0){
                isCol = true;
            }
          
            //if cell is zero, set first cell of the row and col to zero as flags
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //fill cell with zero by checking with flags
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        //check if we need to set first row to all zero
        if(matrix[0][0] == 0){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
        //check if we need to set first col to all zero
        if(isCol){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}



//O(MxN) time complexity
//O(N) space complexity

class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> cols = new ArrayList<>();
        
        for(int i = 0; i < matrix.length; i++){
            boolean flag = false;
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    flag = true;
                    if(!cols.contains(j)){
                        cols.add(j);
                    } 
                }
            }
            if(flag){
                for(int j = 0; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }   
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(Integer j: cols){
                matrix[i][j] = 0;
            }
        }
    }
}
