import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


//1727
public class Algo116 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][m+1];
        int[] man = new int[n];
        int[] woman = new int[m];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            man[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            woman[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(man);
        Arrays.sort(woman);

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i==j){
                    dp[i][j] = dp[i-1][j-1]+Math.abs(man[i-1]-woman[j-1]);
                }else if(i>j){
                    dp[i][j] = Math.min(dp[i-1][j-1]+Math.abs(man[i-1]-woman[j-1]),dp[i-1][j]);
                }else if(i<j){
                    dp[i][j] = Math.min(dp[i-1][j-1]+Math.abs(man[i-1]-woman[j-1]),dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n][m]);




    }

}






