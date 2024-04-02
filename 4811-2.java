import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//4811
public class Algo82 {
    static int n;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        dp = new long[31][31];

        while(true){
            n = Integer.parseInt(br.readLine());
            if(n==0){
                break;
            }
            long answer = solve(n,0);
            System.out.println(answer);
        }



    }

    public static long solve(int left, int right){
        if(left==0 && right ==0){
            return 1;
        }
        if(dp[left][right]!=0){
            return dp[left][right];
        }
        long ans = 0;
        if(left!=0){ //남은 알약 w가 0이 아니면 w 선택
            ans+=solve(left-1,right+1);
        }
        if(right!=0){ //h선택
            ans+=solve(left,right-1);
        }
        dp[left][right]=ans;
        return dp[left][right];
    }
}
