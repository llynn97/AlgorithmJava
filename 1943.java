import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1943
public class Algo49 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int[] dp;


        for(int t=0; t<3; t++){
            int total = 0;
            dp = new int[1000001];
            n = Integer.parseInt(br.readLine());
            for(int i=1; i<=n; i++){

                st = new StringTokenizer(br.readLine());
                int coin = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                for(int j=1; j<=cnt; j++){
                    for(int k=total; k>=0; k--){
                        if(k+(coin*j)>100000){
                            break;
                        }
                        if(dp[k]>0){
                            dp[k+(coin*j)]+=1;
                        }
                    }
                }
                for(int j=0; j<=cnt; j++){
                    dp[j*coin]+=1;
                }
                total+=coin*cnt;

            }
            if(total%2!=0){
                System.out.println(0);
            }else{
                if(dp[total/2]!=0){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }

        }


    }

}
