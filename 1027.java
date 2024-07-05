import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1027
public class Algo83 {
    static int n;
    static long[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            dp[i] = Long.parseLong(st.nextToken());
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            int cnt = 0;
            double tmp = 0;
            for(int j=i-1; j>=0; j--){
                double num = (double)(dp[i]-dp[j])/(i-j); //기울기
                if(j==i-1 || tmp>num){
                    cnt++;
                    tmp = num;
                }
            }
            for(int j=i+1; j<n; j++){
                double num = (double)(dp[i]-dp[j])/(i-j);
                if(j==i+1||tmp<num){
                    cnt++;
                    tmp=num;
                }
            }
            ans = Math.max(ans,cnt);

        }
        System.out.println(ans);



    }
}
