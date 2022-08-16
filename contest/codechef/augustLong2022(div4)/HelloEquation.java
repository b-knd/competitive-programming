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
		
		for(int j = 0; j < t; j++){
		    int x = sc.nextInt();
		    boolean found = false;
		    for(int b = 1; b < Math.sqrt(x); b++){
		        int a = (x - (2 * b))/(2+b);
		        if(a > 0 && (2*a)+(2*b)+(a*b) == x){
		            found = true;
		            break;
		        }
		    }
		    
		    if(found){
		        System.out.println("YES");
		    }else{
		        System.out.println("NO");
		    }
		}
	}
}

//O(sqrt(x)) time complexity
