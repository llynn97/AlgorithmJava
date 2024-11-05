import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;


//13335
public class Algo173 {
    static int n,w,L;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w=  Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            truck.add(Integer.parseInt(st.nextToken()));
        }
        int time = 0;
        int bw = 0; //다리에 올라간 무게

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<w; i++){
            q.add(0);
        }

        while(!q.isEmpty()){
            time++;
            bw-=q.poll();
            if(!truck.isEmpty()){
                if(truck.peek()+bw<=L){
                    bw+=truck.peek();
                    q.offer(truck.poll());
                }else{
                    q.offer(0);
                }
            }
        }

        System.out.println(time);
    }
}
