import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//2166
public class Algo164 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[i][0] = a;
            map[i][1] = b;
        }

        double sum = 0;

        for(int i=0; i<n; i++){
            sum += (double)map[i][0]*map[(i+1)%n][1];
            sum -= (double) map[i][1] * map[(i+1)%n][0];
        }

        System.out.printf("%.1f", Math.abs(sum / 2));
    }
}
