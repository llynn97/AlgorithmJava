import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//11505
public class Algo166 {
    static int n,m,k;
    static int[] map;
    static long[] tree;
    static int mod = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n+1];
        tree = new long[getTreeSize()];
        for(int i=1; i<=n; i++){
            int num = Integer.parseInt(br.readLine());
            map[i] = num;
        }
        init(1,n,1);
        for(int i=1; i<=m+k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==1){
                map[b] = c;
                update(1,n,1,b,c);
            }else{
                System.out.println(solve(1,n,1,b,c)%mod);
            }
        }

    }
    static int getTreeSize(){
        int h = (int)Math.ceil(Math.log(n)/Math.log(2));
        return (int)Math.pow(2,h+1);
    }
    static long init(int start,int end,int node){
        if(start==end){//리프노드 일 때
            return tree[node]=map[start];
        }
        int mid = (start+end)/2;
        return tree[node]=(init(start,mid,node*2)*init(mid+1,end,node*2+1))%mod;
    }

    static long update(int start,int end,int node,int idx,int dif){
        if(end<idx||idx<start){//값 변경하는 인덱스를 포함하지 않을 경우
            return tree[node];
        }
        if(start==end){
            return tree[node]=dif;
        }
        int mid = (start+end)/2;
        return tree[node]=(update(start,mid,node*2,idx,dif)*update(mid+1,end,node*2+1,idx,dif))%mod;
    }

    static long solve(int start,int end,int node,int left,int right){
        if(end<left || right<start){ //겹치지 않는 경우
            return 1;
        }
        if(left<=start && end<=right){//완전 포함되는 경우
            return tree[node];
        }
        int mid = (start+end)/2;
        return (solve(start,mid,node*2,left,right)*solve(mid+1,end,node*2+1,left,right))%mod;
    }
}
