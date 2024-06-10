import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


//2666
public class Algo132 {
    static int n;
    static List<Integer> list; //문
    static int[] map;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        list.add(Integer.parseInt(st.nextToken()));
        list.add(Integer.parseInt(st.nextToken()));
        int num = Integer.parseInt(br.readLine());
        map = new int[num];
        for(int i=0; i<num; i++){
            map[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve(0,list.get(0),list.get(1)));
    }

    public static int solve(int cnt,int a,int b){
        if(cnt==map.length){
            return 0;
        }
        int n1 = Math.abs(a-map[cnt]);
        int n2 = Math.abs(b-map[cnt]);

        return Math.min(n1+solve(cnt+1,b,map[cnt]),n2+solve(cnt+1,a,map[cnt]));
    }
}






