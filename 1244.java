import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//1244
public class Algo96 {
    static int n;
    static int[] map;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        int num = Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x==1){ //남학생일 경우
                int j = 1;
                while(y*j<=n){
                    change(y*j);
                    j++;
                }
            }else{
                change(y);
                int j = 1;
                while(y+j<=n && y-j>=1){
                    if(map[y+j]!=map[y-j]){
                        break;
                    }
                    change(y+j);
                    change(y-j);
                    j++;
                }
            }
        }
        for(int i=1; i<=n; i++){
            System.out.print(map[i]+" ");
            if(i%20==0){
                System.out.println();
            }
        }

    }

    public static void change(int k){
        if(map[k]==1){
            map[k]=0;
        }else{
            map[k]=1;
        }
    }

}
