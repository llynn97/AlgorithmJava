import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//17471
public class Algo120 {
    static int n;
    static int ans;
    static int[] people;
    static List<ArrayList<Integer>> list;
    static boolean[] check; //두 선거구 나눌때 체크
    static boolean[] check2; // 나눈 선거구 안 구역이 연결되어있는지

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        check= new boolean[n];
        check2 = new boolean[n];
        people = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++){
                int num2 = Integer.parseInt(st.nextToken());
                list.get(i).add(num2-1);
            }
        }

        solve1(0);
        if(ans==Integer.MAX_VALUE){
            ans= -1;
        }
        System.out.println(ans);


    }

    public static void solve1(int idx){ //선거구 2개로 나누기
        if(idx==n){
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for(int i=0; i<n; i++){
                if(!check[i]){
                    list1.add(i);
                }else{
                    list2.add(i);
                }

            }
            if(list1.size()==0 || list2.size()==0){
                return;
            }
            if(solve2(list1)&&solve2(list2)){
                int num1 = 0;
                int num2 = 0;
                for(int j=0; j<n; j++){
                    if(!check[j]){
                        num1+=people[j];
                    }else{
                        num2+=people[j];
                    }
                }
                ans = Math.min(ans,Math.abs(num1-num2));
            }
            return;
        }


        check[idx]=true;
        solve1(idx+1);
        check[idx]=false;
        solve1(idx+1);

    }

    public static boolean solve2(List<Integer> map){ //나눈 선거구의 구역들이 서로 연결되어 있는지 확인
        Queue<Integer> q = new LinkedList<>();
        check2 = new boolean[n];
        check2[map.get(0)] = true;
        q.add(map.get(0));
        int cnt=1;
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0; i<list.get(x).size(); i++){
                int y = list.get(x).get(i);
                if(!check2[y] && map.contains(y)){
                    q.add(y);
                    check2[y]=true;
                    cnt++;
                }
            }
        }
        if(cnt==map.size()){
            return true;
        }else{
            return false;
        }


    }

}






