import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2201
public class Algo54 {

    static long n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        long[][] dp = new long[104][2];
        long[] sum = new long[104];

        dp[1][1] = 1; //1자리수 일때 이친수 개수
        sum[1] = 1; // 1 자리수까지 이친수 중 가장 큰 수의 번호

        for(int i=2; i<=101; i++){
            dp[i][1] = dp[i-1][0];
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            sum[i] = sum[i-1] + dp[i][0] + dp[i][1];
        }

        if(n==1){
            System.out.println(1);
        }else{
            System.out.print("1");
            int k = 0; //자리수
            for(int i=2; i<=100; i++){
                if(n<=sum[i]){
                    k = i;
                    break;
                }
            }
            n-=(sum[k-1]+1);
            k-=1;
            while(k>0){
                if(n>sum[k-1]){
                    System.out.print("1");
                    n-=(sum[k-1]+1);
                }else{
                    System.out.print("0");
                }

                k--;
            }

        }

    }

}
