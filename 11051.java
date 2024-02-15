import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//11051
public class Algo31 {

    static int dp[][];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n+1][n+1];
        int answer = binomialCoefficient(n,k);
        System.out.println(answer);



    }

    public static int binomialCoefficient(int n, int k){
        if(k==0 || n==k ){
            return 1;
        }
        if(dp[n][k]==0){
            dp[n][k] = (binomialCoefficient(n-1,k-1)+binomialCoefficient(n-1,k))%10007;

        }
        return dp[n][k];
    }
}
