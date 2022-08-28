import java.util.Scanner;

public class Solution {

    private static String gBuses(int[][] stops, int[] P) {
        StringBuilder res = new StringBuilder();
        for(int i: P){
            int sum = 0;
            //if i falls into interval, increment sum
            for(int[] interval: stops){
                if(i <= interval[1] && i >= interval[0]){
                    sum++;
                }
            }
            res.append(sum).append(" ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int[][] stops = new int[in.nextInt()][2];
            for(int i = 0; i < stops.length; i++){
                stops[i][0] = in.nextInt();
                stops[i][1] = in.nextInt();
            }
            int[] P = new int[in.nextInt()];
            for(int i = 0; i < P.length; i++){
                P[i] = in.nextInt();
            }

            System.out.println("Case #" + t + ": " + gBuses(stops, P));
        }
        in.close();
    }
}
