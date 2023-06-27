import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         *      히스토그램에서 가장 큰 직사각형
         *
         *      - 직사각형의 수: n (1 ~ 100_000)
         *      - 직사각형의 높이: h (0 ~ 1_000_000_000)
         *      - 테스트 케이스는 여러 개 일 수 있으며 n 이 0이면 종료
         *
         *      - 해결책 : 구간 내 가운데를 기준으로 분할하여 풀이
         *      (1) 가운데 위치를 구한다
         *      (2) 가운데 위치를 기준으로 분할하여 왼쪽 구간 넓이, 오른쪽 구간 넓이를 구한다
         *      (3) 왼쪽과 오른쪽 중 큰 넓이를 저장한다
         *      (4) 변수에 저장된 넓이와 두 구간을 합친 구간의 가장 큰 넓이 중 가장 큰 넓이를 반환한다
         *
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        StringTokenizer st = null;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            long[] array = new long[n+1];
            for (int i = 1; i <= n; i++) {
                array[i] = Long.parseLong(st.nextToken());
            }

            // 코드
            long result = divide(array, 1, n);
            builder.append(result).append("\n");
        }

        System.out.print(builder.toString());
    }

    public static long divide(long[] array, int from, int to) {
        if (from == to) {
            return array[from];
        }

        int mid = (from + to) / 2;
        long leftMax = divide(array, from, mid);
        long rightMax = divide(array, mid+1, to);

        // 공통 부분
        long areaMax = conquer(array, from, mid, to);

        long result = Math.max(leftMax, rightMax);
        result = Math.max(result, areaMax);

        return result;
    }

    public static long conquer(long[] array, int from ,int mid, int to) {
        long height = array[mid];
        long answer = array[mid];
        int count = 1;
        int leftIndex = mid;
        int rightIndex = mid;

        while (true) {

            // leftIndex와 rightIndex가 남아있는 경우
            if (leftIndex > from && rightIndex < to) {
                if (array[leftIndex - 1] < array[rightIndex + 1]) {
                    rightIndex++;
                    height = Math.min(height, array[rightIndex]);
                } else {
                    leftIndex--;
                    height = Math.min(height, array[leftIndex]);
                }
            }
            else if (leftIndex > from && rightIndex >= to) {
                leftIndex--;
                height = Math.min(height, array[leftIndex]);
            }
            else if (leftIndex <= from && rightIndex < to) {
                rightIndex++;
                height = Math.min(height, array[rightIndex]);
            }
            else {
                // 종료
                break;
            }

            count++;
            answer = Math.max(answer, height * count);
        }

        return answer;
    }
}
