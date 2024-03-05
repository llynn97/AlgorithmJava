import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2342
public class Algo51 {

    static int n;
    static int[][][] dp;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String[] str = br.readLine().split(" ");
        n = str.length-1;
        map = new int[str.length];
        dp = new int[5][5][str.length];
        for(int i=0; i<str.length-1; i++){
            map[i] = Integer.parseInt(str[i]);
        }
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                for(int k=0; k<n; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        System.out.println(solve(0,0,0));


       

    }

    public static int solve(int left, int right, int cnt){
        if(cnt == n){
            return 0;
        }
        if(dp[left][right][cnt]!=-1){
            return dp[left][right][cnt];
        }
        dp[left][right][cnt] = Math.min(solve(map[cnt],right,cnt+1)+move(left,map[cnt]),solve(left,map[cnt],cnt+1)+move(right,map[cnt]));
        return dp[left][right][cnt];
    }


    public static int move(int start, int end){
        int diff = Math.abs(start - end);
        if (start == 0) return 2;
        if (diff == 1 || diff == 3) return 3;
        if (diff == 0) return 1;
        return 4;
    }

}
