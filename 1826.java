import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//1826
public class Algo103 {
    static int n;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq1 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        }); //거리순 오름차순
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq1.add(new int[]{a,b});
        }
        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int ans = 0;
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); //갈수 있는 거리안에 연료 내림차순으로
        while(l>p){
            while(!pq1.isEmpty()&&pq1.peek()[0]<=p){
                pq2.add(pq1.poll()[1]);
            }
            if(pq2.isEmpty()){
                ans = -1;
                break;
            }


            ans++;
            p+=pq2.poll();

        }
        System.out.println(ans);
    }


}






