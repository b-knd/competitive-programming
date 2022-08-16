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
		    int n = sc.nextInt();
		    int x = sc.nextInt();
		    int y = sc.nextInt();
		    int[] arr = new int[n];
		    PriorityQueue<Integer> queue = new PriorityQueue<>();
		    for(int j = 0; j < n; j++){
		        queue.add(sc.nextInt());
		    }
		    
		    while(y > 0){
		        int min = queue.peek();
		        if((min ^ x) > min){
		            queue.remove();
		            queue.add(min ^= x);
		            y--;
		        } else{
		            if(y % 2 == 0){
		                break;
		            } else{
		                queue.remove();
		                queue.add(min ^= x);
		                break;
		            }
		        }
		    }
		    
            while(!queue.isEmpty()){
                System.out.print(queue.remove() + " ");
            }
            System.out.println();
		}
		sc.close();
	}
}

//O(N log N) time complexity
