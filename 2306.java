import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//2306
public class Algo135 {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        int[][] dp = new int[str.length()][str.length()];
        //acattgagtc

        for(int i=1; i<str.length(); i++){
            for(int j=0; j+i<str.length(); j++){
                int left = j;
                int right = j+i;
                if((str.charAt(left)=='a'&&str.charAt(right)=='t')||(str.charAt(left)=='g'&&str.charAt(right)=='c')){
                    dp[left][right] = dp[left+1][right-1]+2;
                }

                for(int mid = left; mid<right; mid++){
                    dp[left][right]=Math.max(dp[left][right],dp[left][mid]+dp[mid+1][right]);
                }
            }
        }
        System.out.println(dp[0][str.length()-1]);

    }
}






