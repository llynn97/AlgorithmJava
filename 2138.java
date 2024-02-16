import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2138
public class Algo33 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] map1 = new int[n+1]; // 상태 전
        int[] map2 = new int[n+1]; // 상태 후

        int[] lightOn = new int[n+1];
        int[] lightOff = new int[n+1];

        int cnt1 = 0; //불 키고 시작했을 때
        int cnt2 = 0; //불 안키고 시작했을 때

        for(int i=0; i<n; i++){
            map1[i] = str1.charAt(i) - '0';
            map2[i] = str2.charAt(i) - '0';
            lightOn[i] = map1[i];
            lightOff[i] = map1[i];
        }

        lightOn[0] = numChange(map1[0]);
        lightOn[1] = numChange(map1[1]);
        cnt1++;


        for(int i=1; i<n; i++){
            if(map2[i-1]!=lightOn[i-1]){
                lightOn[i-1] = numChange(lightOn[i-1]);
                lightOn[i] = numChange(lightOn[i]);
                cnt1++;
                if(i!=n-1){
                    lightOn[i+1] = numChange(lightOn[i+1]);
                }

            }
            if(map2[i-1]!=lightOff[i-1]){
                lightOff[i-1] = numChange(lightOff[i-1]);
                lightOff[i] = numChange(lightOff[i]);
                cnt2++;
                if(i!=n-1){
                    lightOff[i+1] = numChange(lightOff[i+1]);
                }

            }
        }

        if(lightOn[n-1]!=map2[n-1]){
            cnt1 = Integer.MAX_VALUE;
        }
        if (lightOff[n-1]!=map2[n-1]) {
            cnt2= Integer.MAX_VALUE;
        }

        if(cnt1==Integer.MAX_VALUE && cnt2==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(cnt1,cnt2));
        }


    }

    public static int numChange(int k){
        if(k==0){
            return 1;
        }
        return 0;
    }
}
