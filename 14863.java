import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//14863
public class Algo42 {

    static int n,k;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 구간 개수
        k = Integer.parseInt(st.nextToken()); // 사용 가능 시간


        dp = new int[n+1][k+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //시간
            int b = Integer.parseInt(st.nextToken()); // 모금액
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(i==1){
                dp[i][a] = b;
                dp[i][c] = Math.max(dp[i][c],d);
            }else{
                for(int j=0; j<=k; j++){
                    if(dp[i-1][j]==0){
                        continue;
                    }
                    if(j+a<=k){
                        dp[i][j+a] = Math.max(dp[i][j+a],dp[i-1][j]+b);
                    }
                    if(j+c<=k){
                        dp[i][j+c] = Math.max(dp[i][j+c],dp[i-1][j]+d);
                    }
                }
            }
        }
        int ans = -1;
        for(int i=1; i<=k; i++){
            ans = Math.max(ans,dp[n][i]);
        }

        System.out.println(ans);

    }

}
