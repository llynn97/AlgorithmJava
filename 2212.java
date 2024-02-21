import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//2212
public class Algo39 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> list = new ArrayList<>();
        List<Integer> diff = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        for(int i=0; i<n-1; i++){
            diff.add(list.get(i+1)-list.get(i));
        }
        Collections.sort(diff);


        int ans = 0;
        for(int i=0; i<n-k; i++){
            ans+=diff.get(i);
        }
        System.out.println(ans);

    }
}
