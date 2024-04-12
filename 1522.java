import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//1522
public class Algo91 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        int aCnt=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='a'){
                aCnt++;
            }
        }

        int ans= Integer.MAX_VALUE;

        for(int i=0; i<str.length(); i++){
            int bCnt = 0;
            for(int j=i; j<i+aCnt; j++){
                if(str.charAt(j%str.length())=='b'){
                    bCnt++;
                }
            }
            ans = Math.min(bCnt,ans);
        }
        System.out.println(ans);




    }


}
