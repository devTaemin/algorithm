import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 모듈러 연산의 성질
        // (A + B) % C == ((A % C) + (B % C)) % C

        // 구간의 합
        // [i, j]
        // sum[j] - sum[i-1]
        // (sum[j] - sum[i-1]) % m == 0
        // (sum[j] % m - sum[i-1] % m) == 0
        // sum[j] % m == sum[i-1] % m

        // sum[i] = 0 은 자기 자신 만으로도 나누어 떨어진다
        // 나머지는 자기 자신만으로 떨어지는 것을 제외해야 한다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] array = new long[(int)n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            long remain = Long.parseLong(st.nextToken()) % m;
            array[i] = (remain + array[i-1]) % m;
        }

        long[] table = new long[(int)m];
        for (int i = 1; i <= n; i++) {
            table[(int)array[i]]++;
        }

        long answer = 0;
        for (int i = 0; i < m; i++) {
            if (table[i] > 0) {
                if (i == 0) {
                    answer += table[0];
                }

                answer += (table[i] * (table[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}
