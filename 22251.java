import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//22251
public class Algo98 {
    static int n,k,p,x;
    static long[] map;
    static int[][] number = {{1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 0, 1}, //1
            {0, 1, 1, 1, 1, 1, 0}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 0, 1}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 0, 1}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}}; //9

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int t = x;
        int[] digit = new int[k];
        for(int i=k-1; i>=0; i--){
            digit[i] = t%10;
            t/=10;
        }
        int ans = 0;
        for(int i=1; i<=n; i++){
            if(i==x){
                continue;
            }
            if(solve(i,digit)){
                ans++;
            }
        }
        System.out.println(ans);



    }

    public static boolean solve(int target,int[] num2){
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            result[i] = target % 10;
            target /= 10;
        }
        int cnt = 0;
        for(int i=0; i<k; i++){
            for(int j=0; j<7; j++){
                if(number[num2[i]][j]!=number[result[i]][j]){
                    cnt++;
                    if(cnt>p){
                        return false;
                    }
                }
            }
        }
        return true;
    }




}
