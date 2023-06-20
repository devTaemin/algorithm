import java.io.*;
import java.util.*;

public class Main {

    static int t, target, answer;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        t = 0;
        target = k;
        answer = -1;
        flag = false;
        mergeSort(array, 0, array.length - 1);

        System.out.println(answer);
    }
    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] array, int front, int rear) {
        if (flag) return;

        if (front < rear) {
            int mid = (front + rear) / 2;

            mergeSort(array, front, mid);
            mergeSort(array, mid + 1, rear);
            merge(array, front, mid, rear);
        }
    }

    public static void merge(int[] array, int front, int mid, int rear) {
        if (flag) return;

        int i = front;
        int j = mid + 1;
        ArrayList<Integer> result = new ArrayList<>();

        while (i <= mid && j <= rear) {
            if (array[i] <= array[j]) {
                result.add(array[i++]);

            } else {
                result.add(array[j++]);
            }
        }

        while (i <= mid) {
            result.add(array[i++]);
        }

        while (j <= rear) {
            result.add(array[j++]);
        }

        for (int index = 0; index < result.size(); index++) {
            int value = result.get(index);

            array[front + index] = value;
            t++;

            if (t == target) {
                answer = value;
                flag = true;
                break;
            }
        }
    }
}
