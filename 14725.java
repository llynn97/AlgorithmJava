import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


//14725
public class Algo145 {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        Node root = new Node();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            Node cur = root;
            for(int j=0; j<size; j++){
                String str = st.nextToken();
                if(!cur.childs.containsKey(str)){
                    cur.childs.put(str,new Node());
                }
                cur = cur.childs.get(str);

            }
        }
        print("",root);

    }
    public static void print(String str,Node root){
        Object[] keys = root.childs.keySet().toArray();
        Arrays.sort(keys);

        for(Object s : keys){
            System.out.println(str+s);
            print(str+"--",root.childs.get(s));
        }

    }



}
class Node{
    Map<String,Node> childs = new HashMap<>();
}






