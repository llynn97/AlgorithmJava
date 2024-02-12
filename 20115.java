import java.util.Scanner;
//20115
public class Algo21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] arr = new double[N];
        double max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextDouble();
            if (max < arr[i])
                max = arr[i];
        }
        double sum = max;
        for (int i = 0; i < N; i++) {
            if (arr[i] == max)
                continue;
            sum += arr[i] / 2;
        }
        System.out.println(sum);
    }
}