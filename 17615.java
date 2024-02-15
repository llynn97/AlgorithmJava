import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

//17615
public class Algo30 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str =  br.readLine();
        boolean check;
        int cnt=0;
        int answer = Integer.MAX_VALUE;
        //왼쪽으로 빨간공 모으기
        check=false;
        cnt=0;
        for(int i=0; i<n; i++){
            if(check && str.charAt(i)=='R'){
                cnt++;
                continue;
            }
            if(str.charAt(i)=='B'){
                check = true;
            }
        }
        answer = Math.min(cnt,answer);

        //왼쪽으로 파란공 모으기
        check=false;
        cnt=0;
        for(int i=0; i<n; i++){
            if(check && str.charAt(i)=='B'){
                cnt++;
                continue;
            }
            if(str.charAt(i)=='R'){
                check = true;
            }
        }
        answer = Math.min(cnt,answer);

        //오른쪽으로 빨간공 모으기
        check=false;
        cnt=0;
        for(int i=n-1; i>=0; i--){
            if(check && str.charAt(i)=='R'){
                cnt++;
                continue;
            }
            if(str.charAt(i)=='B'){
                check = true;
            }
        }
        answer = Math.min(cnt,answer);

        //오른쪽으로 파란공 모으기
        check=false;
        cnt=0;
        for(int i=n-1; i>=0; i--){
            if(check && str.charAt(i)=='B'){
                cnt++;
                continue;
            }
            if(str.charAt(i)=='R'){
                check = true;
            }
        }
        answer = Math.min(cnt,answer);

        System.out.println(answer);


    }
}
