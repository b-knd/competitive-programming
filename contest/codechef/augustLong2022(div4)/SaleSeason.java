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
		int t = sc.nextInt();
		for(int i = 0; i < t; i++){
		    int x = sc.nextInt();
		    if(x > 100){
		        if (x > 100 && x <= 1000){
		            x -= 25;
		        } else if(x <= 5000){
		            x -= 100;
		        } else {
		            x -= 500;
		        }
		    }
		    System.out.println(x);
		}
		sc.close();
	}
}

//O(1) time complexity
