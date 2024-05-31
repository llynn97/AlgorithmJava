import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//2229
public class Algo128 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[] map = new int[n+1];
        int[] dp = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            int maxNum = 0;
            int minNum = 10001;
            map[i] = Integer.parseInt(st.nextToken());
            for(int j=i; j>0; j--){
                maxNum = Math.max(maxNum,map[j]);
                minNum = Math.min(minNum,map[j]);
                dp[i] = Math.max(dp[i],Math.abs(maxNum-minNum)+dp[j-1]);
            }

        }
        System.out.println(dp[n]);
    }
}






