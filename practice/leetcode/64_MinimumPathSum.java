//dynammic programming
//O(mn) time complexity (nested for loop)
//O(1) constant extra space as we are manipulating the cells in original grid so no extra space is used

class Solution {
  
    public int minPathSum(int[][] grid) {
        //use recursion (one right, one down until reaching last cell, update sum)
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //first cell
                if(i == 0 && j == 0) grid[i][j] = grid[i][j];
                //topmost row
                else if(i == 0 && j != 0) grid[i][j] += grid[i][j-1];
                //leftmost column
                else if(i != 0 && j == 0) grid[i][j] += grid[i-1][j];
                //inner column: update with minimum from cell above and left
                else grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
  
}
