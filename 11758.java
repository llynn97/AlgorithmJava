import java.io.*;
import java.util.*;


//11758
public class Algo148 {

    static int n,m;
    static int x1,y1,x2,y2,x3,y3;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());

        int ccw = (x1*y2+x2*y3+x3*y1)-(y1*x2+y2*x3+y3*x1);

        if(ccw>0){
            System.out.println("1");
        }else if(ccw==0){
            System.out.println("0");
        }else{
            System.out.println("-1");
        }


    }
}






