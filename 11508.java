import java.util.*;
import java.io.*;
//11508
public class Algo13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        ArrayList<Integer> map = new ArrayList<>();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            map.add(num);
        }
        Collections.sort(map,Collections.reverseOrder());

        int j = 0;
        for(int i=1; i<=n/3; i++){
           answer += map.get(j)+map.get(j+1);
           j+=3;
        }
        if(n%3!=0){
            for(int i=j; i<map.size(); i++){
                answer+=map.get(i);
            }
        }
        System.out.println(answer);
    }
}
