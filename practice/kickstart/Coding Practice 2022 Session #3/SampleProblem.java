import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            //get number of candy packs
            int N = sc.nextInt();
            int candies = 0;
            //number of children
            int M = sc.nextInt();
          
            //add up all candies
            for(int i = 0; i < N; i++){
                candies += sc.nextInt();
            }
          
            //find remaining using modulo
            int res = candies % M;
            
            System.out.println("Case #"+tc+": "+res);
        }
        sc.close();
    }
}
