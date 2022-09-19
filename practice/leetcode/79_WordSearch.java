class Solution {
    public boolean exist(char[][] board, String word) {
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(recurse(0, row, col, board, word)) return true;
            }
        }
        return false;
    }
    
    public boolean recurse(int idx, int i, int j, char[][] board, String word){
        //base case
        if(idx == word.length()) return true;
        
        //invalid index on board
        if(j < 0 || i < 0 || j == board[0].length || i == board.length) return false;
        
        //wrong character found
        if(board[i][j] != word.charAt(idx)) return false;
        
        //mark as used
        board[i][j] ^= 256;
        boolean exist = recurse(idx+1, i-1, j, board, word) || recurse(idx+1, i+1, j, board, word) || recurse(idx+1, i, j+1, board, word) || recurse(idx+1, i, j-1, board, word);
        //unmark
        board[i][j] ^= 256;
        
        return exist;
    }
}
