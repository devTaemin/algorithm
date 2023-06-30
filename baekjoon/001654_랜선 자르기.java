import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 이미 자른 랜선은 붙일 수 없다
        // K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다
        // N개 보다 많이 만드는 것도 N개를 만드는 것에 포함
        // N개를 만들 수 있는 랜선의 최대 길이
        // 주어진 랜선의 길이는 2^31 - 1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] lens = new long[k];
        long max = Long.MIN_VALUE;
        long min = 1;
        for (int i = 0; i < k; i++) {
            lens[i] = Long.parseLong(br.readLine());
            max = Math.max(max, lens[i]);
        }

        // 기준 길이가 짧을 수록 생성하는 랜선의 수가 많아진다
        // 기준 길이를 최대한 늘리면서 생성 개수를 목표에 근접하게 만들어라 -> min을 올리기
        long result = 0;
        while (min <= max) {
            long mid = (max + min) / 2;

            long count = 0;
            for (int i = 0; i < k; i++) {
                count += lens[i] / mid;
            }

            if (count < n) {
                max = mid - 1;
            } else {
                min = mid + 1;
                result = Math.max(result, mid);
            }
        }

        System.out.println(result);
    }
}
