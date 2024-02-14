import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//20365
public class Algo26 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int rCnt = 0;
        int bCnt = 0;
        char ch = '\0';
        for(int i=0; i<n; i++){
           char ch2 = str.charAt(i);
           if(ch2!=ch){
               if(ch2=='R'){
                   rCnt++;
               }else{
                   bCnt++;
               }
           }
           ch = ch2;
        }

        System.out.println(Math.min(1+rCnt,1+bCnt));

    }
}
