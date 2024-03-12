import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1513
public class Algo60 {

    static int n,m,c;

    static int[][][][] dp; //x,y,오락실 최대번호,방문한 오락실 개수
    static int[][] map;

    static int[] dx = {0,1};
    static int[] dy = {1,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dp = new int[n+1][m+1][51][51];
        map= new int[n+1][m+1];
        dp[1][1][0][0] = 1;
        for(int i=1; i<=c; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x==1 && y==1){
                dp[1][1][0][0] = 0;
                dp[1][1][i][1] = 1;
            }
            map[x][y] = i;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i==1 && j==1){
                    continue;
                }
                if(map[i][j]>0){//현재 오락실 이라면
                    for(int l=0; l<map[i][j]; l++){ // 최대 오락실 번호
                        for(int k=0; k<=l; k++){ // 오락실 방문 수
                            dp[i][j][map[i][j]][k+1]+=dp[i-1][j][l][k]+dp[i][j-1][l][k];
                            dp[i][j][map[i][j]][k+1]%=1000007;
                        }
                    }
                }else{
                    for(int l=0; l<=c; l++){
                        for(int k=0; k<=l; k++){
                            dp[i][j][l][k]+=dp[i-1][j][l][k]+dp[i][j-1][l][k];
                            dp[i][j][l][k]%=1000007;
                        }
                    }

                }
            }
        }

        for(int i=0; i<=c; i++){
            int sum =0;
            for(int j=0; j<=c; j++){
                sum+=dp[n][m][j][i];
            }
            sum%=1000007;
            System.out.print(sum+" ");
        }





    }





}
