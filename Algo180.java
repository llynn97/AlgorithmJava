import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//9084
public class Algo180 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int t = Integer.parseInt(st.nextToken());

        for(int j=0; j<t; j++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] coin = new int[n];

            for(int i=0; i<n; i++){
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m+1];
            for(int i=1; i<=m; i++){
                if(i%coin[0]==0){
                    dp[i] = 1;
                }
            }
            for(int i=1; i<n; i++){
                for(int k=coin[i]; k<=m; k++){
                    if(k-coin[i]==0){
                        dp[k]++;
                    }else{
                        dp[k] = dp[k] + dp[k-coin[i]];
                    }
                }
            }
            System.out.println(dp[m]);
        }
    }
}
