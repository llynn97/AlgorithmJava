import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//2248
public class Algo48 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        long i = Long.parseLong(st.nextToken());

        long[][] dp = new long[n+1][l+1];
        dp[0][0] = 1;

        for(int j=1; j<=n; j++){
            dp[j][0] = 1;
            for(int k=1; k<=l; k++){
                dp[j][k] = dp[j-1][k] + dp[j-1][k-1]; //비트 0 을 추가하는 경우 + 비트 1을 추가하는 경우

            }
        }
        StringBuilder sb = new StringBuilder();

        for(int j=n; j>0; j--){
            int pos = j;
            long sum = 0;
            for(int x = 0; x<=l; x++){
                sum+=dp[pos-1][x];
            }
            int digit = 0;

            if(i>sum){
                i-=sum;
                l--;
                digit = 1;
            }else{
                digit = 0;
            }
            sb.append(digit);


        }
        System.out.print(sb.toString());



    }

}
