import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


//13913
public class Algo153 {

    static int n,k;
    static int[] parent;
    static int[] d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        d = new int[100001];
        parent = new int[100001];

        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int idx = k;

        while(idx!=n){
            stack.push(parent[idx]);
            idx = parent[idx];
        }
        System.out.println(d[k]-1);
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }

    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        d[n] = 1;

        while(!q.isEmpty()){
            int num = q.poll();
            if(num==k){
                return;
            }
            for(int i=0; i<3; i++){
                int next = 0;
                if(i==0){
                    next = num+1;
                }
                else if(i==1){
                    next = num-1;
                }
                else{
                    next = num*2;
                }
                if(next<0 || next>100000){
                    continue;
                }
                if(d[next]==0){
                    q.add(next);
                    d[next]=d[num]+1;
                    parent[next] = num;
                }
            }
        }
    }
}








