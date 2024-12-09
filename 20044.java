import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//20044
public class Algo185 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[2*n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<2*n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = 987654321;
        for(int i=0; i<n; i++){
            ans = Math.min(ans,arr[i]+arr[2*n-i-1]);
        }

        System.out.println(ans);



    }
}
