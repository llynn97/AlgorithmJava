import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

//19941
public class Algo24 {

    static int[] check;
    static int answer=0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        check = new int[n+1];
        int idx=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='P'){
                boolean che = false;
                idx = Math.max(0,i-k);
                for(int j=idx; j<=i-1; j++){
                    if(str.charAt(j)=='H'){
                        if(checkHam(j)){
                            che=true;
                            break;
                        }
                    }
                }
                if(!che){
                    if(i+k>n-1){
                        idx= n-1;
                    }else{
                        idx = i+k;
                    }
                    for(int j=i+1; j<=idx; j++){
                        if(str.charAt(j)=='H'){
                            if(checkHam(j)){
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);



    }

    public static boolean checkHam(int num){
        if(check[num]==1){
            return false;
        }
        check[num]=1;
        answer++;
        return true;
    }
}
