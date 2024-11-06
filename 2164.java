import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//13335
public class Algo174 {
    static int n;
    static Queue<Integer> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());


        for(int i=1; i<=n; i++){
            q.add(i); //4
        }

        while(!q.isEmpty()){
            if(q.size()==1){
                break;
            }
            q.poll();
            int num = q.poll();
            q.add(num);
        }

        System.out.println(q.poll());

    }
}
