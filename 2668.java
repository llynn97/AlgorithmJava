import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//2668

public class Algo94 {
    static int n;
    static List<Integer> list;
    static boolean[] check;
    static int[] num;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        num = new int[n+1];
        list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        check = new boolean[n+1];
        for(int i=1 ;i<=n; i++){
            check[i] = true;
            dfs(i,i);
            check[i] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }


    }

    public static void dfs(int x,int y){
        if(check[num[x]]==false){
            check[num[x]] = true;
            dfs(num[x],y);
            check[num[x]] = false;
        }
        if(num[x]==y){
            list.add(y);
        }
    }





}
