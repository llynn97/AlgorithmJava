import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

//16500
public class Algo19 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        HashSet<String> set = new HashSet<>();
        int[] dp = new int[101];
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
           set.add(br.readLine());
        }
        for(int i = sentence.length()-1; i>=0; i--){
            for(int j = i+1; j<sentence.length(); j++){
                if(dp[j]==1){
                    if(set.contains(sentence.substring(i,j))){
                        dp[i] = 1;
                    }
                }
            }
            if(set.contains(sentence.substring(i))){
                dp[i]=1;
            }
        }

        System.out.println(dp[0]);
    }
}
