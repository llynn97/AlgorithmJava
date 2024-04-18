import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


//2179

public class Algo95 {
    static int n;
    static List<String> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String str = br.readLine();
            if(!list.contains(str)){
                list.add(str);
            }
        }

        int ans = 0;
        int a = 0;
        int b = 0;

        for(int i=0; i<list.size()-1; i++){
            String s1 = list.get(i);
            for(int j=i+1; j<list.size(); j++){
                String s2 = list.get(j);
                int num = Math.min(s1.length(),s2.length());
                int cnt = 0;
                for(int k=0; k<num; k++){
                    if(s1.charAt(k)!=s2.charAt(k)){
                        break;
                    }
                    cnt++;
                }
                if(ans<cnt){
                    a = i;
                    b = j;
                    ans = cnt;
                }
            }
        }
        System.out.println(list.get(a));
        System.out.println(list.get(b));




    }







}
