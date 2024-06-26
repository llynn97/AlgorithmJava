import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//1309
public class Algo131 {
    static int n;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long[][] dp = new long[n+1][3];

        dp[1][0]=1;
        dp[1][1]=1;
        dp[1][2]=1;

        for(int i=2; i<=n; i++){
            dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
            dp[i][1]=(dp[i-1][0]+dp[i-1][2])%9901;
            dp[i][2]=(dp[i-1][0]+dp[i-1][1])%9901;
        }

        long ans = (dp[n][0]+dp[n][1]+dp[n][2])%9901;

        System.out.println(ans);


    }
}






