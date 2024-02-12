import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//14497(bfs)
public class Algo18 {

    static int n,m;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int[][] map;
    static boolean[][] visited;
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
        visited = new boolean[n+1][m+1];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                char val = str.charAt(j);
                if(val == '#' || val == '*'){
                    continue;
                }
                map[i][j] = val - '0';
            }
        }
        map[y2][x2] = 1;
        System.out.println(bfs(x1,y1,x2,y2));


    }

    static int bfs(int sx, int sy, int ex, int ey){
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{sx,sy,0});
        visited[sy][sx] = true;
        while(!que.isEmpty()){
            int[] cc = que.poll();
            if(cc[0] == ex && cc[1] == ey){
                return cc[2];
            }
            for(int i=0; i<4; i++){
                int nx = cc[0] + dx[i];
                int ny = cc[1] + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n){
                    continue;
                }
                if(visited[ny][nx]){
                    continue;
                }
                visited[ny][nx] = true;
                if(map[ny][nx] == 0){
                    que.offerFirst(new int[]{nx,ny,cc[2]});
                }else{
                    que.offerLast(new int[]{nx,ny,cc[2]+1});
                }
            }
        }
        return -1;
    }
}
