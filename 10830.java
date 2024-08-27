import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//10830
public class Algo143 {

    static int n;
    static long b;
    static int[] d;
    static int[][] map;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        map = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] result = func(map,b);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);



    }

    public static int[][] func(int[][] a,long exp){
        if(exp == 1L){
            return a;
        }
        int[][] ret = func(a,exp/2); //지수를 절반으로 분할
        ret = multiply(ret,ret);

        if(exp%2==1L){ //지수가 홀수 이면 A를 곱해줌
            ret = multiply(ret,map);
        }
        return ret;
    }

    public static int[][] multiply(int[][] o1,int[][] o2){
        int[][] ret = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j]%=1000;
                }
            }
        }
        return ret;
    }
}






