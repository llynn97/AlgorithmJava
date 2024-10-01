import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


//2263
public class Algo158 {

    static int n;
    static int[] in,post,pre;
    static int idx;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        in = new int[n];
        post = new int[n];
        pre = new int[n];

        idx = 0;

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            in[i] = num;
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            post[i] = num;
        }

        preOrder(0,n-1,0,n-1);
        for(int i=0; i<n; i++){
            System.out.print(pre[i]+" ");
        }
    }

    public static void preOrder(int x,int y,int z,int p){//x = 인오더 시작 , y = 인오더 끝 위치
        if(x<=y && z<=p){
            pre[idx] = post[p]; //프리오더의 마지막 노드가 루트 노드
            idx++;

            int pos = x;
            for(int i=x; i<=y; i++){
                if(in[i]==post[p]){ //인오더에서 루트 노드를 찾으면
                    pos = i;
                    break;
                }
            }
            preOrder(x,pos-1,z,z+pos-x-1);
            preOrder(pos+1,y,z+pos-x,p-1);
        }
    }
}
