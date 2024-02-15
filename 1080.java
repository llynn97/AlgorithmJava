import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1080
public class Algo29 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] mapBefore = new int[n+1][m+1];
        int[][] mapAfter = new int[n+1][m+1];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                mapBefore[i][j] = (int)(str.charAt(j)-'0');
            }
        }
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                mapAfter[i][j] = (int)(str.charAt(j)-'0');
            }
        }

        int answer = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mapBefore[i][j]!=mapAfter[i][j] && i+2<n && j+2 <m){
                    for(int r=i; r<i+3; r++){
                        for(int c=j; c<j+3; c++){
                            if(mapBefore[r][c]==0){
                                mapBefore[r][c]=1;
                            }else{
                                mapBefore[r][c]=0;
                            }
                        }
                    }
                    answer++;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mapBefore[i][j]!=mapAfter[i][j]){
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(answer);

    }
}
