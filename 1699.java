import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1699
public class Algo35 {

    static int dp[][];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            dp[i] = i;
            for(int j=1; j*j<=i; j++){
                if(dp[i]>dp[i-j*j]+1){
                    dp[i] = dp[i-j*j]+1;
                }
            }
        }

        System.out.println(dp[n]);

    }
}
