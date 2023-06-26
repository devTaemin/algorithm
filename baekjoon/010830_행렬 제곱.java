import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long[][] origin = new long[n + 1][n + 1];
        long[][] matrix = new long[n + 1][n + 1];
        for (int row = 1; row <= n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= n; col++) {
                int value = Integer.parseInt(st.nextToken());
                origin[row][col] = value;
                matrix[row][col] = value;
            }
        }

        matrix = conquer(b, matrix, origin);
        if (b == 1) {
            for (int row = 1; row <= n; row++) {
                for (int col = 1; col <= n; col++) {
                    matrix[row][col] %= 1000;
                }
            }
        }
        print(n, matrix);
    }

    public static void print(int n, long[][] matrix) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static long[][] conquer(long b, long[][] matrix, long[][] origin) {
        if (b == 1L) {
            return origin;
        }

        long[][] result = conquer(b/2, matrix, origin);
        if (b % 2 == 0) {
            result = calculate(result, result);
        } else {
            result = calculate(result, result);
            result = calculate(result, origin);
        }

        return result;
    }

    public static long[][] calculate(long[][] matrix, long[][] origin) {

        int size = origin.length;
        long[][] result = new long[size][size];
        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {
                for (int i = 1; i < size; i++) {
                    result[row][col] += (matrix[row][i] * origin[i][col]);
                }
                result[row][col] %= 1000;
            }
        }

        return result;
    }
}
