import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//6087
public class Algo134 {
    static int h,w;
    static char[][] map;
    static int[][] dp;
    static int[] dx = {-1,0,1,0}; // 북 서 남 동
    static int[] dy = {0,-1,0,1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        dp = new int[h][w];

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        int sX = 0;
        int sY = 0;

        for(int i=0; i<h; i++){
            String str = br.readLine();
            for(int j=0; j<w; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='C'){
                    sX = i;
                    sY = j;
                }
            }
        }
        System.out.println(bfs(sX,sY));

    }

    public static int bfs(int x, int y){
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[3]-o2[3];
            }
        });

        q.add(new int[]{x,y,-1,0}); //x,y좌표,방향,거울 수
        dp[x][y]=0;
        int cnt = 0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();

            if(map[tmp[0]][tmp[1]]=='C'){
                cnt++;
                if(cnt==2){
                    return dp[tmp[0]][tmp[1]]; //다른 거울에 도착했을 때
                }
            }
            if(tmp[3]>dp[tmp[0]][tmp[1]]){
                continue;
            }
            for(int i=0;i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if(nx<0 || ny<0 || nx>=h || ny>=w || map[nx][ny]=='*'){
                    continue;
                }
                if(i!=tmp[2]&&tmp[2]!=-1){ //방향이 달라질 경우
                    if(dp[nx][ny]>=tmp[3]+1){
                        dp[nx][ny]=tmp[3]+1;
                        q.add(new int[]{nx,ny,i,tmp[3]+1});
                    }
                }else{ //방향이 같을 때
                    if(dp[nx][ny]>=tmp[3]){
                        dp[nx][ny]=tmp[3];
                        q.add(new int[]{nx,ny,i,tmp[3]});
                    }
                }


            }
        }
        return -1;

    }
}






