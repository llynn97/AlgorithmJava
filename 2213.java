import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//2213
public class Algo62 {

    static int n;
    static List<Integer>[] node;
    static int[] weight;
    static int[][] dp;
    static boolean[] check;
    static List<Integer> ans;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        weight = new int[n+1];
        dp = new int[n+1][2];
        node = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            node[i] = new ArrayList<>();
        }

        check = new boolean[n+1];
        ans = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[x].add(y);
            node[y].add(x);
        }
        solve1(1);
        check = new boolean[n+1];
        if(dp[1][1]>dp[1][0]){
            System.out.println(dp[1][1]);
            solve2(1,1);
        }else{
            System.out.println(dp[1][0]);
            solve2(0,1);
        }
        Collections.sort(ans);
        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }

    }

    public static void solve1(int left){
        check[left] = true;
        dp[left][0] = 0;
        dp[left][1] = weight[left];
        for(int i=0; i<node[left].size(); i++){
            int child = node[left].get(i);
            if(!check[child]){
                solve1(child);
                if(dp[child][0]>dp[child][1]){
                    dp[left][0]+=dp[child][0];
                }else{
                    dp[left][0]+=dp[child][1];
                }
                dp[left][1]+=dp[child][0];
            }
        }
        check[left] = false;
    }

    public static void solve2(int cnt,int num){
        check[num] = true;
        if(cnt == 1){ //부모 노드가 참석하면
            ans.add(num);
            for(int i=0; i<node[num].size(); i++){
                int next = node[num].get(i);
                if(!check[next]){
                    solve2(0,next);
                }
            }
        }else{
            for(int i=0; i<node[num].size(); i++){
                int next = node[num].get(i);
                if(!check[next]){
                    if(dp[next][0]>dp[next][1]){
                        solve2(0,next);
                    }else{
                        solve2(1,next);
                    }
                }
            }

        }
        check[num] = false;
    }





}
