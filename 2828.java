import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2828
public class Algo17 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());
        int answer = 0;
        int start = 1, end = M;

        for(int i=0;i<j;i++){
            int apple = Integer.parseInt(br.readLine());
            if(start > apple){
                answer += start - apple;
                end -= start - apple;
                start = apple;
            }else if(end < apple){
                answer += apple - end;
                start += apple - end;
                end = apple;
            }
        }
      System.out.println(answer);
    }
}
