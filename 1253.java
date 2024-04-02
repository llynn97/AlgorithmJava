import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1253
public class Algo80 {
    static int n;
    static int[] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map);
        int ans = 0;
        for(int i=0; i<n; i++){
            int left = 0;
            int right = n-1;
            while(true){
                if(left==i){
                    left++;
                }
                if(right==i){
                    right--;
                }
                if(left>=right){
                    break;
                }
                if(map[left]+map[right]<map[i]){
                    left++;
                }else if(map[left]+map[right]>map[i]){
                    right--;
                }else{
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);







    }
}
