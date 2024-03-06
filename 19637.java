import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//19637
public class Algo55 {

    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        String[] name = new String[n+1];
        int[] power = new int[n+1];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<k; i++){
            int num = Integer.parseInt(br.readLine());
            int left = 0;
            int right = n-1;
            while(left<=right){
                int mid = (left+right)/2;
                if(num>power[mid]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            sb.append(name[left]).append("\n");

        }
        System.out.print(sb.toString());


    }

}
