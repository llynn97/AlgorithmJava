import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


//18429
public class Algo172 {
    static int n,m,k;
    static int[] map;
    static boolean[] check;
    static int ans;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n];
        check = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
        dfs(0);
        System.out.println(ans);

    }

    public static void dfs(int dep){
        if(dep == n){
            int weight = 500;
            for(int i=0; i<list.size(); i++){
                weight = weight-k+list.get(i);

                if(weight<500){
                    return;
                }
            }
            ans++;
            return;
        }

        for(int i=0; i<n; i++){
            if(!check[i]){
              check[i] = true;
              list.add(map[i]);
              dfs(dep+1);
              check[i]  = false;
              list.remove(list.size()-1);
            }
        }
    }
}
