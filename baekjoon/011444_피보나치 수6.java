import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        /**
         *  F(n+2) = [ 1  1 ] [ F(n+1) ]
         *  F(n+1) = [ 1  0 ] [ F(n) ]
         *
         *  U(n) = F(n) + F(n+1)
         *
         *  U(1) = A * U(0)
         *  U(2) = A * U(n+1) = A * A * U(0)
         *  U(3) = A * U(n+2) = A * A * A * U(0)
         *
         *  U(n) = A^n * U(0)
         */

        long[][] matrix = new long[3][3];
        long[][] origin = new long[3][3];
        long[][] base = new long[3][2];
        matrix[1][1] = origin[1][1] = 1;
        matrix[1][2] = origin[1][2] = 1;
        matrix[2][1] = origin[2][1] = 1;
        base[1][1] = 1;

        matrix = conquer(n, matrix, origin);

//        print(matrix);
//        System.out.println();

        long[][] result = multiply(matrix, base);

//        print(result);

        System.out.println(result[2][1]);
    }

    public static void print(long[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static long[][] conquer(long n, long[][] matrix, long[][] origin) {
        if (n == 0L || n == 1L) {
            return origin;
        }

        long[][] result = conquer(n/2, matrix, origin);
        if (n % 2 == 0) {
            result = multiply(result, result);
        } else {
            result = multiply(result, result);
            result = multiply(result, origin);
        }

        return result;
    }

    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[3][3];

        for (int row = 1; row <= 2; row++) {
            for (int col = 1; col <= b[0].length - 1; col++) {
                for (int i = 1; i <= 2; i++) {
                    result[row][col] += (a[row][i] * b[i][col]);
                }
                result[row][col] %= 1_000_000_007;
            }
        }

        return result;
    }

}
