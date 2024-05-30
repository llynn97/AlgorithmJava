import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//2096
public class Algo127 {
    static int n;
    private static final int MOD = 1000000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][3];
        int[][] dp1 = new int[n][3]; //최대
        int[][] dp2 = new int[n][3]; //최소

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp1[0][0]=map[0][0];
        dp1[0][1]=map[0][1];
        dp1[0][2]=map[0][2];
        dp2[0][0]=map[0][0];
        dp2[0][1]=map[0][1];
        dp2[0][2]=map[0][2];

        for(int i=1; i<n; i++){
            dp1[i][0]=Math.max(dp1[i-1][0],dp1[i-1][1])+map[i][0];
            dp1[i][2]=Math.max(dp1[i-1][1],dp1[i-1][2])+map[i][2];
            int num = Math.max(dp1[i-1][0],dp1[i-1][1]);
            num = Math.max(num,dp1[i-1][2]);
            dp1[i][1]=num+map[i][1];
        }


        for(int i=1; i<n; i++){
            dp2[i][0]=Math.min(dp2[i-1][0],dp2[i-1][1])+map[i][0];
            dp2[i][2]=Math.min(dp2[i-1][1],dp2[i-1][2])+map[i][2];
            int num = Math.min(dp2[i-1][0],dp2[i-1][1]);
            num = Math.min(num,dp2[i-1][2]);
            dp2[i][1]=num+map[i][1];
        }


        int ans1 = Math.max(dp1[n-1][0],dp1[n-1][1]);
        ans1 = Math.max(ans1,dp1[n-1][2]);

        int ans2 = Math.min(dp2[n-1][0],dp2[n-1][1]);
        ans2 = Math.min(ans2,dp2[n-1][2]);

        System.out.println(ans1+" "+ans2);



    }
}






