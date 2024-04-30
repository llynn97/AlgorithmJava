import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//1114
public class Algo105 {
    static int l,k,c;
    static int[] map;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[l+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<l; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        map[l] = k;
        Arrays.sort(map);
        int left = 0;
        int right = k;
        int ans1 = 0 ;
        int ans2 = 0;
        for(int i=0; i<30; i++){
            int mid = (left+right)/2;
            int result = solve(mid);

            if(result!=-1){
                ans1 = mid;
                ans2 = result;
                right = mid;
            }else{
                left = mid+1;
            }


        }
        System.out.println(ans1+" "+ans2);
    }

    public static int solve(int len){
        int left = l;
        int right = l;
        int cnt = 0;
        while(left!=0 && cnt<c ){
            left--;
            if(map[right]-map[left]>len){
                if(right-left==1){
                    return -1;
                }
                cnt++;
                left+=1;
                right=left;
            }
        }
        if(map[right]-map[left]>len || map[left]>len){
            return -1;
        }
        return map[left];
    }


}






