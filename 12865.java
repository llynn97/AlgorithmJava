import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//12865
public class Algo88 {
    static int n,k;
    static int[][] bag;
    static long[][] dp;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bag = new int[n+1][2];
        dp = new long[n+1][k+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bag[i][0] = w;
            bag[i][1] = v;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=k; j++){
                if(j>=bag[i][0]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-bag[i][0]]+bag[i][1]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][k]);


    }








}
