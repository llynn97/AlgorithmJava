import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//1863
public class Algo43 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<Integer> stack = new Stack<>();
        int[] map ;
        int ans = 0;
        n = Integer.parseInt(br.readLine());
        map = new int[n+1];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[i] = y;
            while(!stack.empty() && stack.peek()>map[i]){
                ans ++;
                stack.pop();
            }
            if(!stack.empty() && stack.peek() == map[i]){
                continue;
            }

            stack.push(map[i]);
        }

        while(!stack.empty()){
            if(stack.peek()>0){
                ans++;
            }
            stack.pop();
        }
        System.out.println(ans);


    }

}
