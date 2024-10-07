import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


//1786
public class Algo161 {

    static String t;
    static String p;
    static int[] pi;

    static List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t= br.readLine();
        p = br.readLine();
        int num = p.length();

        pi = new int[num];

        solve();

        System.out.println(answers.size());


        for(int i=0; i<answers.size(); i++){
            System.out.print(answers.get(i)+" ");
        }
    }

    public static void solve(){
        kmp();
        int tLen = t.length();
        int pLen = p.length();
        int idx = 0;
        for(int i=0; i<tLen; i++){
            while(idx>0 && t.charAt(i)!=p.charAt(idx)){
                idx = pi[idx-1];
            }
            if(t.charAt(i)==p.charAt(idx)){
                if(idx==pLen-1){
                    answers.add(i-idx+1);
                    idx = pi[idx];

                }else{
                    idx+=1;
                }
            }
        }
    }


    public static void kmp(){
        int j = 0; //접두사 인덱스
        int pLen = p.length();


        for(int i=1; i<pLen; i++){
            while(j>0 && p.charAt(i)!=p.charAt(j)){
                 j = pi[j-1];
            }
            if(p.charAt(i)==p.charAt(j)){
                ++j;
                pi[i] = j;
            }
        }
    }
}
