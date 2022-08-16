/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int j = 0; j < t; j++){
		    int n = sc.nextInt();
		    //A is cumulative sum because A do not need to wait for B, so keep going, total time = sum of all input in array
        //As for B, the extra time needed for B to reach destination is the max element in input
		    int b = 0;
		    int sum = 0;
		    int max = 0;
		    for(int i = 1; i < n; i++){
		        b = sc.nextInt();
		        max = Math.max(b, max);
		        sum += b;
		        A[i] = sum;
		    }
		    System.out.println(sum + max);
		}
		
		sc.close();
	}
}
