import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2494
public class Algo64 {

    static int n;
    static int[] start;
    static int[] end;
    static int[][] dp;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        String str1 = br.readLine();
        String str2 = br.readLine();
        start = new int[n];
        end = new int[n];
        dp = new int[10002][10]; // 현재까지 왼쪽 회전수, 나사 인덱스
        for(int i=0; i<n; i++){
            start[i] = (int)(str1.charAt(i)-'0');
            end[i] = (int)(str2.charAt(i)-'0');
        }
        for(int i=0; i<10002; i++){
            for(int j=0; j<10; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(solve1(0,0));
        solve2(0,00);

    }

    public static int solve1(int idx, int rotNum ){
        if(idx==n){
            dp[idx][rotNum] = 0;
            return dp[idx][rotNum];
        }
        if(dp[idx][rotNum]!=-1){
            return dp[idx][rotNum];
        }
        int ret = Integer.MAX_VALUE;
        int leftRot = (20+end[idx]-start[idx]-rotNum)%10; // 돌려야하는 왼쪽 회전수
        ret = Math.min(ret,solve1(idx+1,(rotNum+leftRot)%10)+leftRot); //왼쪽으로 돌렸을 때
        ret = Math.min(ret,solve1(idx+1,rotNum)+(10-leftRot)%10);
        dp[idx][rotNum] = ret;
        return dp[idx][rotNum];

    }

    public static void solve2(int idx, int rotNum){
        if(idx==n){
            return;
        }
        int leftRot = (20+end[idx]-start[idx]-rotNum)%10;
        if(dp[idx+1][rotNum]!=-1 && (dp[idx][rotNum]-dp[idx+1][rotNum]) == (10-leftRot)%10){
            System.out.println(idx+1+" "+ -(10-leftRot)%10);
            solve2(idx+1,rotNum);
        }else{ //왼쪽으로 회전하는 경우
            System.out.println(idx+1+" "+leftRot);
            solve2(idx+1,(leftRot+rotNum+10)%10);

        }

    }





}
