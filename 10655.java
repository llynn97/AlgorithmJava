import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//10655
public class Algo178 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        int total = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }
        // 0,0 | 8,3 | 11,-1 | 10,0

        for(int i=0; i<n-1; i++){
            total+= Math.abs(arr[i][0]-arr[i+1][0]) + Math.abs(arr[i][1]-arr[i+1][1]);
        }

        int ans = 987654321;

        for(int i=1; i<n-1; i++){
            int temp = total;
            temp -= (Math.abs(arr[i-1][0]-arr[i][0])+Math.abs(arr[i-1][1]-arr[i][1]));
            temp -= (Math.abs(arr[i][0]-arr[i+1][0])+Math.abs(arr[i][1]-arr[i+1][1]));
            temp += (Math.abs(arr[i-1][0]-arr[i+1][0])+Math.abs(arr[i-1][1]-arr[i+1][1]));
            ans = Math.min(temp,ans);
        }

        System.out.println(ans);
    }
}
