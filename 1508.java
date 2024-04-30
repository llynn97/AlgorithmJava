import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//1508
public class Algo104 {
    static int n;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] map = new int[k+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        int l = 1;
        int r = map[k-1]-map[0];
        int cnt = 0;
        int ans = -1;
        while(l<=r){
            int mid = (l+r)/2;
            int tmp = map[0];
            cnt = 1;
            for(int i=1; i<k; i++){
                if(map[i]-tmp>=mid){
                    cnt++;
                    tmp = map[i];
                }
            }
            if(cnt>=m){
                ans = mid;
                l = mid+1;

            }else{
                r = mid-1;
            }
        }
        int tmp = map[0];
        System.out.print(1);
        cnt = 1;
        for(int i=1; i<k; i++){
            if((map[i]-tmp>=ans) && cnt<m){
                cnt++;
                System.out.print(1);
                tmp = map[i];
            }else{
                System.out.print(0);
            }
        }

    }


}






