import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
//1758
public class Algo14 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        long answer = 0;
        ArrayList<Integer> map  = new ArrayList<>();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            map.add(num);
        }
        Collections.sort(map,Collections.reverseOrder());
        for(int i=0; i<map.size(); i++){
            int m = map.get(i)-i;
            if(m>=0){
                answer+=m;
            }
        }
        System.out.println(answer);

    }
}
