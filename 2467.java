import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2467
public class Algo63 {

    static int n,m;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long[] map = new long[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            map[i] = Long.parseLong(st.nextToken());
        }
        long minNum = Long.MAX_VALUE;
        int left = 0;
        int right = 0;
        for(int i=0; i<n-1; i++){
            int first = i+1;
            int second = n-1;
            while(first<=second){
                int mid = (first+second)/2;
                long sum = Math.abs(map[i]+map[mid]);
                if(minNum>sum){
                    minNum = sum;
                    left = i;
                    right = mid;
                }
                if(map[mid]>= -map[i]){
                    second = mid-1;
                }else{
                    first = mid+1;
                }
            }
        }
        System.out.println(map[left]+" "+map[right]);


    }





}
