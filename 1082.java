import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


//1082
public class Algo109 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[] map = new int[n];
        int minNum = 50;
        int idx = -1;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
            if(minNum>=map[i]){
                minNum = map[i];
                idx = i;
            }
        }
        int m = Integer.parseInt(br.readLine());
        char[] ans = new char[51];
        int cnt = 0;
        while(m>=minNum){ // 가장 적은 비용으로 자릿수를 최대로 만듦
            ans[cnt] = (char)(idx+'0');
            cnt++;
            m-=minNum;
        }
        int start = 0;
        for(int i=0; i<cnt; i++){ //현재 자릿수를 더 큰수로 바꿀수 있으면 바꿈
            for(int j=n-1; j>=0; j--){
                if(m+minNum>=map[j]){
                    ans[i] = (char)(j+'0');
                    m+=(minNum-map[j]);
                    break;
                }
            }
            if(ans[start]=='0'){
                start++;
                m+=minNum;
            }
        }
        String str = "";

        if(start==cnt){
            System.out.println(0);
        }else{
            for(int i=start; i<cnt; i++){
                str+=ans[i];
            }
            System.out.println(str);
        }



    }


}






