import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//1504
public class Algo142 {

    static int n,e;
    static List<int[]>[] map;





    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //4
        e = Integer.parseInt(st.nextToken());
        map = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            map[i]=new ArrayList<>();
        }
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new int[]{b,c});
            map[b].add(new int[]{a,c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1=-1;
        int ans2=-1;
        int a1 = dijkstra(1,v1);
        int b1 = dijkstra(v1,v2);
        int c1 = dijkstra(v2,n);
        if(a1!=-1 && b1!=-1 && c1!=-1){
            ans1=a1+b1+c1;
        }
        int a2 = dijkstra(1,v2);
        int c2 = dijkstra(v1,n);
        if(a2!=-1 && b1!=-1 && c2!=-1){
            ans2=a2+b1+c2;
        }
        int ans = 0;
        if(ans1==-1 && ans2==-1){
            ans=-1;
        }else{
            if(ans1==-1){
                ans = ans2;
            }else if(ans2==-1){
                ans = ans1;
            }else{
                ans = Math.min(ans1,ans2);
            }
        }

        System.out.println(ans);


    }

    public static int dijkstra(int idx,int end){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] d1 = new int[n+1];
        for(int i=1; i<=n; i++){
            d1[i] = Integer.MAX_VALUE;
        }
        d1[idx]=0;
        pq.add(new int[]{0,idx});
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int weight = tmp[0];
            int next = tmp[1];

            for(int i=0; i<map[next].size(); i++){
                if(weight+map[next].get(i)[1]<d1[map[next].get(i)[0]]){
                    d1[map[next].get(i)[0]] = weight+map[next].get(i)[1];
                    pq.add(new int[]{d1[map[next].get(i)[0]],map[next].get(i)[0]});
                }
            }
        }

        if(d1[end]==Integer.MAX_VALUE){
            return -1;
        }
        return d1[end];
    }


}






