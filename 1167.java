import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


//1167
public class Algo157 {

    static int v;
    static ArrayList<Node>[] list;
    static int maxNum = -1;
    static int node;
    static boolean[] check;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());

        list = new ArrayList[v+1];
        check = new boolean[v+1];
        for(int i=1; i<=v; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<v; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true){
                int end = Integer.parseInt(st.nextToken());
                if(end==-1){
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                list[start].add(new Node(end,weight));
            }
        }

        dfs(1,0); //1번 노드로부터 가장 거리가 긴 정점을 찾음


        check = new boolean[v+1];
        dfs(node,0); //node 노드로부터 가장 거리가 긴 정점을 찾으면 답

        System.out.println(maxNum);
    }

    public static void dfs(int start,int cost){
        if(maxNum<cost){
            maxNum = cost;
            node = start;
        }

        check[start] = true;

        for(int i=0; i<list[start].size(); i++){
            int next = list[start].get(i).end;
            int weight = list[start].get(i).weight;
            if(!check[next]){
                check[next]  = true;
                dfs(next,cost+weight);
            }
        }
    }

    public static class Node{
        int end;
        int weight;

        public Node(int end,int weight){
            this.end = end;
            this.weight = weight;
        }
    }
}
