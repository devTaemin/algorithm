import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        StringTokenizer token = null;
        Deque<Integer> deque = new ArrayDeque<Integer>();

        int n = Integer.parseInt(br.readLine());
        int value = 0;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            String command = token.nextToken();

            switch(command) {
                case "push_front":
                    value = Integer.parseInt(token.nextToken());
                    deque.addFirst(value);
                    break;
                case "push_back":
                    value = Integer.parseInt(token.nextToken());
                    deque.addLast(value);
                    break;
                case "pop_front":
                    if (deque.size() == 0) builder.append(-1).append("\n");
                    else {
                        value = deque.poll();
                        builder.append(value).append("\n");
                    }
                    break;
                case "pop_back":
                    if (deque.size() == 0) builder.append(-1).append("\n");
                    else {
                        value = deque.pollLast();
                        builder.append(value).append("\n");
                    }
                    break;
                case "size":
                    builder.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(deque.size() == 0) value = 1;
                    else value = 0;
                    builder.append(value).append("\n");
                    break;
                case "front":
                    if (deque.size() == 0) builder.append(-1).append("\n");
                    else {
                        builder.append(deque.peek()).append("\n");
                    }
                    break;
                case "back":
                    if (deque.size() == 0) builder.append(-1).append("\n");
                    else {
                        builder.append(deque.peekLast()).append("\n");
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println(builder.toString());
    }
}
