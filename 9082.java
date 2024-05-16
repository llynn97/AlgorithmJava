import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


//9082
public class Algo119 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());
            String str = br.readLine(); //검사수
            String str2 = br.readLine(); //지뢰
            int[] map = new int[n];
            for(int j=0; j<n; j++){
                map[j] = (int)(str.charAt(j)-'0');
            }
            int ans = 0;
            for(int j=0; j<n; j++){
                if(j==0 && map[j]!=0 && map[j+1]!=0){
                    map[j]-=1;
                    map[j+1]-=1;
                    ans++;
                }else if(j==(n-1) && map[j]!=0 && map[j-1]!=0){
                    map[j]-=1;
                    map[j-1]-=1;
                    ans++;
                }else if(1<=j && j<=(n-2)&&map[j-1]!=0&&map[j]!=0&&map[j+1]!=0) {
                    map[j-1]-=1;
                    map[j]-=1;
                    map[j+1]-=1;
                    ans++;
                }

            }
            System.out.println(ans);
        }

    }

}






