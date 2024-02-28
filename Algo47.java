import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//24337
public class Algo47 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());

        List<Integer> tower = new ArrayList<>();

        if(a+b>n+1){
            System.out.println(-1);
            return;
        }
        for(int i=1; i<a; i++){
            tower.add(i);
        }
        tower.add(Math.max(a,b));
        for(int i = b-1; i>=1; i--){
            tower.add(i);
        }
        if(a==1){
            while (tower.size()<n){
                tower.add(1,1);
            }
        }else{
            while (tower.size()<n){
                tower.add(0,1);
            }
        }
        for(int i=0; i<tower.size(); i++){
            System.out.print(tower.get(i)+" ");
        }


    }

}
