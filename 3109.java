import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//3109
public class Algo123 {
    static int r,c;
    static int[][] dir={{-1,1},{0,1},{1,1}}; //대각선 위 오른, 오른쪽, 대각선 아래 오른
    static char[][] map;
    static boolean[][] check;
    static boolean flag;
    static int cnt;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        check = new boolean[r][c];
        cnt = 0;
        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<r; i++){
            flag = false;
            dfs(i,0);
        }
        System.out.println(cnt);



    }

    public static void dfs(int x, int y){
        if(y==c-1){
            cnt++;
            flag = true;
            check[x][y]=true;
            return;
        }
        for(int i=0; i<3; i++){
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            if(dx>=0 && dy>=0 && dx<r && dy<c && !check[dx][dy]&&map[dx][dy]=='.'){
                dfs(dx,dy);
                if(flag){
                    check[x][y]=true;
                    return;
                }else{
                    check[x][y]=true;
                }
            }
        }
    }
}






