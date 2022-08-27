import java.util.*;
import java.lang.Math.*;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            //number of days
            int[] days = new int[sc.nextInt()];
            int res = 0;
            int prevMax = -1;
            
            //fill array with days
            for(int i = 0; i < days.length; i++){
                days[i] = sc.nextInt();
            }
            
            for(int i = 0; i < days.length; i++){
                int next = (i == days.length-1? -1: days[i+1]);
                
                //strictly greater than all previous and greater than following day (if exists)
                if(days[i] > prevMax && days[i] > next){
                    res++;
                }
                
                //update new max if possible
                prevMax = Math.max(prevMax, days[i]);
            }
            
            System.out.println("Case #"+tc+": "+res);
        }
        sc.close();
    }
}
