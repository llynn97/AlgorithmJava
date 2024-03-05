import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//18185
public class Algo52 {

    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] map = new int[n+2];
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        int ans = 0;
        while(idx<n){
            if(map[idx]>0){
                int temp = map[idx];
                ans+=3*temp;
                temp = Math.min(temp,map[idx+1]);
                ans+=2*temp;
                map[idx+1]-=temp;
                temp = Math.min(temp,map[idx+2]-Math.min(map[idx+1],map[idx+2]));
                ans+=2*temp;
                map[idx+2]-=temp;

            }
            idx++;
        }
        System.out.println(ans);

    }

}
