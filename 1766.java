import java.io.*;
import java.util.*;


//1766
public class Algo149 {

    static int n,m;
    static List<Integer> [] lists;
    static int[] d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n+1];
        d = new int[n+1];

        for(int i=1; i<=n; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            d[b]++;
        }

        System.out.println(solve());
    }
    
    public static String solve(){
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            if(d[i]==0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int now = pq.poll();
            sb.append(now).append(" ");
            for(int i=0; i<lists[now].size(); i++){
                int next = lists[now].get(i);
                d[next]--;
                if(d[next]==0){
                    pq.add(next);
                }
            }
        }
        return sb.toString();
    }
}








