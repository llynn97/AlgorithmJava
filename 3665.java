import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//3665
public class Algo162 {

    static int n,m,t;
    static List<Integer> answers = new ArrayList<>();
    static int[] map;
    static int[] di; //진입차수
    static ArrayList<Integer>[] list;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        for(int k=0; k<t; k++){
            queue = new LinkedList<>();
            n = Integer.parseInt(br.readLine());
            map = new int[n+1];
            di = new int[n+1];
            list = new ArrayList[n+1];
            for(int i=1; i<=n; i++){
                list[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                map[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<=n; i++){
                for(int j=i+1; j<=n; j++){
                    list[map[i]].add(map[j]);
                    di[map[j]]++;
                }
            }
            m = Integer.parseInt(br.readLine());
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                if(list[start].contains(end)){
                    list[start].remove((Integer) end);
                    list[end].add(start);
                    di[start]++;
                    di[end]--;
                }else{
                    list[end].remove((Integer) start);
                    list[start].add(end);
                    di[end]++;
                    di[start]--;
                }
            }
            StringBuilder sb = new StringBuilder();

            int cnt = 0;
            for(int i=1; i<=n; i++){
                if(di[i]==0){
                    cnt++;
                    queue.add(i);
                }
            }
            if(cnt>1){
                System.out.print("?");
                continue;
            }
            int result = 0;
            boolean check = false;
            for(int i=1; i<=n; i++){
                if(queue.isEmpty()){
                    System.out.println("IMPOSSIBLE");
                    check = true;
                    break;
                }
                int from = queue.poll();
                result++;
                sb.append(from).append(" ");
                for(int j=0; j<list[from].size(); j++){
                    int to =  list[from].get(j);
                    di[to]--;
                    if(di[to]==0){
                        queue.add(to);
                    }
                }

            }
            if(check){
                continue;
            }
            System.out.println(sb.toString());

        }

    }


}
