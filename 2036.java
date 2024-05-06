import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//2036
public class Algo111 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        List<Long> list1 = new ArrayList<>(); //음수
        List<Long> list2 = new ArrayList<>(); //양수

        int cnt = 0; //0 개수
        for(int i=0; i<n; i++){
            long num = Long.parseLong(br.readLine());
            if(num==0){
                cnt++;
            }else if(num>0){
                list2.add(num);
            }else{
                list1.add(-num);
            }
        }
        Collections.sort(list2,Collections.reverseOrder());
        Collections.sort(list1,Collections.reverseOrder()); //양수로 바꿔준후 내림차순

        long sum = 0;
        for(int i=1; i<list1.size(); i+=2){
            sum+= list1.get(i)*list1.get(i-1);
        }
        if(list1.size()%2==1 && cnt==0){
            sum-= list1.get(list1.size()-1);
        }
        for(int i=1; i<list2.size(); i+=2){
            long x = list2.get(i);
            long y = list2.get(i-1);
            sum+=Math.max(x+y,x*y);
        }
        if(list2.size()%2==1){
            sum+=list2.get(list2.size()-1);
        }
        System.out.println(sum);

    }

}






