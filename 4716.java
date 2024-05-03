import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


//4716
public class Algo110 {
    static int n,a,b;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a==0 && b==0 && n==0){
                break;
            }
            int ans =0;
            int[][] map = new int[n][3];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                int da = Integer.parseInt(st.nextToken());
                int db = Integer.parseInt(st.nextToken());
                map[i][0]=k;
                map[i][1]=da;
                map[i][2]=db;
            }
            Arrays.sort(map, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Math.abs(o2[1]-o2[2])-Math.abs(o1[1]-o1[2]);
                }
            });
            for(int i=0; i<n; i++){
                if(map[i][1]<map[i][2]){ //a가 더 가까움
                    if(a-map[i][0]<0){
                        ans+=map[i][1]*a; //a의 남은 풍선 모두 사용
                        map[i][0]-=a;
                        a=0;
                        ans+=map[i][0]*map[i][2]; //남은 풍선은 b로 채움
                    }else{
                        ans+=map[i][1]*map[i][0];
                        a-=map[i][0];
                    }
                }else{
                    if(b-map[i][0]<0){
                        ans+=map[i][2]*b;
                        map[i][0]-=b;
                        b=0;
                        ans+=map[i][0]*map[i][1];
                    }else{
                        ans+=map[i][2]*map[i][0];
                        b-=map[i][0];
                    }
                }
            }
            System.out.println(ans);

        }



    }


}






