import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // M미터 필요
        // 절단기 높이 H 지정, 모든 나무 자르기
        // 나무 길이 > H -> H 위 부분 잘리기
        // 나무 길이 <= H -> 안잘림
        // 0 <= H (정수)
        // 적어도 M 미터의 나무를 가지고 가기 위해 필요한 H의 최대 높이
        // H를 높일 수록 M이 줄어든다 -> M미터 이상의 목재를 가져가기 위해 H를 최대한 늘린다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] trees = new long[n];
        long max = Long.MIN_VALUE;
        long min = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        long result = 0;
        while (min <= max) {
            long mid = (min + max) / 2;

            long left = 0;
            for (int i = 0; i < n; i++) {
                if (trees[i] > mid) {
                    left += (trees[i] - mid);
                }
            }

            if (left < m) {
                max = mid - 1;
            } else {
                min = mid + 1;
                result = Math.max(result, mid);
            }
        }

        System.out.println(result);
    }
}
