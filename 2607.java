import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


//2607
public class Algo100 {
    static int n,m;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        String first = br.readLine();
        int result = 0;

        for(int i = 0; i < n - 1; i++) {
            String str = br.readLine();
            int cnt = 0;    // 같은 문자 개수
            int[] word = new int[26];
            for(int j = 0; j < first.length(); j++) {
                word[first.charAt(j) - 'A']++;
            }

            for(int j = 0; j < str.length(); j++) {
                if(word[str.charAt(j) - 'A'] > 0) {
                    cnt++;
                    word[str.charAt(j) - 'A']--;
                }
            }


            // 같은 경우 or 한 글자만 바뀐경우
            if(first.length() == str.length() && (first.length() == cnt || first.length() == cnt+1)) {
                result++;
            }
            // first가 하나 짧은 경우 (추가) //dog good
            else if (first.length() == str.length() - 1 && str.length()  == cnt+1) {
                result++;
            }
            // first가 하나 긴 경우 (삭제) //good dog
            else if (first.length() == str.length() + 1 && str.length() == cnt) {
                result++;
            }

        }
        System.out.println(result);
        }


    }






