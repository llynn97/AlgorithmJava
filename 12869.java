import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//12869
public class Algo32 {

    static int n;
    static int[] map;
    static int[][][] dp;

    static int minNum;

    static int[][] scv = {{-9,-3,-1},{-9,-1,-3},{-3,-1,-9},{-3,-9,-1},{-1,-9,-3},{-1,-3,-9}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new int[3];
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[61][61][61];
        minNum = Integer.MAX_VALUE;

        dfs(map,0);

        System.out.println(minNum);
    }

    public static void dfs(int[] sc,int cnt){
        int n1 = sc[0];
        int n2 = sc[1];
        int n3 = sc[2];

        if(dp[n1][n2][n3]!=0 && dp[n1][n2][n3]<=cnt){
            return;
        }
        dp[n1][n2][n3] = cnt;

        if(n1==0 && n2==0 && n3==0){
            minNum = Math.min(minNum,cnt);
            return;
        }

        for(int i=0; i<6; i++){
            dfs( new int[]{Math.max(n1+scv[i][0],0),Math.max(n2+scv[i][1],0),Math.max(n3+scv[i][2],0)},cnt+1);
        }

    }
}
