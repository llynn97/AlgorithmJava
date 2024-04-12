import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//20310
public class Algo90 {
    static int n,m,l,k;





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        List<int[]> star = new ArrayList<>();

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            star.add(new int[]{x,y});
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                int x1 = star.get(i)[0];
                int y1 = star.get(j)[1];
                int res = 0;
                for(int p=0; p<k; p++){
                    if(x1<=star.get(p)[0]&&star.get(p)[0]<=x1+l&&y1<=star.get(p)[1]&&y1+l>=star.get(p)[1]){
                        res++;
                    }
                }
                ans = Math.max(res,ans);
            }
        }
        System.out.println(k-ans);




    }









}
