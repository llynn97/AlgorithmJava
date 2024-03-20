import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1023
public class Algo68 {

    static int n,k;
    static int[][][] dp;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n+1][(n+1)*2][2]; //i번재 순서,닫히지 않은 열린 괄호 개수, i-1번째 가지 ㄴㄴ괄호 문자열이 있었는지
        for(int i=0; i<n+1; i++){
            for(int j=0; j<(n+1)*2; j++){
                for(int k=0; k<2; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        solve1(0,0,0);
        if(k+1>dp[0][n][0]){
            System.out.println("-1");
        }else {
            solve2(0,0,0,k+1);
        }



    }

    public static int solve1(int pos, int open,int wrong){
        if(pos == n ){
            if(wrong == 1 || open!=0){
                return 1;
            }
            return 0;
        }
        if(dp[pos][open+n][wrong]!=-1){
            return dp[pos][open+n][wrong];
        }
        int ret = 0;
        ret+= solve1(pos+1,open+1,wrong); // 열린괄호 추가
        if(wrong==1 || open-1<0){ // 닫힌 괄호 추가
            ret+=solve1(pos+1,open-1,1);
        }else{
            ret+=solve1(pos+1,open-1,0);
        }
        dp[pos][open+n][wrong] = ret;
        return dp[pos][open+n][wrong];
    }

    public static void solve2(int pos, int open, int wrong, int cnt){
        if(pos == n ){
            return;
        }
        if(dp[pos+1][open+1+n][wrong]>=cnt){
            if(pos == n-1 && cnt==2){

                System.out.print(")");
            }else{

                System.out.print("(");
            }

            solve2(pos+1,open+1,wrong,cnt);

        }else{

            System.out.print(")");
            if(wrong==1 || open-1<0){
                solve2(pos+1,open-1,1,cnt-dp[pos+1][open+1+n][wrong]);
            }else{
                solve2(pos+1,open-1,0,cnt-dp[pos+1][open+1+n][wrong]);
            }
        }
    }





}
