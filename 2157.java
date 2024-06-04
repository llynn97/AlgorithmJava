import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//2157
public class Algo130 {
    static int n;
    static int m,k;
    static List<int[]>[] list;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        dp = new int[m+1][n+1]; //m번 도시 방문 했을 대 도시 번호가 n
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a>b){
                continue;
            }
            list[a].add(new int[]{b,c});
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int cnt = 1;
        while(!q.isEmpty()&&cnt<m){
            int size = q.size();
            while(size-- >0){
                int now = q.poll();
                for(int i=0; i<list[now].size(); i++){
                    int next = list[now].get(i)[0];
                    int sum = dp[cnt][now]+list[now].get(i)[1];
                    if(dp[cnt+1][next]>=sum){
                        continue;
                    }
                    dp[cnt+1][next] = sum;
                    q.add(next);
                }
            }
            cnt++;
        }
        int ans = 0;

        for(int i=2; i<=m; i++){
            ans = Math.max(ans,dp[i][n]);
        }
        System.out.println(ans);

    }
}






