import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

//20300
public class Algo23 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] weight = new long[n];
        for(int i=0; i<n; i++){
            weight[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(weight);
        long maxNum = 0;
        if(n%2==0){
            for(int i=0; i<n/2; i++){
                maxNum = Math.max(maxNum,weight[i]+weight[n-1-i]);
            }
        }else{
            maxNum = weight[n-1];
            for(int i=0; i<(n-1)/2; i++){
                maxNum = Math.max(maxNum,weight[i]+weight[n-2-i]);
            }
        }

        System.out.println(maxNum);

    }
}
