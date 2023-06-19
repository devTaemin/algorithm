import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            int target = list.get(i);

            Iterator<Integer> iter = deque.iterator();
            int size = deque.size();
            int count = 1;
            while (iter.hasNext()) {
                int value = iter.next();
                if (value == target) {
                    break;
                }

                count++;
            }

            int front = count - 1;
            int rear = size - count + 1;

            if (front <= rear) {
                answer += front;
                for (int j = 0; j < front; j++) {
                    int value = deque.poll();
                    deque.addLast(value);
                }
                deque.poll();

            } else {
                answer += rear;
                for (int j = 0; j < rear; j++) {
                    int value = deque.pollLast();
                    deque.addFirst(value);
                }
                deque.poll();

            }
        }

        System.out.println(answer);
    }
}
