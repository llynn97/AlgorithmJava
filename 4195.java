import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


//4195
public class Algo154 {

    static int n,k,t,f;
    static int[] parent;
    static int[] level;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        for(int i=0; i<t; i++){
            f = Integer.parseInt(br.readLine());
            parent = new int[f*2];
            level = new int[f*2];

            int idx = 0;
            HashMap<String,Integer> map = new HashMap<>();
            for(int j=0; j<2*f; j++){
                parent[j] = j;
                level[j]=1;
            }
            for(int j=0; j<3; j++){
                String str = br.readLine();
                String a = str.split(" ")[0];
                String b = str.split(" ")[1];

                if(!map.containsKey(a)){
                    map.put(a,idx++);
                }
                if(!map.containsKey(b)){
                    map.put(b,idx++);
                }
                System.out.println(union(map.get(a),map.get(b)));
            }
        }
    }

    public static int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    public static int union(int x,int y){
        x = find(x);
        y= find(y);
        if(x!=y){
            parent[y]=x;
            level[x]+=level[y];
            level[y]=1;
        }
        return level[x];
    }
}








