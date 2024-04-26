import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


//17780
public class Algo103 {
    static int n,k;
    static ArrayList<Integer>[][] map; //체스판에 쌓여있는 말
    static int[][] chess; //체스판
    static int[][] horse; //말
    static int[] dx = {1,-1,0,0}; //우 좌 위 아래
    static int[] dy = {0,0,-1,1};




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new ArrayList[n][n];
        chess = new int[n][n];
        horse = new int[k][3]; // 행,열,방향
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                chess[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = new ArrayList<>();
            }
        }
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken())-1;
            horse[i][0] = x;
            horse[i][1] = y;
            horse[i][2] = dir;
            map[y][x].add(i);
        }
        int ans = solve();
        System.out.println(ans);



    }

    static int solve(){
        int num = 0;
        while(true){
            num++;
            if(num>1000){
                return -1;
            }
            for(int i=0; i<k; i++){
                int x = horse[i][0];
                int y = horse[i][1];
                int dir = horse[i][2];
                if(map[y][x].get(0)!=i){ //말이 젤 아래가 아닌 경우
                    continue;
                }
                int nx = x+dx[dir];
                int ny = y+dy[dir];
                if(check(nx,ny) || chess[ny][nx]==2){ // 파란색이거나 범위 벗어났을 때
                    int dir2 = changeDir(dir);
                    horse[i][2] = dir2; // 반대로 방향 바꿈
                    nx = x+dx[dir2];
                    ny = y+dy[dir2];
                    if(check(nx,ny)||chess[ny][nx]==2){ //이동한 칸이 파란색이면
                        continue; //방향만 바꿈
                    }else if(chess[ny][nx]==1){//빨간색 일때 이동 후 말의 순서를 바꿈
                        goRed(x,y,nx,ny);
                    }else{
                        goWhite(x,y,nx,ny);
                    }

                }else if(chess[ny][nx]==1){ //빨간색일때
                    goRed(x,y,nx,ny);
                }else{
                    goWhite(x,y,nx,ny);
                }
                if(map[ny][nx].size()>=4){
                    return num;
                }
            }
        }
    }

    static boolean check(int x, int y){ //체스판 벗어난 경우 파란색이랑 같음
        if(x<0 || y<0 || x>=n || y>=n){
            return true;
        }
        return false;
    }

    static int changeDir(int dir){
        if(dir==0){
            return 1;
        }else if(dir==1){
            return 0;
        }else if(dir==2){
            return 3;
        }else{
            return 2;
        }
    }

    static void goRed(int x, int y, int nx, int ny){
        for(int i=map[y][x].size()-1; i>=0; i--){
            int tmp = map[y][x].get(i);
            map[ny][nx].add(tmp);
            horse[tmp][0] = nx;
            horse[tmp][1] = ny;
        }
        map[y][x].clear();
    }

    static void goWhite(int x, int y, int nx, int ny){
        for(int i=0; i<map[y][x].size(); i++){
            int tmp = map[y][x].get(i);
            map[ny][nx].add(tmp);
            horse[tmp][0] = nx;
            horse[tmp][1] = ny;
        }
        map[y][x].clear();
    }


}






