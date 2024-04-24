import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//15591
public class Algo101 {
    static int n,q;
    static List<int[]>[] list;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            st  = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            list[p1].add(new int[]{q1,r1});
            list[q1].add(new int[]{p1,r1});
        }

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int k1 = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            boolean[] check = new boolean[n+1];
            check[v1] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(v1);
            int ans =  0;
            while (!queue.isEmpty()){
                int cur = queue.poll();
                for(int j=0; j<list[cur].size(); j++){
                    int num3 = list[cur].get(j)[0]; //1-2 2
                    int num4 = list[cur].get(j)[1]; //usado
                    if(!check[num3] && num4>=k1){
                        queue.add(num3);
                        check[num3]=true;
                        ans++;
                    }
                }
            }
            System.out.println(ans);

        }

    }

}






