import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1256
public class Algo57 {

    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[][] dp = new long[202][202];


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=200; i++){
            dp[i][1] = i; //3C1
            dp[i][0] = 1; //3C0
            dp[i][i] = 1;
        }
        for(int i=1; i<=200; i++){
            for(int j=1; j<=i; j++){
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1]; //전에 j개 a를 뽑고 지금 z 뽑은 가지수 + 전에 j-1개 a를 뽑고 지금 a를 뽑음
                if(dp[i][j]>1000000000){
                    dp[i][j] = 1000000001;
                }
            }
        }
        if(dp[n+m][m]<k){
            System.out.println("-1");
        }else{
            while(!(n==0 && m==0)){
                if(dp[n+m-1][m]>=k){
                    sb.append("a");
                    n--;
                }else{
                    sb.append("z");
                    k-=dp[m+n-1][m];
                    m--;
                }
            }
            System.out.println(sb.toString());
        }



    }

}
