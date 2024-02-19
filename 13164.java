import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//13164
public class Algo34 {

    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> diff = new ArrayList<>();
        map = new int[n+1];
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n-1; i++){
            diff.add(map[i+1]-map[i]);
        }
        Collections.sort(diff);
        int answer = 0;
        for(int i=0; i<n-k; i++){
            answer+=diff.get(i);
        }
        System.out.println(answer);




    }
}
