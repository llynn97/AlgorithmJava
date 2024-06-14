import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//1670
public class Algo136 {

    static int n;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[2] = 1;

        for(int i=4; i<=n; i+=2){ //if n=6) dp[0]*dp[4],dp[2]*dp[2],dp[4]*dp[0]
            for(int j=0; j<=i-2; j+=2){
                dp[i]+=dp[j]*dp[i-j-2];
                dp[i]%=987654321;
            }
        }

        System.out.println(dp[n]);

    }
}






