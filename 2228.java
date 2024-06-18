import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//2228
public class Algo137 {

    static int n,m;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] map = new int[n+1];
        int[] sum = new int[n+1]; //누적합
        int[][] dp= new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            map[i] = Integer.parseInt(br.readLine());
            sum[i] = sum[i-1]+map[i];
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Integer.MIN_VALUE / 2;
            }
        }

        dp[1][1] = map[1];

        for(int i=2; i<=n; i++){
            for(int j=1; j<=m; j++){

                dp[i][j] = dp[i-1][j]; //map[i-1]이 j 구간에 포함 안될 때

                int tmp = 0;
                if(j==1){
                    tmp = -1;
                }

                for(int k=i-2; k>=tmp; k--){
                    if(k==-1){
                        dp[i][j] = Math.max(dp[i][j],sum[i]);
                    }else{
                        dp[i][j] = Math.max(dp[i][j],dp[k][j-1]+sum[i]-sum[k+1]);
                    }
                }
            }
        }

        System.out.println(dp[n][m]);

    }
}






