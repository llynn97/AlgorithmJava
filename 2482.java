import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


//2482
public class Algo156 {

    static int n,k;
    static int[][] dp;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        dp = new int[n+1][n+1]; //n개 색상이 있을 때 k개 색상을 선택하는 방법

        for(int i=1; i<=n; i++){
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        for(int i=3; i<=n; i++){
            for(int j=2; j<=(n+1)/2; j++){
                dp[i][j] = (dp[i-2][j-1] + dp[i-1][j])%1000000003;
            }
        }

        System.out.println((dp[n-3][k-1]+dp[n-1][k])%1000000003);
    }
}








