import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//1450
public class Algo71 {

   static int n,c;
   static List<Integer> l,r;
   static int[] weight;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        l = new ArrayList<>();
        r = new ArrayList<>();
        int ans = 0;
        weight = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }
        dfs(l,0,n/2,0);
        dfs(r,n/2,n,0);
        Collections.sort(r);
        for(int i=0; i<l.size(); i++){
            int cnt = l.get(i); //기준: c-cnt
            int left = 0;
            int right = r.size()-1;
            while(left<=right){
                int mid = (left+right)/2;
                if(c-cnt<r.get(mid)){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            ans+=left;
        }
        System.out.println(ans);






    }

    public static void dfs(List<Integer> list, int left, int right, int sum){
        if(sum>c){
            return;
        }
        if(left==right){
            list.add(sum);
            return;
        }

        dfs(list,left+1,right,sum);
        dfs(list,left+1,right,sum+weight[left]);
    }

}
