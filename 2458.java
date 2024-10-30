import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//2458
public class Algo170 {
    static int n,m,k;
    static boolean[][] map;
    static boolean[][] rMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[n+1][n+1];
        rMap = new boolean[n+1][n+1];

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            rMap[b][a] = true;
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(map[i][k] && map[k][j]){
                        map[i][j] = true;
                    }

                    if(rMap[i][k] && rMap[k][j]){
                        rMap[i][j] = true;
                    }
                }
            }
        }
        int ans = 0;
        for(int i=1; i<=n; i++){
            boolean check = true;
            for(int j=1; j<=n; j++){
                if(i==j){
                    continue;
                }
                if(!(map[i][j] || rMap[i][j])){
                    check = false;
                    break;
                }
            }
            if(check){
               ans++;
            }
        }
        System.out.println(ans);

    }
}
