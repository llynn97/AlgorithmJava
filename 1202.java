import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//1202
public class Algo50 {

    static int n,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] jewelry = new int[n][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            jewelry[i][0] = Integer.parseInt(st.nextToken());
            jewelry[i][1] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(jewelry, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }
                return o1[0]-o2[0];
            }
        }); //보석을 무게순으로 오름차순 정렬, 같을 땐 가격 내림차순 정렬



        int[] bag = new int[k];

        for(int i=0; i<k; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag); // 무게순으로 가방 오름차순 정렬

        long ans = 0;
        PriorityQueue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder());
        int j=0;
        for(int i=0; i<k; i++){
            while(j<n && jewelry[j][0]<=bag[i]){
              pq.offer(jewelry[j][1]);
              j++;
            }
            if(!pq.isEmpty()){
                ans+=pq.poll();
            }

        }

        System.out.println(ans);







    }

}
