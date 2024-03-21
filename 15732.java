import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//15732
public class Algo68 {

    static int n,k;
    static long d;
    static int[][] map;
    static long ans;





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        d = Long.parseLong(st.nextToken());
        map = new int[k+1][3];
        int left = 0;
        int right = n;
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());

        }
        int ans = Integer.MAX_VALUE;
        while(left<=right){
            int mid = (left+right)/2;
            long num = 0;
            for(int i=0; i<k; i++){
                if(mid<map[i][0]){
                    continue;
                }
                int end = Math.min(map[i][1],mid);
                num+= (end-map[i][0])/map[i][2] + 1;
            }
            if(num>=d){
                right = mid-1;
                ans = Math.min(ans,mid);
                continue;
            }
            left = mid+1;

        }
        System.out.println(ans);



    }

}
