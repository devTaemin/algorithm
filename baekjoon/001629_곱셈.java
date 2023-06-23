import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // (A * A) % C = (A % C * A % C) % C

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long result = multiply(a % c, b, c);
        System.out.println(result);
    }

    public static long multiply(long value, long time, long div) {
        if (time == 1) {
            return value % div;
        }

        long l = multiply(value % div, time / 2, div) % div;
        if (time % 2 == 0) {
            return (l * l) % div;
        }
        else {
            return (((l * l) % div) * value) % div;
        }
    }
}
