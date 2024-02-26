import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//2533
public class Algo46 {

    static int n;
    static int[][] dp;
    static boolean[] visited;
    static List<Integer>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dp = new int[n+1][2];
        visited = new boolean[n+1];
        map = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            map[i] = new ArrayList<>();
        }

        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start].add(end);
            map[end].add(start);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0],dp[1][1]));



    }

    public static void dfs(int num){
        visited[num] = true;
        dp[num][0] = 0;
        dp[num][1] = 1;
        for(int i=0; i<map[num].size(); i++){
            if(!visited[map[num].get(i)]){
                dfs(map[num].get(i));
                dp[num][0]+=dp[map[num].get(i)][1];
                dp[num][1]+=Math.min(dp[map[num].get(i)][0],dp[map[num].get(i)][1]);
            }
        }
    }

}
