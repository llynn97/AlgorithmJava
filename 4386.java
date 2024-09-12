import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


//4386
public class Algo151 {

    static int n;
    static ArrayList<Node> list1 = new ArrayList<>();
    static ArrayList<Edge>[] list2;
    static boolean[] check;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        list2 = new ArrayList[n];
        check = new boolean[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            list1.add(new Node(i,x,y));
            list2[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                double dist = Math.sqrt(Math.pow(list1.get(i).x-list1.get(j).x,2)+Math.pow(list1.get(i).y-list1.get(j).y,2));
                list2[i].add(new Edge(j,dist));
                list2[j].add(new Edge(i,dist));
            }
        }

        double ans = solve();
        System.out.printf("%.2f",ans);



    }

    public static double solve(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0,0));
        double dist = 0;

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(!check[now.end]){
                dist+=now.cost;
                check[now.end] = true;

                for(int i=0; i<list2[now.end].size(); i++){
                    Edge next = list2[now.end].get(i);
                    if(!check[next.end]){
                        pq.offer(new Edge(next.end,next.cost));
                    }
                }
            }

        }
        return dist;
    }


    public static class Node{
        int num;
        double x;
        double y;

        public Node(int num,double x, double y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    public static class Edge implements Comparable<Edge>{
        int end;
        double cost;

        public Edge(int end,double cost){
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.cost<o.cost){
                return -1;
            }
            return 1;
        }
    }

}








