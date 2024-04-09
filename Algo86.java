import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//16637
public class Algo86 {
    static int n,n1;
    static String str;
    static List<Integer> num;
    static List<Character> op;

    static boolean[] check;

    static int ans;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        str = br.readLine();
        num = new ArrayList<>();
        op = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            if(i%2==0){
                num.add(str.charAt(i)-'0');
            }else{
                op.add(str.charAt(i));
            }
        }
        ans = Integer.MIN_VALUE;
        solve(0,num.get(0));
        System.out.println(ans);

    }


    public static void solve(int idx,int result){
        if(idx>=op.size()){
            ans = Math.max(result,ans);
            return;
        }
        int num3 = calculate(op.get(idx),result,num.get(idx+1));
        solve(idx+1,num3);
        if(idx+1<op.size()){
            num3 = calculate(op.get(idx+1),num.get(idx+1),num.get(idx+2));
            int num4 = calculate(op.get(idx),result,num3);
            solve(idx+2,num4);
        }
    }



    public static int calculate(char op,int num1,int num2){
        if(op=='*'){
            return num1*num2;
        }
        else if(op=='-'){
            return num1-num2;
        }
        return num1+num2;
    }





}
