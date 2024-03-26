import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2293
public class Algo73 {

   static int n,k;
   static int[] dp;
   static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[k+1];
        map = new int[n+1];

        for(int i=1; i<=n; i++){
            map[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=map[i]; j<=k; j++){
                dp[j]+=dp[j-map[i]];
            }
        }
        System.out.println(dp[k]);



    }

}
