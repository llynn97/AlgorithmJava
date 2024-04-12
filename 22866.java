import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//22866

public class Algo92 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr =new int[n+1];
        int[] building = new int[n+1]; //index,height
        int[][] gap = new int[n+1][2]; //index,gap
        for(int i=1; i<=n; i++){
            building[i] = Integer.parseInt(st.nextToken());

        }
        for(int i=1; i<=n; i++){
            gap[i][1] = 100001;
        }
        Stack<int[]> stack = new Stack<>();
        for(int i=1; i<=n; i++){
            while (!stack.isEmpty()&&stack.peek()[1]<=building[i]){
                stack.pop();
            }
            arr[i]+=stack.size();
            if(!stack.isEmpty()){
                int res = Math.abs(stack.peek()[0]-i);
                if(res<gap[i][1]){
                    gap[i][1] = res;
                    gap[i][0] = stack.peek()[0];
                }else if(res==gap[i][1]&&stack.peek()[0]<gap[i][0]){
                    gap[i][0] = stack.peek()[0];
                }

            }
            stack.push(new int[]{i,building[i]});
        }

        stack = new Stack<>();
        for(int i=n; i>=1; i--){
            while (!stack.isEmpty()&&stack.peek()[1]<=building[i]){
                stack.pop();
            }
            arr[i]+=stack.size();
            if(!stack.isEmpty()){
                int res = Math.abs(stack.peek()[0]-i);
                if(res<gap[i][1]){
                    gap[i][1] = res;
                    gap[i][0] = stack.peek()[0];
                }else if(res==gap[i][1]&&stack.peek()[0]<gap[i][0]){
                    gap[i][0] = stack.peek()[0];
                }

            }
            stack.push(new int[]{i,building[i]});
        }

        for(int i=1; i<=n; i++){
            if(arr[i]==0){
                System.out.println(0);
            }else{
                System.out.println(arr[i]+" "+gap[i][0]);
            }
        }


    }

}
