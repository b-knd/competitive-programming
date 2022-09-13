/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++){
		    long min = Integer.MAX_VALUE;
		    long max = Integer.MIN_VALUE;
		    long N = sc.nextLong();
		    for(int i = 0; i < N; i++){
		        int curr = sc.nextInt();
		        min = Math.min(curr, min);
		        max = Math.max(curr, max);
		    }
		    //if max>0, min<0, max could be min*min or max*max, min is max * min
		    //if max > 0, min > 0, max is max*max, min is min*min
		    //if max < 0, min < 0, max ix min*min, min is max*max
		    if(max > 0 && min < 0){
		        long maxTemp = max;
		        max = Math.max(min*min, max*max);
		        min = maxTemp*min;
		    }
		    else if(max > 0 && min >= 0){
		        max = max*max;
		        min = min*min;
		    } 
		    else if(max <= 0 && min < 0){
		        long maxTemp = max;
		        max = min*min;
		        min = maxTemp*maxTemp;
		    }
		    
		    System.out.println(min + " " + max);
		}
		sc.close();
	}
}
