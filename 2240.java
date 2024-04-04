import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

//2240
public class Algo85 {
    static int t,w;
    static int[][][] dp;
    static int[][] apple;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        apple = new int[t+1][3];
        dp = new int[t+1][3][w+1]; //초,나무 위치,움직인 횟수
        for(int i=1; i<=t; i++){
            apple[i][Integer.parseInt(br.readLine())] = 1;
        }

            dp[1][1][0] = apple[1][1];
            dp[1][2][1] = apple[1][2];

            int ans = Math.max(dp[1][1][0],dp[1][2][1]);

        for(int i=2; i<=t; i++){
            for(int j=0; j<=w; j++){
                if(j-1>=0){
                    dp[i][1][j] = Math.max(dp[i-1][1][j],dp[i-1][2][j-1])+apple[i][1];
                    dp[i][2][j] = Math.max(dp[i-1][2][j],dp[i-1][1][j-1])+apple[i][2];
                }else{
                    dp[i][1][j] = dp[i-1][1][j]+apple[i][1];
                    dp[i][2][j] = dp[i-1][2][j]+apple[i][2];
                }


                    ans = Math.max(Math.max(ans,dp[i][1][j]),dp[i][2][j]);
            }
        }

        System.out.println(ans);






    }


}
