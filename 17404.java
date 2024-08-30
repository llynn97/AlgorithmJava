import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//17404
public class Algo144 {

    static int n;
    static int[][] map;
    static int[][] dp;
    static final int INF = 1000000;
    static int ans = INF;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][3];
        dp = new int[n+1][3];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==j){
                    dp[1][j] = map[1][j];
                }else{
                    dp[1][j] = INF;
                }
            }
            for(int j=2; j<=n; j++){
                dp[j][0] = Math.min(dp[j-1][1],dp[j-1][2])+map[j][0];
                dp[j][1] = Math.min(dp[j-1][0],dp[j-1][2])+map[j][1];
                dp[j][2] = Math.min(dp[j-1][0],dp[j-1][1])+map[j][2];


            }

            for(int j=0; j<3; j++){
                if(j!=i){
                    ans = Math.min(ans,dp[n][j]);
                }
            }
        }

        System.out.println(ans);
    }
}






