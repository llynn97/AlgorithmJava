import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//2042
public class Algo167 {
    static int n,m,k;
    static long[] tree;
    static long[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new long[n+1];
        tree = new long[getTreeSize()];
        for(int i=1; i<=n; i++){
            map[i] = Long.parseLong(br.readLine());
        }
        init(1,n,1);
        for(int i=1; i<=m+k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a==1){
                map[b]=c;
               change(1,n,1,b,c);
            }else{
                System.out.println(sSum(1,n,1,b,c));
            }
        }
    }

    public static int getTreeSize(){
        int h = (int)Math.ceil(Math.log(n)/Math.log(2));
        return (int) Math.pow(2,h+1);
    }

    public static long init(int start,int end,int node){
        if(start==end){
            return tree[node] = map[start];
        }
        int mid = (start+end)/2;
        return tree[node] = (init(start,mid,node*2)+init(mid+1,end,node*2+1));
    }

    public static long change(int start,int end,int node,int idx,long num){
        if(idx<start|| end<idx){
            return tree[node];
        }
        if(start==end){
            return tree[node]=num;
        }

        int mid = (start+end)/2;

        return tree[node] = change(start,mid,node*2,idx,num)+change(mid+1,end,node*2+1,idx,num);
    }

    public static long sSum(int start,int end, int node, int left,long right){
        if(end<left || right<start){
            return 0;
        }
        if(left<=start && end<=right){
            return tree[node];
        }

        int mid = (start+end)/2;

        return sSum(start,mid,node*2,left,right)+sSum(mid+1,end,node*2+1,left,right);
    }
}
