import java.io.*;
import java.util.*;


//2252
public class Algo146 {

    static int n,m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //학생 수
        m = Integer.parseInt(st.nextToken()); //학생 키를 비교한 횟수

        int[] nodeCount = new int[n+1]; //진입차수 저장 배열

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); //위상정렬 그래프
        for(int i=0; i<=n+1; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b); // a->b
            nodeCount[b]++;
        }

        Queue<Integer> q = new LinkedList<>(); //위상정렬 큐

        for(int i=1; i<=n; i++){ //진입차수가 0인 노트 큐에 넣기
            if(nodeCount[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            bw.write(String.valueOf(node)+" ");

            List<Integer> list = graph.get(node); // 해당 노드에서 나가는 간선

            for(int i=0; i<list.size(); i++){
                int tmp = list.get(i);
                nodeCount[tmp]--; //진입차수 감소
                if(nodeCount[tmp]==0){
                    q.add(tmp);
                }
            }
        }

        bw.flush();

    }
}






