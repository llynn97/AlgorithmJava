import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//1736
public class Algo186 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][m+1];
        PriorityQueue<Integer> pq[] = new PriorityQueue[m+1];

        for(int i=1; i<=m; i++){
            pq[i] = new PriorityQueue<>();
        }
        int cnt = 0;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    pq[j].add(i);
                    cnt++;
                }
            }
        }

        int answer=0;

        for(int i=m; i>=1; i--){
            int pa = 0;
            int h = n;
            for(int j=m; j>=1; j--){
                if(pq[j].size() ==0){ //쓰러기가 없는 줄은 넘어감
                    continue;
                }
                int s = pq[j].peek();
                if(h>=s){
                    while(pq[j].size()>0 && h>=pq[j].peek()){
                        pq[j].poll();
                        pa++;
                    }
                    h=s;
                }
            }
            if(pa>0){
                answer++;
            }
            if(pa==0){
                break;
            }
        }
        System.out.println(answer);
    }
}
