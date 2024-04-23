import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


//22233
public class Algo99 {
    static int n,m;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        for(int i=0; i<m; i++){
            String[] str = br.readLine().split(",");
            int cnt = 0;
            for(int j=0; j<str.length; j++){
                cnt = 0;
                if(set.contains(str[j])){
                    set.remove(str[j]);
                }
            }
            System.out.println(set.size());
        }

    }





}
