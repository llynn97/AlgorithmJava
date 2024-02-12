import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//14497(dijkstra)
public class Algo18_2 {

    static int n,m;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int[][] map;
    static int[][] dist;
    static int x1,x2,y1,y2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        y1 = Integer.parseInt(st.nextToken())-1;
        x1 = Integer.parseInt(st.nextToken())-1;
        y2 = Integer.parseInt(st.nextToken())-1;
        x2 = Integer.parseInt(st.nextToken())-1;
        map = new int[n+1][m+1];
        dist = new int[n+1][m+1];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                char val = str.charAt(j);
                if(val == '1' || val == '0'){
                    map[i][j] = val - '0';
                    continue;
                }
                map[i][j] = 0;
            }
        }
        map[y2][x2] = 1;
        dijkstra(x1,y1);
        System.out.println(dist[y2][x2]);


    }

    static void dijkstra(int sx, int sy){
        for(int[] ints: dist){
            Arrays.fill(ints,123456789);
        }
        PriorityQueue<int[]> pq  = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        dist[sy][sx] = 0;
        pq.add(new int[]{sx,sy,dist[sy][sx]});
        while(!pq.isEmpty()){
            int[] cc = pq.poll();
            if(dist[cc[1]][cc[0]]<cc[2]){
                continue;
            }
            for(int i=0; i<4; i++){
                int nx = cc[0] + dx[i];
                int ny = cc[1] + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n){
                    continue;
                }
               if(dist[ny][nx] > dist[cc[1]][cc[0]]+map[ny][nx]){
                   dist[ny][nx] = dist[cc[1]][cc[0]]+map[ny][nx];
                   pq.add(new int[]{nx,ny,dist[ny][nx]});
               }
            }
        }
    }
}
