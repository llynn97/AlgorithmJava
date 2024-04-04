import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//10431
public class Algo84 {
    static int n;
    static int[] people;
    static int[] people2;
    static List<Integer> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            people = new int[20];
            for(int j=0; j<20; j++){
                people[j] = Integer.parseInt(st.nextToken());

            }
            int cnt = 0;
            for(int j=0; j<20; j++){
                for(int k=0; k<j; k++){
                    if(people[k]>people[j]){
                        cnt++;
                    }
                }
            }
            System.out.println(num+" "+cnt);


        }




    }


}
