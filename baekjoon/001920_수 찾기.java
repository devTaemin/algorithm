import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         *      N(1 ~ 100_100)
         *      X가 존재하는지 알아내는 프로그램
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder builder = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long[] array = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            long target = Long.parseLong(st.nextToken());
            int result = 0;
            if (find(array, target)) result = 1;

            builder.append(result).append("\n");
        }

        System.out.print(builder.toString());
    }

    public static boolean find(long[] array, long target) {
        boolean result = false;
        int front = 0;
        int rear = array.length - 1;

        while (front <= rear) {
            int mid = (front + rear) / 2;

            if (array[mid] < target) {
                front = mid + 1;

            } else if (array[mid] > target) {
                rear = mid - 1;

            } else {
                result = true;
                break;
            }
        }

        return result;
    }
}
