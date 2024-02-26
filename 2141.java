import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//2141
public class Algo44 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<long[]> list = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        long sum = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            list.add(new long[]{x,y});
            sum+=y;
        }
        Collections.sort(list, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int)(o1[0]-o2[0]);
            }
        });
        long ans = 0;
        for(int i=0; i<n; i++){
            ans+=list.get(i)[1];
            if((sum+1)/2<=ans){
                System.out.println(list.get(i)[0]);
                break;
            }
        }



    }

}
