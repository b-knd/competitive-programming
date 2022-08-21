//what will be the best move? if third cells from red has not gone out of bound, coloured that
//bots, move, keep moving forward by two cells from last red cell found
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Input number of test cases
        int testCaseCount = in.nextInt();
        for (int tc = 1; tc <= testCaseCount; ++tc) {
            int N = in.nextInt();
            //0 stands for white cells
            //1 stands for red cells

            int count = 1;
            int index = 0;
            while(index < N){
                //my move
                index += 3;
                
                //bot's move
                if(index+2 < N){
                    index += 2;
                    count++;
                }
            }
            
            System.out.println("Case #" + tc + ": " + count);
        }
    }
}
