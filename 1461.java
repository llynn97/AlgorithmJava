import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//1461
public class Algo114 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        st= new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num>0){
                pos.add(num);
            }else{
                neg.add(-num);
            }
        }
        Collections.sort(pos,Collections.reverseOrder());
        Collections.sort(neg,Collections.reverseOrder());

        int ans1  = 0; //맨마지막이 pos
        int ans2 = 0;//맨마지막이 neg



        for(int i=0; i<neg.size(); i+=m){
            ans1+=(neg.get(i)*2);
        }
        for(int i=0; i<pos.size(); i+=m){
            if(i==0){
                ans1+=pos.get(i);

            }else{
                ans1+=(pos.get(i)*2);
            }
        }

        for(int i=0; i<pos.size(); i+=m){
            ans2+=(pos.get(i)*2);
        }
        for(int i=0; i<neg.size(); i+=m){
            if(i==0){
                ans2+=neg.get(i);

            }else{
                ans2+=(neg.get(i)*2);
            }
        }

        int answer = Math.min(ans1,ans2);
        System.out.println(answer);


    }

}






