import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//1459
public class Algo121 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        int w = Integer.parseInt(st.nextToken()); //한 블록 움직임
        int s = Integer.parseInt(st.nextToken()); //대각선 움직임
        long ans=0;
        long num = Math.min(x,y);

        if(w>s){ //대각선으로 움직이는게 더 최소
            ans+=s*num;
            x-=num;
            y-=num;
            if(x==0){
                num=y;
            }else{
                num=x;
            }
            if(num%2==0){
                ans+=s*num;
            }else{
                ans+=(s*(num-1)+w);
            }

        }else{
            if(s-w<=w){ //대각선으로 움직이는게 더 최소
                ans+=s*num;
                x-=num;
                y-=num;
                if(x==0){
                    num=y;
                }else{
                    num=x;
                }
                ans+=(w*num);
            }else{ //한 블록으로 움직이는게 더 최소
                ans+=(w*(x+y));
            }
        }

        System.out.println(ans);

    }
}






