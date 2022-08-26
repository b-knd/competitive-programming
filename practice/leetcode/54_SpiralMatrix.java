class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowStart = 0, rowEnd = matrix.length-1;
        int colStart = 0, colEnd = matrix[0].length-1;
        
        int targetSize = matrix.length * matrix[0].length;
            
        while(res.size() < targetSize){
            //traversing right
            for(int i = colStart; i <= colEnd && res.size() < targetSize; i++){
                res.add(matrix[rowStart][i]);
            }
            rowStart++;
            
            //traversing down
            for(int i = rowStart; i <= rowEnd && res.size() < targetSize; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            //traversing left
            for(int i = colEnd; i >= colStart && res.size() < targetSize; i--){
                res.add(matrix[rowEnd][i]);
            } 
            rowEnd--;

            //traversing up
            for(int i = rowEnd; i >= rowStart && res.size() < targetSize; i--){
                res.add(matrix[i][colStart]);
            }  
            colStart++;
        }
        return res;
    }
}
