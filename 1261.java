import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//1261
public class Algo141 {

    static int n,m;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int[][] map;
    static boolean[][] check;




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); //4
        n = Integer.parseInt(st.nextToken()); //2

        map = new int[n+1][m+1];
        check = new boolean[n+1][m+1];

        for(int i=1; i<=n; i++){
            String str = br.readLine();
            for(int j=1; j<=m; j++){
                map[i][j]= Character.getNumericValue(str.charAt(j-1));
            }
        }

        int ans  = bfs(1,1);
        System.out.println(ans);


    }


    public static int bfs(int x, int y){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        check[x][y]=true;
        pq.add(new int[]{x,y,0});
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            if(tmp[0]==n && tmp[1]==m){
                return tmp[2];
            }

            for(int i=0; i<4; i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];
                if(nx>=1 && ny>=1 && nx<=n && ny<=m && !check[nx][ny]){
                    check[nx][ny]=true;
                    if(map[nx][ny]==1){
                        pq.add(new int[]{nx,ny,tmp[2]+1});
                    }else{
                        pq.add(new int[]{nx,ny,tmp[2]});
                    }
                }
            }
        }
        return 0;
    }
}






