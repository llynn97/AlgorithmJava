import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


//1947
public class Algo133 {
    static int n;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long[] dp = new long[1000001];
        dp[1]=0;
        dp[2]=1;
        dp[3]=2;

        for(int i=4; i<=n; i++){
            dp[i]=((i-1)*(dp[i-1]+dp[i-2]))%1000000000;
        }

        System.out.println(dp[n]);
    }
}






