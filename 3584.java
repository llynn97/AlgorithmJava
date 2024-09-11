import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//3584
public class Algo150 {

    static int n,m;
    static int t;
    static List<Integer> [] lists;
    static int[] d;
    static int[] p;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            p = new int[n+1];
            check = new boolean[n+1];
            for(int j=0; j<n-1; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                p[b] = a;
            }
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            solve(x,y);

        }


    }

    public static void solve(int a, int b){
        while(a>0){ //루트 노드 찾아가기
            check[a] = true;
            a = p[a];
        }

        while(b>0){
            if(check[b]){
                System.out.println(b);
                break;
            }
            check[b] = true;
            b = p[b];
        }

    }
}








