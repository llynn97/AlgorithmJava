import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2110
public class Algo61 {

    static int n,m;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] map = new int[n];

        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(map);

        int left = 1;
        int right= map[n-1];

        while(left<=right){
            int mid = (left+right)/2; //최소거리
            int pos = 0; //마지막 공유기 위치
            int cnt = 1;
            for(int i=1; i<n; i++){
                if(map[i]-map[pos]>=mid){
                    cnt++;
                    pos = i;
                }
            }
            if(cnt<m){
                right = mid-1;
                continue;
            }
            left = mid+1;
        }
        System.out.println(left-1);

    }





}
