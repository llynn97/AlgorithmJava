import java.io.*;
import java.util.*;


//10282
public class Algo147 {

    static int n,d,c,t;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        t = Integer.parseInt(br.readLine());

        for(int k=0; k<t; k++){
            List<List<Node1>> graph = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken()); //의존성 개수
            c = Integer.parseInt(st.nextToken()); //해킹당한 컴퓨터
            for(int i=0; i<n+1; i++){
                graph.add(new ArrayList<>());
            }
            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph.get(b).add(new Node1(a,s));
            }

            int[] dist = dijkstra(graph);

            int cnt = 0;
            int time = 0;
            for(int i=1; i<=n; i++){
                if(dist[i]!=Integer.MAX_VALUE){
                    cnt++;
                    time = Math.max(time,dist[i]);
                }
            }
            System.out.println(cnt+" "+time);

        }
    }

    public static int[] dijkstra(List<List<Node1>> graph){
        boolean[] computer = new boolean[n+1];
        int[] dist = new int[n+1];

        Arrays.fill(dist,Integer.MAX_VALUE);
        computer[c] = true;
        dist[c] = 0;

        Queue<Node1> queue = new PriorityQueue<>();
        queue.add(new Node1(c,0));

        while(!queue.isEmpty()){
            Node1 node = queue.poll();
            int next = node.next;
            int cost = node.second;

            for(int i=0; i<graph.get(next).size(); i++){
                Node1 nextNode = graph.get(next).get(i);

                if(dist[nextNode.next]>cost+nextNode.second){
                    dist[nextNode.next] = cost+nextNode.second;
                    queue.add(new Node1(nextNode.next,cost+nextNode.second));
                }

            }
        }
        return dist;
    }
}

class Node1 implements Comparable<Node1> {
    int next; //도착하는 지점
    int second; //비용

    public Node1(int next, int second) {
        this.next = next;
        this.second = second;
    }

    @Override
    public int compareTo(Node1 o) {
        return this.second - o.second;
    }
}






