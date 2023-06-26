import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n+1][m+1];
        for (int row = 1; row <= n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= m; col++) {
                a[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] b = new int[m+1][k+1];
        for (int row = 1; row <= m; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= k; col++) {
                b[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[n+1][k+1];
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= k; col++) {
                for (int i = 1; i <= m; i++) {
                    result[row][col] += a[row][i] * b[i][col];
                }
            }
        }

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= k; col++) {
                System.out.print(result[row][col] + " ");
            }
            System.out.println();
        }
    }
}
