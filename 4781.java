import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//4781
public class Algo36 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] dp;
        int[][] map;
        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = (int)((Double.parseDouble(st.nextToken())*100)+0.5);
            if(n==0){
                break;
            }
            dp = new int[10010];
            map = new int[n+1][2];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                map[i][0] = Integer.parseInt(st.nextToken()); //칼로리
                map[i][1] = (int)((Double.parseDouble(st.nextToken())*100)+0.5); //가격
            }
            for(int i=0; i<n; i++){
                for(int j=1; j<=m; j++){
                    if(j-map[i][1]>=0){
                        dp[j] = Math.max(dp[j],dp[j-map[i][1]]+map[i][0]);
                    }
                }
            }
            System.out.println(dp[m]);

        }


    }
}
