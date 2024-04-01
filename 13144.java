import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//13144
public class Algo79 {
    static int n;
    static int[] map;
    static int[] cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        cnt = new int[100001];
        st = new StringTokenizer(br.readLine());
        map = new int[n+1];
        for(int i=1; i<=n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        long ans = 0;
        int num = 0;
        int start = 1;
        int end = 1;
        while(start<=n){
            while(end<=n &&cnt[map[end]]==0){
                cnt[map[end]]++;
                end++;
            }
            ans+=(end-start);
            cnt[map[start]]--;
            start++;
        }

        System.out.println(ans);






    }
}
