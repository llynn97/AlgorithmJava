import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//9657
public class Algo181 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n+1];
        dp[0] = 0; //0은 상영이가 짐 1은 이김
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4]= 1;

        for(int i=5; i<=n; i++){
            if(dp[i-1]+dp[i-3]+dp[i-4]==3){
                dp[i] = 0;
            }else{
                dp[i] = 1;
            }
        }

        if(dp[n]==1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}
