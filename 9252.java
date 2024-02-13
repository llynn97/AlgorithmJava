import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//9252
public class Algo22 {

    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1  = br.readLine();
        String str2 = br.readLine();
        int len1 = str1.length();
        int len2 = str2.length();
        dp = new int[len1+1][len2+1];
        lcs(str1,str2);
        getLcs(str1,str1.length(),str2.length());

        System.out.println(sb.toString());

    }

    public static void lcs(String s1, String s2) {
        for (int i = 1; i < s1.length()+1; i++){
            for (int j = 1; j < s2.length()+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        sb.append(dp[s1.length()][s2.length()]+"\n");
    }


    public static void getLcs(String str, int i,int j){
        Stack<Character> st = new Stack<>();
        while (i>0 && j>0){
            if(i==0 || j==0){
                break;
            }
            if(dp[i][j]==dp[i-1][j]){
                i--;
            }else if(dp[i][j]==dp[i][j-1]){
                j--;
            }else{
                st.push(str.charAt(i-1));
                i--;
                j--;
            }
        }

        while(!st.empty()){
            sb.append(st.pop());
        }

    }
}