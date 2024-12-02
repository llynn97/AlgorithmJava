import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//12018
public class Algo182 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list;

        list = new ArrayList[n];
        int[] people = new int[n];
        int[] minArr = new int[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            people[i] = b;

            st = new StringTokenizer(br.readLine());

            for(int j=0; j<a; j++){
                int c = Integer.parseInt(st.nextToken());
                list[i].add(c);
            }
            Collections.sort(list[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            if(a<b){
                minArr[i] = 1;
            }else{
                minArr[i] = list[i].get(b-1);
            }

        }

        int sum = 0;
        Arrays.sort(minArr);
        for(int i=0; i<n; i++){
            if(minArr[i]+sum>m){
                break;
            }
            sum+=minArr[i];
            ans++;
        }

        System.out.println(ans);

    }
}
