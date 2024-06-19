import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//2281
public class Algo138 {

    static int n,m;
    static int[][] dp;
    static int[] map;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[1001][1002]; //i번째 이름을 넣는데 현재 j번째 칸까지 채워졌음
        map = new int[n];

        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<1000; i++){
            for(int j=0; j<=1001; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(solve(1,map[0]+1));



    }

    public static int solve(int idx,int cnt){
        if(idx==n){
            return 0;
        }
        int ans = dp[idx][cnt];
        if(ans!=-1){
            return ans;
        }
        //새로운 줄에 채움
        int left = m - cnt+1;
        ans = solve(idx+1,map[idx]+1)+ left*left;
        //현재 줄에 이어서 채움
        if(cnt+map[idx]<=m){
            ans = Math.min(ans,solve(idx+1,cnt+map[idx]+1));
        }
        dp[idx][cnt]=ans;
        return ans;
    }
}






