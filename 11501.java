import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//11501
public class Algo97 {
    static int n;
    static long[] map;

//1 1 3 1 2
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(t>0){
            n = Integer.parseInt(br.readLine());
            map = new long[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                map[i] = Long.parseLong(st.nextToken());
            }
            long result = 0;
            long maxNum = Long.MIN_VALUE;
            for(int i=n-1; i>=0; i--){
                maxNum = Math.max(map[i],maxNum);
                result += maxNum-map[i];
            }


            t--;
            System.out.println(result);
        }


    }

}
