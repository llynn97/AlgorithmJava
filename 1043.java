import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


//1043
public class Algo168 {
    static int n,m,k;
    static int[] parent;
    static List<Integer>[] partyList;
    static List<Integer> truePeople;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken()); //진실을 아는 사람 수

        if(k==0){
            System.out.println(m);
        }else{
            truePeople = new ArrayList<>();
            partyList = new ArrayList[m+1];

            for(int i=1; i<=m; i++){
                partyList[i] = new ArrayList<>();
            }

            for(int i=0; i<k; i++){
                int num = Integer.parseInt(st.nextToken());
                truePeople.add(num);
            }

            for(int i=1; i<=m; i++){
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                for(int j=0; j<num; j++){
                    int y = Integer.parseInt(st.nextToken());
                    partyList[i].add(y);
                }
            }

            for(int i=1; i<=m; i++) {
                int first = partyList[i].get(0);
                for(int j=1; j<partyList[i].size(); j++){
                    union(first,partyList[i].get(j));
                }
            }


            int cnt = 0;
            for(int i=1; i<=m; i++){
                boolean check = true;
                for(int j=0; j<partyList[i].size(); j++){
                    if(truePeople.contains(find(parent[partyList[i].get(j)]))){
                        check = false;
                        break;
                    }
                }
                if(check){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

    }

    public static int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(truePeople.contains(x)){
            parent[y] = x;
        }else if(truePeople.contains(y)){
            parent[x] = y;
        }else{
            parent[y] = x;
        }
    }
}
