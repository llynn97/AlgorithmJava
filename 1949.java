import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//1949
public class Algo65 {

    static int n;
    static int[] map;
    static List<Integer>[] node;
    static boolean[] check;
    static int[][] dp;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        map = new int[n+1];
        check = new boolean[n+1];
        dp = new int[n+1][2];
        for(int i=1; i<=n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        node = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            node[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++){
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[x].add(y);
            node[y].add(x);
        }

        solve(1);
        System.out.println(Math.max(dp[1][0],dp[1][1]));


    }

    public static void solve(int num){
        check[num] = true;
        dp[num][0] = 0;
        dp[num][1] = map[num];
        for(int i=0; i<node[num].size(); i++){
            int next = node[num].get(i);
            if(!check[next]){
                solve(next);

                dp[num][0] += Math.max(dp[next][0],dp[next][1]);
                dp[num][1] += dp[next][0];
            }
        }


        check[num] = false;
    }





}
