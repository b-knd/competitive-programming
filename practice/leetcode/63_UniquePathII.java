class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        //starting or ending point is an obstacle, return 0
        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1){
            return 0;
        }
        
        //starting point
        obstacleGrid[0][0] = 1;
      
        //filling up topmost row and leftmost column: if the cell or cell before is obstacle set to 0, otherwise, initiate as 1
        for(int i = 1; i < m; i++){
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1? 1 : 0);
        }
        for(int j = 1; j < n; j++){
            obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 && obstacleGrid[0][j-1] == 1? 1: 0);
        }
        
        //filling up inner rows and columns
        //if the current cell is space: add up cell value (left and above), 0 otherwise (indicating obstacle and no path found)
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                } else{
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        
        return obstacleGrid[m-1][n-1];
    }
}
