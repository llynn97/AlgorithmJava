import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//1132
public class Algo115 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long[][] alpha = new long[10][3]; //인덱스,가중치,맨첫번째자리인지 확인(1일때 x)
        for(int i=0; i<10; i++){
            alpha[i][0]=i;
        }
        for(int i=0; i<n; i++){
            long w = 1;
            String str = br.readLine();
            for(int j=str.length()-1; j>=0; j--,w*=10){
                int idx = str.charAt(j)-'A';
                alpha[idx][1]+=w;
                if(j==0){
                    alpha[idx][2]=1;
                }
            }
        }
        Arrays.sort(alpha, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int)(o1[1]-o2[1]);
            }
        });

        boolean[] check = new boolean[10];
        long ans=0;

        for(int i=0; i<10; i++){
            if(alpha[i][2]==1){//알파벳이 맨 앞자리에 올 때 0이 올 수 없음
                for(int j=1 ;j<=9; j++){
                    if(!check[j]){
                        check[j]=true;
                        ans+=alpha[i][1]*(long)j;
                        break;
                    }
                }
            }else{
                for(int j=0; j<=9; j++){
                    if(!check[j]){
                        check[j]=true;
                        ans+=alpha[i][1]*(long)j;
                        break;
                    }
                }
            }

        }
        System.out.println(ans);




    }

}






