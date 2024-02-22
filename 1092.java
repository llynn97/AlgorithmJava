import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//1092
public class Algo40 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        List<Integer> crane = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int k = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }

        crane.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        if(crane.get(0)<box.get(0)){
            System.out.println(-1);
            return;
        }
        int ans = 0;

        while (!box.isEmpty()){
            int boxIdx = 0;
            int craneIdx = 0;
            while(craneIdx<n){
                if(boxIdx == box.size()){
                    break;
                }
                else if(crane.get(craneIdx)>=box.get(boxIdx)){
                    box.remove(boxIdx);
                    craneIdx++;
                }
                else{
                    boxIdx++;
                }
            }
            ans++;
        }
        System.out.println(ans);

    }
}
