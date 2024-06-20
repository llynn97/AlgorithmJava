import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//1916
public class Algo139 {

    static int n,m;
    static int[] d;
    static boolean[] check;
    static List<int[]>[] map;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        map = new ArrayList[n+1];
        d = new int[n+1];
        check = new boolean[n+1];
        for(int i=0; i<=n; i++){
            map[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new int[]{b,c});
        }

        for(int i=0; i<=n; i++){
            d[i]=Integer.MAX_VALUE;
        }
        st= new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(d[end]);


    }

    public static void dijkstra(int idx){
        d[idx] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        pq.add(new int[]{0,idx});
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int j = tmp[1]; //선택한 노드
            int num = tmp[0]; //가중치
            if(!check[j]){
                check[j]=true;
                for(int i=0; i<map[j].size(); i++){
                    if(!check[map[j].get(i)[0]]&&num+map[j].get(i)[1]<d[map[j].get(i)[0]]){
                        d[map[j].get(i)[0]]= num+map[j].get(i)[1];
                        pq.add(new int[]{d[map[j].get(i)[0]],map[j].get(i)[0]});
                    }
                }
            }


        }
    }
}






