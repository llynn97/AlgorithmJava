import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//2812
public class Algo107 {
    static int n,k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int len  = n-k;
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            while(!stack.isEmpty() && k>0 && str.charAt(i)>stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(str.charAt(i));
        }
        while(true){
            if(stack.size()==len){
                break;
            }
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse().toString());

    }


}






