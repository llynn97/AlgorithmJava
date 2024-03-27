import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//20922
public class Algo75 {

   static int n,k;
   static int[] map; //숫자 개수 카운트
   static int[] cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        map = new int[100001];
        cnt = new int[n];
        int ans = 1;
        for(int i=0; i<n; i++){
            cnt[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        while(end<n){
            while(end<n && map[cnt[end]]+1<=k){
                map[cnt[end]]++;
                end++;
            }
            ans = Math.max(ans,end-start);
            map[cnt[start]]--;
            start++;
        }
        System.out.println(ans);





    }

}
