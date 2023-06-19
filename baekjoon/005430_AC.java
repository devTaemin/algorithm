import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // AC: 정수 배열에 연산을 하기 위한 언어
        // R(뒤집기): 배열의 순서를 뒤집기
        // D(버리기): 첫 번째 수를 버리는 함수, 비어있는 경우 사용하면 에러 처리

        // 배열의 초기값, 수행 함수가 주어진 경우 최종 결과 구하기

        // T (<= 100)
        // function (1 ~ 100_000)
        // numOfArray(1 ~ 100)
        // Array

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int numOfTest = Integer.parseInt(br.readLine());
        for (int t = 0; t < numOfTest; t++) {
            char[] commands = br.readLine().toCharArray();
            int numOfElem = Integer.parseInt(br.readLine());
            Deque<Integer> deque = convertToQ(br.readLine());

            // true는 정방향, false는 역방향
            boolean flag = true;

            // 오류 발생 여부 판단
            boolean prog = true;

            for (int i = 0; i < commands.length; i++) {
                char command = commands[i];

                switch(command) {
                    case 'R':
                        flag = !flag;
                        break;
                    case 'D':
                        if (deque.size() == 0) {
                            prog = false;
                        }
                        else {
                            if (flag) deque.poll();
                            else deque.pollLast();
                        }
                        break;
                    default:
                        break;
                }
            }

            if (prog) builder.append(convertToString(deque, flag));
            else builder.append("error").append("\n");
        }

        System.out.print(builder.toString());
    }

    public static String convertToString(Deque<Integer> queue, boolean flag) {
        StringBuilder builder = new StringBuilder();

        builder.append("[");

        if (flag) {
            while (!queue.isEmpty()) {
                builder.append(queue.poll()).append(",");
            }
        }
        else {
            while (!queue.isEmpty()) {
                builder.append(queue.pollLast()).append(",");
            }
        }

        if (builder.length() > 1) builder.setLength(builder.length() - 1);
        builder.append("]").append("\n");

        return builder.toString();
    }

    public static Deque<Integer> convertToQ(String input) {
        Deque<Integer> result = new ArrayDeque<Integer>();

        if (input.length() == 2) return result;

        String[] list = input.substring(1, input.length() - 1).split(",");
        for (String elem : list) {
            result.add(Integer.parseInt(elem));
        }

        return result;
    }

}
