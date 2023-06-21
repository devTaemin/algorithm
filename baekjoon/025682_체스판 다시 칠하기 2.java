import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] board = new char[n+1][m+1];
        for (int row = 1; row <= n; row++) {
            String line = br.readLine();

            for (int col = 1; col <= m; col++) {
                board[row][col] = line.charAt(col-1);
            }
        }

        // 테이블
        int[][] bTable = new int[n+1][m+1];
        int[][] wTable = new int[n+1][m+1];

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                char target = board[row][col];
                int bValue = 0;
                int wValue = 0;

                if ((row + col) % 2 == 0) {
                    bValue = (target == 'B') ? 0 : 1;
                    wValue = (target == 'W') ? 0 : 1;

                } else {
                    bValue = (target == 'W') ? 0 : 1;
                    wValue = (target == 'B') ? 0 : 1;
                }

                bTable[row][col] = bValue;
                wTable[row][col] = wValue;
            }
        }

        // 누적 테이블
        accumulated(bTable);
        accumulated(wTable);

        // area(x1, y1, x2, y2) = area(x2, y2)
        //                        + area(x1 - 1, y1 - 1)
        //                        - area(x1 - 1, y2)
        //                        - area(x2, y1 - 1)

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n - k + 1; i++) {
            for (int j = 1; j <= m - k + 1; j++) {
                int x1 = i;
                int y1 = j;
                int x2 = i + k - 1;
                int y2 = j + k - 1;

                int bResult = bTable[x2][y2]
                              - bTable[x2][y1 - 1]
                              - bTable[x1 - 1][y2]
                              + bTable[x1 - 1][y1 - 1];

                int wResult = wTable[x2][y2]
                        - wTable[x2][y1 - 1]
                        - wTable[x1 - 1][y2]
                        + wTable[x1 - 1][y1 - 1];

                min = Math.min(min, bResult);
                min = Math.min(min, wResult);
            }
        }

        System.out.println(min);
    }

    public static void print(int[][] table) {
        for (int[] line : table) {
            for (int elem : line) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static void accumulated(int[][] table) {
        for (int row = 0; row < table.length; row++) {
            for (int col = 1; col < table[0].length; col++) {
                table[row][col] += table[row][col-1];
            }
        }

        for (int col = 0; col < table[0].length; col++) {
            for (int row = 1; row < table.length; row++) {
                table[row][col] += table[row-1][col];
            }
        }
    }
}
