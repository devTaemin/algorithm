import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder builder = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        int length = input.length;

        int[][] accumulated = new int[length + 1][26];
        for (int i = 1; i <= length; i++) {
            int indexOfElem = input[i - 1] - '0' - 49;

            for (int j = 0; j < 26; j++) {;
                int before = accumulated[i - 1][j];
                if (indexOfElem == j) {
                    accumulated[i][j] = before + 1;
                } else {
                    accumulated[i][j] = before;
                }
            }
        }

        int numOfQ = Integer.parseInt(br.readLine());
        for (int t = 0; t < numOfQ; t++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int indexOfTarget = a - '0' - 49;
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int count = accumulated[r+1][indexOfTarget] -
                        accumulated[l][indexOfTarget];

            builder.append(count).append("\n");
        }

        System.out.print(builder.toString());
    }
}
