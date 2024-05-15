import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//16890
public class Algo118 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String koo = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String cube = st.nextToken();
        n = koo.length();
        List<Character> k = new ArrayList<>();
        List<Character> c = new ArrayList<>();

        for(int i=0; i<n; i++){
            k.add(koo.charAt(i));
            c.add(cube.charAt(i));
        }
        Collections.sort(k);
        Collections.sort(c,Collections.reverseOrder());

        char[] ans = new char[n];
        int i = 0; //구사과
        int j = 0; //큐브
        for(int l=0; l<n; l++){
            if(l%2==0){ //구사과 순서
                if(k.get(i)>=c.get(j)){
                    int idx = n-1-l;
                    ans[idx] = k.get(i);
                    i++;
                }else{
                    ans[l] = k.get(i);
                    i++;
                }
            }else{ //큐브 순서
                if(c.get(j)<=k.get(i)){
                    int idx = n-1-l;
                    ans[idx] = c.get(j);
                    j++;

                }else{
                    ans[l] = c.get(j);
                    j++;
                }
            }
        }

        System.out.println(ans);

    }

}






