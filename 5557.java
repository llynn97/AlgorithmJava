import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//5557
public class Algo28 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] map  = new int[n];
        long[][] dp = new long[n][21];
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][map[0]] = 1;
        int maxNum;
        int minNum;
        for(int i=1; i<n-1; i++){
            for(int j=0; j<=20; j++){
                if(dp[i-1][j]!=0){
                    maxNum = j+map[i];
                    minNum = j-map[i];
                    if(maxNum>=0 && maxNum<=20){
                        dp[i][maxNum]+=dp[i-1][j];
                    }
                    if(minNum>=0 && minNum<=20){
                        dp[i][minNum]+=dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[n-2][map[n-1]]);


    }
}
