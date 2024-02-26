import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//13975
public class Algo45 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int j=0; j<n; j++){
                pq.add(Long.parseLong(st.nextToken()));
            }
            long ans = 0;

            while(pq.size()>1){
                long num = pq.poll();
                num+=pq.poll();
                ans+=num;
                pq.add(num);
            }

            System.out.println(ans);

        }




    }

}
