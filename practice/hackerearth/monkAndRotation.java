import java.util.*;
import java.lang.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
      
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
      
        for(int j = 0; j < T; j++){
            int N = sc.nextInt();
            int k = sc.nextInt();
            
            //keep input in an array
            String[] arr = new String[N];
            for(int i = 0; i < N; i++){
                arr[i] = sc.nextInt()+"";
            }
            //build an array of the same size as inputs
            String[] res = new String[N];
          
            //rotational factor after modulo (so that given N = 5, rotate by 5, instead of k = 5, we do k = 5 % 5 = 0 -- no rotation)
            k = k % N;
          
            //copy array based on rotational factor
            System.arraycopy(arr, N-k, res, 0, k);
            System.arraycopy(arr, 0, res, k, N-k);
          
            //return result
            System.out.println(String.join(" ", res));
        }
        sc.close();
    }
}
