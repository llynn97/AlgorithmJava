import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//1701
public class Algo160 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str= br.readLine();
        int len = str.length();
        int ans = 0;
        for(int i=0; i<len; i++){
            String subStr = str.substring(i,len);
            ans = Math.max(ans,kmp(subStr));
        }

        System.out.print(ans);
    }


    public static int kmp(String str){
        int j = 0; //접두사 인덱스
        int n = str.length();
        int maxNum = 0;
        int[] pi = new int[n]; //접두사 접미사가 같은 문자열 최대 길이

        for(int i=1; i<n; i++){ //접미사 인덱스
            while (j>0 && str.charAt(i)!=str.charAt(j)){
                j = pi[j-1]; //pi 값 만큼 탐색 건너뜀
            }
            if(str.charAt(i)==str.charAt(j)){
                pi[i] = ++j;
                maxNum = Math.max(maxNum,pi[i]);
            }
        }
        return maxNum;
    }
}
