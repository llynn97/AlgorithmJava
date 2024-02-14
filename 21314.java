import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//21314
public class Algo27 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int mCnt=0;
        int kCnt=0;
        String maxNum="";
        String minNum="";
        String str2 = "";
        for(int i=0; i<str.length(); i++){
            str2+=str.charAt(i);
            if(str.charAt(i)=='K'){
                kCnt++;
                maxNum+=makeNum(mCnt,kCnt);
                kCnt = 0;
                mCnt = 0;
                str2="";

            }else{
                mCnt++;
            }
        }
        if(!str2.equals("")){
            maxNum+=makeNum(mCnt,kCnt);
        }
        mCnt=0;
        kCnt=0;
        str2="";
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='K'){
                if(!str2.equals("")){
                    minNum+=makeNum(mCnt,kCnt);
                    str2="";
                    mCnt=0;
                }
                kCnt++;
                minNum+="5";
                kCnt=0;
            }else{
                str2+=str.charAt(i);
                mCnt++;
            }
        }
        if(!str2.equals("")){
            minNum+=makeNum(mCnt,kCnt);
        }

        System.out.println(maxNum);
        System.out.println(minNum);



    }

    public static String makeNum(int m, int k){
        String sen="";
        if(k==0){
            sen+="1";
            for(int i=0; i<m-1; i++){
                sen+="0";
            }
            return sen;
        }
        sen="5";
        for(int i=0; i<m; i++){
            sen+="0";
        }
        return sen;
    }
}
