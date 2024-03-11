import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2291
public class Algo59 {

    static int n,m,k;

    static int[][][] dp; //길이-합-마지막수


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n+1][m+1][221];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                for(int k=0; k<=220; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        for(int i=1; i<=m; i++){
            dp[n][m][i] = 1;
        }
        solve1(0,0,1);
        solve2(0,0,1,k);

    }


    public static int solve1(int len, int sum, int num){
        if(len>n || sum>m){
            return 0;
        }
        if(dp[len][sum][num]!=-1){
            return dp[len][sum][num];
        }
        int res = 0;
        for(int i=num; i<=m; i++){
            res += solve1(len+1,sum+i,i);
        }
        dp[len][sum][num] = res;
        return dp[len][sum][num];
    }

    public static void solve2(int len, int sum, int num, int cnt){
        if(len == n){
           return;
        }
        for(int i=num; i<=m; i++){
            if(dp[len+1][sum+i][i]==-1){
                continue;
            }
            if(cnt > dp[len+1][sum+i][i]){
                cnt-=dp[len+1][sum+i][i];
                continue;
            }
            System.out.print(i+" ");
            solve2(len+1,sum+i,i,cnt);
            break;
        }
    }

}
