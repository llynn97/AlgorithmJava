import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//17182
public class Algo171 {
    static int n,m,k;
    static int[][] arr;
    static boolean[] check;
    static int ans;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        check = new boolean[n];

        ans = 987654321;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int t = Integer.parseInt(st.nextToken());
                arr[i][j] = t;
            }
        }

        for(int p=0; p<n; p++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = Math.min(arr[i][j],arr[i][p]+arr[p][j]);
                }
            }
        }
        check[k] = true;
        dfs(0,k,0);
        System.out.println(ans);
    }


    public static void dfs(int idx,int start,int sum){
        if(idx==n-1){
            ans = Math.min(ans,sum);
            return;
        }

        for(int i=0; i<n; i++){
            if(!check[i]){
                check[i] = true;
                dfs(idx+1,i,sum+arr[start][i]);
                check[i] = false;
            }
        }
    }
}
