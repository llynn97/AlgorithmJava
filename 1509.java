import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//1509
public class Algo66 {

    static int n;
    static String str;
    static boolean[][] check;
    static int[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        str = br.readLine();
        n = str.length();
        check = new boolean[n+1][n+1]; // j부터 i 까지 문자열이 팰린드롬인지 확인
        dp = new int[n+1];
        for(int i=1; i<=n; i++){
            for(int j=i; j<=n; j++){
                boolean flag = true;
                int s = i-1;
                int e = j-1;
                while(s<=e){
                    if(str.charAt(s)!=str.charAt(e)){
                        flag= false;
                        break;
                    }
                    s++;
                    e--;
                }
                if(flag){
                    check[i][j] = true;
                }
            }
        }
        for(int i=1; i<=n; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                if(check[j][i]){ //팰린드롬이면
                    dp[i] = Math.min(dp[i],dp[j-1]+1);
                }
            }
        }
        System.out.println(dp[n]);
    }






}
