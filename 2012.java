import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//2012
public class Algo124 {
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[] map = new int[n];
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(map);
        long sum = 0;
        for(int i=0; i<n; i++){
            sum+=Math.abs(map[i]-(i+1));
        }
        System.out.println(sum);

    }
}






