import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//2195
public class Algo122 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        String P = br.readLine();
        int idx = 0;
        int cnt = 0;
        for(int i=0; i<P.length(); i++){
            if(S.indexOf(P.substring(idx,i+1))!=-1){
                continue;
            }
            cnt++;
            idx=i;
        }
        System.out.println(cnt+1);


    }
}






