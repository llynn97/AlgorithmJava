import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//19598
public class Algo37 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<int[]> meeting = new ArrayList<>();
        List<Integer> nowMeeting = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            meeting.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }

        Collections.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0] - o2[0];
            }
        });


        int answer = 1;
        nowMeeting.add(meeting.get(0)[1]);

        for(int i=1; i<n; i++){
            int start = meeting.get(i)[0];
            int end = meeting.get(i)[1];
            boolean check = false;
            for(int j=0; j<nowMeeting.size(); j++){
                if(start>=nowMeeting.get(j)){
                    check = true;
                    nowMeeting.remove(j);
                    nowMeeting.add(end);
                    break;
                }
            }
            if(!check){
                answer++;
                nowMeeting.add(end);
            }
        }
        System.out.println(answer);
    }
}
