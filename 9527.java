import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//9527

public class Algo93 {
    static long[] DP = new long[55];	//1의 개수 누적합 저장 배열
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        setDp();	//누적합 계산!

        long result = calOne(M) - calOne(N-1);
        System.out.print(result);
    }

    static long calOne(long N) {
        long count = N & 1;

        int size = (int) (Math.log(N)/Math.log(2));

        for(int i=size;i>0;i--) {
            if((N & (1L<<i)) != 0L) {
                count += DP[i-1] +(N - (1L<<i) + 1);
                N -= (1L << i);	//비트 이동시키기
            }
        }
        return count;
    }
    //DP[n] = DP[n-1] × 2 + 2ⁿ
    static void setDp() {
        DP[0] = 1;

        for(int i=1;i<55;i++)
            DP[i] = (DP[i-1] << 1) + (1L << i);
    }




}
