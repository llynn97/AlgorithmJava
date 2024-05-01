import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//2258
public class Algo106 {
    static int n,m;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            list.add(new int[]{weight,price});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o2[0]-o1[0];
                }
                return o1[1]-o2[1];
            }
        });
        boolean check = false;
        int totalWeight = 0;
        int totalPrice = -1;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            totalWeight+=list.get(i)[0];
            if(i>0&&list.get(i-1)[1]==list.get(i)[1]){ //이전과 가격이 같음(이전께 공짜x)
                totalPrice+=list.get(i)[1];
            }else{
                totalPrice=list.get(i)[1];
            }
            if(totalWeight>=m){
                check = true;
                ans = Math.min(ans,totalPrice);
            }
        }
        if(!check){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }

    }


}






