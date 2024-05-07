import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


//2831
public class Algo112 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        List<Integer> negMan = new ArrayList<>(); //남자 - 키작은사람 선호
        List<Integer> posMan = new ArrayList<>(); //남자 - 키큰사람 선호
        List<Integer> negWoman = new ArrayList<>();
        List<Integer> posWoman = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int mm = Integer.parseInt(st.nextToken());
            if(mm>0){
                posMan.add(mm);
            }else{
                negMan.add(-mm);
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int mm = Integer.parseInt(st.nextToken());
            if(mm>0){
                posWoman.add(mm);
            }else{
                negWoman.add(-mm);
            }
        }
        Collections.sort(posMan);
        Collections.sort(posWoman);
        Collections.sort(negMan);
        Collections.sort(negWoman);
        int ans = 0;
        int i=0; int j=0;

        while(true){
            if(i==posMan.size()||j==negWoman.size()){
                break;
            }
            if(posMan.get(i)<negWoman.get(j)){
                ans++;
                i++;
                j++;
            }else {
                j++;
            }
        }

        i=0;
        j=0;

        while(true){
            if(i==posWoman.size()||j==negMan.size()){
                break;
            }
            if(posWoman.get(i)<negMan.get(j)){
                ans++;
                i++;
                j++;
            }else {
                j++;
            }
        }
        System.out.println(ans);




    }

}






