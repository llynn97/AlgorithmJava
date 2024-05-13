import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//1464
public class Algo117 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        String ans = ""+str.charAt(0);

        for(int i=1; i<str.length(); i++){ //BCDAF
            if(ans.charAt(i-1)<str.charAt(i)){
                ans = str.charAt(i)+ans;
            }else{
                ans = ans+str.charAt(i);
            }
        }

        String answer = "";
        for(int i=ans.length()-1; i>=0; i--){
            answer+=ans.charAt(i);
        }

        System.out.println(answer);




    }

}






