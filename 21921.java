import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//21921
public class Algo72 {

   static int n,x;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] map = new int[n+1];
        for(int i=1; i<=n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=n; i++){
            map[i]+=map[i-1];
        }
        int maxNum = 0;
        int num=1;
        for(int i=1; i<=n-x+1; i++){
            int cnt = map[i+x-1]-map[i-1];
            if(maxNum==cnt){
                num++;
            }else if(maxNum<cnt){
                num=1;
                maxNum = cnt;
            }


        }
        if(maxNum==0){
            System.out.println("SAD");
        }else{
            System.out.println(maxNum);
            System.out.println(num);
        }


    }

}
