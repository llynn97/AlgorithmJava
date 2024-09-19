import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//10775
public class Algo152 {

    static int g,p;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        g = Integer.parseInt(st.nextToken()); //게이트 수
        p = Integer.parseInt(br.readLine()); //비행기 수
        parent = new int[g+1]; //차선책 저장
        for(int i=1; i<=g; i++){
            parent[i] = i;
        }
        int ans = 0;

        for(int i=0; i<p; i++){
            int n = Integer.parseInt(br.readLine());
            int gate = find(n);
            if(gate==0){
                break;
            }
            ans++;
            union(gate,gate-1);
        }

        System.out.println(ans);

    }

    public static int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parent[x] = y;
        }
    }
}








