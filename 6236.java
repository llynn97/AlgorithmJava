import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//6236
public class Algo56 {

    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int right = 1000000000;
        int left= -1;
        int[] map = new int[n];
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(br.readLine());
            left = Math.max(left,map[i]);
        }

        int cnt =0;
        int mid = 0;
        int sum = 0;
        while(left<=right){
            cnt = 1;
            mid = (left+right)/2;
            sum=mid;
            for(int i=0; i<n; i++){

                if(map[i]>sum){
                    sum=mid;
                    cnt++;
                }
                sum-=map[i];

            }
            if(cnt>m){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.print(left);


    }

}
