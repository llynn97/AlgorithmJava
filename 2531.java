import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2531
public class Algo77 {

   static int n,k,d,c;
   static int[] map;
   static int[] cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[n*2+1];
        cnt = new int[3001];
        for(int i=1; i<=n; i++){
            int num = Integer.parseInt(br.readLine());
            map[i] = num;
            map[i+n] = num;
        }
        int ans = 0;
        for(int i=1; i<=k; i++){
            if(cnt[map[i]]==0){
                ans++;
            }
            cnt[map[i]]++;
        }
        if(cnt[c]==0){
            ans++;
        }

        int count = ans;
        for(int i=1; i<=n; i++){
            //System.out.println(count);
            if(cnt[c]==0){
                count--;
            }
            if(cnt[map[i]]==1){
               count--;
            }
            cnt[map[i]]--;
            if(cnt[map[i+k]]==0){
                count++;
            }
            cnt[map[i+k]]++;
            if(cnt[c]==0){
                count++;
            }
            ans = Math.max(ans,count);
        }
        System.out.println(ans);






    }

}
