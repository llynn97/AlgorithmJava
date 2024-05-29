import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//2011
public class Algo126 {
    static int k;
    private static final int MOD = 1000000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int[] dp = new int[str.length()+1];
        dp[0]=1;
        for(int i=1; i<=str.length(); i++){ //25114
            int num = (int)(str.charAt(i-1)-'0');
            if(num>=1 && num<=9){
                dp[i]+=dp[i-1];
                dp[i]%=MOD;
            }
            if(i==1){
                continue;
            }
            int pre = (int)(str.charAt(i-2)-'0');

            if(pre==0){
                continue;
            }
            int num2 = pre*10+num;
            if(num2>=10 && num2<=26){
                dp[i]+=dp[i-2];
                dp[i]%=MOD;
            }

        }
        System.out.println(dp[str.length()]);


    }
}






