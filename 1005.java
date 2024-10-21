import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//1005
public class Algo165 {
    static int n,t,k,w;
    static ArrayList<Integer>[] list;
    static int[] building; //빌딩 비용
    static int[] indegree;
    static int[] buildCost; //각 위치까지 빌딩 비용의 최대값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            list = new ArrayList[n+1];
            building = new int[n+1];
            indegree = new int[n+1];
            buildCost = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                building[j] = Integer.parseInt(st.nextToken());
                list[j] = new ArrayList<>();
            }

            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                indegree[y]++;
            }
            w = Integer.parseInt(br.readLine());
            topologySort();
            System.out.println(buildCost[w]);
        }

    }

    public static void topologySort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<indegree.length; i++){
            if(indegree[i]==0){
                buildCost[i] = building[i];
                q.offer(i);
            }
        }

        while (!q.isEmpty()){
            int cur = q.poll();

            for(int i=0; i<list[cur].size(); i++){
                int next = list[cur].get(i);
                buildCost[next] = Math.max(buildCost[cur]+building[next],buildCost[next]);
                indegree[next]--;
                if(indegree[next]==0){
                    q.add(next);
                }
            }
        }
    }
}
