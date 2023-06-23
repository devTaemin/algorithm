import java.io.*;
import java.util.*;

public class Main {

    static int numOfWhite, numOfBlue;

    public static void main(String[] args) throws IOException {
        // 분할정복
        // 입력으로 주어진 종이의 한 변의 길이 N
        // 각 정사각형의 색
        // 하얀색 색종이와 파란색 색종이의 개수를 구하라

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
        
        System.out.println(numOfWhite);
        System.out.println(numOfBlue);
    }

    public static void find(int[][] table, int size, int row, int col) {

        if (size == 1 || check(table, size, row, col)) {
            if (table[row][col] == 0) numOfWhite++;
            else numOfBlue++;
        }
        else {
            find(table, size / 2, row, col);
            find(table, size / 2, row + size / 2, col);
            find(table, size / 2, row, col + size / 2);
            find(table, size / 2, row + size / 2, col + size / 2);
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
