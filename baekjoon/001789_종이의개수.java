import java.io.*;
import java.util.*;

public class Main {

    static int numOfMinusOne, numOfZero, numOfOne;

    public static void main(String[] args) throws IOException {
        // N x N 크기의 행렬
        // -1, 0, 1 로 저장
        // 규칙에 따라 적절한 크기로 자르기
        // (1) 모두 같은 수로 되어 있으면 그대로 사용
        // (2) (1)이 아닌 경우 종이를 같은 크기의 종이 9개로 자르고, (1) 반복

        // -1로만 채워진 종이, 0, 1로만 채워진 종이의 개수 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[][] table = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(table, n, 1, 1);

        System.out.println(numOfMinusOne);
        System.out.println(numOfZero);
        System.out.println(numOfOne);
    }

    public static void find(int[][] table, int size, int row, int col) {
        if (size == 1 || check(table, size, row, col)) {
            int value = table[row][col];
            if (value == -1) numOfMinusOne += 1;
            else if (value == 0) numOfZero += 1;
            else numOfOne += 1;

        }
        else {
            find(table, size / 3, row, col);
            find(table, size / 3, row, col + size / 3);
            find(table, size / 3, row, col + size * 2 / 3);
            find(table, size / 3, row + size / 3, col);
            find(table, size / 3, row + size / 3, col + size / 3);
            find(table, size / 3, row + size / 3, col + size * 2 / 3);
            find(table, size / 3, row + size * 2 / 3, col);
            find(table, size / 3, row + size * 2 / 3, col + size / 3);
            find(table, size / 3, row + size * 2 / 3, col + size * 2 / 3);
        }
    }

    public static boolean check(int[][] table, int size, int row, int col) {
        int standard = table[row][col];
        boolean result = true;

        for (int r = row; r <= row + size - 1 && result; r++) {
            for (int c = col; c <= col + size - 1; c++) {
                if (table[r][c] != standard) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }
}
