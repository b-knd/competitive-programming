//runtime error on test set 1
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static int[] endPosition(int N, int R, int C, int Sr, int Sc, String instructions) {
        int[][] grid = new int[R][C];
        for(int[] arr: grid){
            Arrays.fill(arr, 0);
        }
        //zero indexed
        Sc--; Sr--;
        grid[Sr][Sc] = -1;

        for(int index = 0; index < N; index++){
            char i = instructions.charAt(index);
            if(i == 'E'){
                while(grid[Sr][Sc] == -1){
                    Sc++;
                }
            } else if(i == 'W'){
                while(grid[Sr][Sc] == -1){
                    Sc--;
                }
            } else if(i == 'N'){
                while(grid[Sr][Sc] == -1){
                    Sr--;
                }
            } else if(i == 'S'){
                while(grid[Sr][Sc] == -1){
                    Sr++;
                }
            } else{
                continue;
            }
            grid[Sr][Sc] = -1;
        }

        return new int[] {Sr+1, Sc+1};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        try{
            for (int t = 1; t <= T; ++t) {
                int N = in.nextInt();
                int R = in.nextInt();
                int C = in.nextInt();
                int Sr = in.nextInt();
                int Sc = in.nextInt();
                String instructions = in.next();
                int[] ans = endPosition(N, R, C, Sr, Sc, instructions);
                System.out.println("Case #" + t + ": " + ans[0] + " " + ans[1]);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        in.close();
    }
}
