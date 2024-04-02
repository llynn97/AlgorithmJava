import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1806
public class Algo81 {
    static int n,s;
    static int[] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        map = new int[n];
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while(start<n){
            while(end<n && sum+map[end]<s){
                sum+=map[end];
                end++;
            }

            if(end<n && sum+map[end]>=s){
                ans = Math.min(ans,(end-start)+1);
            }
            sum-=map[start];
            start++;
        }

        if(ans == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(ans);
        }










    }
}
