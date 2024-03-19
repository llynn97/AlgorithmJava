import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//16434
public class Algo67 {

    static int n;
    static int pAttack;
    static int[][] map;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        pAttack = Integer.parseInt(st.nextToken()); //용사 공격력
        map = new int[n][3];

        long left = 1 ;
        long right = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==1){
                right += ((long)b*c);
            }
            map[i][0] = a;
            map[i][1] = b;
            map[i][2] = c;
        }

        while(left<=right){
            long mid = (left+right)/2;

            long alive = mid;
            long attack2 = pAttack;
            boolean check = true;
            for(int i=0; i<n; i++){
                if(map[i][0]==1){//몬스터가 있으면
                    long num = 0;
                    if(map[i][2]%attack2==0){
                        num = (map[i][2]/attack2) -1;
                    }else{
                        num = map[i][2]/attack2;
                    }
                    if(alive-num*map[i][1]<=0){
                        check = false;
                        break;
                    }else{
                        alive-=num*map[i][1];
                    }
                }else{ //포션이 있는 방이면
                    alive = Math.min(mid,alive+map[i][2]);
                    attack2+=map[i][1];
                }
            }
            if(!check){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(left);

    }





}
