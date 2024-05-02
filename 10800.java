import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;


//10800
public class Algo108 {
    static int n,k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][3]; //인덱스,색,크기
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            map[i][0] = i;
            map[i][1] = color;
            map[i][2] = size;
        }

        Arrays.sort(map, new Comparator<int[]>() { //크기 오름차순
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        int[] colors = new int[n+1]; //같은 색깔 공들의 크기 합
        int[] ans  = new int[n]; //인덱스에 대한 크기 합

        int idx1 = 0;
        int sum  = 0; //크기 누적합
        for(int i=0; i<n; i++){
            while(map[i][2]>map[idx1][2]){
                sum+=map[idx1][2];
                colors[map[idx1][1]]+=map[idx1][2];
                idx1++;
            }
            ans[map[i][0]] = sum - colors[map[i][1]];
        }
        for(int i=0; i<n; i++){
            System.out.println(ans[i]);
        }

    }


}






