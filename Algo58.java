import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2343
public class Algo58 {

    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] map = new int[n];
        long left = 0;
        long right = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left,map[i]);
            right+=map[i];
        }



        int cnt = 0;
        long sum = 0 ;
        while(left<=right){
            long mid = (left+right)/2;
            sum = mid;
            cnt = 1;
            for(int i=0; i<n; i++){
                if(map[i]>sum){
                   cnt++;
                   sum=mid;
                }
                sum-=map[i];
            }
            if(cnt>m){
                left = mid+1;
            }else{
                right = mid-1;
            }


        }
        System.out.println(left);

    }

}
