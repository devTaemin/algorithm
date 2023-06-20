import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        String input = "";
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int n = Integer.parseInt(input);

            char[] array = new char[(int)Math.pow(3, n) + 1];
            Arrays.fill(array, '-');
            cantorSet(array, 1, (int)Math.pow(3, n));

            for (int i = 1; i <= (int)Math.pow(3, n); i++) {
                builder.append(array[i]);
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }

    public static void cantorSet(char[] array, int start, int end) {
        if (start == end) return;

        int size = (end - start + 1) / 3;
        int from = start + size;
        int to = from + size - 1;

        for (int i = from; i <= to; i++) {
            array[i] = ' ';
        }

        cantorSet(array, start, from - 1);
        cantorSet(array, to + 1, end);
    }
}
