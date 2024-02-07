import java.util.*;
import java.io.*;
//1976
public class Algo12 {

    static int n;
    static int m;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        for (int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a==1){
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start  = Integer.parseInt(st.nextToken());
        for(int i=1; i<m; i++){
            int next = Integer.parseInt(st.nextToken());
            if(parent[start] != parent[next]){
                System.out.println("NO");

            }
        }
        System.out.println("YES");

    }

    static void union(int x, int y){
        x= find(x);
        y=find(y);
        if(x>y){
            parent[x]=y;
        }
        else parent[y] = x;
    }
    static int find(int x){
        if(parent[x]==x){
            return x;
        }
        else return parent[x]=find(parent[x]);
    }
}
