import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//2109
public class Algo113 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][2]; // 가격,날짜
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[i][0] = p;
            map[i][1] = d;
        }

        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }
                return o2[0]-o1[0];
            }
        });
        int ans  = 0;
        boolean[] check = new boolean[10001];
        for(int i=0; i<n; i++){
            for(int j=map[i][1]; j>=1; j--){
                if(!check[j]){
                    check[j]=true;
                    ans+=map[i][0];
                    break;
                }
            }
        }
        System.out.println(ans);
    }

}






