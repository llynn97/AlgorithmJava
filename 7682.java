import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//7682
public class Algo163 {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            String s = br.readLine();
            if(s.equals("end")) break;

            int xCnt = 0;
            int oCnt = 0;
            board = new char[3][3];
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    board[i][j] = s.charAt(3*i+j);

                    if(board[i][j]=='X') xCnt++;
                    else if(board[i][j]=='O') oCnt++;
                }
            }
            if(oCnt+xCnt==9 && xCnt-oCnt==1) { // 다 채워질 경우 x가 o 보다 1개 많아야 함
                if(Check('X') && Check('O')) sb.append("invalid\n"); //둘다 빙고는 불가능함
                else if(Check('O')) sb.append("invalid\n"); //x가 무조건 이겨야함
                else sb.append("valid\n");
            }else{ //다 안채워졌을 때
                if(Check('X') && Check('O')) sb.append("invalid\n");
                else if(Check('X') && xCnt-oCnt==1) sb.append("valid\n"); //x가 이기려면 o보다 1개 많아야함
                else if(Check('O') && xCnt==oCnt) sb.append("valid\n"); //o가 이기려면 o와 x 개수가 같아야함
                else sb.append("invalid\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean Check(char tiktakto) {

        //가로가 성립할 때
        for(int i=0; i<3; i++) {
            int cnt = 0;
            for(int j=0; j<3; j++) {
                if(board[i][j]==tiktakto) cnt++;
            }
            if(cnt==3) return true;
        }
        //세로로 성립할 때
        for(int j=0; j<3; j++) {
            int cnt = 0;
            for(int i=0; i<3; i++) {
                if(board[i][j]==tiktakto) cnt++;
            }
            if(cnt==3) return true;
        }
        //대각선으로 성립할 때
        if(board[0][0]==tiktakto && board[1][1]==tiktakto
                && board[2][2]==tiktakto) return true;
        if(board[0][2]==tiktakto && board[1][1]==tiktakto
                && board[2][0]==tiktakto) return true;

        return false;
    }
}
