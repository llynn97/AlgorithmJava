import java.io.*;
import java.util.*;


//1774
public class Algo155 {

    static int n,m;
    static int[] parent;
    static ArrayList<Edge> list;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        list = new ArrayList<>();
        double ans = 0;

        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        Point[] points = new Point[n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            double a = Integer.parseInt(st.nextToken());
            double b = Integer.parseInt(st.nextToken());
            points[i] = new Point(i,a,b);
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            union(start,end);
        }

        for(int i=1; i<=n; i++){
            for(int j=i+1; j<=n; j++){
                double weight = Math.sqrt(Math.pow(points[i].x-points[j].x,2)+Math.pow(points[i].y-points[j].y,2));
                list.add(new Edge(points[i].num,points[j].num,weight));
            }
        }
        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            Edge edge = list.get(i);

            if(find(edge.start)!=find(edge.end)){
                ans+=edge.weight;
                union(edge.start,edge.end);
            }
        }

        bw.write(String.format("%.2f",ans)+"\n");
        bw.flush();
        bw.close();;
        br.close();
    }
    public static int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    public static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[y]=x;
        }
    }
}

class Point{
    int num;
    double x;
    double y;
    public Point(int num, double x,double y){
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge>{
    int start;
    int end;
    double weight; //가중치

    Edge(int start,int end,double weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge o) {
        if(weight<o.weight){
            return -1;
        }
        return 1;
    }
}








