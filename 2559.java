import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2559
public class Algo74 {

   static int n,k;
   static int[] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for(int i=1; i<k; i++){
            sum+=map[i];
        }
        int maxNum = sum;
        for(int i=k; i<n; i++){
            sum-=map[i-k];
            sum+=map[i];
            maxNum = Math.max(sum,maxNum);
        }
        System.out.println(maxNum);




    }

}
