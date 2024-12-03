import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//2891
public class Algo183 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] map = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            map[i]++;
        }

        for(int i=0; i<s; i++){
            int num = Integer.parseInt(st.nextToken());
            map[num]--;
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<r; i++){
            int num = Integer.parseInt(st.nextToken());
            map[num]++;
        }

        for(int i=1; i<=n; i++){
            if(i==1 || i==n){
                if(map[i]>=1){
                    continue;
                }else{
                    if(i==1 && map[i+1]==2){
                        map[i+1]--;
                        map[i]++;
                    }else if(i==n &&map[i-1]==2){
                        map[i-1]--;
                        map[i]++;
                    }
                }
            }else{
                if(map[i]>=1){
                    continue;
                }else{
                    if(map[i-1]==2){
                        map[i-1]--;
                        map[i]++;
                    }else if(map[i+1]==2){
                        map[i+1]--;
                        map[i]++;
                    }
                }
            }
        }
        int ans = 0;

        for(int i=1; i<=n; i++){
            if(map[i]<1){
                ans++;
            }
        }

        System.out.println(ans);
    }
}
