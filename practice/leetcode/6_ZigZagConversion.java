//my solution using matrix
class Solution {
    public String convert(String s, int numRows) {
        //if row == 1 simply return string as zigzag form is the same as string itself
        if(numRows == 1){
            return s;
        }
      
        //do some calculation to find out how many columns in total (not necessary to be honest as spaces will be compressed in the end)
        int remainder = s.length()%(numRows*2-2);  
        int numCols = (s.length()/(numRows*2-2))*(numRows-1) + ( remainder > numRows? remainder-numRows+1 : remainder > 0? 1:0);
        String[][] mat = new String[numRows][numCols];
        
        for(String[] arr: mat){
            Arrays.fill(arr, "");
        }
        
        int row = 0;
        int col = 0;
        int dir = 0;
      
        //traverse matrix in a zigzag manner
        for(String str: s.split("")){
            mat[row][col] = str;
            if(dir == 0){
                if(row+1 >= numRows){
                    dir = 1;
                    col++;
                    row--;
                } else{
                    row++;
                }
            } else{
                if(row-1 < 0){
                    dir = 0;
                    row++;
                } else{
                    col++;
                    row--;
                }
            }
        }
        
        //join string and return result
        StringBuilder sb = new StringBuilder();
        for(String[] arr: mat){
            sb.append(String.join("",arr));
        }
        return sb.toString();
    }
}

//improved version using arraylist and string builder

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        //assuming each indices corresponds to rows
        for(int i = 0; i < numRows; i++){
            rows.add(new StringBuilder());
        }
        
        int row = 0;
        boolean dir = false; //true: going down, false: going up
        
        for(char c: s.toCharArray()){
            rows.get(row).append(c);
            //change direction upon reaching topmost rows and bottomost row
            //take note of initial direction
            if(row == 0 || row == numRows-1){
                dir = !dir;
            }
            
            //moving down or up based on direction
            row += dir? 1: -1;
        }
        
        StringBuilder res = new StringBuilder();
        for(StringBuilder str: rows){
            res.append(str);
        }
        return res.toString();
    }
}

//O(N) time and space complexity
