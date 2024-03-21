import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1300
public class Algo69 {

    static long n,k;





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        n = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());

        long left = 1;
        long right = k;

        while(left<=right){
            long mid = (left+right)/2; //B[k] = x 값 : k는 x보다 작거나 같은 수의 개수
            long cnt = 0;
            for(int i=1; i<=n; i++){
                cnt += Math.min(n,mid/i);
            }
            if(cnt>=k){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(left);




    }

}
