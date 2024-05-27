import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//2885
public class Algo125 {
    static int k;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        int n = 1;
        int cnt = 0;
        while(n<k){
            n*=2;
        }
        System.out.print(n);
        while(k>0){
            if(k>=n){
                k-=n;
            }else{
                n/=2;
                cnt++;
            }
        }
        System.out.print(" "+cnt);


    }
}






